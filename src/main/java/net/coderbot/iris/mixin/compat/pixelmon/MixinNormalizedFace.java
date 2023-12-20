package net.coderbot.iris.mixin.compat.pixelmon;

import com.mojang.blaze3d.vertex.BufferBuilder;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(targets = {"com/pixelmonmod/pixelmon/client/models/smd/NormalizedFace"})
public class MixinNormalizedFace {
    /**
     * @author embeddedt (original idea by NanoLive)
     * @reason Pixelmon manipulates the buffer of a {@link BufferBuilder} directly which causes problems.
     * We bypass that code path.
     */
    @Redirect(method = "addFaceForRender", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lcom/pixelmonmod/pixelmon/client/models/smd/DeformVertex;id2:I"))
    public int hideBufferBuilderId(@Coerce Object instance) {
        return -1; // prevent using "optimized" code path
    }
}
