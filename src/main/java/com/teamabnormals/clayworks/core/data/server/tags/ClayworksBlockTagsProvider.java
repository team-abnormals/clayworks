package com.teamabnormals.clayworks.core.data.server.tags;

import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

public class ClayworksBlockTagsProvider extends BlockTagsProvider {

	public ClayworksBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, ExistingFileHelper fileHelper) {
		super(output, lookupProvider, Clayworks.MOD_ID, fileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(CONCRETE_POWDER.get());
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(POTTERY_TABLE.get());

		this.tag(Tags.Blocks.CONCRETES).add(CONCRETE.get());
		this.tag(BlockTags.CONCRETE_POWDER).add(CONCRETE_POWDER.get());

		this.collect(BlockTags.STAIRS, block -> block instanceof StairBlock);
		this.collect(BlockTags.SLABS, block -> block instanceof SlabBlock);
		this.collect(BlockTags.WALLS, block -> block instanceof WallBlock);
		this.collect(BlockTags.DOORS, block -> block instanceof DoorBlock);
		this.collect(BlockTags.TRAPDOORS, block -> block instanceof TrapDoorBlock);

		IntrinsicTagAppender<Block> mineable = this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
		ClayworksBlocks.BLOCKS.getDeferredRegister().getEntries().forEach((holder -> {
			Block block = holder.get();
			if (!(block instanceof DecoratedPotBlock || block instanceof ConcretePowderBlock || block instanceof DoorBlock || block instanceof TrapDoorBlock || block == ClayworksBlocks.POTTERY_TABLE.get())) {
				mineable.add(block);
			}
		}));

		List<String> colors = Arrays.stream(DyeColor.values()).map(DyeColor::getName).toList();
		ClayworksBlocks.BLOCKS.getDeferredRegister().getEntries().forEach(holder -> {
			for (String color : colors) {
				if (holder.getRegisteredName().contains(color)) {
					this.tag(BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "dyed/" + color))).add(holder.get());
					break;
				}
			}
		});
	}

	public IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> collect(TagKey<Block> tag, Predicate<? super Block> predicate, Block... exclude) {
		return this.tag(tag).add(BLOCKS.getDeferredRegister().getEntries().stream().map(DeferredHolder::get).filter(predicate).filter(block -> !Arrays.stream(exclude).toList().contains(block)).toList().toArray(new Block[0]));
	}
}
