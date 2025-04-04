package com.teamabnormals.clayworks.core.other;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;

import javax.annotation.Nullable;
import java.util.Map;

public class ClayworksMaterials {
	public static final Map<DyeColor, Material> DECORATED_POT_BASE_MATERIALS = formDecoratedPotBaseMaterials();
	public static final Map<Pair<ResourceKey<DecoratedPotPattern>, DyeColor>, Material> DECORATED_POT_MATERIALS = formDecoratedPotMaterials();

	private static Map<Pair<ResourceKey<DecoratedPotPattern>, DyeColor>, Material> formDecoratedPotMaterials() {
		Map<Pair<ResourceKey<DecoratedPotPattern>, DyeColor>, Material> map = Maps.newHashMap();
		for (Holder<DecoratedPotPattern> pattern : BuiltInRegistries.DECORATED_POT_PATTERN.holders().toList()) {
			for (DyeColor color : DyeColor.values()) {
				map.put(Pair.of(pattern.getKey(), color), createDecoratedPotMaterial(pattern.value().assetId(), color));
			}
		}
		return map;
	}

	private static Map<DyeColor, Material> formDecoratedPotBaseMaterials() {
		Map<DyeColor, Material> map = Maps.newHashMap();
		for (DyeColor color : DyeColor.values()) {
			map.put(color, createDecoratedPotMaterial(ResourceLocation.withDefaultNamespace("decorated_pot_base"), color));
		}
		return map;
	}

	private static Material createDecoratedPotMaterial(ResourceLocation assetId, DyeColor color) {
		return new Material(Sheets.DECORATED_POT_SHEET, assetId.withPrefix("entity/decorated_pot/").withSuffix("_" + color.getName()));
	}

	public static Material createTrimMaterial(ResourceLocation location, @Nullable DyeColor color) {
		return new Material(Sheets.DECORATED_POT_SHEET, location.withPrefix("entity/decorated_pot/").withSuffix(color != null ? "_" + color.getName() : ""));
	}

	public static Material createTrimMaterial(ResourceLocation location, String trimMaterial) {
		return new Material(Sheets.DECORATED_POT_SHEET, location.withSuffix("_" + trimMaterial));
	}

	@Nullable
	public static Material getDecoratedPotMaterial(@Nullable ResourceKey<DecoratedPotPattern> string, DyeColor color) {
		return string == null ? null : DECORATED_POT_MATERIALS.get(Pair.of(string, color));
	}
}
