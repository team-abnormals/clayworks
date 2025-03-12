package com.teamabnormals.clayworks.client.gui.screens.inventory;

import com.teamabnormals.clayworks.client.gui.screens.recipebook.BakingRecipeBookComponent;
import com.teamabnormals.clayworks.common.inventory.KilnMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class KilnScreen extends AbstractFurnaceScreen<KilnMenu> {
	private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/blast_furnace/lit_progress");
	private static final ResourceLocation BURN_PROGRESS_SPRITE = ResourceLocation.withDefaultNamespace("container/blast_furnace/burn_progress");
	private static final ResourceLocation TEXTURE = Clayworks.location("textures/gui/container/kiln.png");

	public KilnScreen(KilnMenu screenContainer, Inventory inv, Component titleIn) {
		super(screenContainer, new BakingRecipeBookComponent(), inv, titleIn, TEXTURE, LIT_PROGRESS_SPRITE, BURN_PROGRESS_SPRITE);
	}
}
