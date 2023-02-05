package com.teamabnormals.clayworks.integration.jei;

import com.teamabnormals.clayworks.client.gui.screens.inventory.KilnScreen;
import com.teamabnormals.clayworks.common.inventory.KilnMenu;
import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksMenuTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class ClayworksPlugin implements IModPlugin {
	public static final RecipeType<BakingRecipe> BAKING = RecipeType.create(Clayworks.MOD_ID, "baking", BakingRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(Clayworks.MOD_ID, Clayworks.MOD_ID);
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new BakingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(BAKING, Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ClayworksRecipeTypes.BAKING.get()));
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
		registration.addRecipeClickArea(KilnScreen.class, 78, 32, 28, 23, BAKING, RecipeTypes.FUELING);
	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
		registration.addRecipeTransferHandler(KilnMenu.class, ClayworksMenuTypes.KILN.get(), BAKING, 0, 1, 3, 36);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(ClayworksBlocks.KILN.get()), BAKING, RecipeTypes.FUELING);
	}
}