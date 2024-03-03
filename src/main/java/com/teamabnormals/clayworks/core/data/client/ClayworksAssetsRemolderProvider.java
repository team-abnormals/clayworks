package com.teamabnormals.clayworks.core.data.client;

import com.google.common.collect.Lists;
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
		this.entry("decorated_pot_atlas")
				.path("minecraft:atlases/decorated_pot")
				.remolder(add(
						target("sources[]"),
						value(new DirectoryPalettedPermutations(
								"entity/decorated_pot", "entity/decorated_pot/",
								new ResourceLocation(Clayworks.MOD_ID, "entity/decorated_pot/color_palettes/decorated_pot_palette"),
								dyePaletteMappings()
						), SpriteSources.CODEC)
				));
	}

	public static List<ResourceLocation> textures() {
		List<String> patterns = List.of("entity/decorated_pot/decorated_pot_base",
				"entity/decorated_pot/decorated_pot_side",
				"entity/decorated_pot/angler_pottery_pattern",
				"entity/decorated_pot/archer_pottery_pattern",
				"entity/decorated_pot/arms_up_pottery_pattern",
				"entity/decorated_pot/blade_pottery_pattern",
				"entity/decorated_pot/brewer_pottery_pattern",
				"entity/decorated_pot/burn_pottery_pattern",
				"entity/decorated_pot/danger_pottery_pattern",
				"entity/decorated_pot/explorer_pottery_pattern",
				"entity/decorated_pot/friend_pottery_pattern",
				"entity/decorated_pot/heart_pottery_pattern",
				"entity/decorated_pot/heartbreak_pottery_pattern",
				"entity/decorated_pot/howl_pottery_pattern",
				"entity/decorated_pot/miner_pottery_pattern",
				"entity/decorated_pot/mourner_pottery_pattern",
				"entity/decorated_pot/plenty_pottery_pattern",
				"entity/decorated_pot/prize_pottery_pattern",
				"entity/decorated_pot/sheaf_pottery_pattern",
				"entity/decorated_pot/shelter_pottery_pattern",
				"entity/decorated_pot/skull_pottery_pattern",
				"entity/decorated_pot/snort_pottery_pattern",
				"clayworks:entity/decorated_pot/trims/decorated_pot_base");

		List<ResourceLocation> locs = Lists.newArrayList();
		patterns.forEach(pattern -> locs.add(new ResourceLocation(pattern)));

		return locs;
	}

	public static Map<String, ResourceLocation> dyePaletteMappings() {
		Map<String, ResourceLocation> map = Maps.newHashMap();
		for (DyeColor color : DyeColor.values()) {
			map.put(color.getName(), new ResourceLocation(Clayworks.MOD_ID, "entity/decorated_pot/color_palettes/" + color.getName()));
		}
		return map;
	}
}