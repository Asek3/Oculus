package net.coderbot.iris.compat.sodium.mixin.separate_ao;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.jellysquid.mods.sodium.client.render.chunk.compile.buffers.ChunkModelBuilder;
import me.jellysquid.mods.sodium.client.render.pipeline.BlockRenderer;
import net.coderbot.iris.block_rendering.BlockRenderingSettings;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.IModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Allows vertex AO to be optionally passed in the alpha channel of the vertex color instead of being multiplied
 * through into the RGB values.
 */
@Mixin(BlockRenderer.class)
public class MixinBlockRenderer {
    @Unique
    private boolean useSeparateAo;

    @Inject(method = "renderModel", remap = false, at = @At("HEAD"))
    private void renderModel(
        final BlockAndTintGetter world,
        final BlockState state,
        final BlockPos pos,
        final BlockPos origin,
        final BakedModel model,
        final ChunkModelBuilder buffers,
        final boolean cull,
        final long seed,
        final IModelData modelData,
        final CallbackInfoReturnable<Boolean> cir
    ) {
        this.useSeparateAo = BlockRenderingSettings.INSTANCE.shouldUseSeparateAo();
    }

    @WrapOperation(
        method = "renderQuad", remap = false,
        at = @At(
            value = "INVOKE",
            target = "me/jellysquid/mods/sodium/client/util/color/ColorABGR.mul (IF)I",
            remap = false
        )
    )
    private int iris$applySeparateAo(int color, final float ao, final Operation<Integer> original) {
        if (useSeparateAo) {
            color &= 0x00FFFFFF;
            color |= ((int) (ao * 255.0f)) << 24;
        } else {
            color = original.call(color, ao);
        }

        return color;
    }
}
