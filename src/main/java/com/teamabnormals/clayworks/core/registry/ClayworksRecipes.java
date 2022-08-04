package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ClayworksRecipes {

	public static class ClayworksRecipeSerializers {
		public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Clayworks.MOD_ID);

		public static final RegistryObject<RecipeSerializer<BakingRecipe>> BAKING = RECIPE_SERIALIZERS.register("baking", BakingRecipe.Serializer::new);
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
}
