package net.irisshaders.iris.mixin;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.shaders.Program;
import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.irisshaders.iris.Iris;
import net.irisshaders.iris.gl.GLDebug;
import net.irisshaders.iris.gl.IrisRenderSystem;
import net.irisshaders.iris.gl.blending.DepthColorStorage;
import net.irisshaders.iris.pipeline.IrisRenderingPipeline;
import net.irisshaders.iris.pipeline.ShaderRenderingPipeline;
import net.irisshaders.iris.pipeline.WorldRenderingPipeline;
import net.irisshaders.iris.pipeline.programs.ExtendedShader;
import net.irisshaders.iris.pipeline.programs.FallbackShader;
import net.irisshaders.iris.pipeline.programs.ShaderInstanceInterface;
import net.irisshaders.iris.shadows.ShadowRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.util.GsonHelper;
import org.lwjgl.opengl.ARBTextureSwizzle;
import org.lwjgl.opengl.GL20C;
import org.lwjgl.opengl.GL30C;
import net.minecraft.util.GsonHelper;
import org.lwjgl.opengl.KHRDebug;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.IOException;
import java.io.Reader;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Map;
import java.util.Objects;

@Mixin(ShaderInstance.class)
public abstract class MixinShaderInstance implements ShaderInstanceInterface {
    @Unique
    private static final ImmutableSet<String> ATTRIBUTE_LIST = ImmutableSet.of("Position", "Color", "Normal", "UV0", "UV1", "UV2");
    @Shadow
    private static ShaderInstance lastAppliedShader;
    @Shadow
    @Final
    private int programId;
    @Shadow
    @Final
    private Program vertexProgram;
    @Shadow
    @Final
    private Program fragmentProgram;
    @Unique
    private static final MethodHandle NONE = MethodHandles.constant(Integer.class, 2);

    @Unique
    private static final MethodHandle ALWAYS = MethodHandles.constant(Integer.class, 1);

    @Unique
    private MethodHandle shouldSkip;

    private static Map<Class<?>, MethodHandle> shouldSkipList = new Object2ObjectOpenHashMap<>();

    static {
        shouldSkipList.put(ExtendedShader.class, NONE);
        shouldSkipList.put(FallbackShader.class, NONE);
    }

    @Inject(method = "<init>(Lnet/minecraft/server/packs/resources/ResourceProvider;Lnet/minecraft/resources/ResourceLocation;Lcom/mojang/blaze3d/vertex/VertexFormat;)V", at = @At("TAIL"), require = 0)
    private void iriss$storeSkip(ResourceProvider resourceProvider, ResourceLocation string, VertexFormat vertexFormat, CallbackInfo ci) {
        shouldSkip = shouldSkipList.computeIfAbsent(getClass(), x -> {
            try {
                MethodHandle iris$skipDraw = MethodHandles.lookup().findVirtual(x, "iris$skipDraw", MethodType.methodType(boolean.class));
                Iris.logger.warn("Class " + x.getName() + " has opted out of being rendered with shaders.");
                return iris$skipDraw;
            } catch (NoSuchMethodException | IllegalAccessException e) {
                return NONE;
            }
        });


        if (Iris.getIrisConfig().shouldSkip(string)) {
            shouldSkip = ALWAYS;
        }
    }

