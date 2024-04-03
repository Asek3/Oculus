package net.coderbot.iris.mixin.fantastic;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.coderbot.iris.fantastic.ParticleRenderingPhase;
import net.coderbot.iris.fantastic.PhasedParticleEngine;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraftforge.client.ForgeHooksClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Extends the ParticleEngine class to allow multiple phases of particle rendering.
 * <p>
 * This is used to enable the rendering of known-opaque particles much earlier than other particles, most notably before
 * translucent content. Normally, particles behind translucent blocks are not visible on Fancy graphics, and a user must
 * enable the much more intensive Fabulous graphics option. This is not ideal because Fabulous graphics is fundamentally
 * incompatible with most shader packs.
 * <p>
 * So what causes this? Essentially, on Fancy graphics, all particles are rendered after translucent terrain. Aside from
 * causing problems with particles being invisible, this also causes particles to write to the translucent depth buffer,
 * even when they are not translucent. This notably causes problems with particles on Sildur's Enhanced Default when
 * underwater.
 * <p>
 * So, what these mixins do is try to render known-opaque particles right before entities are rendered and right after
 * opaque terrain has been rendered. This seems to be an acceptable injection point, and has worked in my testing. It
 * fixes issues with particles when underwater, fixes a vanilla bug, and doesn't have any significant performance hit.
 * A win-win!
 * <p>
 * Unfortunately, there are limitations. Some particles rendering in texture sheets where translucency is supported. So,
 * even if an individual particle from that sheet is not translucent, it will still be treated as translucent, and thus
 * will not be affected by this patch. Without making more invasive and sweeping changes, there isn't a great way to get
 * around this.
 * <p>
 * As the saying goes, "Work smarter, not harder."
 */
@Mixin(ParticleEngine.class)
public class MixinParticleEngine implements PhasedParticleEngine {
    @Unique
    private ParticleRenderingPhase phase = ParticleRenderingPhase.EVERYTHING;

    @Shadow
    @Final
    private static List<ParticleRenderType> RENDER_ORDER;

    @Shadow
    @Final
    private Map<ParticleRenderType, Queue<Particle>> particles;

    private static final List<ParticleRenderType> OPAQUE_PARTICLE_RENDER_TYPES;

    static {
        OPAQUE_PARTICLE_RENDER_TYPES = ImmutableList.of(
            ParticleRenderType.PARTICLE_SHEET_OPAQUE,
            ParticleRenderType.PARTICLE_SHEET_LIT,
            ParticleRenderType.CUSTOM,
            ParticleRenderType.NO_RENDER
        );
    }

    @ModifyExpressionValue(
        method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;" +
				 "Lnet/minecraft/client/renderer/MultiBufferSource$BufferSource;" +
				 "Lnet/minecraft/client/renderer/LightTexture;Lnet/minecraft/client/Camera;" +
				 "FLnet/minecraft/client/renderer/culling/Frustum;)V",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/client/particle/ParticleEngine;particles:Ljava/util/Map;"
        )
    )
    private Map<ParticleRenderType, Queue<Particle>> iris$selectParticlesToRender(Map original) {
        Map<ParticleRenderType, Queue<Particle>> toRender = Maps.newTreeMap(ForgeHooksClient.makeParticleRenderTypeComparator(RENDER_ORDER));
        for (Map.Entry<ParticleRenderType, Queue<Particle>> type : particles.entrySet()) {
            if (!((phase == ParticleRenderingPhase.TRANSLUCENT && OPAQUE_PARTICLE_RENDER_TYPES.contains(type.getKey())) || (phase == ParticleRenderingPhase.OPAQUE && type.getKey() == ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT))) {
                toRender.put(type.getKey(), type.getValue());
            }
        }
        return toRender;
    }

    @Override
    public void setParticleRenderingPhase(ParticleRenderingPhase phase) {
        this.phase = phase;
    }
}
