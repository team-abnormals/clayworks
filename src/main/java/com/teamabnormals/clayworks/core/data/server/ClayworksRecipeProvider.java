package com.teamabnormals.clayworks.core.data.server;

import com.teamabnormals.blueprint.core.Blueprint;
import com.teamabnormals.blueprint.core.api.conditions.QuarkFlagRecipeCondition;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.other.ClayworksBlockFamilies;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ICondition;

import javax.annotation.Nullable;
import java.util.function.Consumer;

import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

public class ClayworksRecipeProvider extends RecipeProvider {
	public static final QuarkFlagRecipeCondition VERTICAL_SLABS = new QuarkFlagRecipeCondition(new ResourceLocation(Blueprint.MOD_ID, "quark_flag"), "vertical_slabs");

	public ClayworksRecipeProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	public void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		ShapedRecipeBuilder.shaped(KILN.get()).define('#', ItemTags.STONE_CRAFTING_MATERIALS).define('X', Blocks.FURNACE).define('B', TERRACOTTA_BRICKS.get()).pattern("BBB").pattern("BXB").pattern("###").unlockedBy("has_cobblestone", has(ItemTags.STONE_CRAFTING_MATERIALS)).save(consumer);
		kilnRecipes(consumer);
		chiseled(consumer, CHISELED_BRICKS.get(), Blocks.BRICK_SLAB);
		stonecutterResultFromBase(consumer, Blocks.BRICKS, CHISELED_BRICKS.get());

