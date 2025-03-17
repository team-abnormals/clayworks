package com.teamabnormals.clayworks.common.block.entity;

import com.teamabnormals.clayworks.common.inventory.KilnMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlockEntityTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
	public static final Component CONTAINER_TITLE = Component.translatable("container." + Clayworks.MOD_ID + ".kiln");

	public KilnBlockEntity(BlockPos pos, BlockState state) {
		super(ClayworksBlockEntityTypes.KILN.get(), pos, state, ClayworksRecipeTypes.BAKING.get());
	}

	protected Component getDefaultName() {
		return CONTAINER_TITLE;
	}

	protected int getBurnDuration(ItemStack fuel) {
		return super.getBurnDuration(fuel) / 2;
	}

	protected AbstractContainerMenu createMenu(int id, Inventory player) {
		return new KilnMenu(id, player, this, this.dataAccess);
	}
}