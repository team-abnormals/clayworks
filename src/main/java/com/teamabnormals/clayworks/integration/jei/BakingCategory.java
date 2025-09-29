package com.teamabnormals.clayworks.integration.jei;

import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.library.plugins.vanilla.cooking.AbstractCookingCategory;

public class BakingCategory extends AbstractCookingCategory<BakingRecipe> {
	public static final String TRANSLATION = "gui." + Clayworks.MOD_ID + ".category.baking";

	public BakingCategory(IGuiHelper guiHelper) {
		super(guiHelper, ClayworksPlugin.BAKING, ClayworksBlocks.KILN.get(), TRANSLATION, 100);
	}
}