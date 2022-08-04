package com.teamabnormals.clayworks.common.item.crafting;

import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;

public class BakingRecipe extends AbstractCookingRecipe {

	public BakingRecipe(ResourceLocation p_i50022_1_, String p_i50022_2_, Ingredient ingredient, ItemStack stack, float p_i50022_5_, int p_i50022_6_) {
		super(ClayworksRecipeTypes.BAKING.get(), p_i50022_1_, p_i50022_2_, ingredient, stack, p_i50022_5_, p_i50022_6_);
	}

	public ItemStack getToastSymbol() {
		return new ItemStack(ClayworksBlocks.KILN.get());
	}

	public RecipeSerializer<?> getSerializer() {
		return ClayworksRecipeSerializers.BAKING.get();
	}

	public static class Serializer extends SimpleCookingSerializer<BakingRecipe> {

		public Serializer() {
			super(BakingRecipe::new, 100);
		}
	}
}