package net.irisshaders.iris.mixin;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.irisshaders.iris.shadows.ShadowRenderingState;
import net.irisshaders.iris.vertices.DiscardingVertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(OutlineBufferSource.class)
public class MixinOutlineBufferSource {
	@Shadow @Final
	private MultiBufferSource.BufferSource bufferSource;

	@Inject(method = "getBuffer", at = @At("HEAD"), cancellable = true)
	private void iris$skipShadowOutlines(RenderType type, CallbackInfoReturnable<VertexConsumer> cir) {
		if (ShadowRenderingState.areShadowsCurrentlyBeingRendered()) {
			// Shadow rendering never draws the glow outline. Keep the ordinary model vertices,
			// but do not leave its outline in a batch that has no matching endOutlineBatch call.
			cir.setReturnValue(type.isOutline() ? DiscardingVertexConsumer.INSTANCE : this.bufferSource.getBuffer(type));
		}
	}
}
