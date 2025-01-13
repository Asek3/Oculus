package net.coderbot.iris.mixin;

import net.coderbot.iris.block_rendering.BlockRenderingSettings;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Map;

@Mixin(ChunkRenderDispatcher.RenderChunk.RebuildTask.class)
public class MixinChunkRenderDispatcherRebuildTask {
    @Redirect(method = "compile", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/BakedModel;getRenderTypes(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/util/RandomSource;Lnet/minecraftforge/client/model/data/ModelData;)Lnet/minecraftforge/client/ChunkRenderTypeSet;"))
    private ChunkRenderTypeSet oculus$overrideRenderTypes(BakedModel instance, BlockState blockState, RandomSource randomSource, ModelData modelData) {
        Map<Holder.Reference<Block>, ChunkRenderTypeSet> idMap = BlockRenderingSettings.INSTANCE.getBlockTypeIds();
        if (idMap != null) {
            ChunkRenderTypeSet type = idMap.get(ForgeRegistries.BLOCKS.getDelegateOrThrow(blockState.getBlock()));
            if (type != null) {
                return type;
            }
        }

        return instance.getRenderTypes(blockState, randomSource, modelData);
    }
}
