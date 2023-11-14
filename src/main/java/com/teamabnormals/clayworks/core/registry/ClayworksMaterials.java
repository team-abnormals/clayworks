package com.teamabnormals.clayworks.core.registry;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;

import javax.annotation.Nullable;
import java.util.Map;

public class ClayworksMaterials {
	public static final Map<Pair<ResourceKey<String>, DyeColor>, Material> DECORATED_POT_MATERIALS = formDecoratedPotMaterials();

	private static Map<Pair<ResourceKey<String>, DyeColor>, Material> formDecoratedPotMaterials() {
		Map<Pair<ResourceKey<String>, DyeColor>, Material> map = Maps.newHashMap();
		for (ResourceKey<String> key : BuiltInRegistries.DECORATED_POT_PATTERNS.registryKeySet()) {
			for (DyeColor color : DyeColor.values()) {
				map.put(Pair.of(key, color), createDecoratedPotMaterial(key, color));
			}
		}
		return map;
	}

	private static Material createDecoratedPotMaterial(ResourceKey<String> name, DyeColor color) {
		return new Material(Sheets.DECORATED_POT_SHEET, name.location().withPrefix("entity/decorated_pot/").withSuffix("_" + color.getName()));
	}

	@Nullable
	public static Material getDecoratedPotMaterial(@Nullable ResourceKey<String> string, DyeColor color) {
		return string == null ? null : DECORATED_POT_MATERIALS.get(Pair.of(string, color));
	}
}
