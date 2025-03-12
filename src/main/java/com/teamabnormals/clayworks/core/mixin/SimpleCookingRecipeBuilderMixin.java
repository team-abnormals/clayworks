package com.teamabnormals.clayworks.core.mixin;

import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleCookingRecipeBuilder.class)
public abstract class SimpleCookingRecipeBuilderMixin {

	@Shadow
	private static CookingBookCategory determineSmeltingRecipeCategory(ItemLike result) {
		return null;
	}

	@Inject(method = "determineRecipeCategory", at = @At("HEAD"), cancellable = true)
	private static void determineRecipeCategory(RecipeSerializer<? extends AbstractCookingRecipe> serializer, ItemLike result, CallbackInfoReturnable<CookingBookCategory> cir) {
		if (serializer == ClayworksRecipeSerializers.BAKING_RECIPE.get()) {
			cir.setReturnValue(determineSmeltingRecipeCategory(result));
			cir.cancel();
		}
	}
}
