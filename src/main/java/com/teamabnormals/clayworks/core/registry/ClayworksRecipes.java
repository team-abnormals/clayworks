package com.teamabnormals.clayworks.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.common.item.crafting.DecoratedPotColoring;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClayworksRecipes {

	public static class ClayworksRecipeSerializers {
		public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Clayworks.MOD_ID);

		public static final DeferredHolder<RecipeSerializer<?>, SimpleCookingSerializer<BakingRecipe>> BAKING_RECIPE = RECIPE_SERIALIZERS.register("baking", () -> new SimpleCookingSerializer<>(BakingRecipe::new, 100));
		public static final DeferredHolder<RecipeSerializer<?>, SimpleCraftingRecipeSerializer<DecoratedPotColoring>> DECORATED_POT_COLORING = RECIPE_SERIALIZERS.register("crafting_special_decoratedpotcoloring", () -> new SimpleCraftingRecipeSerializer<>(DecoratedPotColoring::new));
	}

	public static class ClayworksRecipeTypes {
		public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Clayworks.MOD_ID);

		public static final DeferredHolder<RecipeType<?>, RecipeType<BakingRecipe>> BAKING = RECIPE_TYPES.register("baking", () -> new RecipeType<>() {
			@Override
			public String toString() {
				return Clayworks.MOD_ID + ":baking";
			}
		});
	}

	public static ItemStack getResultItem(Recipe<?> recipe) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		if (level == null) {
			throw new NullPointerException("level must not be null.");
		}
		RegistryAccess registryAccess = level.registryAccess();
		return recipe.getResultItem(registryAccess);
	}

	@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClayworksRecipeCategories {
		public static final RecipeBookCategories KILN_SEARCH = RecipeBookCategories.valueOf("CLAYWORKS_KILN_SEARCH");
		public static final RecipeBookCategories KILN_BLOCKS = RecipeBookCategories.valueOf("CLAYWORKS_KILN_BLOCKS");
		public static final RecipeBookCategories KILN_MISC = RecipeBookCategories.valueOf("CLAYWORKS_KILN_MISC");

		@SubscribeEvent
		public static void registerCategories(RegisterRecipeBookCategoriesEvent event) {
			event.registerBookCategories(RecipeBookType.valueOf("CLAYWORKS_BAKING"), ImmutableList.of(KILN_SEARCH, KILN_BLOCKS, KILN_MISC));
			event.registerAggregateCategory(KILN_SEARCH, ImmutableList.of(KILN_BLOCKS, KILN_MISC));
			event.registerRecipeCategoryFinder(ClayworksRecipeTypes.BAKING.get(), recipe -> ClayworksRecipes.getResultItem(recipe.value()).getItem() instanceof BlockItem ? KILN_BLOCKS : KILN_MISC);
		}
	}
}
