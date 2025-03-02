package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DataPackRegistryEvent;

public final class ClayworksRegistries {
	public static final ResourceKey<Registry<DecoratedPotTrimPattern>> DECORATED_POT_TRIM_PATTERN = key("decorated_pot_trim_pattern");

	public static void registerRegistries(DataPackRegistryEvent.NewRegistry event) {
		event.dataPackRegistry(DECORATED_POT_TRIM_PATTERN, DecoratedPotTrimPattern.CODEC, DecoratedPotTrimPattern.CODEC);
	}

	private static <T> ResourceKey<Registry<T>> key(String name) {
		return ResourceKey.createRegistryKey(new ResourceLocation(Clayworks.MOD_ID, name));
	}
}