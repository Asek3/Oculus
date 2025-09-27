package net.irisshaders.iris.gl.program;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.shaders.ProgramManager;
import net.irisshaders.iris.Iris;
import net.irisshaders.iris.gl.GlResource;
import net.irisshaders.iris.gl.IrisRenderSystem;
import net.irisshaders.iris.pipeline.WorldRenderingPipeline;
import net.irisshaders.iris.shaderpack.FilledIndirectPointer;
import org.joml.Vector2f;
import org.joml.Vector3i;
import org.lwjgl.opengl.GL43C;
import org.lwjgl.opengl.GL46C;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ComputeProgram extends GlResource {
	// Vector3i对象池，避免频繁创建临时对象
	private static final ConcurrentLinkedQueue<Vector3i> VECTOR3I_POOL = new ConcurrentLinkedQueue<>();
	private static final int MAX_POOL_SIZE = 64;
	
	private final ProgramUniforms uniforms;
	private final ProgramSamplers samplers;
	private final ProgramImages images;
	private final int[] localSize;
	private Vector3i absoluteWorkGroups;
	private Vector2f relativeWorkGroups;
	private float cachedWidth;
	private float cachedHeight;
	private Vector3i cachedWorkGroups;
	private FilledIndirectPointer indirectPointer;
	
	// 缓存工作组计算结果，避免重复调用Math.ceil
	private int lastWidth = -1;
	private int lastHeight = -1;
	private Vector3i cachedResult = null;

	ComputeProgram(int program, ProgramUniforms uniforms, ProgramSamplers samplers, ProgramImages images) {
		super(program);

		localSize = new int[3];
		IrisRenderSystem.getProgramiv(program, GL43C.GL_COMPUTE_WORK_GROUP_SIZE, localSize);
		this.uniforms = uniforms;
		this.samplers = samplers;
		this.images = images;
	}

	// 从对象池获取Vector3i对象
	private static Vector3i getFromPool() {
		Vector3i vec = VECTOR3I_POOL.poll();
		return vec != null ? vec : new Vector3i();
	}

	// 将Vector3i对象归还到池中
	private static void returnToPool(Vector3i vec) {
		if (vec != null && VECTOR3I_POOL.size() < MAX_POOL_SIZE) {
			VECTOR3I_POOL.offer(vec);
		}
	}

	public static void unbind() {
		ProgramUniforms.clearActiveUniforms();
		ProgramManager.glUseProgram(0);
	}

	public void setWorkGroupInfo(Vector2f relativeWorkGroups, Vector3i absoluteWorkGroups, FilledIndirectPointer indirectPointer) {
		this.relativeWorkGroups = relativeWorkGroups;
		this.absoluteWorkGroups = absoluteWorkGroups;
		this.indirectPointer = indirectPointer;
	}

	public Vector3i getWorkGroups(float width, float height) {
		if (indirectPointer != null) return null;

		// 转换为整数以减少浮点比较误差
		int widthInt = Math.round(width);
		int heightInt = Math.round(height);
		
		// 如果尺寸相同且有缓存结果，直接返回缓存
		if (widthInt == lastWidth && heightInt == lastHeight && cachedResult != null) {
			return cachedResult;
		}
		
		// 更新缓存状态
		lastWidth = widthInt;
		lastHeight = heightInt;
		
		// 归还之前的结果到池中
		if (cachedResult != null) {
			returnToPool(cachedResult);
		}
		
		// 获取新的Vector3i对象
		Vector3i result = getFromPool();
		
		if (this.absoluteWorkGroups != null) {
			result.set(absoluteWorkGroups);
		} else if (relativeWorkGroups != null) {
			// 优化计算，减少重复的Math.ceil调用
			int groupX = (int) Math.ceil((width * relativeWorkGroups.x) / localSize[0]);
			int groupY = (int) Math.ceil((height * relativeWorkGroups.y) / localSize[1]);
			result.set(groupX, groupY, 1);
		} else {
			int groupX = (int) Math.ceil(width / localSize[0]);
			int groupY = (int) Math.ceil(height / localSize[1]);
			result.set(groupX, groupY, 1);
		}
		
		cachedResult = result;
		return result;
	}

	public void use() {
		ProgramManager.glUseProgram(getGlId());

		uniforms.update();
		samplers.update();
		images.update();
	}

	public void dispatch(float width, float height) {
		// 默认启用并发计算，只有明确禁止时才添加内存屏障
		boolean allowConcurrent = Iris.getPipelineManager().getPipeline()
				.map(WorldRenderingPipeline::allowConcurrentCompute)
				.orElse(true); // 默认设为true以提高性能
		
		// 智能内存屏障：根据需要添加最少必要的内存屏障
		if (!allowConcurrent) {
			// 使用更精确的内存屏障组合，减少性能开销
			int barrierBits = 0;
			
			// 只有在使用图像或着色器存储时才添加相应的屏障
			if (images.getActiveImages() > 0) {
				barrierBits |= GL43C.GL_SHADER_IMAGE_ACCESS_BARRIER_BIT;
			}
			if (samplers.hasActiveSamplers()) {
				barrierBits |= GL43C.GL_TEXTURE_FETCH_BARRIER_BIT;
			}
			// 简化为只使用必要的内存屏障
			if (barrierBits > 0) {
				IrisRenderSystem.memoryBarrier(barrierBits);
			}
		}

		if (indirectPointer != null) {
			IrisRenderSystem.bindBuffer(GL46C.GL_DISPATCH_INDIRECT_BUFFER, indirectPointer.buffer());
			IrisRenderSystem.dispatchComputeIndirect(indirectPointer.offset());
		} else {
			IrisRenderSystem.dispatchCompute(getWorkGroups(width, height));
		}
	}

	public void destroyInternal() {
		GlStateManager.glDeleteProgram(getGlId());
	}

	/**
	 * @return the OpenGL ID of this program.
	 * @deprecated this should be encapsulated eventually
	 */
	@Deprecated
	public int getProgramId() {
		return getGlId();
	}

	public int getActiveImages() {
		return images.getActiveImages();
	}
}
