package com.teamabnormals.clayworks.common.item.crafting;

import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class BakingRecipe extends AbstractCookingRecipe {

	public BakingRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
		super(ClayworksRecipeTypes.BAKING.get(), group, category, ingredient, result, experience, cookingTime);
	}

	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(ClayworksBlocks.KILN.get());
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ClayworksRecipeSerializers.BAKING_RECIPE.get();
	}
}