package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.core.api.BlockSetTypeRegistryHelper;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.clayworks.common.block.GlassDoorBlock;
import com.teamabnormals.clayworks.common.block.GlassTrapDoorBlock;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.common.block.PotteryTableBlock;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.registry.helper.ClayworksBlockSubRegistryHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;

import javax.annotation.Nullable;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

public class ClayworksBlocks {
	public static final ClayworksBlockSubRegistryHelper HELPER = Clayworks.REGISTRY_HELPER.getBlockSubHelper();

	public static final DeferredBlock<Block> KILN = HELPER.createBlock("kiln", () -> new KilnBlock(ClayworksProperties.KILN));
	public static final DeferredBlock<Block> POTTERY_TABLE = HELPER.createBlock("pottery_table", () -> new PotteryTableBlock(ClayworksProperties.POTTERY_TABLE));

	public static final DeferredBlock<Block> CHISELED_BRICKS = HELPER.createBlock("chiseled_bricks", () -> new Block(ClayworksProperties.BRICKS));
	public static final DeferredBlock<Block> GLAZED_TERRACOTTA = HELPER.createBlock("glazed_terracotta", () -> new GlazedTerracottaBlock(ClayworksProperties.GLAZED_TERRACOTTA));
	public static final DeferredBlock<Block> CONCRETE = HELPER.createBlock("concrete", () -> new GlazedTerracottaBlock(ClayworksProperties.CONCRETE));
	public static final DeferredBlock<Block> CONCRETE_POWDER = HELPER.createBlock("concrete_powder", () -> new ConcretePowderBlock(CONCRETE.get(), ClayworksProperties.CONCRETE_POWDER));

