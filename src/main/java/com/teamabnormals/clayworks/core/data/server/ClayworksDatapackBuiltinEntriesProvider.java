package com.teamabnormals.clayworks.core.data.server;

import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import com.teamabnormals.clayworks.core.registry.datapack.ClayworksPaintingVariants;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ClayworksDatapackBuiltinEntriesProvider extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN, DecoratedPotTrimPattern::bootstrap)
			.add(Registries.PAINTING_VARIANT, ClayworksPaintingVariants::bootstrap);

	public ClayworksDatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(output, provider, BUILDER, Set.of(Clayworks.MOD_ID));
	}
}