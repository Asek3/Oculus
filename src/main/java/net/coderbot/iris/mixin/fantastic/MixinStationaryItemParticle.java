package net.coderbot.iris.mixin.fantastic;

import net.coderbot.iris.fantastic.IrisParticleRenderTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.BlockMarker;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.model.data.ModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockMarker.class)
public class MixinStationaryItemParticle {
	@Unique
	private boolean isOpaque;

	@Inject(method = "<init>", at = @At("RETURN"))
	private void iris$resolveTranslucency(ClientLevel clientLevel, double d, double e, double f, BlockState blockState, CallbackInfo ci) {
		BakedModel model = Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState);
		ChunkRenderTypeSet types = model.getRenderTypes(blockState, clientLevel.random, ModelData.EMPTY);

		if (types.contains(RenderType.solid()) || types.contains(RenderType.cutout()) || types.contains(RenderType.cutoutMipped())) {
				isOpaque = true;
		}
	}

	@Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
	private void iris$overrideParticleRenderType(CallbackInfoReturnable<ParticleRenderType> cir) {
		if (isOpaque) {
			cir.setReturnValue(ParticleRenderType.TERRAIN_SHEET);
		}
	}
}
