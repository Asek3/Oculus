package net.coderbot.iris.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.platform.Window;
import net.coderbot.iris.Iris;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = Window.class, remap = false)
public class MixinWindow {
	@WrapOperation(method = "<init>", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwDefaultWindowHints()V"))
	private void iris$enableDebugContext(final Operation<Void> original) {
		original.call();
		if (Iris.getIrisConfig().areDebugOptionsEnabled()) {
			GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_DEBUG_CONTEXT, GLFW.GLFW_TRUE);
			Iris.logger.info("OpenGL debug context activated.");
		}
	}
}
