package com.teamabnormals.clayworks.core.data.server;

import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.other.ClayworksBlockFamilies;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.crafting.conditions.ICondition;

import javax.annotation.Nullable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import static com.teamabnormals.clayworks.core.ClayworksConfig.COMMON;
import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

public class ClayworksRecipeProvider extends RecipeProvider {
	public static final ConfigValueCondition KILN_CONFIG = config(COMMON.kiln, "kiln");
	public static final ConfigValueCondition CHISELED_BRICKS_CONFIG = config(COMMON.chiseledBricks, "chiseled_bricks");
	public static final ConfigValueCondition GLAZED_TERRACOTTA_CONFIG = config(COMMON.glazedTerracotta, "glazed_terracotta");
	public static final ConfigValueCondition TERRACOTTA_VARIANTS_CONFIG = config(COMMON.terracottaVariants, "terracotta_variants");
	public static final ConfigValueCondition TERRACOTTA_BRICKS_CONFIG = config(COMMON.terracottaBricks, "terracotta_bricks");

	public ClayworksRecipeProvider(PackOutput output) {
		super(output);
	}

	@Override
	public void buildRecipes(Consumer<FinishedRecipe> consumer) {
		conditionalRecipe(consumer, RecipeCategory.DECORATIONS, KILN_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, KILN.get()).define('#', ItemTags.STONE_CRAFTING_MATERIALS).define('X', Blocks.FURNACE).define('B', Blocks.MUD_BRICKS).pattern("###").pattern("#X#").pattern("BBB").unlockedBy("has_cobblestone", has(ItemTags.STONE_CRAFTING_MATERIALS)));
		generateKilnRecipes(consumer);
		SpecialRecipeBuilder.special(ClayworksRecipeSerializers.DECORATED_POT_COLORING.get()).save(consumer, Clayworks.MOD_ID + ":decorated_pot_coloring");

		conditionalRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CHISELED_BRICKS_CONFIG, chiseledBuilder(RecipeCategory.BUILDING_BLOCKS, CHISELED_BRICKS.get(), Ingredient.of(Blocks.BRICK_SLAB)).unlockedBy(getHasName(Blocks.BRICK_SLAB), has(Blocks.BRICK_SLAB)));
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, CHISELED_BRICKS_CONFIG, CHISELED_BRICKS.get(), Blocks.BRICKS);
		conditionalRecipe(consumer, RecipeCategory.DECORATIONS, GLAZED_TERRACOTTA_CONFIG, SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.TERRACOTTA), RecipeCategory.BUILDING_BLOCKS, GLAZED_TERRACOTTA.get().asItem(), 0.1F, 200).unlockedBy("has_terracotta", has(Blocks.TERRACOTTA)));

		terracottaBricksRecipes(consumer, Blocks.TERRACOTTA, ClayworksBlockFamilies.TERRACOTTA, ClayworksBlockFamilies.TERRACOTTA_BRICKS, null);
		terracottaBricksRecipes(consumer, Blocks.WHITE_TERRACOTTA, ClayworksBlockFamilies.WHITE_TERRACOTTA, ClayworksBlockFamilies.WHITE_TERRACOTTA_BRICKS, Items.WHITE_DYE);
		terracottaBricksRecipes(consumer, Blocks.ORANGE_TERRACOTTA, ClayworksBlockFamilies.ORANGE_TERRACOTTA, ClayworksBlockFamilies.ORANGE_TERRACOTTA_BRICKS, Items.ORANGE_DYE);
		terracottaBricksRecipes(consumer, Blocks.MAGENTA_TERRACOTTA, ClayworksBlockFamilies.MAGENTA_TERRACOTTA, ClayworksBlockFamilies.MAGENTA_TERRACOTTA_BRICKS, Items.MAGENTA_DYE);
		terracottaBricksRecipes(consumer, Blocks.LIGHT_BLUE_TERRACOTTA, ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA, ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA_BRICKS, Items.LIGHT_BLUE_DYE);
		terracottaBricksRecipes(consumer, Blocks.YELLOW_TERRACOTTA, ClayworksBlockFamilies.YELLOW_TERRACOTTA, ClayworksBlockFamilies.YELLOW_TERRACOTTA_BRICKS, Items.YELLOW_DYE);
		terracottaBricksRecipes(consumer, Blocks.LIME_TERRACOTTA, ClayworksBlockFamilies.LIME_TERRACOTTA, ClayworksBlockFamilies.LIME_TERRACOTTA_BRICKS, Items.LIME_DYE);
		terracottaBricksRecipes(consumer, Blocks.PINK_TERRACOTTA, ClayworksBlockFamilies.PINK_TERRACOTTA, ClayworksBlockFamilies.PINK_TERRACOTTA_BRICKS, Items.PINK_DYE);
		terracottaBricksRecipes(consumer, Blocks.GRAY_TERRACOTTA, ClayworksBlockFamilies.GRAY_TERRACOTTA, ClayworksBlockFamilies.GRAY_TERRACOTTA_BRICKS, Items.GRAY_DYE);
		terracottaBricksRecipes(consumer, Blocks.LIGHT_GRAY_TERRACOTTA, ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA, ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA_BRICKS, Items.LIGHT_GRAY_DYE);
		terracottaBricksRecipes(consumer, Blocks.CYAN_TERRACOTTA, ClayworksBlockFamilies.CYAN_TERRACOTTA, ClayworksBlockFamilies.CYAN_TERRACOTTA_BRICKS, Items.CYAN_DYE);
		terracottaBricksRecipes(consumer, Blocks.PURPLE_TERRACOTTA, ClayworksBlockFamilies.PURPLE_TERRACOTTA, ClayworksBlockFamilies.PURPLE_TERRACOTTA_BRICKS, Items.PURPLE_DYE);
		terracottaBricksRecipes(consumer, Blocks.BLUE_TERRACOTTA, ClayworksBlockFamilies.BLUE_TERRACOTTA, ClayworksBlockFamilies.BLUE_TERRACOTTA_BRICKS, Items.BLUE_DYE);
		terracottaBricksRecipes(consumer, Blocks.BROWN_TERRACOTTA, ClayworksBlockFamilies.BROWN_TERRACOTTA, ClayworksBlockFamilies.BROWN_TERRACOTTA_BRICKS, Items.BROWN_DYE);
		terracottaBricksRecipes(consumer, Blocks.GREEN_TERRACOTTA, ClayworksBlockFamilies.GREEN_TERRACOTTA, ClayworksBlockFamilies.GREEN_TERRACOTTA_BRICKS, Items.GREEN_DYE);
		terracottaBricksRecipes(consumer, Blocks.RED_TERRACOTTA, ClayworksBlockFamilies.RED_TERRACOTTA, ClayworksBlockFamilies.RED_TERRACOTTA_BRICKS, Items.RED_DYE);
		terracottaBricksRecipes(consumer, Blocks.BLACK_TERRACOTTA, ClayworksBlockFamilies.BLACK_TERRACOTTA, ClayworksBlockFamilies.BLACK_TERRACOTTA_BRICKS, Items.BLACK_DYE);
	}

	public static void generateKilnRecipes(Consumer<FinishedRecipe> consumer) {
		conditionalRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, KILN_CONFIG, baking(Ingredient.of(ItemTags.SAND), RecipeCategory.DECORATIONS, Blocks.GLASS, 0.1F, 100).unlockedBy("has_sand", has(ItemTags.SAND)), new ResourceLocation(Clayworks.MOD_ID, "glass_from_baking"));
		conditionalRecipe(consumer, RecipeCategory.MISC, KILN_CONFIG, baking(Ingredient.of(ItemTags.LOGS_THAT_BURN), RecipeCategory.MISC, Items.CHARCOAL, 0.15F, 100).unlockedBy("has_log", has(ItemTags.LOGS_THAT_BURN)), new ResourceLocation(Clayworks.MOD_ID, "charcoal_from_baking"));
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.WET_SPONGE, Blocks.SPONGE, 0.15F, 100);
		baking(consumer, RecipeCategory.MISC, Blocks.SEA_PICKLE, Items.LIME_DYE, 0.1F, 100);
		baking(consumer, RecipeCategory.MISC, Blocks.CACTUS, Items.GREEN_DYE, 1.0F, 100);
		baking(consumer, RecipeCategory.MISC, Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT, 0.1F, 100);

		baking(consumer, RecipeCategory.MISC, Items.CLAY_BALL, Items.BRICK, 0.3F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.CLAY, Blocks.TERRACOTTA, 0.35F, 100);
		baking(consumer, RecipeCategory.MISC, Blocks.NETHERRACK, Items.NETHER_BRICK, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE, Blocks.STONE, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE, Blocks.SMOOTH_STONE, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT, Blocks.SMOOTH_BASALT, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS, 0.1F, 100);
		baking(consumer, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, 0.1F, 100);

		conditionalRecipe(consumer, RecipeCategory.DECORATIONS, new AndCondition(KILN_CONFIG, GLAZED_TERRACOTTA_CONFIG), baking(Ingredient.of(Blocks.TERRACOTTA), RecipeCategory.BUILDING_BLOCKS, GLAZED_TERRACOTTA.get(), 0.1F, 100).unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA)), new ResourceLocation(Clayworks.MOD_ID, getItemName(GLAZED_TERRACOTTA.get()) + "_from_baking"));
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, RecipeCategory.DECORATIONS, Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, 0.1F, 100);
	}

	private static void terracottaBricksRecipes(Consumer<FinishedRecipe> consumer, Block terracotta, BlockFamily family, BlockFamily bricksFamily, @Nullable Item dye) {
		generateConditionalRecipes(consumer, family, TERRACOTTA_VARIANTS_CONFIG);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.SLAB), family.getBaseBlock(), 2);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.STAIRS), family.getBaseBlock());
		conditionalStonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, TERRACOTTA_VARIANTS_CONFIG, family.get(Variant.WALL), family.getBaseBlock());

		conditionalRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksFamily.getBaseBlock(), 4).define('#', terracotta).pattern("##").pattern("##").unlockedBy(getHasName(terracotta), has(terracotta)));
		generateConditionalRecipes(consumer, bricksFamily, TERRACOTTA_BRICKS_CONFIG);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.SLAB), bricksFamily.getBaseBlock(), 2);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.STAIRS), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.WALL), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.CHISELED), bricksFamily.getBaseBlock());
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.getBaseBlock(), terracotta);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.SLAB), terracotta, 2);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.STAIRS), terracotta);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.DECORATIONS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.WALL), terracotta);
		conditionalStonecuttingRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, bricksFamily.get(Variant.CHISELED), terracotta);
		if (dye != null) {
			conditionalRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_BRICKS_CONFIG, ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, bricksFamily.getBaseBlock(), 8).define('#', TERRACOTTA_BRICKS.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_terracotta_bricks").unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA)), new ResourceLocation(Clayworks.MOD_ID, getConversionRecipeName(bricksFamily.getBaseBlock(), dye)));
		}
	}

	public static SimpleCookingRecipeBuilder baking(Ingredient ingredient, RecipeCategory category, ItemLike result, float experience, int cookingTime) {
		return new SimpleCookingRecipeBuilder(category, result.asItem() instanceof BlockItem ? CookingBookCategory.BLOCKS : CookingBookCategory.MISC, result, ingredient, experience, cookingTime, ClayworksRecipeSerializers.BAKING_RECIPE.get());
	}

	protected static void baking(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike ingredient, ItemLike result, float experience, int cookingTime) {
		conditionalRecipe(consumer, category, KILN_CONFIG, baking(Ingredient.of(ingredient), category, result, experience, cookingTime).unlockedBy(getHasName(ingredient), has(ingredient)), new ResourceLocation(Clayworks.MOD_ID, getItemName(result) + "_from_baking"));
	}

	protected static RecipeBuilder verticalSlabBuilder(ItemLike item, Ingredient ingredient) {
		return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, item, 6).define('#', ingredient).pattern("#").pattern("#").pattern("#");
	}

	protected static void generateConditionalRecipes(Consumer<FinishedRecipe> consumer, BlockFamily family, ICondition condition) {
		family.getVariants().forEach((variant, output) -> {
			BiFunction<ItemLike, ItemLike, RecipeBuilder> function = SHAPE_BUILDERS.get(variant);
			ItemLike block = getBaseBlock(family, variant);
			if (function != null) {
				RecipeBuilder recipebuilder = function.apply(output, block);
				family.getRecipeGroupPrefix().ifPresent((p_176601_) -> recipebuilder.group(p_176601_ + (variant == Variant.CUT ? "" : "_" + variant.getName())));
				recipebuilder.unlockedBy(family.getRecipeUnlockedBy().orElseGet(() -> getHasName(block)), has(block));
				if (recipebuilder instanceof ShapedRecipeBuilder shapedRecipeBuilder) {
					conditionalRecipe(consumer, condition, shapedRecipeBuilder);
				} else if (recipebuilder instanceof ShapelessRecipeBuilder shapelessRecipeBuilder) {
					conditionalRecipe(consumer, condition, shapelessRecipeBuilder);
				}
			}

			if (variant == BlockFamily.Variant.CRACKED) {
				smeltingResultFromBase(consumer, output, block);
				conditionalRecipe(consumer, RecipeCategory.BUILDING_BLOCKS, condition, SimpleCookingRecipeBuilder.smelting(Ingredient.of(block), RecipeCategory.BUILDING_BLOCKS, output, 0.1F, 200).unlockedBy(getHasName(block), has(block)));
			}
		});
	}

	public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, ICondition condition, RecipeBuilder recipe) {
		conditionalRecipe(consumer, category, condition, recipe, RecipeBuilder.getDefaultRecipeId(recipe.getResult()));
	}

	public static void conditionalStonecuttingRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, ICondition condition, ItemLike output, ItemLike input, int count) {
		conditionalRecipe(consumer, category, condition, SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, output, count).unlockedBy(getHasName(input), has(input)), new ResourceLocation(Clayworks.MOD_ID, getConversionRecipeName(output, input) + "_stonecutting"));
	}

	public static void conditionalStonecuttingRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory category, ICondition condition, ItemLike output, ItemLike input) {
		conditionalStonecuttingRecipe(consumer, category, condition, output, input, 1);
	}

	public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, RecipeCategory recipeCategory, ICondition condition, RecipeBuilder recipe, ResourceLocation id) {
		ConditionalRecipe.builder().addCondition(condition).addRecipe(consumer1 -> recipe.save(consumer1, id)).generateAdvancement(new ResourceLocation(id.getNamespace(), "recipes/" + recipeCategory.getFolderName() + "/" + id.getPath())).build(consumer, id);
	}

	public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, ShapelessRecipeBuilder recipe) {
		conditionalRecipe(consumer, recipe.category, condition, recipe, RecipeBuilder.getDefaultRecipeId(recipe.getResult()));
	}

	public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, ShapedRecipeBuilder recipe) {
		conditionalRecipe(consumer, recipe.category, condition, recipe, RecipeBuilder.getDefaultRecipeId(recipe.getResult()));
	}

	public static ConfigValueCondition config(ForgeConfigSpec.ConfigValue<?> value, String key, boolean inverted) {
		return new ConfigValueCondition(new ResourceLocation(Clayworks.MOD_ID, "config"), value, key, Maps.newHashMap(), inverted);
	}

	public static ConfigValueCondition config(ForgeConfigSpec.ConfigValue<?> value, String key) {
		return config(value, key, false);
	}
}
