package net.irisshaders.iris.pipeline.programs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;

import java.io.IOException;
import java.lang.invoke.MethodHandle;

public interface ShaderInstanceInterface {
	void iris$createExtraShaders(ResourceProvider factory, ResourceLocation name) throws IOException;

	void setShouldSkip(MethodHandle s);
}
