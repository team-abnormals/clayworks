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

import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

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

		tag(ClayworksTags.Items.TERRACOTTA_BRICKS)
				.add(TERRACOTTA_BRICKS.asItem())
				.add(WHITE_TERRACOTTA_BRICKS.asItem())
				.add(ORANGE_TERRACOTTA_BRICKS.asItem())
				.add(MAGENTA_TERRACOTTA_BRICKS.asItem())
				.add(YELLOW_TERRACOTTA_BRICKS.asItem())
				.add(LIGHT_BLUE_TERRACOTTA_BRICKS.asItem())
				.add(LIME_TERRACOTTA_BRICKS.asItem())
				.add(PINK_TERRACOTTA_BRICKS.asItem())
				.add(GRAY_TERRACOTTA_BRICKS.asItem())
				.add(LIGHT_GRAY_TERRACOTTA_BRICKS.asItem())
				.add(CYAN_TERRACOTTA_BRICKS.asItem())
				.add(PURPLE_TERRACOTTA_BRICKS.asItem())
				.add(BLUE_TERRACOTTA_BRICKS.asItem())
				.add(BROWN_TERRACOTTA_BRICKS.asItem())
				.add(GREEN_TERRACOTTA_BRICKS.asItem())
				.add(RED_TERRACOTTA_BRICKS.asItem())
				.add(BLACK_TERRACOTTA_BRICKS.asItem());
		tag(ClayworksTags.Items.TERRACOTTA_CHISELED_BRICKS)
				.add(CHISELED_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_WHITE_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_ORANGE_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_MAGENTA_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_YELLOW_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_LIGHT_BLUE_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_LIME_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_PINK_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_GRAY_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_LIGHT_GRAY_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_CYAN_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_PURPLE_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_BLUE_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_BROWN_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_GREEN_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_RED_TERRACOTTA_BRICKS.asItem())
				.add(CHISELED_BLACK_TERRACOTTA_BRICKS.asItem());
		tag(ClayworksTags.Items.TERRACOTTA_BRICK_SLABS)
				.add(TERRACOTTA_BRICK_SLAB.asItem())
				.add(WHITE_TERRACOTTA_BRICK_SLAB.asItem())
				.add(ORANGE_TERRACOTTA_BRICK_SLAB.asItem())
				.add(MAGENTA_TERRACOTTA_BRICK_SLAB.asItem())
				.add(YELLOW_TERRACOTTA_BRICK_SLAB.asItem())
				.add(LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.asItem())
				.add(LIME_TERRACOTTA_BRICK_SLAB.asItem())
				.add(PINK_TERRACOTTA_BRICK_SLAB.asItem())
				.add(GRAY_TERRACOTTA_BRICK_SLAB.asItem())
				.add(LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.asItem())
				.add(CYAN_TERRACOTTA_BRICK_SLAB.asItem())
				.add(PURPLE_TERRACOTTA_BRICK_SLAB.asItem())
				.add(BLUE_TERRACOTTA_BRICK_SLAB.asItem())
				.add(BROWN_TERRACOTTA_BRICK_SLAB.asItem())
				.add(GREEN_TERRACOTTA_BRICK_SLAB.asItem())
				.add(RED_TERRACOTTA_BRICK_SLAB.asItem())
				.add(BLACK_TERRACOTTA_BRICK_SLAB.asItem());
		tag(ClayworksTags.Items.TERRACOTTA_BRICK_WALLS)
				.add(TERRACOTTA_BRICK_WALL.asItem())
				.add(WHITE_TERRACOTTA_BRICK_WALL.asItem())
				.add(ORANGE_TERRACOTTA_BRICK_WALL.asItem())
				.add(MAGENTA_TERRACOTTA_BRICK_WALL.asItem())
				.add(YELLOW_TERRACOTTA_BRICK_WALL.asItem())
				.add(LIGHT_BLUE_TERRACOTTA_BRICK_WALL.asItem())
				.add(LIME_TERRACOTTA_BRICK_WALL.asItem())
				.add(PINK_TERRACOTTA_BRICK_WALL.asItem())
				.add(GRAY_TERRACOTTA_BRICK_WALL.asItem())
				.add(LIGHT_GRAY_TERRACOTTA_BRICK_WALL.asItem())
				.add(CYAN_TERRACOTTA_BRICK_WALL.asItem())
				.add(PURPLE_TERRACOTTA_BRICK_WALL.asItem())
				.add(BLUE_TERRACOTTA_BRICK_WALL.asItem())
				.add(BROWN_TERRACOTTA_BRICK_WALL.asItem())
				.add(GREEN_TERRACOTTA_BRICK_WALL.asItem())
				.add(RED_TERRACOTTA_BRICK_WALL.asItem())
				.add(BLACK_TERRACOTTA_BRICK_WALL.asItem());
		tag(ClayworksTags.Items.TERRACOTTA_BRICK_STAIRS)
				.add(TERRACOTTA_BRICK_STAIRS.asItem())
				.add(WHITE_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(ORANGE_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(MAGENTA_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(YELLOW_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(LIME_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(PINK_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(GRAY_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(CYAN_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(PURPLE_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(BLUE_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(BROWN_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(GREEN_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(RED_TERRACOTTA_BRICK_STAIRS.asItem())
				.add(BLACK_TERRACOTTA_BRICK_STAIRS.asItem());

		tag(ClayworksTags.Items.TERRACOTTA_SLABS)
				.add(TERRACOTTA_SLAB.asItem())
				.add(WHITE_TERRACOTTA_SLAB.asItem())
				.add(ORANGE_TERRACOTTA_SLAB.asItem())
				.add(MAGENTA_TERRACOTTA_SLAB.asItem())
				.add(YELLOW_TERRACOTTA_SLAB.asItem())
				.add(LIGHT_BLUE_TERRACOTTA_SLAB.asItem())
				.add(LIME_TERRACOTTA_SLAB.asItem())
				.add(PINK_TERRACOTTA_SLAB.asItem())
				.add(GRAY_TERRACOTTA_SLAB.asItem())
				.add(LIGHT_GRAY_TERRACOTTA_SLAB.asItem())
				.add(CYAN_TERRACOTTA_SLAB.asItem())
				.add(PURPLE_TERRACOTTA_SLAB.asItem())
				.add(BLUE_TERRACOTTA_SLAB.asItem())
				.add(BROWN_TERRACOTTA_SLAB.asItem())
				.add(GREEN_TERRACOTTA_SLAB.asItem())
				.add(RED_TERRACOTTA_SLAB.asItem())
				.add(BLACK_TERRACOTTA_SLAB.asItem());
		tag(ClayworksTags.Items.TERRACOTTA_WALLS)
				.add(TERRACOTTA_WALL.asItem())
				.add(WHITE_TERRACOTTA_WALL.asItem())
				.add(ORANGE_TERRACOTTA_WALL.asItem())
				.add(MAGENTA_TERRACOTTA_WALL.asItem())
				.add(YELLOW_TERRACOTTA_WALL.asItem())
				.add(LIGHT_BLUE_TERRACOTTA_WALL.asItem())
				.add(LIME_TERRACOTTA_WALL.asItem())
				.add(PINK_TERRACOTTA_WALL.asItem())
				.add(GRAY_TERRACOTTA_WALL.asItem())
				.add(LIGHT_GRAY_TERRACOTTA_WALL.asItem())
				.add(CYAN_TERRACOTTA_WALL.asItem())
				.add(PURPLE_TERRACOTTA_WALL.asItem())
				.add(BLUE_TERRACOTTA_WALL.asItem())
				.add(BROWN_TERRACOTTA_WALL.asItem())
				.add(GREEN_TERRACOTTA_WALL.asItem())
				.add(RED_TERRACOTTA_WALL.asItem())
				.add(BLACK_TERRACOTTA_WALL.asItem());
		tag(ClayworksTags.Items.TERRACOTTA_STAIRS)
				.add(TERRACOTTA_STAIRS.asItem())
				.add(WHITE_TERRACOTTA_STAIRS.asItem())
				.add(ORANGE_TERRACOTTA_STAIRS.asItem())
				.add(MAGENTA_TERRACOTTA_STAIRS.asItem())
				.add(YELLOW_TERRACOTTA_STAIRS.asItem())
				.add(LIGHT_BLUE_TERRACOTTA_STAIRS.asItem())
				.add(LIME_TERRACOTTA_STAIRS.asItem())
				.add(PINK_TERRACOTTA_STAIRS.asItem())
				.add(GRAY_TERRACOTTA_STAIRS.asItem())
				.add(LIGHT_GRAY_TERRACOTTA_STAIRS.asItem())
				.add(CYAN_TERRACOTTA_STAIRS.asItem())
				.add(PURPLE_TERRACOTTA_STAIRS.asItem())
				.add(BLUE_TERRACOTTA_STAIRS.asItem())
				.add(BROWN_TERRACOTTA_STAIRS.asItem())
				.add(GREEN_TERRACOTTA_STAIRS.asItem())
				.add(RED_TERRACOTTA_STAIRS.asItem())
				.add(BLACK_TERRACOTTA_STAIRS.asItem());

		tag(ClayworksTags.Items.GLASS_TRAPDOORS)
				.add(GLASS_TRAPDOOR.asItem())
				.add(WHITE_STAINED_GLASS_TRAPDOOR.asItem())
				.add(ORANGE_STAINED_GLASS_TRAPDOOR.asItem())
				.add(MAGENTA_STAINED_GLASS_TRAPDOOR.asItem())
				.add(YELLOW_STAINED_GLASS_TRAPDOOR.asItem())
				.add(LIGHT_BLUE_STAINED_GLASS_TRAPDOOR.asItem())
				.add(LIME_STAINED_GLASS_TRAPDOOR.asItem())
				.add(PINK_STAINED_GLASS_TRAPDOOR.asItem())
				.add(GRAY_STAINED_GLASS_TRAPDOOR.asItem())
				.add(LIGHT_GRAY_STAINED_GLASS_TRAPDOOR.asItem())
				.add(CYAN_STAINED_GLASS_TRAPDOOR.asItem())
				.add(PURPLE_STAINED_GLASS_TRAPDOOR.asItem())
				.add(BLUE_STAINED_GLASS_TRAPDOOR.asItem())
				.add(BROWN_STAINED_GLASS_TRAPDOOR.asItem())
				.add(GREEN_STAINED_GLASS_TRAPDOOR.asItem())
				.add(RED_STAINED_GLASS_TRAPDOOR.asItem())
				.add(BLACK_STAINED_GLASS_TRAPDOOR.asItem());
		tag(ClayworksTags.Items.GLASS_DOORS)
				.add(GLASS_DOOR.asItem())
				.add(WHITE_STAINED_GLASS_DOOR.asItem())
				.add(ORANGE_STAINED_GLASS_DOOR.asItem())
				.add(MAGENTA_STAINED_GLASS_DOOR.asItem())
				.add(YELLOW_STAINED_GLASS_DOOR.asItem())
				.add(LIGHT_BLUE_STAINED_GLASS_DOOR.asItem())
				.add(LIME_STAINED_GLASS_DOOR.asItem())
				.add(PINK_STAINED_GLASS_DOOR.asItem())
				.add(GRAY_STAINED_GLASS_DOOR.asItem())
				.add(LIGHT_GRAY_STAINED_GLASS_DOOR.asItem())
				.add(CYAN_STAINED_GLASS_DOOR.asItem())
				.add(PURPLE_STAINED_GLASS_DOOR.asItem())
				.add(BLUE_STAINED_GLASS_DOOR.asItem())
				.add(BROWN_STAINED_GLASS_DOOR.asItem())
				.add(GREEN_STAINED_GLASS_DOOR.asItem())
				.add(RED_STAINED_GLASS_DOOR.asItem())
				.add(BLACK_STAINED_GLASS_DOOR.asItem());


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
