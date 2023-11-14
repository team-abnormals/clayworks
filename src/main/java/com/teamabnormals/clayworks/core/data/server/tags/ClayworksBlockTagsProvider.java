package com.teamabnormals.clayworks.core.data.server.tags;

import com.teamabnormals.blueprint.common.block.quark.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ClayworksBlockTagsProvider extends BlockTagsProvider {

	public ClayworksBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, ExistingFileHelper fileHelper) {
		super(output, lookupProvider, Clayworks.MOD_ID, fileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		IntrinsicTagAppender<Block> mineable = this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
		IntrinsicTagAppender<Block> stairs = this.tag(BlockTags.STAIRS);
		IntrinsicTagAppender<Block> slabs = this.tag(BlockTags.SLABS);
		IntrinsicTagAppender<Block> verticalSlabs = this.tag(BlueprintBlockTags.VERTICAL_SLABS);
		IntrinsicTagAppender<Block> walls = this.tag(BlockTags.WALLS);

		ClayworksBlocks.HELPER.getDeferredRegister().getEntries().forEach((registryObject -> {
			Block block = registryObject.get();
			if (!(block instanceof DecoratedPotBlock)) {
				mineable.add(block);
			}
			if (block instanceof SlabBlock) {
				slabs.add(block);
			} else if (block instanceof VerticalSlabBlock) {
				verticalSlabs.add(block);
			} else if (block instanceof StairBlock) {
				stairs.add(block);
			} else if (block instanceof WallBlock) {
				walls.add(block);
			}
		}));
	}
}