	public static final DeferredBlock<Block> TERRACOTTA_STAIRS = HELPER.createBlock("terracotta_stairs", () -> new StairBlock(Blocks.TERRACOTTA.defaultBlockState(), ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> WHITE_TERRACOTTA_STAIRS = HELPER.createBlock("white_terracotta_stairs", () -> new StairBlock(Blocks.WHITE_TERRACOTTA.defaultBlockState(), ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> ORANGE_TERRACOTTA_STAIRS = HELPER.createBlock("orange_terracotta_stairs", () -> new StairBlock(Blocks.ORANGE_TERRACOTTA.defaultBlockState(), ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_STAIRS = HELPER.createBlock("magenta_terracotta_stairs", () -> new StairBlock(Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> YELLOW_TERRACOTTA_STAIRS = HELPER.createBlock("yellow_terracotta_stairs", () -> new StairBlock(Blocks.YELLOW_TERRACOTTA.defaultBlockState(), ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = HELPER.createBlock("light_blue_terracotta_stairs", () -> new StairBlock(Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> LIME_TERRACOTTA_STAIRS = HELPER.createBlock("lime_terracotta_stairs", () -> new StairBlock(Blocks.LIME_TERRACOTTA.defaultBlockState(), ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> PINK_TERRACOTTA_STAIRS = HELPER.createBlock("pink_terracotta_stairs", () -> new StairBlock(Blocks.PINK_TERRACOTTA.defaultBlockState(), ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> GRAY_TERRACOTTA_STAIRS = HELPER.createBlock("gray_terracotta_stairs", () -> new StairBlock(Blocks.GRAY_TERRACOTTA.defaultBlockState(), ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = HELPER.createBlock("light_gray_terracotta_stairs", () -> new StairBlock(Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), ClayworksProperties.LIGHT_GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CYAN_TERRACOTTA_STAIRS = HELPER.createBlock("cyan_terracotta_stairs", () -> new StairBlock(Blocks.CYAN_TERRACOTTA.defaultBlockState(), ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> PURPLE_TERRACOTTA_STAIRS = HELPER.createBlock("purple_terracotta_stairs", () -> new StairBlock(Blocks.PURPLE_TERRACOTTA.defaultBlockState(), ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> BLUE_TERRACOTTA_STAIRS = HELPER.createBlock("blue_terracotta_stairs", () -> new StairBlock(Blocks.BLUE_TERRACOTTA.defaultBlockState(), ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> BROWN_TERRACOTTA_STAIRS = HELPER.createBlock("brown_terracotta_stairs", () -> new StairBlock(Blocks.BROWN_TERRACOTTA.defaultBlockState(), ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> GREEN_TERRACOTTA_STAIRS = HELPER.createBlock("green_terracotta_stairs", () -> new StairBlock(Blocks.GREEN_TERRACOTTA.defaultBlockState(), ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> RED_TERRACOTTA_STAIRS = HELPER.createBlock("red_terracotta_stairs", () -> new StairBlock(Blocks.RED_TERRACOTTA.defaultBlockState(), ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> BLACK_TERRACOTTA_STAIRS = HELPER.createBlock("black_terracotta_stairs", () -> new StairBlock(Blocks.BLACK_TERRACOTTA.defaultBlockState(), ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> TERRACOTTA_SLAB = HELPER.createBlock("terracotta_slab", () -> new SlabBlock(ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> WHITE_TERRACOTTA_SLAB = HELPER.createBlock("white_terracotta_slab", () -> new SlabBlock(ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> ORANGE_TERRACOTTA_SLAB = HELPER.createBlock("orange_terracotta_slab", () -> new SlabBlock(ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_SLAB = HELPER.createBlock("magenta_terracotta_slab", () -> new SlabBlock(ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_SLAB = HELPER.createBlock("light_blue_terracotta_slab", () -> new SlabBlock(ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> YELLOW_TERRACOTTA_SLAB = HELPER.createBlock("yellow_terracotta_slab", () -> new SlabBlock(ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> LIME_TERRACOTTA_SLAB = HELPER.createBlock("lime_terracotta_slab", () -> new SlabBlock(ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> PINK_TERRACOTTA_SLAB = HELPER.createBlock("pink_terracotta_slab", () -> new SlabBlock(ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> GRAY_TERRACOTTA_SLAB = HELPER.createBlock("gray_terracotta_slab", () -> new SlabBlock(ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_SLAB = HELPER.createBlock("light_gray_terracotta_slab", () -> new SlabBlock(ClayworksProperties.LIGHT_GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CYAN_TERRACOTTA_SLAB = HELPER.createBlock("cyan_terracotta_slab", () -> new SlabBlock(ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> PURPLE_TERRACOTTA_SLAB = HELPER.createBlock("purple_terracotta_slab", () -> new SlabBlock(ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> BLUE_TERRACOTTA_SLAB = HELPER.createBlock("blue_terracotta_slab", () -> new SlabBlock(ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> BROWN_TERRACOTTA_SLAB = HELPER.createBlock("brown_terracotta_slab", () -> new SlabBlock(ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> GREEN_TERRACOTTA_SLAB = HELPER.createBlock("green_terracotta_slab", () -> new SlabBlock(ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> RED_TERRACOTTA_SLAB = HELPER.createBlock("red_terracotta_slab", () -> new SlabBlock(ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> BLACK_TERRACOTTA_SLAB = HELPER.createBlock("black_terracotta_slab", () -> new SlabBlock(ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> TERRACOTTA_WALL = HELPER.createBlock("terracotta_wall", () -> new WallBlock(ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> WHITE_TERRACOTTA_WALL = HELPER.createBlock("white_terracotta_wall", () -> new WallBlock(ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> ORANGE_TERRACOTTA_WALL = HELPER.createBlock("orange_terracotta_wall", () -> new WallBlock(ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_WALL = HELPER.createBlock("magenta_terracotta_wall", () -> new WallBlock(ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_WALL = HELPER.createBlock("light_blue_terracotta_wall", () -> new WallBlock(ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> YELLOW_TERRACOTTA_WALL = HELPER.createBlock("yellow_terracotta_wall", () -> new WallBlock(ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> LIME_TERRACOTTA_WALL = HELPER.createBlock("lime_terracotta_wall", () -> new WallBlock(ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> PINK_TERRACOTTA_WALL = HELPER.createBlock("pink_terracotta_wall", () -> new WallBlock(ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> GRAY_TERRACOTTA_WALL = HELPER.createBlock("gray_terracotta_wall", () -> new WallBlock(ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_WALL = HELPER.createBlock("light_gray_terracotta_wall", () -> new WallBlock(ClayworksProperties.LIGHT_GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CYAN_TERRACOTTA_WALL = HELPER.createBlock("cyan_terracotta_wall", () -> new WallBlock(ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> PURPLE_TERRACOTTA_WALL = HELPER.createBlock("purple_terracotta_wall", () -> new WallBlock(ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> BLUE_TERRACOTTA_WALL = HELPER.createBlock("blue_terracotta_wall", () -> new WallBlock(ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> BROWN_TERRACOTTA_WALL = HELPER.createBlock("brown_terracotta_wall", () -> new WallBlock(ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> GREEN_TERRACOTTA_WALL = HELPER.createBlock("green_terracotta_wall", () -> new WallBlock(ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> RED_TERRACOTTA_WALL = HELPER.createBlock("red_terracotta_wall", () -> new WallBlock(ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> BLACK_TERRACOTTA_WALL = HELPER.createBlock("black_terracotta_wall", () -> new WallBlock(ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> TERRACOTTA_BRICKS = HELPER.createBlock("terracotta_bricks", () -> new Block(ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> WHITE_TERRACOTTA_BRICKS = HELPER.createBlock("white_terracotta_bricks", () -> new Block(ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> ORANGE_TERRACOTTA_BRICKS = HELPER.createBlock("orange_terracotta_bricks", () -> new Block(ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_BRICKS = HELPER.createBlock("magenta_terracotta_bricks", () -> new Block(ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("light_blue_terracotta_bricks", () -> new Block(ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> YELLOW_TERRACOTTA_BRICKS = HELPER.createBlock("yellow_terracotta_bricks", () -> new Block(ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> LIME_TERRACOTTA_BRICKS = HELPER.createBlock("lime_terracotta_bricks", () -> new Block(ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> PINK_TERRACOTTA_BRICKS = HELPER.createBlock("pink_terracotta_bricks", () -> new Block(ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("gray_terracotta_bricks", () -> new Block(ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("light_gray_terracotta_bricks", () -> new Block(ClayworksProperties.LIGHT_GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CYAN_TERRACOTTA_BRICKS = HELPER.createBlock("cyan_terracotta_bricks", () -> new Block(ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> PURPLE_TERRACOTTA_BRICKS = HELPER.createBlock("purple_terracotta_bricks", () -> new Block(ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("blue_terracotta_bricks", () -> new Block(ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> BROWN_TERRACOTTA_BRICKS = HELPER.createBlock("brown_terracotta_bricks", () -> new Block(ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> GREEN_TERRACOTTA_BRICKS = HELPER.createBlock("green_terracotta_bricks", () -> new Block(ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> RED_TERRACOTTA_BRICKS = HELPER.createBlock("red_terracotta_bricks", () -> new Block(ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> BLACK_TERRACOTTA_BRICKS = HELPER.createBlock("black_terracotta_bricks", () -> new Block(ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("terracotta_brick_stairs", () -> new StairBlock(TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> WHITE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("white_terracotta_brick_stairs", () -> new StairBlock(WHITE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> ORANGE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("orange_terracotta_brick_stairs", () -> new StairBlock(ORANGE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("magenta_terracotta_brick_stairs", () -> new StairBlock(MAGENTA_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> YELLOW_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("yellow_terracotta_brick_stairs", () -> new StairBlock(YELLOW_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("light_blue_terracotta_brick_stairs", () -> new StairBlock(LIGHT_BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> LIME_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("lime_terracotta_brick_stairs", () -> new StairBlock(LIME_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> PINK_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("pink_terracotta_brick_stairs", () -> new StairBlock(PINK_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> GRAY_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("gray_terracotta_brick_stairs", () -> new StairBlock(GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("light_gray_terracotta_brick_stairs", () -> new StairBlock(LIGHT_GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.LIGHT_GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CYAN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("cyan_terracotta_brick_stairs", () -> new StairBlock(CYAN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> PURPLE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("purple_terracotta_brick_stairs", () -> new StairBlock(PURPLE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> BLUE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("blue_terracotta_brick_stairs", () -> new StairBlock(BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> BROWN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("brown_terracotta_brick_stairs", () -> new StairBlock(BROWN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> GREEN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("green_terracotta_brick_stairs", () -> new StairBlock(GREEN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> RED_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("red_terracotta_brick_stairs", () -> new StairBlock(RED_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> BLACK_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("black_terracotta_brick_stairs", () -> new StairBlock(BLACK_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> TERRACOTTA_BRICK_SLAB = HELPER.createBlock("terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> WHITE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("white_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> ORANGE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("orange_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("magenta_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("light_blue_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> YELLOW_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("yellow_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> LIME_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("lime_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> PINK_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("pink_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> GRAY_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("gray_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("light_gray_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.LIGHT_GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CYAN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("cyan_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> PURPLE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("purple_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> BLUE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("blue_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> BROWN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("brown_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> GREEN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("green_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> RED_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("red_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> BLACK_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("black_terracotta_brick_slab", () -> new SlabBlock(ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> TERRACOTTA_BRICK_WALL = HELPER.createBlock("terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> WHITE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("white_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> ORANGE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("orange_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_BRICK_WALL = HELPER.createBlock("magenta_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("light_blue_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> YELLOW_TERRACOTTA_BRICK_WALL = HELPER.createBlock("yellow_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> LIME_TERRACOTTA_BRICK_WALL = HELPER.createBlock("lime_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> PINK_TERRACOTTA_BRICK_WALL = HELPER.createBlock("pink_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> GRAY_TERRACOTTA_BRICK_WALL = HELPER.createBlock("gray_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_BRICK_WALL = HELPER.createBlock("light_gray_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.LIGHT_GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CYAN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("cyan_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> PURPLE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("purple_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> BLUE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("blue_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> BROWN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("brown_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> GREEN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("green_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> RED_TERRACOTTA_BRICK_WALL = HELPER.createBlock("red_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> BLACK_TERRACOTTA_BRICK_WALL = HELPER.createBlock("black_terracotta_brick_wall", () -> new WallBlock(ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> CHISELED_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_terracotta_bricks", () -> new Block(ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_WHITE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_white_terracotta_bricks", () -> new Block(ClayworksProperties.WHITE_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_ORANGE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_orange_terracotta_bricks", () -> new Block(ClayworksProperties.ORANGE_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_MAGENTA_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_magenta_terracotta_bricks", () -> new Block(ClayworksProperties.MAGENTA_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_LIGHT_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_light_blue_terracotta_bricks", () -> new Block(ClayworksProperties.LIGHT_BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_YELLOW_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_yellow_terracotta_bricks", () -> new Block(ClayworksProperties.YELLOW_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_LIME_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_lime_terracotta_bricks", () -> new Block(ClayworksProperties.LIME_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_PINK_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_pink_terracotta_bricks", () -> new Block(ClayworksProperties.PINK_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_gray_terracotta_bricks", () -> new Block(ClayworksProperties.GRAY_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_LIGHT_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_light_gray_terracotta_bricks", () -> new Block(ClayworksProperties.TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_CYAN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_cyan_terracotta_bricks", () -> new Block(ClayworksProperties.CYAN_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_PURPLE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_purple_terracotta_bricks", () -> new Block(ClayworksProperties.PURPLE_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_blue_terracotta_bricks", () -> new Block(ClayworksProperties.BLUE_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_BROWN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_brown_terracotta_bricks", () -> new Block(ClayworksProperties.BROWN_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_GREEN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_green_terracotta_bricks", () -> new Block(ClayworksProperties.GREEN_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_RED_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_red_terracotta_bricks", () -> new Block(ClayworksProperties.RED_TERRACOTTA));
	public static final DeferredBlock<Block> CHISELED_BLACK_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_black_terracotta_bricks", () -> new Block(ClayworksProperties.BLACK_TERRACOTTA));

	public static final DeferredBlock<Block> GLASS_DOOR = HELPER.createBlock("glass_door", GlassDoorBlock::new);
	public static final DeferredBlock<Block> WHITE_STAINED_GLASS_DOOR = HELPER.createBlock("white_stained_glass_door", () -> new GlassDoorBlock(DyeColor.WHITE));
	public static final DeferredBlock<Block> ORANGE_STAINED_GLASS_DOOR = HELPER.createBlock("orange_stained_glass_door", () -> new GlassDoorBlock(DyeColor.ORANGE));
	public static final DeferredBlock<Block> MAGENTA_STAINED_GLASS_DOOR = HELPER.createBlock("magenta_stained_glass_door", () -> new GlassDoorBlock(DyeColor.MAGENTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_GLASS_DOOR = HELPER.createBlock("light_blue_stained_glass_door", () -> new GlassDoorBlock(DyeColor.LIGHT_BLUE));
	public static final DeferredBlock<Block> YELLOW_STAINED_GLASS_DOOR = HELPER.createBlock("yellow_stained_glass_door", () -> new GlassDoorBlock(DyeColor.YELLOW));
	public static final DeferredBlock<Block> LIME_STAINED_GLASS_DOOR = HELPER.createBlock("lime_stained_glass_door", () -> new GlassDoorBlock(DyeColor.LIME));
	public static final DeferredBlock<Block> PINK_STAINED_GLASS_DOOR = HELPER.createBlock("pink_stained_glass_door", () -> new GlassDoorBlock(DyeColor.PINK));
	public static final DeferredBlock<Block> GRAY_STAINED_GLASS_DOOR = HELPER.createBlock("gray_stained_glass_door", () -> new GlassDoorBlock(DyeColor.GRAY));
	public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_GLASS_DOOR = HELPER.createBlock("light_gray_stained_glass_door", () -> new GlassDoorBlock(DyeColor.LIGHT_GRAY));
	public static final DeferredBlock<Block> CYAN_STAINED_GLASS_DOOR = HELPER.createBlock("cyan_stained_glass_door", () -> new GlassDoorBlock(DyeColor.CYAN));
	public static final DeferredBlock<Block> PURPLE_STAINED_GLASS_DOOR = HELPER.createBlock("purple_stained_glass_door", () -> new GlassDoorBlock(DyeColor.PURPLE));
	public static final DeferredBlock<Block> BLUE_STAINED_GLASS_DOOR = HELPER.createBlock("blue_stained_glass_door", () -> new GlassDoorBlock(DyeColor.BLUE));
	public static final DeferredBlock<Block> BROWN_STAINED_GLASS_DOOR = HELPER.createBlock("brown_stained_glass_door", () -> new GlassDoorBlock(DyeColor.BROWN));
	public static final DeferredBlock<Block> GREEN_STAINED_GLASS_DOOR = HELPER.createBlock("green_stained_glass_door", () -> new GlassDoorBlock(DyeColor.GREEN));
	public static final DeferredBlock<Block> RED_STAINED_GLASS_DOOR = HELPER.createBlock("red_stained_glass_door", () -> new GlassDoorBlock(DyeColor.RED));
	public static final DeferredBlock<Block> BLACK_STAINED_GLASS_DOOR = HELPER.createBlock("black_stained_glass_door", () -> new GlassDoorBlock(DyeColor.BLACK));

	public static final DeferredBlock<Block> GLASS_TRAPDOOR = HELPER.createBlock("glass_trapdoor", GlassTrapDoorBlock::new);
	public static final DeferredBlock<Block> WHITE_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("white_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.WHITE));
	public static final DeferredBlock<Block> ORANGE_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("orange_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.ORANGE));
	public static final DeferredBlock<Block> MAGENTA_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("magenta_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.MAGENTA));
	public static final DeferredBlock<Block> LIGHT_BLUE_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("light_blue_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.LIGHT_BLUE));
	public static final DeferredBlock<Block> YELLOW_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("yellow_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.YELLOW));
	public static final DeferredBlock<Block> LIME_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("lime_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.LIME));
	public static final DeferredBlock<Block> PINK_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("pink_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.PINK));
	public static final DeferredBlock<Block> GRAY_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("gray_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.GRAY));
	public static final DeferredBlock<Block> LIGHT_GRAY_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("light_gray_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.LIGHT_GRAY));
	public static final DeferredBlock<Block> CYAN_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("cyan_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.CYAN));
	public static final DeferredBlock<Block> PURPLE_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("purple_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.PURPLE));
	public static final DeferredBlock<Block> BLUE_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("blue_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.BLUE));
	public static final DeferredBlock<Block> BROWN_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("brown_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.BROWN));
	public static final DeferredBlock<Block> GREEN_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("green_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.GREEN));
	public static final DeferredBlock<Block> RED_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("red_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.RED));
	public static final DeferredBlock<Block> BLACK_STAINED_GLASS_TRAPDOOR = HELPER.createBlock("black_stained_glass_trapdoor", () -> new GlassTrapDoorBlock(DyeColor.BLACK));

	public static final DeferredBlock<Block> WHITE_DECORATED_POT = HELPER.createdDecoratedPotBlock("white_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_WHITE)));
	public static final DeferredBlock<Block> ORANGE_DECORATED_POT = HELPER.createdDecoratedPotBlock("orange_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_ORANGE)));
	public static final DeferredBlock<Block> MAGENTA_DECORATED_POT = HELPER.createdDecoratedPotBlock("magenta_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_MAGENTA)));
	public static final DeferredBlock<Block> LIGHT_BLUE_DECORATED_POT = HELPER.createdDecoratedPotBlock("light_blue_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_LIGHT_BLUE)));
	public static final DeferredBlock<Block> YELLOW_DECORATED_POT = HELPER.createdDecoratedPotBlock("yellow_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_YELLOW)));
	public static final DeferredBlock<Block> LIME_DECORATED_POT = HELPER.createdDecoratedPotBlock("lime_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_LIGHT_GREEN)));
	public static final DeferredBlock<Block> PINK_DECORATED_POT = HELPER.createdDecoratedPotBlock("pink_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_PINK)));
	public static final DeferredBlock<Block> GRAY_DECORATED_POT = HELPER.createdDecoratedPotBlock("gray_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_GRAY)));
	public static final DeferredBlock<Block> LIGHT_GRAY_DECORATED_POT = HELPER.createdDecoratedPotBlock("light_gray_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_LIGHT_GRAY)));
	public static final DeferredBlock<Block> CYAN_DECORATED_POT = HELPER.createdDecoratedPotBlock("cyan_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_CYAN)));
	public static final DeferredBlock<Block> PURPLE_DECORATED_POT = HELPER.createdDecoratedPotBlock("purple_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_PURPLE)));
	public static final DeferredBlock<Block> BLUE_DECORATED_POT = HELPER.createdDecoratedPotBlock("blue_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_BLUE)));
	public static final DeferredBlock<Block> BROWN_DECORATED_POT = HELPER.createdDecoratedPotBlock("brown_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_BROWN)));
	public static final DeferredBlock<Block> GREEN_DECORATED_POT = HELPER.createdDecoratedPotBlock("green_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_GREEN)));
	public static final DeferredBlock<Block> RED_DECORATED_POT = HELPER.createdDecoratedPotBlock("red_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_RED)));
	public static final DeferredBlock<Block> BLACK_DECORATED_POT = HELPER.createdDecoratedPotBlock("black_decorated_pot", () -> new DecoratedPotBlock(ClayworksProperties.decoratedPot(MapColor.TERRACOTTA_BLACK)));

	@Nullable
	public static DyeColor getDyeColorFromPot(Block block) {
		if (block == WHITE_DECORATED_POT.get()) return DyeColor.WHITE;
		if (block == ORANGE_DECORATED_POT.get()) return DyeColor.ORANGE;
		if (block == MAGENTA_DECORATED_POT.get()) return DyeColor.MAGENTA;
		if (block == LIGHT_BLUE_DECORATED_POT.get()) return DyeColor.LIGHT_BLUE;
		if (block == YELLOW_DECORATED_POT.get()) return DyeColor.YELLOW;
		if (block == LIME_DECORATED_POT.get()) return DyeColor.LIME;
		if (block == PINK_DECORATED_POT.get()) return DyeColor.PINK;
		if (block == GRAY_DECORATED_POT.get()) return DyeColor.GRAY;
		if (block == LIGHT_GRAY_DECORATED_POT.get()) return DyeColor.LIGHT_GRAY;
		if (block == CYAN_DECORATED_POT.get()) return DyeColor.CYAN;
		if (block == PURPLE_DECORATED_POT.get()) return DyeColor.PURPLE;
		if (block == BLUE_DECORATED_POT.get()) return DyeColor.BLUE;
		if (block == BROWN_DECORATED_POT.get()) return DyeColor.BROWN;
		if (block == GREEN_DECORATED_POT.get()) return DyeColor.GREEN;
		if (block == RED_DECORATED_POT.get()) return DyeColor.RED;
		if (block == BLACK_DECORATED_POT.get()) return DyeColor.BLACK;
		return null;
	}

	public static Block getPotFromDyeColor(@Nullable DyeColor color) {
		if (color == null) {
			return Blocks.DECORATED_POT;
		} else {
			return switch (color) {
				case WHITE -> WHITE_DECORATED_POT.get();
				case ORANGE -> ORANGE_DECORATED_POT.get();
				case MAGENTA -> MAGENTA_DECORATED_POT.get();
				case LIGHT_BLUE -> LIGHT_BLUE_DECORATED_POT.get();
				case YELLOW -> YELLOW_DECORATED_POT.get();
				case LIME -> LIME_DECORATED_POT.get();
				case PINK -> PINK_DECORATED_POT.get();
				case GRAY -> GRAY_DECORATED_POT.get();
				case LIGHT_GRAY -> LIGHT_GRAY_DECORATED_POT.get();
				case CYAN -> CYAN_DECORATED_POT.get();
				case PURPLE -> PURPLE_DECORATED_POT.get();
				case BLUE -> BLUE_DECORATED_POT.get();
				case BROWN -> BROWN_DECORATED_POT.get();
				case GREEN -> GREEN_DECORATED_POT.get();
				case RED -> RED_DECORATED_POT.get();
				case BLACK -> BLACK_DECORATED_POT.get();
			};
		}
	}

	public static final class ClayworksProperties {
		public static final BlockSetType GLASS_BLOCK_SET = BlockSetTypeRegistryHelper.register(new BlockSetType(Clayworks.MOD_ID + ":glass", true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.GLASS, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundEvents.STONE_BUTTON_CLICK_OFF, SoundEvents.STONE_BUTTON_CLICK_ON));

		public static final Block.Properties KILN = Block.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0);
		public static final Block.Properties POTTERY_TABLE = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava();
		public static final Block.Properties BRICKS = Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F);
		public static final Block.Properties GLAZED_TERRACOTTA = Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY);
		public static final Block.Properties CONCRETE = Block.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.8F);
		public static final Block.Properties CONCRETE_POWDER = Block.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND);

		public static final Block.Properties TERRACOTTA = terracotta(MapColor.COLOR_ORANGE);
		public static final Block.Properties WHITE_TERRACOTTA = terracotta(MapColor.TERRACOTTA_WHITE);
		public static final Block.Properties ORANGE_TERRACOTTA = terracotta(MapColor.TERRACOTTA_ORANGE);
		public static final Block.Properties MAGENTA_TERRACOTTA = terracotta(MapColor.TERRACOTTA_MAGENTA);
		public static final Block.Properties LIGHT_BLUE_TERRACOTTA = terracotta(MapColor.TERRACOTTA_LIGHT_BLUE);
		public static final Block.Properties YELLOW_TERRACOTTA = terracotta(MapColor.TERRACOTTA_YELLOW);
		public static final Block.Properties LIME_TERRACOTTA = terracotta(MapColor.TERRACOTTA_LIGHT_GREEN);
		public static final Block.Properties PINK_TERRACOTTA = terracotta(MapColor.TERRACOTTA_PINK);
		public static final Block.Properties GRAY_TERRACOTTA = terracotta(MapColor.TERRACOTTA_GRAY);
		public static final Block.Properties LIGHT_GRAY_TERRACOTTA = terracotta(MapColor.TERRACOTTA_LIGHT_GRAY);
		public static final Block.Properties CYAN_TERRACOTTA = terracotta(MapColor.TERRACOTTA_CYAN);
		public static final Block.Properties PURPLE_TERRACOTTA = terracotta(MapColor.TERRACOTTA_PURPLE);
		public static final Block.Properties BLUE_TERRACOTTA = terracotta(MapColor.TERRACOTTA_BLUE);
		public static final Block.Properties BROWN_TERRACOTTA = terracotta(MapColor.TERRACOTTA_BROWN);
		public static final Block.Properties GREEN_TERRACOTTA = terracotta(MapColor.TERRACOTTA_GREEN);
		public static final Block.Properties RED_TERRACOTTA = terracotta(MapColor.TERRACOTTA_RED);
		public static final Block.Properties BLACK_TERRACOTTA = terracotta(MapColor.TERRACOTTA_BLACK);

		public static Block.Properties terracotta(MapColor color) {
			return Block.Properties.of().mapColor(color).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		}

		public static final Block.Properties GLASS = BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(Blocks::never).isRedstoneConductor(PropertyUtil::never).isSuffocating(PropertyUtil::never).isViewBlocking(PropertyUtil::never);

		public static BlockBehaviour.Properties stainedGlass(DyeColor color) {
			return BlockBehaviour.Properties.of().mapColor(color).instrument(NoteBlockInstrument.HAT).strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(Blocks::never).isRedstoneConductor(PropertyUtil::never).isSuffocating(PropertyUtil::never).isViewBlocking(PropertyUtil::never);
		}

		public static Block.Properties decoratedPot(MapColor color) {
			return Block.Properties.of().mapColor(color).strength(0.0F, 0.0F).pushReaction(PushReaction.DESTROY).noOcclusion();
		}
	}

	public static void setupTabEditors() {
		CreativeModeTabContentsPopulator.mod(Clayworks.MOD_ID)
				.predicate(event -> event.getTabKey() == BUILDING_BLOCKS && ClayworksConfig.COMMON.chiseledBricks.get())
				.addItemsAfter(of(Items.BRICK_WALL), CHISELED_BRICKS)
				.predicate(event -> event.getTabKey() == COLORED_BLOCKS && ClayworksConfig.COMMON.terracottaVariants.get())
				.addItemsAfter(of(Items.PINK_TERRACOTTA),
						TERRACOTTA_STAIRS, WHITE_TERRACOTTA_STAIRS, LIGHT_GRAY_TERRACOTTA_STAIRS, GRAY_TERRACOTTA_STAIRS, BLACK_TERRACOTTA_STAIRS, BROWN_TERRACOTTA_STAIRS, RED_TERRACOTTA_STAIRS, ORANGE_TERRACOTTA_STAIRS, YELLOW_TERRACOTTA_STAIRS, LIME_TERRACOTTA_STAIRS, GREEN_TERRACOTTA_STAIRS, CYAN_TERRACOTTA_STAIRS, LIGHT_BLUE_TERRACOTTA_STAIRS, BLUE_TERRACOTTA_STAIRS, PURPLE_TERRACOTTA_STAIRS, MAGENTA_TERRACOTTA_STAIRS, PINK_TERRACOTTA_STAIRS,
						TERRACOTTA_SLAB, WHITE_TERRACOTTA_SLAB, LIGHT_GRAY_TERRACOTTA_SLAB, GRAY_TERRACOTTA_SLAB, BLACK_TERRACOTTA_SLAB, BROWN_TERRACOTTA_SLAB, RED_TERRACOTTA_SLAB, ORANGE_TERRACOTTA_SLAB, YELLOW_TERRACOTTA_SLAB, LIME_TERRACOTTA_SLAB, GREEN_TERRACOTTA_SLAB, CYAN_TERRACOTTA_SLAB, LIGHT_BLUE_TERRACOTTA_SLAB, BLUE_TERRACOTTA_SLAB, PURPLE_TERRACOTTA_SLAB, MAGENTA_TERRACOTTA_SLAB, PINK_TERRACOTTA_SLAB,
						TERRACOTTA_WALL, WHITE_TERRACOTTA_WALL, LIGHT_GRAY_TERRACOTTA_WALL, GRAY_TERRACOTTA_WALL, BLACK_TERRACOTTA_WALL, BROWN_TERRACOTTA_WALL, RED_TERRACOTTA_WALL, ORANGE_TERRACOTTA_WALL, YELLOW_TERRACOTTA_WALL, LIME_TERRACOTTA_WALL, GREEN_TERRACOTTA_WALL, CYAN_TERRACOTTA_WALL, LIGHT_BLUE_TERRACOTTA_WALL, BLUE_TERRACOTTA_WALL, PURPLE_TERRACOTTA_WALL, MAGENTA_TERRACOTTA_WALL, PINK_TERRACOTTA_WALL
				)
				.predicate(event -> event.getTabKey() == COLORED_BLOCKS && ClayworksConfig.COMMON.terracottaBricks.get())
				.addItemsAfter(of(Items.PINK_TERRACOTTA),
						TERRACOTTA_BRICKS, WHITE_TERRACOTTA_BRICKS, LIGHT_GRAY_TERRACOTTA_BRICKS, GRAY_TERRACOTTA_BRICKS, BLACK_TERRACOTTA_BRICKS, BROWN_TERRACOTTA_BRICKS, RED_TERRACOTTA_BRICKS, ORANGE_TERRACOTTA_BRICKS, YELLOW_TERRACOTTA_BRICKS, LIME_TERRACOTTA_BRICKS, GREEN_TERRACOTTA_BRICKS, CYAN_TERRACOTTA_BRICKS, LIGHT_BLUE_TERRACOTTA_BRICKS, BLUE_TERRACOTTA_BRICKS, PURPLE_TERRACOTTA_BRICKS, MAGENTA_TERRACOTTA_BRICKS, PINK_TERRACOTTA_BRICKS,
						CHISELED_TERRACOTTA_BRICKS, CHISELED_WHITE_TERRACOTTA_BRICKS, CHISELED_LIGHT_GRAY_TERRACOTTA_BRICKS, CHISELED_GRAY_TERRACOTTA_BRICKS, CHISELED_BLACK_TERRACOTTA_BRICKS, CHISELED_BROWN_TERRACOTTA_BRICKS, CHISELED_RED_TERRACOTTA_BRICKS, CHISELED_ORANGE_TERRACOTTA_BRICKS, CHISELED_YELLOW_TERRACOTTA_BRICKS, CHISELED_LIME_TERRACOTTA_BRICKS, CHISELED_GREEN_TERRACOTTA_BRICKS, CHISELED_CYAN_TERRACOTTA_BRICKS, CHISELED_LIGHT_BLUE_TERRACOTTA_BRICKS, CHISELED_BLUE_TERRACOTTA_BRICKS, CHISELED_PURPLE_TERRACOTTA_BRICKS, CHISELED_MAGENTA_TERRACOTTA_BRICKS, CHISELED_PINK_TERRACOTTA_BRICKS,
						TERRACOTTA_BRICK_STAIRS, WHITE_TERRACOTTA_BRICK_STAIRS, LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, GRAY_TERRACOTTA_BRICK_STAIRS, BLACK_TERRACOTTA_BRICK_STAIRS, BROWN_TERRACOTTA_BRICK_STAIRS, RED_TERRACOTTA_BRICK_STAIRS, ORANGE_TERRACOTTA_BRICK_STAIRS, YELLOW_TERRACOTTA_BRICK_STAIRS, LIME_TERRACOTTA_BRICK_STAIRS, GREEN_TERRACOTTA_BRICK_STAIRS, CYAN_TERRACOTTA_BRICK_STAIRS, LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, BLUE_TERRACOTTA_BRICK_STAIRS, PURPLE_TERRACOTTA_BRICK_STAIRS, MAGENTA_TERRACOTTA_BRICK_STAIRS, PINK_TERRACOTTA_BRICK_STAIRS,
						TERRACOTTA_BRICK_SLAB, WHITE_TERRACOTTA_BRICK_SLAB, LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, GRAY_TERRACOTTA_BRICK_SLAB, BLACK_TERRACOTTA_BRICK_SLAB, BROWN_TERRACOTTA_BRICK_SLAB, RED_TERRACOTTA_BRICK_SLAB, ORANGE_TERRACOTTA_BRICK_SLAB, YELLOW_TERRACOTTA_BRICK_SLAB, LIME_TERRACOTTA_BRICK_SLAB, GREEN_TERRACOTTA_BRICK_SLAB, CYAN_TERRACOTTA_BRICK_SLAB, LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, BLUE_TERRACOTTA_BRICK_SLAB, PURPLE_TERRACOTTA_BRICK_SLAB, MAGENTA_TERRACOTTA_BRICK_SLAB, PINK_TERRACOTTA_BRICK_SLAB,
						TERRACOTTA_BRICK_WALL, WHITE_TERRACOTTA_BRICK_WALL, LIGHT_GRAY_TERRACOTTA_BRICK_WALL, GRAY_TERRACOTTA_BRICK_WALL, BLACK_TERRACOTTA_BRICK_WALL, BROWN_TERRACOTTA_BRICK_WALL, RED_TERRACOTTA_BRICK_WALL, ORANGE_TERRACOTTA_BRICK_WALL, YELLOW_TERRACOTTA_BRICK_WALL, LIME_TERRACOTTA_BRICK_WALL, GREEN_TERRACOTTA_BRICK_WALL, CYAN_TERRACOTTA_BRICK_WALL, LIGHT_BLUE_TERRACOTTA_BRICK_WALL, BLUE_TERRACOTTA_BRICK_WALL, PURPLE_TERRACOTTA_BRICK_WALL, MAGENTA_TERRACOTTA_BRICK_WALL, PINK_TERRACOTTA_BRICK_WALL
				)
				.predicate(event -> event.getTabKey() == COLORED_BLOCKS && ClayworksConfig.COMMON.glazedTerracotta.get())
				.addItemsBefore(of(Items.WHITE_GLAZED_TERRACOTTA), GLAZED_TERRACOTTA)

				.predicate(event -> event.getTabKey() == COLORED_BLOCKS && ClayworksConfig.COMMON.concrete.get())
				.addItemsBefore(of(Items.WHITE_CONCRETE), CONCRETE)
				.addItemsBefore(of(Items.WHITE_CONCRETE_POWDER), CONCRETE_POWDER)

				.predicate(event -> event.getTabKey() == COLORED_BLOCKS && ClayworksConfig.COMMON.glassDoors.get())
				.addItemsBefore(of(Items.SHULKER_BOX), GLASS_DOOR, WHITE_STAINED_GLASS_DOOR, LIGHT_GRAY_STAINED_GLASS_DOOR, GRAY_STAINED_GLASS_DOOR, BLACK_STAINED_GLASS_DOOR, BROWN_STAINED_GLASS_DOOR, RED_STAINED_GLASS_DOOR, ORANGE_STAINED_GLASS_DOOR, YELLOW_STAINED_GLASS_DOOR, LIME_STAINED_GLASS_DOOR, GREEN_STAINED_GLASS_DOOR, CYAN_STAINED_GLASS_DOOR, LIGHT_BLUE_STAINED_GLASS_DOOR, BLUE_STAINED_GLASS_DOOR, PURPLE_STAINED_GLASS_DOOR, MAGENTA_STAINED_GLASS_DOOR, PINK_STAINED_GLASS_DOOR,
						GLASS_TRAPDOOR, WHITE_STAINED_GLASS_TRAPDOOR, LIGHT_GRAY_STAINED_GLASS_TRAPDOOR, GRAY_STAINED_GLASS_TRAPDOOR, BLACK_STAINED_GLASS_TRAPDOOR, BROWN_STAINED_GLASS_TRAPDOOR, RED_STAINED_GLASS_TRAPDOOR, ORANGE_STAINED_GLASS_TRAPDOOR, YELLOW_STAINED_GLASS_TRAPDOOR, LIME_STAINED_GLASS_TRAPDOOR, GREEN_STAINED_GLASS_TRAPDOOR, CYAN_STAINED_GLASS_TRAPDOOR, LIGHT_BLUE_STAINED_GLASS_TRAPDOOR, BLUE_STAINED_GLASS_TRAPDOOR, PURPLE_STAINED_GLASS_TRAPDOOR, MAGENTA_STAINED_GLASS_TRAPDOOR, PINK_STAINED_GLASS_TRAPDOOR)

				.predicate(event -> event.getTabKey() == COLORED_BLOCKS && ClayworksConfig.COMMON.decoratedPotColors.get())
				.addItems(() -> Items.DECORATED_POT, WHITE_DECORATED_POT, LIGHT_GRAY_DECORATED_POT, GRAY_DECORATED_POT, BLACK_DECORATED_POT, BROWN_DECORATED_POT, RED_DECORATED_POT, ORANGE_DECORATED_POT, YELLOW_DECORATED_POT, LIME_DECORATED_POT, GREEN_DECORATED_POT, CYAN_DECORATED_POT, LIGHT_BLUE_DECORATED_POT, BLUE_DECORATED_POT, PURPLE_DECORATED_POT, MAGENTA_DECORATED_POT, PINK_DECORATED_POT)

				.predicate(event -> event.getTabKey() == FUNCTIONAL_BLOCKS && ClayworksConfig.COMMON.kiln.get())
				.addItemsAfter(of(Items.SMOKER), KILN)

				.predicate(event -> event.getTabKey() == FUNCTIONAL_BLOCKS && ClayworksConfig.COMMON.potteryTable.get())
				.addItemsAfter(of(Items.LOOM), POTTERY_TABLE);
	}
}
