package net.irisshaders.iris.mixin.vertices.block_rendering;

import net.irisshaders.iris.shaderpack.materialmap.WorldRenderingSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(targets = "codechicken.lib.render.lighting.LightMatrix", remap = false)
public abstract class MixinLightMatrix_SeparateAo {
	@Redirect(
		method = "operate",
		at = @At(
			value = "INVOKE",
			target = "Lcodechicken/lib/colour/ColourRGBA;multiplyC(IF)I",
			remap = false
		),
		require = 0,
		remap = false
	)
	private int iris$separateAo(int color, float ao) {
		if (WorldRenderingSettings.INSTANCE.shouldUseSeparateAo()) {
			int alpha = Math.max(0, Math.min(255, Math.round(ao * 255.0f)));
			return (color & 0xFFFFFF00) | alpha;
		}

		int red = (int) ((color >>> 24) * ao);
		int green = (int) (((color >>> 16) & 0xFF) * ao);
		int blue = (int) (((color >>> 8) & 0xFF) * ao);
		return (red << 24) | (green << 16) | (blue << 8) | (color & 0xFF);
	}
}
