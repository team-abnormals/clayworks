package com.teamabnormals.clayworks.core.data.server.tags;

import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static com.teamabnormals.clayworks.core.registry.ClayworksPaintingVariants.BAKED;

public class ClayworksPaintingVariantTagsProvider extends PaintingVariantTagsProvider {

	public ClayworksPaintingVariantTagsProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
		super(packOutput, lookupProvider, Clayworks.MOD_ID, helper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(PaintingVariantTags.PLACEABLE).add(BAKED.getKey());
	}
}
