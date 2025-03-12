package com.teamabnormals.clayworks.common.item.crafting;

import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.neoforged.neoforge.common.Tags;

public class DecoratedPotColoring extends CustomRecipe {

	public DecoratedPotColoring(CraftingBookCategory category) {
		super(category);
	}

	@Override
	public boolean matches(CraftingInput input, Level level) {
		int i = 0;
		int j = 0;

		for (int k = 0; k < input.size(); ++k) {
			ItemStack stack = input.getItem(k);
			if (!stack.isEmpty()) {
				if (Block.byItem(stack.getItem()) instanceof DecoratedPotBlock) {
					++i;
				} else {
					if (!stack.is(Tags.Items.DYES)) {
						return false;
					}

					++j;
				}

				if (j > 1 || i > 1) {
					return false;
				}
			}
		}

		return i == 1 && j == 1;
	}

	@Override
	public ItemStack assemble(CraftingInput input, Provider provider) {
		ItemStack stack = ItemStack.EMPTY;
		DyeColor color = DyeColor.WHITE;

		for (int i = 0; i < input.size(); ++i) {
			ItemStack itemstack1 = input.getItem(i);
			if (!itemstack1.isEmpty()) {
				Item item = itemstack1.getItem();
				if (Block.byItem(item) instanceof DecoratedPotBlock) {
					stack = itemstack1;
				} else {
					DyeColor tmp = DyeColor.getColor(itemstack1);
					if (tmp != null) color = tmp;
				}
			}
		}

		return stack.transmuteCopy(ClayworksBlocks.getPotFromDyeColor(color));
	}

	@Override
	public boolean canCraftInDimensions(int x, int y) {
		return x * y >= 2;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return ClayworksRecipeSerializers.DECORATED_POT_COLORING.get();
	}
}