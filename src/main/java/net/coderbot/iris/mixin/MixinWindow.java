package net.coderbot.iris.mixin;

import com.mojang.blaze3d.platform.Window;
import net.coderbot.iris.Iris;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Window.class)
public class MixinWindow {
	@Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwDefaultWindowHints()V"))
	private void iris$enableDebugContext() {
		GLFW.glfwDefaultWindowHints();
		if (Iris.getIrisConfig().areDebugOptionsEnabled()) {
			GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_DEBUG_CONTEXT, GLFW.GLFW_TRUE);
			Iris.logger.info("OpenGL debug context activated.");
		}
	}
}
