package net.irisshaders.iris.mixin.vertices;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferVertexConsumer;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.DefaultedVertexConsumer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import net.irisshaders.iris.shaderpack.materialmap.WorldRenderingSettings;
import net.irisshaders.iris.uniforms.CapturedRenderingState;
import net.irisshaders.iris.vertices.BlockSensitiveBufferBuilder;
import net.irisshaders.iris.vertices.BufferBuilderPolygonView;
import net.irisshaders.iris.vertices.ExtendedDataHelper;
import net.irisshaders.iris.vertices.ExtendingBufferBuilder;
import net.irisshaders.iris.vertices.IrisExtendedBufferBuilder;
import net.irisshaders.iris.vertices.IrisVertexFormats;
import net.irisshaders.iris.vertices.NormI8;
import net.irisshaders.iris.vertices.NormalHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.ByteBuffer;

/**
 * Dynamically and transparently extends the vanilla vertex formats with additional data
 */
@Mixin(BufferBuilder.class) // TODO OCULUS: ???
public abstract class MixinBufferBuilder extends DefaultedVertexConsumer implements BufferVertexConsumer, BlockSensitiveBufferBuilder, ExtendingBufferBuilder, IrisExtendedBufferBuilder {
	@Unique
	private final BufferBuilderPolygonView polygon = new BufferBuilderPolygonView();
	@Unique
	private final Vector3f normal = new Vector3f();
	@Unique
	private boolean iris$shouldNotExtend;
	@Unique
	private boolean extending;
	@Unique
	private boolean iris$isTerrain;
	@Unique
	private boolean injectNormalAndUV1;
	@Unique
	private int vertexCount;
	@Unique
	private short currentBlock = -1;
	@Unique
	private short currentRenderType = -1;
	@Unique
	private int currentLocalPosX;
	@Unique
	private int currentLocalPosY;
	@Unique
	private int currentLocalPosZ;
	@Shadow
	private ByteBuffer buffer;

	@Shadow
	private VertexFormat.Mode mode;

	@Shadow
	private VertexFormat format;

	@Shadow
	private int nextElementByte;

	@Shadow
	private @Nullable VertexFormatElement currentElement;

	@Shadow
	public abstract void begin(VertexFormat.Mode drawMode, VertexFormat vertexFormat);

	@Shadow
	public abstract void putShort(int i, short s);

	@Shadow
	public abstract void nextElement();

	@Override
	public void iris$beginWithoutExtending(VertexFormat.Mode drawMode, VertexFormat vertexFormat) {
		iris$shouldNotExtend = true;
		begin(drawMode, vertexFormat);
		iris$shouldNotExtend = false;
	}

	@Override
	public @NotNull VertexConsumer uv2(int pBufferVertexConsumer0, int pInt1) {
		return BufferVertexConsumer.super.uv2(pBufferVertexConsumer0, pInt1);
	}

	@ModifyVariable(method = "begin", at = @At("HEAD"), argsOnly = true)
	private VertexFormat iris$extendFormat(VertexFormat format) {
		extending = false;
		iris$isTerrain = false;
		injectNormalAndUV1 = false;

		if (iris$shouldNotExtend || !WorldRenderingSettings.INSTANCE.shouldUseExtendedVertexFormat()) {
			return format;
		}

		if (format == DefaultVertexFormat.BLOCK) {
			extending = true;
			iris$isTerrain = true;
			injectNormalAndUV1 = false;
			return IrisVertexFormats.TERRAIN;
		} else if (format == DefaultVertexFormat.NEW_ENTITY) {
			extending = true;
			iris$isTerrain = false;
			injectNormalAndUV1 = false;
			return IrisVertexFormats.ENTITY;
		} else if (format == DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP) {
			extending = true;
			iris$isTerrain = false;
			injectNormalAndUV1 = true;
			return IrisVertexFormats.GLYPH;
		}

		return format;
	}

	@Inject(method = "reset()V", at = @At("HEAD"))
	private void iris$onReset(CallbackInfo ci) {
		vertexCount = 0;
	}

