package com.teamabnormals.clayworks.core.data.server.tags;

import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ClayworksItemTagsProvider extends ItemTagsProvider {

	public ClayworksItemTagsProvider(PackOutput output, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> lookup, ExistingFileHelper fileHelper) {
		super(output, provider, lookup, Clayworks.MOD_ID, fileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
		this.copy(BlockTags.WALLS, ItemTags.WALLS);
		this.copy(BlockTags.SLABS, ItemTags.SLABS);
		this.copy(BlockTags.DOORS, ItemTags.DOORS);
		this.copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);

		this.copy(Tags.Blocks.CONCRETES, Tags.Items.CONCRETES);
		this.copy(BlockTags.CONCRETE_POWDER, Tags.Items.CONCRETE_POWDERS);

		List<String> colors = Arrays.stream(DyeColor.values()).map(DyeColor::getName).toList();
		ClayworksBlocks.ITEMS.getDeferredRegister().getEntries().forEach(holder -> {
			for (String color : colors) {
				if (holder.getRegisteredName().contains(color) && !(!color.contains("light_") && holder.getRegisteredName().contains("light_"))) {
					this.tag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "dyed/" + color))).add(holder.get());
					break;
				}
			}
		});
	}
}
