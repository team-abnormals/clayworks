package com.teamabnormals.clayworks.core.data.server;

import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.core.api.conditions.BlueprintAndCondition;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.common.item.crafting.DecoratedPotColoring;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.other.ClayworksBlockFamilies;
import com.teamabnormals.clayworks.core.registry.ClayworksConditions;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

import static com.teamabnormals.clayworks.core.ClayworksConfig.COMMON;
import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

public class ClayworksRecipeProvider extends BlueprintRecipeProvider {
	public static final ConfigValueCondition KILN_CONFIG = config(COMMON.kiln, "kiln");
	public static final ConfigValueCondition POTTERY_TABLE_CONFIG = config(COMMON.potteryTable, "pottery_table");

	public static final ConfigValueCondition CHISELED_BRICKS_CONFIG = config(COMMON.chiseledBricks, "chiseled_bricks");
	public static final ConfigValueCondition GLAZED_TERRACOTTA_CONFIG = config(COMMON.glazedTerracotta, "glazed_terracotta");
	public static final ConfigValueCondition TERRACOTTA_VARIANTS_CONFIG = config(COMMON.terracottaVariants, "terracotta_variants");
	public static final ConfigValueCondition TERRACOTTA_BRICKS_CONFIG = config(COMMON.terracottaBricks, "terracotta_bricks");
	public static final ConfigValueCondition CONCRETE_CONFIG = config(COMMON.concrete, "concrete");
	public static final BlueprintAndCondition KILN_COMPAT = new BlueprintAndCondition(new ModLoadedCondition(Clayworks.MOD_ID), KILN_CONFIG);

	public static final ConfigValueCondition GLASS_DOORS = config(COMMON.glassDoors, "glass_doors");

	public ClayworksRecipeProvider(PackOutput result, CompletableFuture<Provider> provider) {
		super(Clayworks.MOD_ID, result, provider);
	}

