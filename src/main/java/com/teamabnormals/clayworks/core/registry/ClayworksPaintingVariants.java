package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ClayworksPaintingVariants {
	public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, Clayworks.MOD_ID);

	public static final RegistryObject<PaintingVariant> BAKED = PAINTING_VARIANTS.register("baked", () -> new PaintingVariant(16, 16));
}