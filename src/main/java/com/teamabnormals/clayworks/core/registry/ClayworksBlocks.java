package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;

@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ClayworksBlocks {
	public static final BlockSubRegistryHelper HELPER = Clayworks.REGISTRY_HELPER.getBlockSubHelper();

	public static final RegistryObject<Block> KILN = HELPER.createBlock("kiln", () -> new KilnBlock(Properties.copy(Blocks.SMOKER)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> CHISELED_BRICKS = HELPER.createBlock("chiseled_bricks", () -> new Block(ClayworksBlockProperties.BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> TERRACOTTA_BRICKS = HELPER.createBlock("terracotta_bricks", () -> new Block(ClayworksBlockProperties.TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICKS = HELPER.createBlock("white_terracotta_bricks", () -> new Block(ClayworksBlockProperties.WHITE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICKS = HELPER.createBlock("orange_terracotta_bricks", () -> new Block(ClayworksBlockProperties.ORANGE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICKS = HELPER.createBlock("magenta_terracotta_bricks", () -> new Block(ClayworksBlockProperties.MAGENTA_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("light_blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICKS = HELPER.createBlock("yellow_terracotta_bricks", () -> new Block(ClayworksBlockProperties.YELLOW_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICKS = HELPER.createBlock("lime_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIME_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICKS = HELPER.createBlock("pink_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PINK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("light_gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICKS = HELPER.createBlock("cyan_terracotta_bricks", () -> new Block(ClayworksBlockProperties.CYAN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICKS = HELPER.createBlock("purple_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PURPLE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICKS = HELPER.createBlock("brown_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BROWN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICKS = HELPER.createBlock("green_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GREEN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICKS = HELPER.createBlock("red_terracotta_bricks", () -> new Block(ClayworksBlockProperties.RED_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICKS = HELPER.createBlock("black_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLACK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("terracotta_brick_stairs", () -> new StairBlock(() -> TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("white_terracotta_brick_stairs", () -> new StairBlock(() -> WHITE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.WHITE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("orange_terracotta_brick_stairs", () -> new StairBlock(() -> ORANGE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.ORANGE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("magenta_terracotta_brick_stairs", () -> new StairBlock(() -> MAGENTA_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.MAGENTA_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("yellow_terracotta_brick_stairs", () -> new StairBlock(() -> YELLOW_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.YELLOW_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("light_blue_terracotta_brick_stairs", () -> new StairBlock(() -> LIGHT_BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("lime_terracotta_brick_stairs", () -> new StairBlock(() -> LIME_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.LIME_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("pink_terracotta_brick_stairs", () -> new StairBlock(() -> PINK_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.PINK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("gray_terracotta_brick_stairs", () -> new StairBlock(() -> GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("light_gray_terracotta_brick_stairs", () -> new StairBlock(() -> LIGHT_GRAY_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("cyan_terracotta_brick_stairs", () -> new StairBlock(() -> CYAN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.CYAN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("purple_terracotta_brick_stairs", () -> new StairBlock(() -> PURPLE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.PURPLE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("blue_terracotta_brick_stairs", () -> new StairBlock(() -> BLUE_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("brown_terracotta_brick_stairs", () -> new StairBlock(() -> BROWN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.BROWN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("green_terracotta_brick_stairs", () -> new StairBlock(() -> GREEN_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.GREEN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("red_terracotta_brick_stairs", () -> new StairBlock(() -> RED_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.RED_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_STAIRS = HELPER.createBlock("black_terracotta_brick_stairs", () -> new StairBlock(() -> BLACK_TERRACOTTA_BRICKS.get().defaultBlockState(), ClayworksBlockProperties.BLACK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> TERRACOTTA_BRICK_SLAB = HELPER.createBlock("terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("white_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.WHITE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("orange_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("magenta_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("light_blue_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("yellow_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("lime_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.LIME_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("pink_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.PINK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("gray_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("light_gray_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("cyan_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.CYAN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("purple_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("blue_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("brown_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.BROWN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("green_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.GREEN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("red_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.RED_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_SLAB = HELPER.createBlock("black_terracotta_brick_slab", () -> new SlabBlock(ClayworksBlockProperties.BLACK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> TERRACOTTA_BRICK_WALL = HELPER.createBlock("terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("white_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.WHITE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("orange_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_WALL = HELPER.createBlock("magenta_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("light_blue_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_WALL = HELPER.createBlock("yellow_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_WALL = HELPER.createBlock("lime_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.LIME_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_WALL = HELPER.createBlock("pink_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.PINK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_WALL = HELPER.createBlock("gray_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_WALL = HELPER.createBlock("light_gray_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("cyan_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.CYAN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("purple_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_WALL = HELPER.createBlock("blue_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("brown_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.BROWN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_WALL = HELPER.createBlock("green_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.GREEN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_WALL = HELPER.createBlock("red_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.RED_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_WALL = HELPER.createBlock("black_terracotta_brick_wall", () -> new WallBlock(ClayworksBlockProperties.BLACK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "white_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.WHITE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "orange_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.ORANGE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "magenta_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.MAGENTA_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "light_blue_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "yellow_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.YELLOW_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIME_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "lime_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIME_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PINK_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "pink_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.PINK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "gray_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "light_gray_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.LIGHT_GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "cyan_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.CYAN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "purple_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.PURPLE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "blue_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "brown_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BROWN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "green_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.GREEN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> RED_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "red_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.RED_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "black_terracotta_brick_vertical_slab", () -> new VerticalSlabBlock(ClayworksBlockProperties.BLACK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> CHISELED_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_terracotta_bricks", () -> new Block(ClayworksBlockProperties.TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_WHITE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_white_terracotta_bricks", () -> new Block(ClayworksBlockProperties.WHITE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_ORANGE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_orange_terracotta_bricks", () -> new Block(ClayworksBlockProperties.ORANGE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_MAGENTA_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_magenta_terracotta_bricks", () -> new Block(ClayworksBlockProperties.MAGENTA_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_LIGHT_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_light_blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIGHT_BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_YELLOW_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_yellow_terracotta_bricks", () -> new Block(ClayworksBlockProperties.YELLOW_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_LIME_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_lime_terracotta_bricks", () -> new Block(ClayworksBlockProperties.LIME_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_PINK_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_pink_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PINK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GRAY_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_LIGHT_GRAY_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_light_gray_terracotta_bricks", () -> new Block(ClayworksBlockProperties.TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_CYAN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_cyan_terracotta_bricks", () -> new Block(ClayworksBlockProperties.CYAN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_PURPLE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_purple_terracotta_bricks", () -> new Block(ClayworksBlockProperties.PURPLE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_BLUE_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_blue_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLUE_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_BROWN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_brown_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BROWN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_GREEN_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_green_terracotta_bricks", () -> new Block(ClayworksBlockProperties.GREEN_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_RED_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_red_terracotta_bricks", () -> new Block(ClayworksBlockProperties.RED_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_BLACK_TERRACOTTA_BRICKS = HELPER.createBlock("chiseled_black_terracotta_bricks", () -> new Block(ClayworksBlockProperties.BLACK_TERRACOTTA_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final class ClayworksBlockProperties {
		public static final BlockBehaviour.Properties KILN = BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F).lightLevel(litBlockEmission(13));
		public static final BlockBehaviour.Properties BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.0F, 6.0F);

		public static final BlockBehaviour.Properties TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties WHITE_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties ORANGE_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties MAGENTA_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_MAGENTA).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties LIGHT_BLUE_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties YELLOW_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties LIME_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GREEN).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties PINK_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties GRAY_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties LIGHT_GRAY_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_LIGHT_GRAY).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties CYAN_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties PURPLE_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties BLUE_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties BROWN_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BROWN).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties GREEN_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties RED_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).requiresCorrectToolForDrops().strength(1.25F, 4.2F);
		public static final BlockBehaviour.Properties BLACK_TERRACOTTA_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).requiresCorrectToolForDrops().strength(1.25F, 4.2F);

		private static ToIntFunction<BlockState> litBlockEmission(int lightLevel) {
			return (state) -> state.getValue(BlockStateProperties.LIT) ? lightLevel : 0;
		}
	}
}
