package net.irisshaders.iris.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.irisshaders.iris.Iris;
import net.irisshaders.iris.gl.GLDebug;
import net.irisshaders.iris.gl.IrisRenderSystem;
import net.irisshaders.iris.pipeline.ShaderRenderingPipeline;
import net.irisshaders.iris.samplers.IrisSamplers;
import net.irisshaders.iris.texture.TextureTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.function.Supplier;

@Mixin(RenderSystem.class)
public class MixinRenderSystem {
	@Inject(method = "initRenderer", at = @At("RETURN"), remap = false)
	private static void iris$onRendererInit(int debugVerbosity, boolean alwaysFalse, CallbackInfo ci) {
		Iris.duringRenderSystemInit();
		GLDebug.reloadDebugState();
		IrisRenderSystem.initRenderer();
		IrisSamplers.initRenderer();
		Iris.onRenderSystemInit();
	}

	@Inject(method = "_setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/AbstractTexture;getId()I", shift = At.Shift.AFTER), locals = LocalCapture.CAPTURE_FAILHARD)
	private static void _setShaderTexture(int unit, ResourceLocation resourceLocation, CallbackInfo ci, TextureManager lv, AbstractTexture tex) {
		TextureTracker.INSTANCE.onSetShaderTexture(unit, tex.getId());
	}

	@Inject(method = "_setShaderTexture(II)V", at = @At("RETURN"), remap = false)
	private static void _setShaderTexture(int unit, int glId, CallbackInfo ci) {
		TextureTracker.INSTANCE.onSetShaderTexture(unit, glId);
	}

	@Redirect(
		method = "setShader",
		at = @At(value = "INVOKE", target = "Ljava/util/function/Supplier;get()Ljava/lang/Object;", remap = false),
		remap = false
	)
	private static Object iris$replaceProjectRedHaloShader(Supplier<ShaderInstance> supplier) {
		ShaderInstance shader = supplier.get();
		return shader != null
			&& "projectred_core:halo".equals(shader.getName())
			&& !Minecraft.useShaderTransparency()
			&& Iris.getPipelineManager().getPipelineNullable() instanceof ShaderRenderingPipeline pipeline
			&& pipeline.shouldOverrideShaders()
			? GameRenderer.getPositionColorShader()
			: shader;
	}
}