    public boolean iris$shouldSkipThis() {
        if (Iris.getIrisConfig().shouldAllowUnknownShaders()) {
            if (ShadowRenderer.ACTIVE) return true;

            if (!shouldOverrideShaders()) return false;

            if (shouldSkip == NONE) return false;
            if (shouldSkip == ALWAYS) return true;

            try {
                return (boolean) shouldSkip.invoke(((ShaderInstance) (Object) this));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        } else {
            return !(((Object) this) instanceof ExtendedShader || ((Object) this) instanceof FallbackShader || !shouldOverrideShaders());
        }
    }

    private static boolean shouldOverrideShaders() {
        WorldRenderingPipeline pipeline = Iris.getPipelineManager().getPipelineNullable();

        if (pipeline instanceof ShaderRenderingPipeline) {
            return ((ShaderRenderingPipeline) pipeline).shouldOverrideShaders();
        } else {
            return false;
        }
    }

    @Shadow
    public abstract int getId();

    @Redirect(method = "updateLocations",
            at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", remap = false))
    private void iris$redirectLogSpam(Logger logger, String message, Object arg1, Object arg2) {
        if (((Object) this) instanceof ExtendedShader || ((Object) this) instanceof FallbackShader) {
            return;
        }

        logger.warn(message, arg1, arg2);
    }

    @Redirect(method = "<init>(Lnet/minecraft/server/packs/resources/ResourceProvider;Lnet/minecraft/resources/ResourceLocation;Lcom/mojang/blaze3d/vertex/VertexFormat;)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/shaders/Uniform;glBindAttribLocation(IILjava/lang/CharSequence;)V"))
    public void iris$redirectBindAttributeLocation(int i, int j, CharSequence charSequence) {
        if (((Object) this) instanceof ExtendedShader && ATTRIBUTE_LIST.contains(charSequence)) {
            Uniform.glBindAttribLocation(i, j, "iris_" + charSequence);
        } else {
            Uniform.glBindAttribLocation(i, j, charSequence);
        }
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void name(ResourceProvider resourceProvider, String string, VertexFormat vertexFormat, CallbackInfo ci) {
        GLDebug.nameObject(KHRDebug.GL_PROGRAM, this.programId, string);
        GLDebug.nameObject(KHRDebug.GL_SHADER, this.vertexProgram.getId(), string);
        GLDebug.nameObject(KHRDebug.GL_SHADER, this.fragmentProgram.getId(), string);
    }

    @Inject(method = "apply", at = @At("TAIL"))
    private void iris$lockDepthColorState(CallbackInfo ci) {
        if (((Object) this) instanceof ExtendedShader || ((Object) this) instanceof FallbackShader || !shouldOverrideShaders()) {
            return;
        }

        DepthColorStorage.disableDepthColor();
    }

    @Inject(method = "clear", at = @At("HEAD"))
    private void iris$unlockDepthColorState(CallbackInfo ci) {
        if (((Object) this) instanceof ExtendedShader || ((Object) this) instanceof FallbackShader || !shouldOverrideShaders()) {
            return;
        }

        DepthColorStorage.unlockDepthColor();
    }

    @Inject(method = "apply", at = @At("TAIL"))
    private void onTail(CallbackInfo ci) {
        if (!iris$shouldSkipThis()) {
            if (!isKnownShader() && shouldOverrideShaders()) {
                WorldRenderingPipeline pipeline = Iris.getPipelineManager().getPipelineNullable();

                if (pipeline instanceof IrisRenderingPipeline) {
                    if (ShadowRenderer.ACTIVE) {
                        // ((IrisRenderingPipeline) pipeline).bindDefaultShadow(); don't rn
                    } else {
                        ((IrisRenderingPipeline) pipeline).bindDefault();
                    }
                }
            }

            return;
        }

        DepthColorStorage.disableDepthColor();
    }

    private boolean isKnownShader() {
        return ((Object) this) instanceof ExtendedShader || ((Object) this) instanceof FallbackShader;
    }

    @Redirect(method = "<init>(Lnet/minecraft/server/packs/resources/ResourceProvider;Lnet/minecraft/resources/ResourceLocation;Lcom/mojang/blaze3d/vertex/VertexFormat;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/GsonHelper;parse(Ljava/io/Reader;)Lcom/google/gson/JsonObject;"))
    public JsonObject iris$setupGeometryShader(Reader reader, ResourceProvider resourceProvider, ResourceLocation name, VertexFormat vertexFormat) {
        this.iris$createExtraShaders(resourceProvider, name);
        return GsonHelper.parse(reader);
    }


    @Override
    public void iris$createExtraShaders(ResourceProvider provider, ResourceLocation name) {
        //no-op, used for ExtendedShader to call before the super constructor
    }
}
