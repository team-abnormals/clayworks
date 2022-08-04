package com.teamabnormals.clayworks.client.gui.screens.inventory;

import com.teamabnormals.clayworks.common.inventory.KilnMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.SmokingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class KilnScreen extends AbstractFurnaceScreen<KilnMenu> {
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Clayworks.MOD_ID, "textures/gui/container/kiln.png");

	public KilnScreen(KilnMenu screenContainer, Inventory inv, Component titleIn) {
		//TODO BakingRecipeBookComponent
		super(screenContainer, new SmokingRecipeBookComponent(), inv, titleIn, GUI_TEXTURE);
	}
}
