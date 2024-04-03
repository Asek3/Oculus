package net.coderbot.iris.mixin.fantastic;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import net.coderbot.iris.Iris;
import net.coderbot.iris.fantastic.ParticleRenderingPhase;
import net.coderbot.iris.fantastic.PhasedParticleEngine;
import net.coderbot.iris.pipeline.WorldRenderingPipeline;
import net.coderbot.iris.shaderpack.ParticleRenderingSettings;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.Frustum;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Uses the PhasedParticleManager changes to render opaque particles much earlier than other particles.
 *
 * See the comments in {@link MixinParticleEngine} for more details.
 */
@Mixin(LevelRenderer.class)
public class MixinLevelRenderer {
	@Shadow
	@Final
	private Minecraft minecraft;

	@Shadow
	private RenderBuffers renderBuffers;

	@Inject(method = "renderLevel", at = @At("HEAD"))
	private void iris$resetParticleManagerPhase(PoseStack poseStack, float f, long l, boolean bl, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f projectionMatrix, CallbackInfo ci) {
		((PhasedParticleEngine) minecraft.particleEngine).setParticleRenderingPhase(ParticleRenderingPhase.EVERYTHING);
	}

	@Inject(method = "renderLevel", at = @At(value = "CONSTANT", args = "stringValue=entities"))
	private void iris$renderOpaqueParticles(PoseStack poseStack, float f, long l, boolean bl, Camera camera, GameRenderer gameRenderer, LightTexture lightTexture, Matrix4f projectionMatrix, CallbackInfo ci) {
		minecraft.getProfiler().popPush("opaque_particles");

		MultiBufferSource.BufferSource bufferSource = renderBuffers.bufferSource();

		ParticleRenderingSettings settings = getRenderingSettings();

		if (settings == ParticleRenderingSettings.BEFORE) {
			minecraft.particleEngine.render(poseStack, bufferSource, lightTexture, camera, f);
		} else if (settings == ParticleRenderingSettings.MIXED) {
			((PhasedParticleEngine) minecraft.particleEngine).setParticleRenderingPhase(ParticleRenderingPhase.OPAQUE);
			minecraft.particleEngine.render(poseStack, bufferSource, lightTexture, camera, f);
		}
	}

	/*@Redirect(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/particle/ParticleEngine;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource$BufferSource;Lnet/minecraft/client/renderer/LightTexture;Lnet/minecraft/client/Camera;FLnet/minecraft/client/renderer/culling/Frustum;)V"))
	private void iris$renderTranslucentAfterDeferred(ParticleEngine instance, PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, LightTexture lightTexture, Camera camera, float f, Frustum frustum) {
		ParticleRenderingSettings settings = getRenderingSettings();

		if (settings == ParticleRenderingSettings.AFTER) {
			minecraft.particleEngine.render(poseStack, bufferSource, lightTexture, camera, f, frustum);
		} else if (settings == ParticleRenderingSettings.MIXED) {
				((PhasedParticleEngine) minecraft.particleEngine).setParticleRenderingPhase(ParticleRenderingPhase.TRANSLUCENT);
			minecraft.particleEngine.render(poseStack, bufferSource, lightTexture, camera, f, frustum);
		}
	}*/

	@WrapOperation(
		method = "renderLevel",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/particle/ParticleEngine;render(Lcom/mojang/blaze3d/vertex/PoseStack;" +
					 "Lnet/minecraft/client/renderer/MultiBufferSource$BufferSource;" +
					 "Lnet/minecraft/client/renderer/LightTexture;Lnet/minecraft/client/Camera;" +
					 "FLnet/minecraft/client/renderer/culling/Frustum;)V"
		)
	)
	private void oculus$renderTranslucentAfterDeferred(
		final ParticleEngine instance,
		final PoseStack poseStack,
		final MultiBufferSource.BufferSource bufferSource,
		final LightTexture lightTexture,
		final Camera camera,
		final float f,
		final Frustum frustum,
		final Operation<Void> original
	) {
		ParticleRenderingSettings settings = getRenderingSettings();

		if (settings == ParticleRenderingSettings.AFTER) {
			original.call(instance, poseStack, bufferSource, lightTexture, camera, f, frustum);
		} else if (settings == ParticleRenderingSettings.MIXED) {
			((PhasedParticleEngine) instance).setParticleRenderingPhase(ParticleRenderingPhase.TRANSLUCENT);
			original.call(instance, poseStack, bufferSource, lightTexture, camera, f, frustum);
		}
	}

	private ParticleRenderingSettings getRenderingSettings() {
		return Iris.getPipelineManager().getPipeline().map(WorldRenderingPipeline::getParticleRenderingSettings).orElse(ParticleRenderingSettings.MIXED);
	}
}
