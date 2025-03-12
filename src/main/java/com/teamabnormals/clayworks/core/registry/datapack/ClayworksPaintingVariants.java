package com.teamabnormals.clayworks.core.registry.datapack;

import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class ClayworksPaintingVariants {
	public static final ResourceKey<PaintingVariant> BAKED = create("baked");

	public static void bootstrap(BootstrapContext<PaintingVariant> context) {
		register(context, BAKED, 1, 1);
	}

	private static ResourceKey<PaintingVariant> create(String name) {
		return ResourceKey.create(Registries.PAINTING_VARIANT, Clayworks.location(name));
	}

	private static void register(BootstrapContext<PaintingVariant> context, ResourceKey<PaintingVariant> key, int width, int height) {
		context.register(key, new PaintingVariant(width, height, key.location()));
	}
}