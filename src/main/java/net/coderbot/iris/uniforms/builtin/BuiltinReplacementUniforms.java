package net.coderbot.iris.uniforms.builtin;

import net.coderbot.iris.gl.uniform.UniformHolder;
import net.coderbot.iris.gl.uniform.UniformUpdateFrequency;
import net.coderbot.iris.vendored.joml.Matrix4f;

public class BuiltinReplacementUniforms {
	private static final Matrix4f lightmapTextureMatrix;

	static {
		// This mimics the transformations done in LightTexture to the GL_TEXTURE matrix.
		lightmapTextureMatrix = new Matrix4f(0.00390625f, 0.0f, 0.0f, 0.0f,
			0.0f, 0.00390625f, 0.0f, 0.0f,
			0.0f, 0.0f, 0.00390625f, 0.0f,
			0.03125f, 0.03125f, 0.03125f, 1.0f);
	}

	public static void addBuiltinReplacementUniforms(UniformHolder uniforms) {
		uniforms.uniformJomlMatrix(UniformUpdateFrequency.ONCE, "iris_LightmapTextureMatrix", () -> {
			// Iris.logger.warn("A shader appears to require the lightmap texture matrix even after transformations have occurred");
			// Iris.logger.warn("Iris handles this correctly but it indicates that the shader is doing weird things with lightmap coordinates");

			return lightmapTextureMatrix;
		});
	}
}
