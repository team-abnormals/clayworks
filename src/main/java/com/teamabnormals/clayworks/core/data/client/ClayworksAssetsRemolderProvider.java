package com.teamabnormals.clayworks.core.data.client;

import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.common.remolder.data.RemolderProvider;
import com.teamabnormals.clayworks.client.renderer.texture.atlas.sources.DirectoryPalettedPermutations;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.teamabnormals.blueprint.common.remolder.RemolderTypes.add;
import static com.teamabnormals.blueprint.common.remolder.data.DynamicReference.target;
import static com.teamabnormals.blueprint.common.remolder.data.DynamicReference.value;

public final class ClayworksAssetsRemolderProvider extends RemolderProvider {

	public ClayworksAssetsRemolderProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(Clayworks.MOD_ID, PackOutput.Target.RESOURCE_PACK, packOutput, lookupProvider);
	}

	@Override
	protected void registerEntries(HolderLookup.Provider provider) {
		this.entry("decorated_pot_atlas_colors")
				.path("minecraft:atlases/decorated_pot")
				.remolder(add(
						target("sources[]"),
						value(new DirectoryPalettedPermutations(
								"entity/decorated_pot", "entity/decorated_pot/",
								new ResourceLocation(Clayworks.MOD_ID, "entity/decorated_pot/color_palettes/decorated_pot_palette"),
								dyePaletteMappings()
						), SpriteSources.CODEC)
				));

		this.entry("decorated_pot_atlas_trims")
				.path("minecraft:atlases/decorated_pot")
				.remolder(add(
						target("sources[]"),
						value(new DirectoryPalettedPermutations(
								"entity/decorated_pot/trims", "entity/decorated_pot/trims/",
								new ResourceLocation(Clayworks.MOD_ID, "entity/decorated_pot/trims/color_palettes/decorated_pot_trim_palette"),
								trimPaletteMappings()
						), SpriteSources.CODEC)
				));
	}

	public static Map<String, ResourceLocation> dyePaletteMappings() {
		Map<String, ResourceLocation> map = Maps.newHashMap();
		for (DyeColor color : DyeColor.values()) {
			map.put(color.getName(), new ResourceLocation(Clayworks.MOD_ID, "entity/decorated_pot/color_palettes/" + color.getName()));
		}
		return map;
	}

	public static Map<String, ResourceLocation> trimPaletteMappings() {
		Map<String, ResourceLocation> map = Maps.newHashMap();
		List<String> trimMaterials = List.of(
				"amethyst_shard", "copper_ingot", "diamond", "emerald", "gold_ingot", "iron_ingot", "lapis_lazuli", "netherite_ingot", "quartz", "redstone",
				"necromium_ingot", "sanguine_plating", "silver_ingot", "spinel"
		);
		for (String str : trimMaterials) {
			map.put(str, new ResourceLocation(Clayworks.MOD_ID, "entity/decorated_pot/trims/color_palettes/" + str));
		}
		return map;
	}
}