	@Inject(method = "endVertex", at = @At("HEAD"))
	private void iris$beforeNext(CallbackInfo ci) {
		if (!extending) {
			return;
		}

		// 优化：只有在需要时才注入法线和UV1
		if (injectNormalAndUV1 && currentElement == DefaultVertexFormat.ELEMENT_NORMAL) {
			// 避免不必要的内存写入操作
			if (buffer.getInt(0) != 0) {
				this.putInt(0, 0);
			}
			this.nextElement();
		}

		if (iris$isTerrain) {
			// ENTITY_ELEMENT - 地形渲染的快速路径
			this.putShort(0, currentBlock);
			this.putShort(2, currentRenderType);
		} else {
			// ENTITY_ID_ELEMENT - 实体渲染路径
			this.putShort(0, (short) CapturedRenderingState.INSTANCE.getCurrentRenderedEntity());
			this.putShort(2, (short) CapturedRenderingState.INSTANCE.getCurrentRenderedBlockEntity());
			this.putShort(4, (short) CapturedRenderingState.INSTANCE.getCurrentRenderedItem());
		}

		this.nextElement();

		// MID_TEXTURE_ELEMENT - 优化：跳过已知为0的浮点值写入
		if (buffer.getFloat(0) != 0 || buffer.getFloat(4) != 0) {
			this.putFloat(0, 0);
			this.putFloat(4, 0);
		}
		this.nextElement();
		
		// TANGENT_ELEMENT - 优化：跳过已知为0的整数值写入
		if (buffer.getInt(0) != 0) {
			this.putInt(0, 0);
		}
		this.nextElement();
		
		// MID_BLOCK_ELEMENT - 地形渲染的中间点计算
		if (iris$isTerrain) {
			int posIndex = this.nextElementByte - 48;
			float x = buffer.getFloat(posIndex);
			float y = buffer.getFloat(posIndex + 4);
			float z = buffer.getFloat(posIndex + 8);
			// 只在需要时计算和存储中间点
			int midBlock = ExtendedDataHelper.computeMidBlock(x, y, z, currentLocalPosX, currentLocalPosY, currentLocalPosZ);
			if (buffer.getInt(0) != midBlock) {
				this.putInt(0, midBlock);
			}
			this.nextElement();
		}

		vertexCount++;

		// 只有在四边形或三角形完成时才填充扩展数据
		if (mode == VertexFormat.Mode.QUADS && vertexCount == 4 || mode == VertexFormat.Mode.TRIANGLES && vertexCount == 3) {
			fillExtendedData(vertexCount);
		}
	}

