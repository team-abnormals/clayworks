package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.api.ClayworksTrims;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SpriteSourceProvider;

import java.util.concurrent.CompletableFuture;

public final class ClayworksSpriteSourceProvider extends SpriteSourceProvider {

	public ClayworksSpriteSourceProvider(PackOutput output, CompletableFuture<Provider> provider, ExistingFileHelper helper) {
		super(output, provider, Clayworks.MOD_ID, helper);
	}

	@Override
	protected void gather() {
		this.atlas(ClayworksTrims.DECORATED_POT_ATLAS)
				.addSource(ClayworksTrims.colorPermutations())
				.addSource(ClayworksTrims.materialPatternPermutations(
						TrimMaterials.QUARTZ,
						TrimMaterials.IRON,
						TrimMaterials.GOLD,
						TrimMaterials.DIAMOND,
						TrimMaterials.NETHERITE,
						TrimMaterials.REDSTONE,
						TrimMaterials.COPPER,
						TrimMaterials.EMERALD,
						TrimMaterials.LAPIS,
						TrimMaterials.AMETHYST
				));
	}
}