		terracottaBricksRecipes(consumer, Blocks.TERRACOTTA, ClayworksBlockFamilies.TERRACOTTA_BRICKS, TERRACOTTA_BRICK_VERTICAL_SLAB.get(), null);
		terracottaBricksRecipes(consumer, Blocks.WHITE_TERRACOTTA, ClayworksBlockFamilies.WHITE_TERRACOTTA_BRICKS, WHITE_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.WHITE_DYE);
		terracottaBricksRecipes(consumer, Blocks.ORANGE_TERRACOTTA, ClayworksBlockFamilies.ORANGE_TERRACOTTA_BRICKS, ORANGE_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.ORANGE_DYE);
		terracottaBricksRecipes(consumer, Blocks.MAGENTA_TERRACOTTA, ClayworksBlockFamilies.MAGENTA_TERRACOTTA_BRICKS, MAGENTA_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.MAGENTA_DYE);
		terracottaBricksRecipes(consumer, Blocks.LIGHT_BLUE_TERRACOTTA, ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA_BRICKS, LIGHT_BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.LIGHT_BLUE_DYE);
		terracottaBricksRecipes(consumer, Blocks.YELLOW_TERRACOTTA, ClayworksBlockFamilies.YELLOW_TERRACOTTA_BRICKS, YELLOW_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.YELLOW_DYE);
		terracottaBricksRecipes(consumer, Blocks.LIME_TERRACOTTA, ClayworksBlockFamilies.LIME_TERRACOTTA_BRICKS, LIME_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.LIME_DYE);
		terracottaBricksRecipes(consumer, Blocks.PINK_TERRACOTTA, ClayworksBlockFamilies.PINK_TERRACOTTA_BRICKS, PINK_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.PINK_DYE);
		terracottaBricksRecipes(consumer, Blocks.GRAY_TERRACOTTA, ClayworksBlockFamilies.GRAY_TERRACOTTA_BRICKS, GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.GRAY_DYE);
		terracottaBricksRecipes(consumer, Blocks.LIGHT_GRAY_TERRACOTTA, ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA_BRICKS, LIGHT_GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.LIGHT_GRAY_DYE);
		terracottaBricksRecipes(consumer, Blocks.CYAN_TERRACOTTA, ClayworksBlockFamilies.CYAN_TERRACOTTA_BRICKS, CYAN_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.CYAN_DYE);
		terracottaBricksRecipes(consumer, Blocks.PURPLE_TERRACOTTA, ClayworksBlockFamilies.PURPLE_TERRACOTTA_BRICKS, PURPLE_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.PURPLE_DYE);
		terracottaBricksRecipes(consumer, Blocks.BLUE_TERRACOTTA, ClayworksBlockFamilies.BLUE_TERRACOTTA_BRICKS, BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.BLUE_DYE);
		terracottaBricksRecipes(consumer, Blocks.BROWN_TERRACOTTA, ClayworksBlockFamilies.BROWN_TERRACOTTA_BRICKS, BROWN_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.BROWN_DYE);
		terracottaBricksRecipes(consumer, Blocks.GREEN_TERRACOTTA, ClayworksBlockFamilies.GREEN_TERRACOTTA_BRICKS, GREEN_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.GREEN_DYE);
		terracottaBricksRecipes(consumer, Blocks.BLACK_TERRACOTTA, ClayworksBlockFamilies.RED_TERRACOTTA_BRICKS, RED_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.RED_DYE);
		terracottaBricksRecipes(consumer, Blocks.TERRACOTTA, ClayworksBlockFamilies.BLACK_TERRACOTTA_BRICKS, BLACK_TERRACOTTA_BRICK_VERTICAL_SLAB.get(), Items.BLACK_DYE);
	}

	public static void kilnRecipes(Consumer<FinishedRecipe> consumer) {
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(ItemTags.SAND), Blocks.GLASS, 0.1F, 100, ClayworksRecipeSerializers.BAKING.get()).unlockedBy("has_sand", has(ItemTags.SAND)).save(consumer, new ResourceLocation(Clayworks.MOD_ID, "glass_from_baking"));
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(ItemTags.LOGS_THAT_BURN), Items.CHARCOAL, 0.15F, 100, ClayworksRecipeSerializers.BAKING.get()).unlockedBy("has_log", has(ItemTags.LOGS_THAT_BURN)).save(consumer, new ResourceLocation(Clayworks.MOD_ID, "charcoal_from_baking"));
		baking(consumer, Blocks.WET_SPONGE, Blocks.SPONGE, 0.15F, 100);
		baking(consumer, Blocks.SEA_PICKLE, Items.LIME_DYE, 0.1F, 100);
		baking(consumer, Blocks.CACTUS, Items.GREEN_DYE, 0.1F, 100);
		baking(consumer, Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT, 0.1F, 100);

		baking(consumer, Items.CLAY_BALL, Items.BRICK, 0.3F, 100);
		baking(consumer, Blocks.CLAY, Blocks.TERRACOTTA, 0.35F, 100);
		baking(consumer, Blocks.NETHERRACK, Items.NETHER_BRICK, 0.1F, 100);
		baking(consumer, Blocks.COBBLESTONE, Blocks.STONE, 0.1F, 100);
		baking(consumer, Blocks.COBBLED_DEEPSLATE, Blocks.DEEPSLATE, 0.1F, 100);
		baking(consumer, Blocks.STONE, Blocks.SMOOTH_STONE, 0.1F, 100);
		baking(consumer, Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE, 0.1F, 100);
		baking(consumer, Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE, 0.1F, 100);
		baking(consumer, Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ, 0.1F, 100);
		baking(consumer, Blocks.BASALT, Blocks.SMOOTH_BASALT, 0.1F, 100);
		baking(consumer, Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS, 0.1F, 100);
		baking(consumer, Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, 0.1F, 100);
		baking(consumer, Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS, 0.1F, 100);
		baking(consumer, Blocks.DEEPSLATE_BRICK_SLAB, Blocks.CRACKED_DEEPSLATE_BRICKS, 0.1F, 100);
		baking(consumer, Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES, 0.1F, 100);

		baking(consumer, Blocks.BLACK_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.BLUE_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.BROWN_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.CYAN_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.GRAY_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.GREEN_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.LIME_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.MAGENTA_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.ORANGE_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.PINK_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.PURPLE_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.RED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.WHITE_TERRACOTTA, Blocks.WHITE_GLAZED_TERRACOTTA, 0.1F, 100);
		baking(consumer, Blocks.YELLOW_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, 0.1F, 100);
	}

	public static void baking(Consumer<FinishedRecipe> consumer, ItemLike ingredient, ItemLike result, float experience, int cookingTime) {
		simpleCookingRecipe(consumer, "baking", ClayworksRecipeSerializers.BAKING.get(), cookingTime, ingredient, result, experience);
	}

	protected static void simpleCookingRecipe(Consumer<FinishedRecipe> consumer, String type, SimpleCookingSerializer<?> recipeSerializer, int cookingTime, ItemLike ingredient, ItemLike result, float experience) {
		SimpleCookingRecipeBuilder.cooking(Ingredient.of(ingredient), result, experience, cookingTime, recipeSerializer).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, new ResourceLocation(Clayworks.MOD_ID, getItemName(result) + "_from_" + type));
	}

	private static void terracottaBricksRecipes(Consumer<FinishedRecipe> consumer, Block terracotta, BlockFamily family, Block verticalSlab, @Nullable Item dye) {
		ShapedRecipeBuilder.shaped(family.getBaseBlock(), 4).define('#', terracotta).pattern("##").pattern("##").unlockedBy(getHasName(terracotta), has(terracotta)).save(consumer);
		generateRecipes(consumer, family);
		conditionalRecipe(consumer, VERTICAL_SLABS, verticalSlabBuilder(verticalSlab, Ingredient.of(family.getBaseBlock())).unlockedBy(getHasName(family.getBaseBlock()), has(family.getBaseBlock())));
		stonecutterResultFromBase(consumer, family.get(Variant.SLAB), family.getBaseBlock(), 2);
		stonecutterResultFromBase(consumer, family.get(Variant.STAIRS), family.getBaseBlock());
		stonecutterResultFromBase(consumer, family.get(Variant.WALL), family.getBaseBlock());
		stonecutterResultFromBase(consumer, family.get(Variant.CHISELED), family.getBaseBlock());
		conditionalStonecuttingRecipe(consumer, VERTICAL_SLABS, verticalSlab, family.getBaseBlock(), 2);
		stonecutterResultFromBase(consumer, family.getBaseBlock(), terracotta);
		stonecutterResultFromBase(consumer, family.get(Variant.SLAB), terracotta, 2);
		stonecutterResultFromBase(consumer, family.get(Variant.STAIRS), terracotta);
		stonecutterResultFromBase(consumer, family.get(Variant.WALL), terracotta);
		stonecutterResultFromBase(consumer, family.get(Variant.CHISELED), terracotta);
		conditionalStonecuttingRecipe(consumer, VERTICAL_SLABS, verticalSlab, terracotta, 2);
		if (dye != null) {
			ShapedRecipeBuilder.shaped(family.getBaseBlock(), 8).define('#', TERRACOTTA_BRICKS.get()).define('X', dye).pattern("###").pattern("#X#").pattern("###").group("stained_terracotta_bricks").unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA)).save(consumer, new ResourceLocation(Clayworks.MOD_ID, getConversionRecipeName(family.getBaseBlock(), dye)));
		}
	}

	protected static RecipeBuilder verticalSlabBuilder(ItemLike item, Ingredient ingredient) {
		return ShapedRecipeBuilder.shaped(item, 6).define('#', ingredient).pattern("#").pattern("#").pattern("#");
	}

	public static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike input) {
		stonecutterResultFromBase(consumer, output, input, 1);
	}

	public static void stonecutterResultFromBase(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike input, int count) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), output, count).unlockedBy(getHasName(input), has(input)).save(consumer, new ResourceLocation(Clayworks.MOD_ID, getConversionRecipeName(output, input) + "_stonecutting"));
	}

	public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, RecipeBuilder recipe) {
		conditionalRecipe(consumer, condition, recipe, RecipeBuilder.getDefaultRecipeId(recipe.getResult()));
	}

	public static void conditionalStonecuttingRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, ItemLike output, ItemLike input, int count) {
		conditionalRecipe(consumer, condition, SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), output, count).unlockedBy(getHasName(input), has(input)), new ResourceLocation(Clayworks.MOD_ID, getConversionRecipeName(output, input) + "_stonecutting"));
	}

	public static void conditionalRecipe(Consumer<FinishedRecipe> consumer, ICondition condition, RecipeBuilder recipe, ResourceLocation id) {
		ConditionalRecipe.builder().addCondition(condition).addRecipe(consumer1 -> recipe.save(consumer1, id)).generateAdvancement(new ResourceLocation(id.getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + id.getPath())).build(consumer, id);
	}
}
