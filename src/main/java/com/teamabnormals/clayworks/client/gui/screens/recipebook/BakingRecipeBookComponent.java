package com.teamabnormals.clayworks.client.gui.screens.recipebook;

import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

import java.util.Set;

public class BakingRecipeBookComponent extends AbstractFurnaceRecipeBookComponent {
	public static final String FILTER_NAME = "gui.clayworks.recipebook.toggleRecipes.bakeable";
	public static final Component FILTER_COMPONENT = Component.translatable(FILTER_NAME);

	@Override
	protected Component getRecipeFilterName() {
		return FILTER_COMPONENT;
	}

	@Override
	protected Set<Item> getFuelItems() {
		return AbstractFurnaceBlockEntity.getFuel().keySet();
	}
}