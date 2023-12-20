package net.coderbot.iris.compat.sodium.mixin.vertex_format;

import me.jellysquid.mods.sodium.client.render.chunk.vertex.format.impl.CompactChunkVertex;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CompactChunkVertex.class)
public interface CompactChunkVertexAccessor {
    @Accessor
    static int getTEXTURE_MAX_VALUE() {
        throw new AssertionError();
    }
}
