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
	public static final ConfigValueCondition CHISELED_BRICKS_CONFIG = config(COMMON.chiseledBricks, "chiseled_bricks");
	public static final ConfigValueCondition GLAZED_TERRACOTTA_CONFIG = config(COMMON.glazedTerracotta, "glazed_terracotta");
	public static final ConfigValueCondition TERRACOTTA_VARIANTS_CONFIG = config(COMMON.terracottaVariants, "terracotta_variants");
	public static final ConfigValueCondition TERRACOTTA_BRICKS_CONFIG = config(COMMON.terracottaBricks, "terracotta_bricks");
	public static final ConfigValueCondition CONCRETE_CONFIG = config(COMMON.concrete, "concrete");
	public static final BlueprintAndCondition KILN_COMPAT = new BlueprintAndCondition(new ModLoadedCondition(Clayworks.MOD_ID), KILN_CONFIG);

	public ClayworksRecipeProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(Clayworks.MOD_ID, output, provider);
	}

	@Override
	public void buildRecipes(RecipeOutput recipeOutput) {
		conditionalRecipe(recipeOutput, KILN_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, KILN.get()).define('#', ItemTags.STONE_CRAFTING_MATERIALS).define('X', Blocks.FURNACE).define('B', Blocks.MUD_BRICKS).pattern("###").pattern("#X#").pattern("BBB").unlockedBy("has_cobblestone", has(ItemTags.STONE_CRAFTING_MATERIALS)));
		generateKilnRecipes(recipeOutput);
		SpecialRecipeBuilder.special(DecoratedPotColoring::new).save(recipeOutput, Clayworks.MOD_ID + ":decorated_pot_coloring");

		conditionalRecipe(recipeOutput, CHISELED_BRICKS_CONFIG, chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, CHISELED_BRICKS.get(), Ingredient.of(Blocks.BRICK_SLAB)).unlockedBy(getHasName(Blocks.BRICK_SLAB), has(Blocks.BRICK_SLAB)));
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, CHISELED_BRICKS_CONFIG, CHISELED_BRICKS.get(), Blocks.BRICKS);
		conditionalRecipe(recipeOutput, GLAZED_TERRACOTTA_CONFIG, SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.TERRACOTTA), RecipeCategory.BUILDING_BLOCKS, GLAZED_TERRACOTTA.get().asItem(), 0.1F, 200).unlockedBy("has_terracotta", has(Blocks.TERRACOTTA)));

		conditionalRecipe(recipeOutput, CONCRETE_CONFIG, ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CONCRETE_POWDER.get(), 8).requires(Blocks.SAND, 4).requires(Blocks.GRAVEL, 4).group("concrete_powder").unlockedBy("has_sand", has(Blocks.SAND)).unlockedBy("has_gravel", has(Blocks.GRAVEL)));
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.BLACK_CONCRETE, Blocks.BLACK_CONCRETE_POWDER, Items.BLACK_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.BLUE_CONCRETE, Blocks.BLUE_CONCRETE_POWDER, Items.BLUE_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.BROWN_CONCRETE, Blocks.BROWN_CONCRETE_POWDER, Items.BROWN_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.CYAN_CONCRETE, Blocks.CYAN_CONCRETE_POWDER, Items.CYAN_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.GRAY_CONCRETE, Blocks.GRAY_CONCRETE_POWDER, Items.GRAY_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.GREEN_CONCRETE, Blocks.GREEN_CONCRETE_POWDER, Items.GREEN_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.LIGHT_BLUE_CONCRETE, Blocks.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_BLUE_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.LIGHT_GRAY_CONCRETE, Blocks.LIGHT_GRAY_CONCRETE_POWDER, Items.LIGHT_GRAY_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.LIME_CONCRETE, Blocks.LIME_CONCRETE_POWDER, Items.LIME_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.MAGENTA_CONCRETE, Blocks.MAGENTA_CONCRETE_POWDER, Items.MAGENTA_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.ORANGE_CONCRETE, Blocks.ORANGE_CONCRETE_POWDER, Items.ORANGE_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.PINK_CONCRETE, Blocks.PINK_CONCRETE_POWDER, Items.PINK_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.PURPLE_CONCRETE, Blocks.PURPLE_CONCRETE_POWDER, Items.PURPLE_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.RED_CONCRETE, Blocks.RED_CONCRETE_POWDER, Items.RED_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.WHITE_CONCRETE, Blocks.WHITE_CONCRETE_POWDER, Items.WHITE_DYE);
		coloredConcreteFromConcreteAndDye(recipeOutput, Blocks.YELLOW_CONCRETE, Blocks.YELLOW_CONCRETE_POWDER, Items.YELLOW_DYE);

		terracottaBricksRecipes(recipeOutput, Blocks.TERRACOTTA, ClayworksBlockFamilies.TERRACOTTA, ClayworksBlockFamilies.TERRACOTTA_BRICKS, null);
		terracottaBricksRecipes(recipeOutput, Blocks.WHITE_TERRACOTTA, ClayworksBlockFamilies.WHITE_TERRACOTTA, ClayworksBlockFamilies.WHITE_TERRACOTTA_BRICKS, Items.WHITE_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.ORANGE_TERRACOTTA, ClayworksBlockFamilies.ORANGE_TERRACOTTA, ClayworksBlockFamilies.ORANGE_TERRACOTTA_BRICKS, Items.ORANGE_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.MAGENTA_TERRACOTTA, ClayworksBlockFamilies.MAGENTA_TERRACOTTA, ClayworksBlockFamilies.MAGENTA_TERRACOTTA_BRICKS, Items.MAGENTA_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.LIGHT_BLUE_TERRACOTTA, ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA, ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA_BRICKS, Items.LIGHT_BLUE_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.YELLOW_TERRACOTTA, ClayworksBlockFamilies.YELLOW_TERRACOTTA, ClayworksBlockFamilies.YELLOW_TERRACOTTA_BRICKS, Items.YELLOW_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.LIME_TERRACOTTA, ClayworksBlockFamilies.LIME_TERRACOTTA, ClayworksBlockFamilies.LIME_TERRACOTTA_BRICKS, Items.LIME_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.PINK_TERRACOTTA, ClayworksBlockFamilies.PINK_TERRACOTTA, ClayworksBlockFamilies.PINK_TERRACOTTA_BRICKS, Items.PINK_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.GRAY_TERRACOTTA, ClayworksBlockFamilies.GRAY_TERRACOTTA, ClayworksBlockFamilies.GRAY_TERRACOTTA_BRICKS, Items.GRAY_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.LIGHT_GRAY_TERRACOTTA, ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA, ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA_BRICKS, Items.LIGHT_GRAY_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.CYAN_TERRACOTTA, ClayworksBlockFamilies.CYAN_TERRACOTTA, ClayworksBlockFamilies.CYAN_TERRACOTTA_BRICKS, Items.CYAN_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.PURPLE_TERRACOTTA, ClayworksBlockFamilies.PURPLE_TERRACOTTA, ClayworksBlockFamilies.PURPLE_TERRACOTTA_BRICKS, Items.PURPLE_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.BLUE_TERRACOTTA, ClayworksBlockFamilies.BLUE_TERRACOTTA, ClayworksBlockFamilies.BLUE_TERRACOTTA_BRICKS, Items.BLUE_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.BROWN_TERRACOTTA, ClayworksBlockFamilies.BROWN_TERRACOTTA, ClayworksBlockFamilies.BROWN_TERRACOTTA_BRICKS, Items.BROWN_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.GREEN_TERRACOTTA, ClayworksBlockFamilies.GREEN_TERRACOTTA, ClayworksBlockFamilies.GREEN_TERRACOTTA_BRICKS, Items.GREEN_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.RED_TERRACOTTA, ClayworksBlockFamilies.RED_TERRACOTTA, ClayworksBlockFamilies.RED_TERRACOTTA_BRICKS, Items.RED_DYE);
		terracottaBricksRecipes(recipeOutput, Blocks.BLACK_TERRACOTTA, ClayworksBlockFamilies.BLACK_TERRACOTTA, ClayworksBlockFamilies.BLACK_TERRACOTTA_BRICKS, Items.BLACK_DYE);
	}

	public static void generateKilnRecipes(RecipeOutput recipeOutput) {
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ItemTags.SMELTS_TO_GLASS, "has_smelts_to_glass", Blocks.GLASS, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.MISC, ItemTags.LOGS_THAT_BURN, "has_log", Items.CHARCOAL, 0.15F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.WET_SPONGE, Blocks.SPONGE, 0.15F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.MISC, Blocks.SEA_PICKLE, Items.LIME_DYE, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.MISC, Blocks.CACTUS, Items.GREEN_DYE, 1.0F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.MISC, Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT, 0.1F, 100);

		bakingRecipe(recipeOutput, RecipeCategory.MISC, Items.CLAY_BALL, Items.BRICK, 0.3F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY, Blocks.TERRACOTTA, 0.35F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.MISC, Blocks.NETHERRACK, Items.NETHER_BRICK, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE, Blocks.STONE, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE, Blocks.SMOOTH_STONE, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT, Blocks.SMOOTH_BASALT, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, 0.1F, 100);

		bakingRecipe(recipeOutput, new BlueprintAndCondition(KILN_CONFIG, GLAZED_TERRACOTTA_CONFIG), RecipeCategory.DECORATIONS, Blocks.TERRACOTTA, GLAZED_TERRACOTTA.get(), 0.1F, 100, Clayworks.MOD_ID);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, 0.1F, 100);
		bakingRecipe(recipeOutput, RecipeCategory.DECORATIONS, Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, 0.1F, 100);
	}

	private static void terracottaBricksRecipes(RecipeOutput recipeOutput, Block terracotta, BlockFamily family, BlockFamily bricksFamily, @Nullable Item dye) {
		generateConditionalRecipes(recipeOutput, family, TERRACOTTA_VARIANTS_CONFIG);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.SLAB), family.getBaseBlock(), 2);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.STAIRS), family.getBaseBlock());
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.DECORATIONS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.WALL), family.getBaseBlock());

		conditionalRecipe(recipeOutput, TERRACOTTA_BRICKS_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksFamily.getBaseBlock(), 4).define('#', terracotta).pattern("##").pattern("##").unlockedBy(getHasName(terracotta), has(terracotta)));
		generateConditionalRecipes(recipeOutput, bricksFamily, TERRACOTTA_BRICKS_CONFIG);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.SLAB), bricksFamily.getBaseBlock(), 2);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.STAIRS), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.DECORATIONS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.WALL), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.CHISELED), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.getBaseBlock(), terracotta);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.SLAB), terracotta, 2);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.STAIRS), terracotta);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.DECORATIONS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.WALL), terracotta);
		conditionalStonecuttingRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.CHISELED), terracotta);
		if (dye != null) {
			conditionalRecipe(recipeOutput, TERRACOTTA_BRICKS_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksFamily.getBaseBlock(), 8).define('#', TERRACOTTA_BRICKS.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_terracotta_bricks").unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA)), Clayworks.location(getConversionRecipeName(bricksFamily.getBaseBlock(), dye)));
		}
	}

	public static SimpleCookingRecipeBuilder baking(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
		return SimpleCookingRecipeBuilder.generic(ingredient, category, result, experience, cookingTime, ClayworksRecipeSerializers.BAKING_RECIPE.get(), BakingRecipe::new);
	}

	public static void bakingRecipe(RecipeOutput recipeOutput, RecipeCategory category, TagKey<Item> ingredient, String hasIngredient, ItemLike result, float experience, int cookingTime) {
		bakingRecipe(recipeOutput, category, ingredient, hasIngredient, result, experience, cookingTime, Clayworks.MOD_ID);
	}

	public static void bakingRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike ingredient, ItemLike result, float experience, int cookingTime) {
		bakingRecipe(recipeOutput, category, ingredient, result, experience, cookingTime, Clayworks.MOD_ID);
	}

	public static void bakingRecipe(RecipeOutput recipeOutput, RecipeCategory category, TagKey<Item> ingredient, String hasIngredient, ItemLike result, float experience, int cookingTime, String modid) {
		bakingRecipe(recipeOutput, modid.equals(Clayworks.MOD_ID) ? KILN_CONFIG : KILN_COMPAT, category, ingredient, hasIngredient, result, experience, cookingTime, modid);
	}

	public static void bakingRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike ingredient, ItemLike result, float experience, int cookingTime, String modid) {
		bakingRecipe(recipeOutput, modid.equals(Clayworks.MOD_ID) ? KILN_CONFIG : KILN_COMPAT, category, ingredient, result, experience, cookingTime, modid);
	}

	public static void bakingRecipe(RecipeOutput recipeOutput, ICondition condition, RecipeCategory category, TagKey<Item> ingredient, String hasIngredient, ItemLike result, float experience, int cookingTime, String modid) {
		conditionalRecipe(recipeOutput, condition, baking(Ingredient.of(ingredient), category, result, experience, cookingTime).unlockedBy(hasIngredient, has(ingredient)), ResourceLocation.fromNamespaceAndPath(modid, getItemName(result) + "_from_baking"));
	}

	public static void bakingRecipe(RecipeOutput recipeOutput, ICondition condition, RecipeCategory category, ItemLike ingredient, ItemLike result, float experience, int cookingTime, String modid) {
		conditionalRecipe(recipeOutput, condition, baking(Ingredient.of(ingredient), category, result, experience, cookingTime).unlockedBy(getHasName(ingredient), has(ingredient)), ResourceLocation.fromNamespaceAndPath(modid, getItemName(result) + "_from_baking"));
	}

	protected static void generateConditionalRecipes(RecipeOutput recipeOutput, BlockFamily family, ICondition condition) {
		family.getVariants().forEach((variant, output) -> {
			BiFunction<ItemLike, ItemLike, RecipeBuilder> function = SHAPE_BUILDERS.get(variant);
			ItemLike block = getBaseBlock(family, variant);
			if (function != null) {
				RecipeBuilder recipebuilder = function.apply(output, block);
				family.getRecipeGroupPrefix().ifPresent((p_176601_) -> recipebuilder.group(p_176601_ + (variant == Variant.CUT ? "" : "_" + variant.name())));
				recipebuilder.unlockedBy(family.getRecipeUnlockedBy().orElseGet(() -> getHasName(block)), has(block));
				if (recipebuilder instanceof ShapedRecipeBuilder shapedRecipeBuilder) {
					conditionalRecipe(recipeOutput, condition, shapedRecipeBuilder);
				} else if (recipebuilder instanceof ShapelessRecipeBuilder shapelessRecipeBuilder) {
					conditionalRecipe(recipeOutput, condition, shapelessRecipeBuilder);
				}
			}

			if (variant == BlockFamily.Variant.CRACKED) {
				smeltingResultFromBase(recipeOutput, output, block);
				conditionalRecipe(recipeOutput, condition, SimpleCookingRecipeBuilder.smelting(Ingredient.of(block), RecipeCategory.BUILDING_BLOCKS, output, 0.1F, 200).unlockedBy(getHasName(block), has(block)));
			}
		});
	}

	protected static void coloredConcreteFromConcreteAndDye(RecipeOutput recipeOutput, ItemLike concrete, ItemLike concretePowder, ItemLike dye) {
		conditionalRecipe(recipeOutput, CONCRETE_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, concrete, 8).define('#', CONCRETE.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("concrete").unlockedBy("has_concrete", has(CONCRETE.get())));
		conditionalRecipe(recipeOutput, CONCRETE_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, concretePowder, 8).define('#', CONCRETE_POWDER.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("concrete_powder").unlockedBy("has_concrete_powder", has(CONCRETE_POWDER.get())));
	}

	public static void conditionalStonecuttingRecipe(RecipeOutput recipeOutput, RecipeCategory category, ICondition condition, ItemLike output, ItemLike input, int count) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, output, count).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(condition), Clayworks.location(getConversionRecipeName(output, input) + "_stonecutting"));
	}

	public static void conditionalStonecuttingRecipe(RecipeOutput recipeOutput, RecipeCategory category, ICondition condition, ItemLike output, ItemLike input) {
		conditionalStonecuttingRecipe(recipeOutput, category, condition, output, input, 1);
	}

	public static void conditionalRecipe(RecipeOutput recipeOutput, ICondition condition, RecipeBuilder recipe, ResourceLocation id) {
		recipe.save(recipeOutput.withConditions(condition), id);
	}

	public static void conditionalRecipe(RecipeOutput recipeOutput, ICondition condition, RecipeBuilder recipe) {
		recipe.save(recipeOutput.withConditions(condition));
	}

	public static ConfigValueCondition config(ModConfigSpec.ConfigValue<?> value, String key, boolean inverted) {
		return new ConfigValueCondition(ClayworksConditions.CONFIG.get(), value, key, Maps.newHashMap(), inverted);
	}

	public static ConfigValueCondition config(ModConfigSpec.ConfigValue<?> value, String key) {
		return new ConfigValueCondition(ClayworksConditions.CONFIG.get(), value, key, Maps.newHashMap(), false);
	}
}
