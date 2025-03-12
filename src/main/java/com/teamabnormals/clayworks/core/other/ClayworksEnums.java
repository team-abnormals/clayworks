package com.teamabnormals.clayworks.core.other;

import com.google.common.base.Supplier;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.List;

public class ClayworksEnums {
	public static final EnumProxy<RecipeBookCategories> KILN_SEARCH = new EnumProxy<>(RecipeBookCategories.class, (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.COMPASS)));
	public static final EnumProxy<RecipeBookCategories> KILN_BLOCKS = new EnumProxy<>(RecipeBookCategories.class, (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.TERRACOTTA)));
	public static final EnumProxy<RecipeBookCategories> KILN_MISC = new EnumProxy<>(RecipeBookCategories.class, (Supplier<List<ItemStack>>) () -> List.of(new ItemStack(Items.BRICK)));
}