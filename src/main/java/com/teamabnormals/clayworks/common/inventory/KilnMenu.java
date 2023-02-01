package com.teamabnormals.clayworks.common.inventory;

import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksMenuTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;

public class KilnMenu extends AbstractFurnaceMenu {

	public KilnMenu(int windowId, Inventory playerInventory) {
		super(ClayworksMenuTypes.KILN.get(), ClayworksRecipeTypes.BAKING.get(), Clayworks.RECIPE_TYPE_BAKING, windowId, playerInventory);
	}

	public KilnMenu(int windowId, Inventory playerInventory, Container kilnInventory, ContainerData furnaceData) {
		super(ClayworksMenuTypes.KILN.get(), ClayworksRecipeTypes.BAKING.get(), Clayworks.RECIPE_TYPE_BAKING, windowId, playerInventory, kilnInventory, furnaceData);
	}
}