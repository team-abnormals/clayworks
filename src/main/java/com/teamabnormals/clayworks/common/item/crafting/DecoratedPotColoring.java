package com.teamabnormals.clayworks.common.item.crafting;

import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;

public class DecoratedPotColoring extends CustomRecipe {

	public DecoratedPotColoring(ResourceLocation recipe, CraftingBookCategory category) {
		super(recipe, category);
	}

	@Override
	public boolean matches(CraftingContainer container, Level level) {
		int i = 0;
		int j = 0;

		for (int k = 0; k < container.getContainerSize(); ++k) {
			ItemStack stack = container.getItem(k);
			if (!stack.isEmpty()) {
				if (Block.byItem(stack.getItem()) instanceof DecoratedPotBlock) {
					++i;
				} else {
					if (!(stack.getItem() instanceof DyeItem)) {
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
	public ItemStack assemble(CraftingContainer container, RegistryAccess access) {
		ItemStack stack = ItemStack.EMPTY;
		DyeColor color = DyeColor.WHITE;

		for (int i = 0; i < container.getContainerSize(); ++i) {
			ItemStack itemstack1 = container.getItem(i);
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

		ItemStack itemstack2 = new ItemStack(ClayworksBlocks.getPotFromDyeColor(color));
		if (stack.hasTag()) {
			itemstack2.setTag(stack.getTag().copy());
		}

		return itemstack2;
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