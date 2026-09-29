package net.irisshaders.iris.compat.sodium.impl.vertex_format;

import net.caffeinemc.mods.sodium.api.util.NormI8;
import net.caffeinemc.mods.sodium.api.vertex.format.common.ModelVertex;
import net.caffeinemc.mods.sodium.api.vertex.serializer.VertexSerializer;
import net.irisshaders.iris.uniforms.CapturedRenderingState;
import net.irisshaders.iris.vertices.IrisVertexFormats;
import net.irisshaders.iris.vertices.NormalHelper;
import org.lwjgl.system.MemoryUtil;

public class ModelToEntityVertexSerializer implements VertexSerializer {
	@Override
	public void serialize(long src, long dst, int vertexCount) {
		// Only accept quads, to be safe
		int quadCount = vertexCount / 4;
		for (int i = 0; i < quadCount; i++) {
			int normal = MemoryUtil.memGetInt(src + 32);
			float normalX = NormI8.unpackX(normal);
			float normalY = NormI8.unpackY(normal);
			float normalZ = NormI8.unpackZ(normal);
			float x0 = MemoryUtil.memGetFloat(src);
			float y0 = MemoryUtil.memGetFloat(src + 4);
			float z0 = MemoryUtil.memGetFloat(src + 8);
			float u0 = MemoryUtil.memGetFloat(src + 16);
			float v0 = MemoryUtil.memGetFloat(src + 20);
			float x1 = MemoryUtil.memGetFloat(src + ModelVertex.STRIDE);
			float y1 = MemoryUtil.memGetFloat(src + 4 + ModelVertex.STRIDE);
			float z1 = MemoryUtil.memGetFloat(src + 8 + ModelVertex.STRIDE);
			float u1 = MemoryUtil.memGetFloat(src + 16 + ModelVertex.STRIDE);
			float v1 = MemoryUtil.memGetFloat(src + 20 + ModelVertex.STRIDE);
			float x2 = MemoryUtil.memGetFloat(src + ModelVertex.STRIDE * 2);
			float y2 = MemoryUtil.memGetFloat(src + 4 + ModelVertex.STRIDE * 2);
			float z2 = MemoryUtil.memGetFloat(src + 8 + ModelVertex.STRIDE * 2);
			float u2 = MemoryUtil.memGetFloat(src + 16 + ModelVertex.STRIDE * 2);
			float v2 = MemoryUtil.memGetFloat(src + 20 + ModelVertex.STRIDE * 2);
			float u3 = MemoryUtil.memGetFloat(src + 16 + ModelVertex.STRIDE * 3);
			float v3 = MemoryUtil.memGetFloat(src + 20 + ModelVertex.STRIDE * 3);
			int tangent = NormalHelper.computeTangent(normalX, normalY, normalZ, x0, y0, z0, u0, v0, x1, y1, z1, u1, v1, x2, y2, z2, u2, v2);

			// Accumulated in vertex order, exactly like the loop this replaces.
			float midU = 0, midV = 0;
			midU += u0;
			midV += v0;
			midU += u1;
			midV += v1;
			midU += u2;
			midV += v2;
			midU += u3;
			midV += v3;

			midU /= 4;
			midV /= 4;

			// These cannot change while a quad is being serialized.
			short entity = (short) CapturedRenderingState.INSTANCE.getCurrentRenderedEntity();
			short blockEntity = (short) CapturedRenderingState.INSTANCE.getCurrentRenderedBlockEntity();
			short item = (short) CapturedRenderingState.INSTANCE.getCurrentRenderedItem();
			int stride = IrisVertexFormats.ENTITY.getVertexSize();

			for (int j = 0; j < 4; j++) {
				copyModelVertex(src, dst);
				MemoryUtil.memPutShort(dst + 36, entity);
				MemoryUtil.memPutShort(dst + 38, blockEntity);
				MemoryUtil.memPutShort(dst + 40, item);
				MemoryUtil.memPutFloat(dst + 42, midU);
				MemoryUtil.memPutFloat(dst + 46, midV);
				MemoryUtil.memPutInt(dst + 50, tangent);

				src += ModelVertex.STRIDE;
				dst += stride;
			}
		}
	}

	/**
	 * Copies one 36-byte model vertex with fixed-size loads and stores instead of a memcpy call.
	 * Overlapping ranges keep the behavior of {@link MemoryUtil#memCopy(long, long, long)}.
	 */
	private static void copyModelVertex(long src, long dst) {
		if (Long.compareUnsigned(dst - src, 36) < 0 || Long.compareUnsigned(src - dst, 36) < 0) {
			MemoryUtil.memCopy(src, dst, 36);
			return;
		}

		long a = MemoryUtil.memGetLong(src);
		long b = MemoryUtil.memGetLong(src + 8);
		long c = MemoryUtil.memGetLong(src + 16);
		long d = MemoryUtil.memGetLong(src + 24);
		int e = MemoryUtil.memGetInt(src + 32);
		MemoryUtil.memPutLong(dst, a);
		MemoryUtil.memPutLong(dst + 8, b);
		MemoryUtil.memPutLong(dst + 16, c);
		MemoryUtil.memPutLong(dst + 24, d);
		MemoryUtil.memPutInt(dst + 32, e);
	}
}
