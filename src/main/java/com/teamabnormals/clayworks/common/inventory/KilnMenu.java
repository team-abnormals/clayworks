package com.teamabnormals.clayworks.common.inventory;

import com.teamabnormals.clayworks.core.registry.ClayworksMenuTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;

public class KilnMenu extends AbstractFurnaceMenu {

	//TODO: Kiln RecipeBookType
	public KilnMenu(int windowId, Inventory playerInventory) {
		super(ClayworksMenuTypes.KILN.get(), ClayworksRecipeTypes.BAKING.get(), RecipeBookType.SMOKER, windowId, playerInventory);
	}

	public KilnMenu(int windowId, Inventory playerInventory, Container kilnInventory, ContainerData furnaceData) {
		super(ClayworksMenuTypes.KILN.get(), ClayworksRecipeTypes.BAKING.get(), RecipeBookType.SMOKER, windowId, playerInventory, kilnInventory, furnaceData);
	}
}