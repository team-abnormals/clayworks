package com.teamabnormals.clayworks.core;

import com.teamabnormals.blueprint.client.screen.splash.SplashSerializers;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.clayworks.client.gui.screens.inventory.KilnScreen;
import com.teamabnormals.clayworks.client.gui.screens.inventory.PotteryScreen;
import com.teamabnormals.clayworks.client.splashes.WoodworksSplash;
import com.teamabnormals.clayworks.core.data.client.ClayworksBlockStateProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksLanguageProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksSplashProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksSpriteSourceProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksDataRemolderProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksDatapackBuiltinEntriesProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksBlockTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksItemTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksPaintingVariantTagsProvider;
import com.teamabnormals.clayworks.core.other.ClayworksCompat;
import com.teamabnormals.clayworks.core.registry.*;
import com.teamabnormals.clayworks.core.registry.ClayworksConditions.ClayworksLootConditions;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import com.teamabnormals.clayworks.core.registry.helper.ClayworksBlockSubRegistryHelper;
import com.teamabnormals.gallery.core.data.client.GalleryItemModelProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(Clayworks.MOD_ID)
public class Clayworks {
	public static final String MOD_ID = "clayworks";
	public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(Registries.BLOCK, new ClayworksBlockSubRegistryHelper(helper)));

	public Clayworks(IEventBus bus, ModContainer container) {
		REGISTRY_HELPER.register(bus);
		ClayworksConditions.CONDITION_SERIALIZERS.register(bus);
		ClayworksLootConditions.LOOT_ITEM_CONDITIONS.register(bus);
		ClayworksMenuTypes.MENU_TYPES.register(bus);
		ClayworksRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
		ClayworksRecipeTypes.RECIPE_TYPES.register(bus);
		ClayworksParticleTypes.PARTICLE_TYPES.register(bus);
		ClayworksDataComponents.DATA_COMPONENTS.register(bus);

		bus.addListener(ClayworksRegistries::registerRegistries);

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
		bus.addListener(this::dataSetup);

		if (FMLEnvironment.dist == Dist.CLIENT) {
			bus.addListener(this::registerScreens);
			ClayworksBlocks.setupTabEditors();
			SplashSerializers.register(location("woodworks"), WoodworksSplash.CODEC);
		}

		container.registerConfig(ModConfig.Type.COMMON, ClayworksConfig.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ClayworksCompat.registerCompat();
		});
	}

	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		boolean server = event.includeServer();
		ClayworksDatapackBuiltinEntriesProvider datapackEntries = new ClayworksDatapackBuiltinEntriesProvider(output, provider);
		generator.addProvider(server, datapackEntries);
		provider = datapackEntries.getRegistryProvider();

		ClayworksBlockTagsProvider blockTags = new ClayworksBlockTagsProvider(output, provider, helper);
		generator.addProvider(server, blockTags);
		generator.addProvider(server, new ClayworksItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
		generator.addProvider(server, new ClayworksLootTableProvider(output, provider));
		generator.addProvider(server, new ClayworksRecipeProvider(output, provider));
		generator.addProvider(server, new ClayworksPaintingVariantTagsProvider(output, provider, helper));
		generator.addProvider(server, new ClayworksDataRemolderProvider(output, provider));

		boolean client = event.includeClient();
		generator.addProvider(client, new ClayworksSplashProvider(output));
		generator.addProvider(client, new ClayworksBlockStateProvider(output, helper));
		generator.addProvider(client, new ClayworksLanguageProvider(output));
		generator.addProvider(client, new ClayworksSpriteSourceProvider(output, provider, helper));

		generator.addProvider(client, new GalleryItemModelProvider(MOD_ID, output, helper, provider));
	}

	private void registerScreens(RegisterMenuScreensEvent event) {
		event.register(ClayworksMenuTypes.KILN.get(), KilnScreen::new);
		event.register(ClayworksMenuTypes.POTTERY.get(), PotteryScreen::new);
	}

	public static ResourceLocation location(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}