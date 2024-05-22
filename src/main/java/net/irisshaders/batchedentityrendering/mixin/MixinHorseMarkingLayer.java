package net.irisshaders.batchedentityrendering.mixin;

import net.irisshaders.batchedentityrendering.impl.BlendingStateHolder;
import net.irisshaders.batchedentityrendering.impl.TransparencyType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.HorseMarkingLayer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HorseMarkingLayer.class)
public class MixinHorseMarkingLayer {
    @Redirect(method = "render*", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderType;entityTranslucent(Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraft/client/renderer/RenderType;"))
    private RenderType modifyRenderType(ResourceLocation loc) {
        RenderType t = RenderType.entityTranslucent(loc);
        ((BlendingStateHolder) t).setTransparencyType(TransparencyType.OPAQUE);
        return t;
    }
}
