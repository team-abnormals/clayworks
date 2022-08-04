package com.teamabnormals.clayworks.core.data.server;

import com.teamabnormals.blueprint.core.Blueprint;
import com.teamabnormals.blueprint.core.api.conditions.QuarkFlagRecipeCondition;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.other.ClayworksBlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

	private static void terracottaBricksRecipes(Consumer<FinishedRecipe> consumer, Block terracotta, BlockFamily family, Block verticalSlab, @Nullable Item dye) {
		ShapedRecipeBuilder.shaped(family.getBaseBlock(), 4).define('#', terracotta).pattern("##").pattern("##").unlockedBy(getHasName(terracotta), has(terracotta)).save(consumer);
		generateRecipes(consumer, family);
		conditionalRecipe(consumer, VERTICAL_SLABS, slabBuilder(verticalSlab, Ingredient.of(family.getBaseBlock())).unlockedBy(getHasName(family.getBaseBlock()), has(family.getBaseBlock())));
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
