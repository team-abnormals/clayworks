package com.teamabnormals.clayworks.core.registry;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterRecipeBookCategoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ClayworksRecipes {

	public static class ClayworksRecipeSerializers {
		public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Clayworks.MOD_ID);

		public static final RegistryObject<SimpleCookingSerializer<BakingRecipe>> BAKING = RECIPE_SERIALIZERS.register("baking", () -> new SimpleCookingSerializer<>(BakingRecipe::new, 100));
	}

	public static class ClayworksRecipeTypes {
		public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE_REGISTRY, Clayworks.MOD_ID);

		public static final RegistryObject<RecipeType<BakingRecipe>> BAKING = RECIPE_TYPES.register("baking", () -> new RecipeType<>() {
			@Override
			public String toString() {
				return Clayworks.MOD_ID + ":baking";
			}
		});
	}

	@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClayworksRecipeCategories {
		public static final Supplier<RecipeBookCategories> KILN_SEARCH = Suppliers.memoize(() -> RecipeBookCategories.create("KILN_SEARCH", new ItemStack(Items.COMPASS)));
		public static final Supplier<RecipeBookCategories> KILN_BLOCKS = Suppliers.memoize(() -> RecipeBookCategories.create("KILN_BLOCKS", new ItemStack(Blocks.BRICKS)));
		public static final Supplier<RecipeBookCategories> KILN_MISC = Suppliers.memoize(() -> RecipeBookCategories.create("KILN_MISC", new ItemStack(Items.BRICK)));

		@SubscribeEvent
		public static void registerCategories(RegisterRecipeBookCategoriesEvent event) {
			event.registerBookCategories(Clayworks.RECIPE_TYPE_BAKING, ImmutableList.of(KILN_SEARCH.get(), KILN_BLOCKS.get(), KILN_MISC.get()));
			event.registerAggregateCategory(KILN_SEARCH.get(), ImmutableList.of(KILN_BLOCKS.get(), KILN_MISC.get()));
			event.registerRecipeCategoryFinder(ClayworksRecipeTypes.BAKING.get(), recipe -> recipe.getResultItem().getItem() instanceof BlockItem ? KILN_BLOCKS.get() : KILN_MISC.get());
		}
	}
}
