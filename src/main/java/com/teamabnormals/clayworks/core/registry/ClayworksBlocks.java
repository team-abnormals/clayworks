package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.common.block.quark.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ClayworksBlocks {
	public static final BlockSubRegistryHelper HELPER = Clayworks.REGISTRY_HELPER.getBlockSubHelper();

	public static final RegistryObject<Block> KILN = HELPER.createBlock("kiln", () -> new KilnBlock(ClayworksBlockProperties.KILN));
	public static final RegistryObject<Block> CHISELED_BRICKS = HELPER.createBlock("chiseled_bricks", () -> new Block(ClayworksBlockProperties.BRICKS));
	public static final RegistryObject<Block> GLAZED_TERRACOTTA = HELPER.createBlock("glazed_terracotta", () -> new GlazedTerracottaBlock(ClayworksBlockProperties.GLAZED_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_STAIRS = HELPER.createBlock("terracotta_stairs", () -> new StairBlock(() -> Blocks.TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_STAIRS = HELPER.createBlock("white_terracotta_stairs", () -> new StairBlock(() -> Blocks.WHITE_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_STAIRS = HELPER.createBlock("orange_terracotta_stairs", () -> new StairBlock(() -> Blocks.ORANGE_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_STAIRS = HELPER.createBlock("magenta_terracotta_stairs", () -> new StairBlock(() -> Blocks.MAGENTA_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_STAIRS = HELPER.createBlock("yellow_terracotta_stairs", () -> new StairBlock(() -> Blocks.YELLOW_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = HELPER.createBlock("light_blue_terracotta_stairs", () -> new StairBlock(() -> Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_STAIRS = HELPER.createBlock("lime_terracotta_stairs", () -> new StairBlock(() -> Blocks.LIME_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_STAIRS = HELPER.createBlock("pink_terracotta_stairs", () -> new StairBlock(() -> Blocks.PINK_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_STAIRS = HELPER.createBlock("gray_terracotta_stairs", () -> new StairBlock(() -> Blocks.GRAY_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = HELPER.createBlock("light_gray_terracotta_stairs", () -> new StairBlock(() -> Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_STAIRS = HELPER.createBlock("cyan_terracotta_stairs", () -> new StairBlock(() -> Blocks.CYAN_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_STAIRS = HELPER.createBlock("purple_terracotta_stairs", () -> new StairBlock(() -> Blocks.PURPLE_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_STAIRS = HELPER.createBlock("blue_terracotta_stairs", () -> new StairBlock(() -> Blocks.BLUE_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_STAIRS = HELPER.createBlock("brown_terracotta_stairs", () -> new StairBlock(() -> Blocks.BROWN_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_STAIRS = HELPER.createBlock("green_terracotta_stairs", () -> new StairBlock(() -> Blocks.GREEN_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_STAIRS = HELPER.createBlock("red_terracotta_stairs", () -> new StairBlock(() -> Blocks.RED_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_STAIRS = HELPER.createBlock("black_terracotta_stairs", () -> new StairBlock(() -> Blocks.BLACK_TERRACOTTA.defaultBlockState(), ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_SLAB = HELPER.createBlock("terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_SLAB = HELPER.createBlock("white_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_SLAB = HELPER.createBlock("orange_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_SLAB = HELPER.createBlock("magenta_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_SLAB = HELPER.createBlock("light_blue_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_SLAB = HELPER.createBlock("yellow_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_SLAB = HELPER.createBlock("lime_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_SLAB = HELPER.createBlock("pink_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_SLAB = HELPER.createBlock("gray_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_SLAB = HELPER.createBlock("light_gray_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_SLAB = HELPER.createBlock("cyan_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_SLAB = HELPER.createBlock("purple_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_SLAB = HELPER.createBlock("blue_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_SLAB = HELPER.createBlock("brown_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_SLAB = HELPER.createBlock("green_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_SLAB = HELPER.createBlock("red_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_SLAB = HELPER.createBlock("black_terracotta_slab", () -> new SlabBlock(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_WALL = HELPER.createBlock("terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_WALL = HELPER.createBlock("white_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_WALL = HELPER.createBlock("orange_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_WALL = HELPER.createBlock("magenta_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_WALL = HELPER.createBlock("light_blue_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_WALL = HELPER.createBlock("yellow_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_WALL = HELPER.createBlock("lime_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_WALL = HELPER.createBlock("pink_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_WALL = HELPER.createBlock("gray_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_WALL = HELPER.createBlock("light_gray_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_WALL = HELPER.createBlock("cyan_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_WALL = HELPER.createBlock("purple_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_WALL = HELPER.createBlock("blue_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_WALL = HELPER.createBlock("brown_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_WALL = HELPER.createBlock("green_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_WALL = HELPER.createBlock("red_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_WALL = HELPER.createBlock("black_terracotta_wall", () -> new WallBlock(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("white_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("orange_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("magenta_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("light_blue_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("yellow_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("lime_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("pink_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("gray_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("light_gray_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("cyan_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("purple_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("blue_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("brown_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("green_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("red_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_VERTICAL_SLAB = HELPER.createBlock("black_terracotta_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_BRICKS = HELPER.createBlock("terracotta_bricks", () -> new Block(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICKS = HELPER.createBlock("white_terracotta_bricks", () -> new Block(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICKS = HELPER.createBlock("orange_terracotta_bricks", () -> new Block(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICKS = HELPER.createBlock("magenta_terracotta_bricks", () -> new Block(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("light_blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICKS = HELPER.createBlock("yellow_terracotta_bricks", () -> new Block(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICKS = HELPER.createBlock("lime_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICKS = HELPER.createBlock("pink_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("light_gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICKS = HELPER.createBlock("cyan_terracotta_bricks", () -> new Block(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICKS = HELPER.createBlock("purple_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICKS = HELPER.createBlock("brown_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICKS = HELPER.createBlock("green_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICKS = HELPER.createBlock("red_terracotta_bricks", () -> new Block(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICKS = HELPER.createBlock("black_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("terracotta_brick_stairs", () -> new StairBlock(() -> TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("white_terracotta_brick_stairs", () -> new StairBlock(() -> WHITE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("orange_terracotta_brick_stairs", () -> new StairBlock(() -> ORANGE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("magenta_terracotta_brick_stairs", () -> new StairBlock(() -> MAGENTA_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("yellow_terracotta_brick_stairs", () -> new StairBlock(() -> YELLOW_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("light_blue_terracotta_brick_stairs", () -> new StairBlock(() -> LIGHT_BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("lime_terracotta_brick_stairs", () -> new StairBlock(() -> LIME_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("pink_terracotta_brick_stairs", () -> new StairBlock(() -> PINK_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("gray_terracotta_brick_stairs", () -> new StairBlock(() -> GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("light_gray_terracotta_brick_stairs", () -> new StairBlock(() -> LIGHT_GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("cyan_terracotta_brick_stairs", () -> new StairBlock(() -> CYAN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("purple_terracotta_brick_stairs", () -> new StairBlock(() -> PURPLE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("blue_terracotta_brick_stairs", () -> new StairBlock(() -> BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("brown_terracotta_brick_stairs", () -> new StairBlock(() -> BROWN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("green_terracotta_brick_stairs", () -> new StairBlock(() -> GREEN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("red_terracotta_brick_stairs", () -> new StairBlock(() -> RED_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("black_terracotta_brick_stairs", () -> new StairBlock(() -> BLACK_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_BRICK_SLAB = HELPER.createBlock("terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("white_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("orange_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("magenta_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("light_blue_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("yellow_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("lime_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("pink_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("gray_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("light_gray_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("cyan_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("purple_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("blue_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("brown_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("green_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("red_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("black_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_BRICK_WALL = HELPER.createBlock("terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("white_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("orange_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_WALL = HELPER.createBlock("magenta_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("light_blue_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_WALL = HELPER.createBlock("yellow_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_WALL = HELPER.createBlock("lime_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_WALL = HELPER.createBlock("pink_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_WALL = HELPER.createBlock("gray_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_WALL = HELPER.createBlock("light_gray_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("cyan_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("purple_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("blue_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("brown_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("green_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_WALL = HELPER.createBlock("red_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_WALL = HELPER.createBlock("black_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("white_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("orange_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("magenta_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("light_blue_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("yellow_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("lime_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("pink_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("gray_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("light_gray_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("cyan_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("purple_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("blue_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("brown_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("green_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("red_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createBlock("black_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final RegistryObject<Block> CHISELED_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_terracotta_bricks", () -> new Block(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_WHITE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_white_terracotta_bricks", () -> new Block(ClayworksBlockProperties.WHITE_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_ORANGE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_orange_terracotta_bricks", () -> new Block(ClayworksBlockProperties.ORANGE_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_MAGENTA_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_magenta_terracotta_bricks", () -> new Block(ClayworksBlockProperties.MAGENTA_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_LIGHT_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_light_blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_YELLOW_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_yellow_terracotta_bricks", () -> new Block(ClayworksBlockProperties.YELLOW_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_LIME_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_lime_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIME_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_PINK_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_pink_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PINK_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GRAY_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_LIGHT_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_light_gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_CYAN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_cyan_terracotta_bricks", () -> new Block(ClayworksBlockProperties.CYAN_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_PURPLE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_purple_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PURPLE_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLUE_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_BROWN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_brown_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BROWN_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_GREEN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_green_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GREEN_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_RED_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_red_terracotta_bricks", () -> new Block(ClayworksBlockProperties.RED_TERRACOTTA));
	public static final RegistryObject<Block> CHISELED_BLACK_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_black_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLACK_TERRACOTTA));

	public static final class ClayworksBlockProperties {
		public static final Block.Properties KILN = Block.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0);
		public static final Block.Properties BRICKS = Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F);
		public static final Block.Properties GLAZED_TERRACOTTA = Block.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.4F).pushReaction(PushReaction.PUSH_ONLY);

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
	}

	public static void setupTabEditors() {
		CreativeModeTabContentsPopulator.mod(Clayworks.MOD_ID)
				.tab(BUILDING_BLOCKS).predicate(event -> ClayworksConfig.COMMON.chiseledBricks.get())
				.addItemsAfter(of(Items.BRICK_WALL), CHISELED_BRICKS)
				.tab(COLORED_BLOCKS).predicate(event -> ClayworksConfig.COMMON.terracottaVariants.get())
				.addItemsAfter(of(Items.PINK_TERRACOTTA),
						TERRACOTTA_STAIRS, WHITE_TERRACOTTA_STAIRS, LIGHT_GRAY_TERRACOTTA_STAIRS, GRAY_TERRACOTTA_STAIRS, BLACK_TERRACOTTA_STAIRS, BROWN_TERRACOTTA_STAIRS, RED_TERRACOTTA_STAIRS, ORANGE_TERRACOTTA_STAIRS, YELLOW_TERRACOTTA_STAIRS, LIME_TERRACOTTA_STAIRS, GREEN_TERRACOTTA_STAIRS, CYAN_TERRACOTTA_STAIRS, LIGHT_BLUE_TERRACOTTA_STAIRS, BLUE_TERRACOTTA_STAIRS, PURPLE_TERRACOTTA_STAIRS, MAGENTA_TERRACOTTA_STAIRS, PINK_TERRACOTTA_STAIRS,
						TERRACOTTA_SLAB, WHITE_TERRACOTTA_SLAB, LIGHT_GRAY_TERRACOTTA_SLAB, GRAY_TERRACOTTA_SLAB, BLACK_TERRACOTTA_SLAB, BROWN_TERRACOTTA_SLAB, RED_TERRACOTTA_SLAB, ORANGE_TERRACOTTA_SLAB, YELLOW_TERRACOTTA_SLAB, LIME_TERRACOTTA_SLAB, GREEN_TERRACOTTA_SLAB, CYAN_TERRACOTTA_SLAB, LIGHT_BLUE_TERRACOTTA_SLAB, BLUE_TERRACOTTA_SLAB, PURPLE_TERRACOTTA_SLAB, MAGENTA_TERRACOTTA_SLAB, PINK_TERRACOTTA_SLAB,
						TERRACOTTA_WALL, WHITE_TERRACOTTA_WALL, LIGHT_GRAY_TERRACOTTA_WALL, GRAY_TERRACOTTA_WALL, BLACK_TERRACOTTA_WALL, BROWN_TERRACOTTA_WALL, RED_TERRACOTTA_WALL, ORANGE_TERRACOTTA_WALL, YELLOW_TERRACOTTA_WALL, LIME_TERRACOTTA_WALL, GREEN_TERRACOTTA_WALL, CYAN_TERRACOTTA_WALL, LIGHT_BLUE_TERRACOTTA_WALL, BLUE_TERRACOTTA_WALL, PURPLE_TERRACOTTA_WALL, MAGENTA_TERRACOTTA_WALL, PINK_TERRACOTTA_WALL
				)
				.predicate(event -> ClayworksConfig.COMMON.terracottaBricks.get())
				.addItemsAfter(of(Items.PINK_TERRACOTTA),
						TERRACOTTA_BRICKS, WHITE_TERRACOTTA_BRICKS, LIGHT_GRAY_TERRACOTTA_BRICKS, GRAY_TERRACOTTA_BRICKS, BLACK_TERRACOTTA_BRICKS, BROWN_TERRACOTTA_BRICKS, RED_TERRACOTTA_BRICKS, ORANGE_TERRACOTTA_BRICKS, YELLOW_TERRACOTTA_BRICKS, LIME_TERRACOTTA_BRICKS, GREEN_TERRACOTTA_BRICKS, CYAN_TERRACOTTA_BRICKS, LIGHT_BLUE_TERRACOTTA_BRICKS, BLUE_TERRACOTTA_BRICKS, PURPLE_TERRACOTTA_BRICKS, MAGENTA_TERRACOTTA_BRICKS, PINK_TERRACOTTA_BRICKS,
						CHISELED_TERRACOTTA_BRICKS, CHISELED_WHITE_TERRACOTTA_BRICKS, CHISELED_LIGHT_GRAY_TERRACOTTA_BRICKS, CHISELED_GRAY_TERRACOTTA_BRICKS, CHISELED_BLACK_TERRACOTTA_BRICKS, CHISELED_BROWN_TERRACOTTA_BRICKS, CHISELED_RED_TERRACOTTA_BRICKS, CHISELED_ORANGE_TERRACOTTA_BRICKS, CHISELED_YELLOW_TERRACOTTA_BRICKS, CHISELED_LIME_TERRACOTTA_BRICKS, CHISELED_GREEN_TERRACOTTA_BRICKS, CHISELED_CYAN_TERRACOTTA_BRICKS, CHISELED_LIGHT_BLUE_TERRACOTTA_BRICKS, CHISELED_BLUE_TERRACOTTA_BRICKS, CHISELED_PURPLE_TERRACOTTA_BRICKS, CHISELED_MAGENTA_TERRACOTTA_BRICKS, CHISELED_PINK_TERRACOTTA_BRICKS,
						TERRACOTTA_BRICK_STAIRS, WHITE_TERRACOTTA_BRICK_STAIRS, LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, GRAY_TERRACOTTA_BRICK_STAIRS, BLACK_TERRACOTTA_BRICK_STAIRS, BROWN_TERRACOTTA_BRICK_STAIRS, RED_TERRACOTTA_BRICK_STAIRS, ORANGE_TERRACOTTA_BRICK_STAIRS, YELLOW_TERRACOTTA_BRICK_STAIRS, LIME_TERRACOTTA_BRICK_STAIRS, GREEN_TERRACOTTA_BRICK_STAIRS, CYAN_TERRACOTTA_BRICK_STAIRS, LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, BLUE_TERRACOTTA_BRICK_STAIRS, PURPLE_TERRACOTTA_BRICK_STAIRS, MAGENTA_TERRACOTTA_BRICK_STAIRS, PINK_TERRACOTTA_BRICK_STAIRS,
						TERRACOTTA_BRICK_SLAB, WHITE_TERRACOTTA_BRICK_SLAB, LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, GRAY_TERRACOTTA_BRICK_SLAB, BLACK_TERRACOTTA_BRICK_SLAB, BROWN_TERRACOTTA_BRICK_SLAB, RED_TERRACOTTA_BRICK_SLAB, ORANGE_TERRACOTTA_BRICK_SLAB, YELLOW_TERRACOTTA_BRICK_SLAB, LIME_TERRACOTTA_BRICK_SLAB, GREEN_TERRACOTTA_BRICK_SLAB, CYAN_TERRACOTTA_BRICK_SLAB, LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, BLUE_TERRACOTTA_BRICK_SLAB, PURPLE_TERRACOTTA_BRICK_SLAB, MAGENTA_TERRACOTTA_BRICK_SLAB, PINK_TERRACOTTA_BRICK_SLAB,
						TERRACOTTA_BRICK_WALL, WHITE_TERRACOTTA_BRICK_WALL, LIGHT_GRAY_TERRACOTTA_BRICK_WALL, GRAY_TERRACOTTA_BRICK_WALL, BLACK_TERRACOTTA_BRICK_WALL, BROWN_TERRACOTTA_BRICK_WALL, RED_TERRACOTTA_BRICK_WALL, ORANGE_TERRACOTTA_BRICK_WALL, YELLOW_TERRACOTTA_BRICK_WALL, LIME_TERRACOTTA_BRICK_WALL, GREEN_TERRACOTTA_BRICK_WALL, CYAN_TERRACOTTA_BRICK_WALL, LIGHT_BLUE_TERRACOTTA_BRICK_WALL, BLUE_TERRACOTTA_BRICK_WALL, PURPLE_TERRACOTTA_BRICK_WALL, MAGENTA_TERRACOTTA_BRICK_WALL, PINK_TERRACOTTA_BRICK_WALL
				)
				.predicate(event -> ClayworksConfig.COMMON.glazedTerracotta.get())
				.addItemsBefore(of(Items.WHITE_GLAZED_TERRACOTTA), GLAZED_TERRACOTTA)
				.tab(FUNCTIONAL_BLOCKS).predicate(event -> ClayworksConfig.COMMON.kiln.get())
				.addItemsAfter(of(Items.SMOKER), KILN);
	}
}
