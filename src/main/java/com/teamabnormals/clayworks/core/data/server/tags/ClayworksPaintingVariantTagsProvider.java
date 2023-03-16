package com.teamabnormals.clayworks.core.data.server.tags;

import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.teamabnormals.clayworks.core.registry.ClayworksPaintingVariants.BAKED;

public class ClayworksPaintingVariantTagsProvider extends PaintingVariantTagsProvider {

	public ClayworksPaintingVariantTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Clayworks.MOD_ID, helper);
	}

	@Override
	public void addTags() {
		this.tag(PaintingVariantTags.PLACEABLE).add(BAKED.get());
	}
}
