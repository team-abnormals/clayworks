package com.teamabnormals.clayworks.core.data.server.tags;

import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ClayworksBlockTagsProvider extends BlockTagsProvider {

	public ClayworksBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Clayworks.MOD_ID, existingFileHelper);
	}

	@Override
	public void addTags() {
		TagAppender<Block> mineable = this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
		TagAppender<Block> stairs = this.tag(BlockTags.STAIRS);
		TagAppender<Block> slabs = this.tag(BlockTags.SLABS);
		TagAppender<Block> verticalSlabs = this.tag(BlueprintBlockTags.VERTICAL_SLABS);
		TagAppender<Block> walls = this.tag(BlockTags.WALLS);

		ClayworksBlocks.HELPER.getDeferredRegister().getEntries().forEach((registryObject -> {
			Block block = registryObject.get();
			mineable.add(block);
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
