package com.teamabnormals.clayworks.common.item.crafting;

import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksDataComponents;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.neoforged.neoforge.common.Tags;

import java.util.Optional;

public class DecoratedPotColoring extends CustomRecipe {

	public DecoratedPotColoring(CraftingBookCategory category) {
		super(category);
	}

	@Override
	public boolean matches(CraftingInput input, Level level) {
		int ptCount = 0;
		int dyeCount = 0;
		int trimCount = 0;

		ItemStack pot = ItemStack.EMPTY;
		for (int slot = 0; slot < input.size(); ++slot) {
			ItemStack stack = input.getItem(slot);
			if (!stack.isEmpty()) {
				if (Block.byItem(stack.getItem()) instanceof DecoratedPotBlock) {
					pot = stack.copy();
					++ptCount;
				}
			}
		}

		if (ptCount != 1 || pot.isEmpty()) {
			return false;
		}

		for (int slot = 0; slot < input.size(); ++slot) {
			ItemStack stack = input.getItem(slot);
			if (!stack.isEmpty()) {
				if (stack.is(Tags.Items.DYES) && ClayworksConfig.COMMON.decoratedPotColors.get()) {
					++dyeCount;
					if (DyeColor.getColor(stack) == ClayworksBlocks.getDyeColorFromPot(Block.byItem(pot.getItem()))) {
						return false;
					}
				} else if (stack.is(ItemTags.TRIM_MATERIALS) && ClayworksConfig.COMMON.decoratedPotTrims.get()) {
					++trimCount;
					if (pot.getComponents().get(ClayworksDataComponents.POT_TRIM.get()) != null) {
						return false;
					}
				} else if (!(Block.byItem(stack.getItem()) instanceof DecoratedPotBlock)) {
					return false;
				}

				if (dyeCount > 1 || trimCount > 1) {
					return false;
				}
			}
		}

		return dyeCount == 1 || trimCount == 1;
	}

	@Override
	public ItemStack assemble(CraftingInput input, Provider provider) {
		ItemStack output = ItemStack.EMPTY;
		DyeColor color = DyeColor.WHITE;

		for (int slot = 0; slot < input.size(); ++slot) {
			ItemStack stack = input.getItem(slot);
			if (!stack.isEmpty()) {
				Item item = stack.getItem();
				if (Block.byItem(item) instanceof DecoratedPotBlock block) {
					output = stack.copyWithCount(1);
					color = ClayworksBlocks.getDyeColorFromPot(block);
					break;
				}
			}
		}

		for (int slot = 0; slot < input.size(); ++slot) {
			ItemStack stack = input.getItem(slot);
			if (!stack.isEmpty()) {
				if (stack.is(Tags.Items.DYES)) {
					DyeColor tmp = DyeColor.getColor(stack);
					if (tmp != null) {
						color = tmp;
					}
				} else if (stack.is(ItemTags.TRIM_MATERIALS)) {
					Optional<Reference<TrimMaterial>> material = TrimMaterials.getFromIngredient(provider, stack);
					Optional<Reference<DecoratedPotTrimPattern>> pattern = provider.lookupOrThrow(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN).get(DecoratedPotTrimPattern.BASE);
					if (material.isPresent() && pattern.isPresent()) {
						output.set(ClayworksDataComponents.POT_TRIM.get(), new DecoratedPotTrim(material.get(), pattern.get(), true));
					}
				}
			}
		}

		return output.transmuteCopy(ClayworksBlocks.getPotFromDyeColor(color));
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