	@Unique
	private void fillExtendedData(int vertexAmount) {
		vertexCount = 0;

		int stride = format.getVertexSize();

		polygon.setup(buffer, nextElementByte, stride, vertexAmount);

		// 计算中间纹理坐标
		float midU = 0;
		float midV = 0;
		for (int vertex = 0; vertex < vertexAmount; vertex++) {
			midU += polygon.u(vertex);
			midV += polygon.v(vertex);
		}
		midU /= vertexAmount;
		midV /= vertexAmount;

		// 根据渲染类型确定偏移量
		final int midUOffset = iris$isTerrain ? 16 : 14;
		final int midVOffset = iris$isTerrain ? 12 : 10;
		final int normalOffset = 24;
		final int tangentOffset = iris$isTerrain ? 8 : 6;

		if (vertexAmount == 3) {
			// 三角形渲染路径 - 平滑着色
			for (int vertex = 0; vertex < vertexAmount; vertex++) {
				final int vertexOffset = nextElementByte - stride * vertex;
				int packedNormal = buffer.getInt(vertexOffset - normalOffset); // 获取每个顶点的法线

				// 计算平滑切线
				int tangent = NormalHelper.computeTangentSmooth(
						NormI8.unpackX(packedNormal), 
						NormI8.unpackY(packedNormal), 
						NormI8.unpackZ(packedNormal), 
						polygon);

				// 优化：只有在值不同时才写入内存
				final int tangentPos = vertexOffset - tangentOffset;
				if (buffer.getInt(tangentPos) != tangent) {
					buffer.putInt(tangentPos, tangent);
				}
				
				// 只有在值不同时才写入中间纹理坐标
				final int midUPos = vertexOffset - midUOffset;
				final int midVPos = vertexOffset - midVOffset;
				if (buffer.getFloat(midUPos) != midU) {
					buffer.putFloat(midUPos, midU);
				}
				if (buffer.getFloat(midVPos) != midV) {
					buffer.putFloat(midVPos, midV);
				}
			}
		} else {
			// 四边形渲染路径 - 面法线
			NormalHelper.computeFaceNormal(normal, polygon);
			int packedNormal = NormI8.pack(normal.x, normal.y, normal.z, 0.0f);
			int tangent = NormalHelper.computeTangent(normal.x, normal.y, normal.z, polygon);

			// 缓存计算结果，避免重复访问变量
			final float finalMidU = midU;
			final float finalMidV = midV;
			final int finalPackedNormal = packedNormal;
			final int finalTangent = tangent;
			
			for (int vertex = 0; vertex < vertexAmount; vertex++) {
				final int vertexOffset = nextElementByte - stride * vertex;
				
				// 优化：只有在值不同时才写入内存
				final int normalPos = vertexOffset - normalOffset;
				if (buffer.getInt(normalPos) != finalPackedNormal) {
					buffer.putInt(normalPos, finalPackedNormal);
				}
				
				final int tangentPos = vertexOffset - tangentOffset;
				if (buffer.getInt(tangentPos) != finalTangent) {
					buffer.putInt(tangentPos, finalTangent);
				}
				
				final int midUPos = vertexOffset - midUOffset;
				final int midVPos = vertexOffset - midVOffset;
				if (buffer.getFloat(midUPos) != finalMidU) {
					buffer.putFloat(midUPos, finalMidU);
				}
				if (buffer.getFloat(midVPos) != finalMidV) {
					buffer.putFloat(midVPos, finalMidV);
				}
			}
		}
	}

	@Unique
	private void putInt(int i, int value) {
		this.buffer.putInt(this.nextElementByte + i, value);
	}

	@Override
	public void beginBlock(short block, short renderType, int localPosX, int localPosY, int localPosZ) {
		this.currentBlock = block;
		this.currentRenderType = renderType;
		this.currentLocalPosX = localPosX;
		this.currentLocalPosY = localPosY;
		this.currentLocalPosZ = localPosZ;
	}

	@Override
	public void endBlock() {
		this.currentBlock = -1;
		this.currentRenderType = -1;
		this.currentLocalPosX = 0;
		this.currentLocalPosY = 0;
		this.currentLocalPosZ = 0;
	}

	@Override
	public VertexFormat iris$format() {
		return format;
	}

	@Override
	public VertexFormat.Mode iris$mode() {
		return mode;
	}

	@Override
	public boolean iris$extending() {
		return extending;
	}

	@Override
	public boolean iris$isTerrain() {
		return iris$isTerrain;
	}

	@Override
	public boolean iris$injectNormalAndUV1() {
		return injectNormalAndUV1;
	}

	@Override
	public int iris$vertexCount() {
		return vertexCount;
	}

	@Override
	public void iris$incrementVertexCount() {
		vertexCount++;
	}

	@Override
	public void iris$resetVertexCount() {
		vertexCount = 0;
	}

	@Override
	public short iris$currentBlock() {
		return currentBlock;
	}

	@Override
	public short iris$currentRenderType() {
		return currentRenderType;
	}

	@Override
	public int iris$currentLocalPosX() {
		return currentLocalPosX;
	}

	@Override
	public int iris$currentLocalPosY() {
		return currentLocalPosY;
	}

	@Override
	public int iris$currentLocalPosZ() {
		return currentLocalPosZ;
	}
}