	@Override
	public void buildRecipes(RecipeOutput output) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, KILN.get()).define('#', ItemTags.STONE_CRAFTING_MATERIALS).define('X', Blocks.FURNACE).define('B', Blocks.MUD_BRICKS).pattern("###").pattern("#X#").pattern("BBB").unlockedBy("has_cobblestone", has(ItemTags.STONE_CRAFTING_MATERIALS)).save(output.withConditions(KILN_CONFIG));
		generateKilnRecipes(output);
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, POTTERY_TABLE.get()).define('#', ItemTags.PLANKS).define('@', Items.BRICK).pattern("@@").pattern("##").pattern("##").unlockedBy("has_brick", has(Items.BRICK)).save(output.withConditions(POTTERY_TABLE_CONFIG));
		SpecialRecipeBuilder.special(DecoratedPotColoring::new).save(output, Clayworks.MOD_ID + ":decorated_pot_coloring");

		chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, CHISELED_BRICKS.get(), Ingredient.of(Blocks.BRICK_SLAB)).unlockedBy(getHasName(Blocks.BRICK_SLAB), has(Blocks.BRICK_SLAB)).save(output.withConditions(CHISELED_BRICKS_CONFIG));
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, CHISELED_BRICKS_CONFIG, CHISELED_BRICKS.get(), Blocks.BRICKS);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.TERRACOTTA), RecipeCategory.BUILDING_BLOCKS, GLAZED_TERRACOTTA.get().asItem(), 0.1F, 200).unlockedBy("has_terracotta", has(Blocks.TERRACOTTA)).save(output.withConditions(GLAZED_TERRACOTTA_CONFIG));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CONCRETE_POWDER.get(), 8).requires(Blocks.SAND, 4).requires(Blocks.GRAVEL, 4).group("concrete_powder").unlockedBy("has_sand", has(Blocks.SAND)).unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(output.withConditions(CONCRETE_CONFIG));
		coloredConcreteFromConcreteAndDye(output, Blocks.BLACK_CONCRETE, Blocks.BLACK_CONCRETE_POWDER, Items.BLACK_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.BLUE_CONCRETE, Blocks.BLUE_CONCRETE_POWDER, Items.BLUE_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.BROWN_CONCRETE, Blocks.BROWN_CONCRETE_POWDER, Items.BROWN_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.CYAN_CONCRETE, Blocks.CYAN_CONCRETE_POWDER, Items.CYAN_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.GRAY_CONCRETE, Blocks.GRAY_CONCRETE_POWDER, Items.GRAY_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.GREEN_CONCRETE, Blocks.GREEN_CONCRETE_POWDER, Items.GREEN_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_BLUE_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Items.LIGHT_GRAY_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.LIME_CONCRETE, Blocks.LIME_CONCRETE_POWDER, Items.LIME_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE_POWDER, Items.MAGENTA_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE_POWDER, Items.ORANGE_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.PINK_CONCRETE, Blocks.PINK_CONCRETE_POWDER, Items.PINK_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE_POWDER, Items.PURPLE_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.RED_CONCRETE, Blocks.RED_CONCRETE_POWDER, Items.RED_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.WHITE_CONCRETE, Blocks.WHITE_CONCRETE_POWDER, Items.WHITE_DYE);
		coloredConcreteFromConcreteAndDye(output, Blocks.YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE_POWDER, Items.YELLOW_DYE);

		terracottaBricksRecipes(output, Blocks.TERRACOTTA, ClayworksBlockFamilies.TERRACOTTA, ClayworksBlockFamilies.TERRACOTTA_BRICKS, null);
		terracottaBricksRecipes(output, Blocks.WHITE_TERRACOTTA, ClayworksBlockFamilies.WHITE_TERRACOTTA, ClayworksBlockFamilies.WHITE_TERRACOTTA_BRICKS, Items.WHITE_DYE);
		terracottaBricksRecipes(output, Blocks.ORANGE_TERRACOTTA, ClayworksBlockFamilies.ORANGE_TERRACOTTA, ClayworksBlockFamilies.ORANGE_TERRACOTTA_BRICKS, Items.ORANGE_DYE);
		terracottaBricksRecipes(output, Blocks.MAGENTA_TERRACOTTA, ClayworksBlockFamilies.MAGENTA_TERRACOTTA, ClayworksBlockFamilies.MAGENTA_TERRACOTTA_BRICKS, Items.MAGENTA_DYE);
		terracottaBricksRecipes(output, Blocks.LIGHT_BLUE_TERRACOTTA, ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA, ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA_BRICKS, Items.LIGHT_BLUE_DYE);
		terracottaBricksRecipes(output, Blocks.YELLOW_TERRACOTTA, ClayworksBlockFamilies.YELLOW_TERRACOTTA, ClayworksBlockFamilies.YELLOW_TERRACOTTA_BRICKS, Items.YELLOW_DYE);
		terracottaBricksRecipes(output, Blocks.LIME_TERRACOTTA, ClayworksBlockFamilies.LIME_TERRACOTTA, ClayworksBlockFamilies.LIME_TERRACOTTA_BRICKS, Items.LIME_DYE);
		terracottaBricksRecipes(output, Blocks.PINK_TERRACOTTA, ClayworksBlockFamilies.PINK_TERRACOTTA, ClayworksBlockFamilies.PINK_TERRACOTTA_BRICKS, Items.PINK_DYE);
		terracottaBricksRecipes(output, Blocks.GRAY_TERRACOTTA, ClayworksBlockFamilies.GRAY_TERRACOTTA, ClayworksBlockFamilies.GRAY_TERRACOTTA_BRICKS, Items.GRAY_DYE);
		terracottaBricksRecipes(output, Blocks.LIGHT_GRAY_TERRACOTTA, ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA, ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA_BRICKS, Items.LIGHT_GRAY_DYE);
		terracottaBricksRecipes(output, Blocks.CYAN_TERRACOTTA, ClayworksBlockFamilies.CYAN_TERRACOTTA, ClayworksBlockFamilies.CYAN_TERRACOTTA_BRICKS, Items.CYAN_DYE);
		terracottaBricksRecipes(output, Blocks.PURPLE_TERRACOTTA, ClayworksBlockFamilies.PURPLE_TERRACOTTA, ClayworksBlockFamilies.PURPLE_TERRACOTTA_BRICKS, Items.PURPLE_DYE);
		terracottaBricksRecipes(output, Blocks.BLUE_TERRACOTTA, ClayworksBlockFamilies.BLUE_TERRACOTTA, ClayworksBlockFamilies.BLUE_TERRACOTTA_BRICKS, Items.BLUE_DYE);
		terracottaBricksRecipes(output, Blocks.BROWN_TERRACOTTA, ClayworksBlockFamilies.BROWN_TERRACOTTA, ClayworksBlockFamilies.BROWN_TERRACOTTA_BRICKS, Items.BROWN_DYE);
		terracottaBricksRecipes(output, Blocks.GREEN_TERRACOTTA, ClayworksBlockFamilies.GREEN_TERRACOTTA, ClayworksBlockFamilies.GREEN_TERRACOTTA_BRICKS, Items.GREEN_DYE);
		terracottaBricksRecipes(output, Blocks.RED_TERRACOTTA, ClayworksBlockFamilies.RED_TERRACOTTA, ClayworksBlockFamilies.RED_TERRACOTTA_BRICKS, Items.RED_DYE);
		terracottaBricksRecipes(output, Blocks.BLACK_TERRACOTTA, ClayworksBlockFamilies.BLACK_TERRACOTTA, ClayworksBlockFamilies.BLACK_TERRACOTTA_BRICKS, Items.BLACK_DYE);

		generateConditionalRecipes(output, ClayworksBlockFamilies.GLASS, GLASS_DOORS);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.WHITE_STAINED_GLASS, Items.WHITE_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.ORANGE_STAINED_GLASS, Items.ORANGE_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.MAGENTA_STAINED_GLASS, Items.MAGENTA_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.LIGHT_BLUE_STAINED_GLASS, Items.LIGHT_BLUE_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.YELLOW_STAINED_GLASS, Items.YELLOW_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.LIME_STAINED_GLASS, Items.LIME_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.PINK_STAINED_GLASS, Items.PINK_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.GRAY_STAINED_GLASS, Items.GRAY_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.LIGHT_GRAY_STAINED_GLASS, Items.LIGHT_GRAY_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.CYAN_STAINED_GLASS, Items.CYAN_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.PURPLE_STAINED_GLASS, Items.PURPLE_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.BLUE_STAINED_GLASS, Items.BLUE_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.BROWN_STAINED_GLASS, Items.BROWN_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.GREEN_STAINED_GLASS, Items.GREEN_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.RED_STAINED_GLASS, Items.RED_DYE);
		generateGlassDoorRecipes(output, ClayworksBlockFamilies.BLACK_STAINED_GLASS, Items.BLACK_DYE);
	}

	public static void generateKilnRecipes(RecipeOutput output) {
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, ItemTags.SMELTS_TO_GLASS, "has_smelts_to_glass", Blocks.GLASS, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.MISC, ItemTags.LOGS_THAT_BURN, "has_log", Items.CHARCOAL, 0.15F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.WET_SPONGE, Blocks.SPONGE, 0.15F, 100);
		bakingRecipe(output, RecipeCategory.MISC, Blocks.SEA_PICKLE, Items.LIME_DYE, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.MISC, Blocks.CACTUS, Items.GREEN_DYE, 1.0F, 100);
		bakingRecipe(output, RecipeCategory.MISC, Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT, 0.1F, 100);

		bakingRecipe(output, RecipeCategory.MISC, Items.CLAY_BALL, Items.BRICK, 0.3F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY, Blocks.TERRACOTTA, 0.35F, 100);
		bakingRecipe(output, RecipeCategory.MISC, Blocks.NETHERRACK, Items.NETHER_BRICK, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE, Blocks.STONE, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE, Blocks.SMOOTH_STONE, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT, Blocks.SMOOTH_BASALT, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, 0.1F, 100);

		bakingRecipe(output, new BlueprintAndCondition(KILN_CONFIG, GLAZED_TERRACOTTA_CONFIG), RecipeCategory.DECORATIONS, Blocks.TERRACOTTA, GLAZED_TERRACOTTA.get(), 0.1F, 100, Clayworks.MOD_ID);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(output, RecipeCategory.DECORATIONS, Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, 0.1F, 100);
	}

	private static void terracottaBricksRecipes(RecipeOutput output, Block terracotta, BlockFamily family, BlockFamily bricksFamily, @Nullable Item dye) {
		generateConditionalRecipes(output, family, TERRACOTTA_VARIANTS_CONFIG);
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.SLAB), family.getBaseBlock(), 2);
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.STAIRS), family.getBaseBlock());
		conditionalStonecuttingRecipe(output, RecipeCategory.DECORATIONS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.WALL), family.getBaseBlock());

		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksFamily.getBaseBlock(), 4).define('#', terracotta).pattern("##").pattern("##").unlockedBy(getHasName(terracotta), has(terracotta)).save(output.withConditions(TERRACOTTA_BRICKS_CONFIG));
		generateConditionalRecipes(output, bricksFamily, TERRACOTTA_BRICKS_CONFIG);
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.SLAB), bricksFamily.getBaseBlock(), 2);
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.STAIRS), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(output, RecipeCategory.DECORATIONS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.WALL), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.CHISELED), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.getBaseBlock(), terracotta);
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.SLAB), terracotta, 2);
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.STAIRS), terracotta);
		conditionalStonecuttingRecipe(output, RecipeCategory.DECORATIONS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.WALL), terracotta);
		conditionalStonecuttingRecipe(output, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.CHISELED), terracotta);
		if (dye != null) {
			ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksFamily.getBaseBlock(), 8).define('#', TERRACOTTA_BRICKS.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_terracotta_bricks").unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA)).save(output.withConditions(TERRACOTTA_BRICKS_CONFIG), Clayworks.location(getConversionRecipeName(bricksFamily.getBaseBlock(), dye)));
		}
	}

	public static SimpleCookingRecipeBuilder baking(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
		return SimpleCookingRecipeBuilder.generic(ingredient, category, result, experience, cookingTime, ClayworksRecipeSerializers.BAKING_RECIPE.get(), BakingRecipe::new);
	}

	public static void bakingRecipe(RecipeOutput output, RecipeCategory category, TagKey<Item> ingredient, String hasIngredient, ItemLike result, float experience, int cookingTime) {
		bakingRecipe(output, category, ingredient, hasIngredient, result, experience, cookingTime, Clayworks.MOD_ID);
	}

	public static void bakingRecipe(RecipeOutput output, RecipeCategory category, ItemLike ingredient, ItemLike result, float experience, int cookingTime) {
		bakingRecipe(output, category, ingredient, result, experience, cookingTime, Clayworks.MOD_ID);
	}

	public static void bakingRecipe(RecipeOutput output, RecipeCategory category, TagKey<Item> ingredient, String hasIngredient, ItemLike result, float experience, int cookingTime, String modid) {
		bakingRecipe(output, modid.equals(Clayworks.MOD_ID) ? KILN_CONFIG : KILN_COMPAT, category, ingredient, hasIngredient, result, experience, cookingTime, modid);
	}

	public static void bakingRecipe(RecipeOutput output, RecipeCategory category, ItemLike ingredient, ItemLike result, float experience, int cookingTime, String modid) {
		bakingRecipe(output, modid.equals(Clayworks.MOD_ID) ? KILN_CONFIG : KILN_COMPAT, category, ingredient, result, experience, cookingTime, modid);
	}

	public static void bakingRecipe(RecipeOutput output, ICondition condition, RecipeCategory category, TagKey<Item> ingredient, String hasIngredient, ItemLike result, float experience, int cookingTime, String modid) {
		baking(Ingredient.of(ingredient), category, result, experience, cookingTime).unlockedBy(hasIngredient, has(ingredient)).save(output.withConditions(condition), ResourceLocation.fromNamespaceAndPath(modid, getItemName(result) + "_from_baking"));
	}

	public static void bakingRecipe(RecipeOutput output, ICondition condition, RecipeCategory category, ItemLike ingredient, ItemLike result, float experience, int cookingTime, String modid) {
		baking(Ingredient.of(ingredient), category, result, experience, cookingTime).unlockedBy(getHasName(ingredient), has(ingredient)).save(output.withConditions(condition), ResourceLocation.fromNamespaceAndPath(modid, getItemName(result) + "_from_baking"));
	}

	protected static void generateConditionalRecipes(RecipeOutput output, BlockFamily family, ICondition condition) {
		family.getVariants().forEach((variant, result) -> {
			BiFunction<ItemLike, ItemLike, RecipeBuilder> function = SHAPE_BUILDERS.get(variant);
			ItemLike block = getBaseBlock(family, variant);
			if (function != null) {
				RecipeBuilder recipebuilder = function.apply(result, block);
				family.getRecipeGroupPrefix().ifPresent((p_176601_) -> recipebuilder.group(p_176601_ + (variant == Variant.CUT ? "" : "_" + variant.name())));
				recipebuilder.unlockedBy(family.getRecipeUnlockedBy().orElseGet(() -> getHasName(block)), has(block));
				recipebuilder.save(output.withConditions(condition));
			}

			if (variant == BlockFamily.Variant.CRACKED) {
				smeltingResultFromBase(output, result, block);
				SimpleCookingRecipeBuilder.smelting(Ingredient.of(block), RecipeCategory.BUILDING_BLOCKS, result, 0.1F, 200).unlockedBy(getHasName(block), has(block)).save(output.withConditions(condition).withConditions(condition));
			}
		});
	}

	protected void stainedGlassDoorFromDye(RecipeOutput output, ItemLike input, ItemLike door, ItemLike dye, String group) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, door).requires(input).requires(dye).group(group).unlockedBy(getHasName(input), has(input)).save(output.withConditions(GLASS_DOORS), getModConversionRecipeName(door, dye));
	}

	public void generateGlassDoorRecipes(RecipeOutput output, BlockFamily family, ItemLike dye) {
		generateConditionalRecipes(output, family, GLASS_DOORS);
		stainedGlassDoorFromDye(output, GLASS_DOOR, family.get(Variant.DOOR), dye, "stained_glass_door");
		stainedGlassDoorFromDye(output, GLASS_TRAPDOOR, family.get(Variant.TRAPDOOR), dye, "stained_glass_trapdoor");
	}

	protected static void coloredConcreteFromConcreteAndDye(RecipeOutput output, ItemLike concrete, ItemLike concretePowder, ItemLike dye) {
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, concrete, 8).define('#', CONCRETE.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("concrete").unlockedBy("has_concrete", has(CONCRETE.get())).save(output.withConditions(CONCRETE_CONFIG), Clayworks.location(BuiltInRegistries.ITEM.getKey(concrete.asItem()).getPath()));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, concretePowder, 8).define('#', CONCRETE_POWDER.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("concrete_powder").unlockedBy("has_concrete_powder", has(CONCRETE_POWDER.get())).save(output.withConditions(CONCRETE_CONFIG), Clayworks.location(BuiltInRegistries.ITEM.getKey(concretePowder.asItem()).getPath()));
	}

	public static void conditionalStonecuttingRecipe(RecipeOutput output, RecipeCategory category, ICondition condition, ItemLike result, ItemLike input, int count) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, result, count).unlockedBy(getHasName(input), has(input)).save(output.withConditions(condition), Clayworks.location(getConversionRecipeName(result, input) + "_stonecutting"));
	}

	public static void conditionalStonecuttingRecipe(RecipeOutput output, RecipeCategory category, ICondition condition, ItemLike result, ItemLike input) {
		conditionalStonecuttingRecipe(output, category, condition, result, input, 1);
	}

	public static ConfigValueCondition config(ModConfigSpec.ConfigValue<?> value, String key, boolean inverted) {
		return new ConfigValueCondition(ClayworksConditions.CONFIG.get(), value, key, Maps.newHashMap(), inverted);
	}

	public static ConfigValueCondition config(ModConfigSpec.ConfigValue<?> value, String key) {
		return new ConfigValueCondition(ClayworksConditions.CONFIG.get(), value, key, Maps.newHashMap(), false);
	}
}
