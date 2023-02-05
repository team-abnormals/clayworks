package com.teamabnormals.clayworks.core;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.clayworks.core.data.client.ClayworksBlockStateProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksLanguageProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksBlockTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksItemTagsProvider;
import com.teamabnormals.clayworks.core.registry.ClayworksLootConditions;
import com.teamabnormals.clayworks.core.registry.ClayworksMenuTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksParticleTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Clayworks.MOD_ID)
public class Clayworks {
	public static final String MOD_ID = "clayworks";
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

	public static final RecipeBookType RECIPE_TYPE_BAKING = RecipeBookType.create("BAKING");

	public Clayworks() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext context = ModLoadingContext.get();
		MinecraftForge.EVENT_BUS.register(this);

		REGISTRY_HELPER.register(bus);
		ClayworksLootConditions.LOOT_CONDITION_TYPES.register(bus);
		ClayworksMenuTypes.MENU_TYPES.register(bus);
		ClayworksRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
		ClayworksRecipeTypes.RECIPE_TYPES.register(bus);
		ClayworksParticleTypes.PARTICLE_TYPES.register(bus);

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
		bus.addListener(this::dataSetup);

		context.registerConfig(ModConfig.Type.COMMON, ClayworksConfig.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
	}

	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ClayworksMenuTypes.registerScreenFactories();
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		boolean includeServer = event.includeServer();
		ClayworksBlockTagsProvider blockTags = new ClayworksBlockTagsProvider(generator, fileHelper);
		generator.addProvider(includeServer, blockTags);
		generator.addProvider(includeServer, new ClayworksItemTagsProvider(generator, blockTags, fileHelper));
		generator.addProvider(includeServer, new ClayworksLootTableProvider(generator));
		generator.addProvider(includeServer, new ClayworksRecipeProvider(generator));

		boolean includeClient = event.includeServer();
		generator.addProvider(includeClient, new ClayworksBlockStateProvider(generator, fileHelper));
		generator.addProvider(includeClient, new ClayworksLanguageProvider(generator));
	}
}