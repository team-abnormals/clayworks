package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.api.ClayworksTrims;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;

public final class ClayworksSpriteSourceProvider extends SpriteSourceProvider {

	public ClayworksSpriteSourceProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, helper, Clayworks.MOD_ID);
	}

	@Override
	protected void addSources() {
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