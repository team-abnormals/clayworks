package com.teamabnormals.clayworks.core.api;

import com.mojang.datafixers.util.Either;
import com.teamabnormals.blueprint.client.renderer.texture.atlas.BlueprintPalettedPermutations;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.renderer.texture.atlas.sources.DirectoryLister;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.HashMap;
import java.util.List;

public class ClayworksTrims {
	public static final ResourceLocation DECORATED_POT_ATLAS = ResourceLocation.withDefaultNamespace("decorated_pot");

	public static final ResourceLocation COLOR_PALETTE_KEY = Clayworks.location("entity/decorated_pot_color_palettes/decorated_pot_palette");
	public static final ResourceLocation TRIM_PALETTE_KEY = Clayworks.location("entity/decorated_pot_trim_palettes/trim_palette");

	public static BlueprintPalettedPermutations colorPermutations() {
		return new BlueprintPalettedPermutations(Either.left(List.of(
				new DirectoryLister("entity/decorated_pot", "entity/decorated_pot/"))),
				COLOR_PALETTE_KEY, getColorPermutations());
	}

	private static HashMap<String, ResourceLocation> getColorPermutations() {
		HashMap<String, ResourceLocation> permutations = new HashMap<>();
		for (DyeColor key : DyeColor.values()) {
			String name = key.getName();
			permutations.put(name, Clayworks.location("entity/decorated_pot_color_palettes/" + name));
		}
		return permutations;
	}

	@SafeVarargs
	public static BlueprintPalettedPermutations materialPatternPermutations(ResourceKey<TrimMaterial>... keys) {
		return new BlueprintPalettedPermutations(Either.left(List.of(
				new DirectoryLister("entity/decorated_pot_trim_patterns", "entity/decorated_pot_trim_patterns/"))),
				TRIM_PALETTE_KEY, getPermutations(keys));
	}

	@SafeVarargs
	private static HashMap<String, ResourceLocation> getPermutations(ResourceKey<TrimMaterial>... keys) {
		HashMap<String, ResourceLocation> permutations = new HashMap<>();
		for (var key : keys) {
			ResourceLocation location = key.location();
			String name = location.getNamespace() + "_" + location.getPath();

			if (location.getNamespace().equals("minecraft")) {
				name = location.getPath();
				location = Clayworks.location(name);
			}

			permutations.put(name, location.withPath(string -> "entity/decorated_pot_trim_palettes/" + string));
		}
		return permutations;
	}
}
