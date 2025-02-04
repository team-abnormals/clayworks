package com.teamabnormals.clayworks.core;

import com.teamabnormals.blueprint.client.screen.splash.SplashSerializers;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.clayworks.client.splashes.WoodworksSplash;
import com.teamabnormals.clayworks.core.data.client.ClayworksBlockStateProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksLanguageProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksSplashProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksSpriteSourceProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider;
import com.teamabnormals.clayworks.core.data.server.modifiers.ClayworksLootModifierProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksBlockTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksItemTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksPaintingVariantTagsProvider;
import com.teamabnormals.clayworks.core.other.ClayworksCompat;
import com.teamabnormals.clayworks.core.registry.*;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import com.teamabnormals.clayworks.core.registry.helper.ClayworksBlockSubRegistryHelper;
import com.teamabnormals.clayworks.integration.gallery.ClayworksPaintingIcons;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;

@Mod(Clayworks.MOD_ID)
public class Clayworks {
	public static final String MOD_ID = "clayworks";
	public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(ForgeRegistries.BLOCKS, new ClayworksBlockSubRegistryHelper(helper)));

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
		ClayworksPaintingVariants.PAINTING_VARIANTS.register(bus);

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
		bus.addListener(this::dataSetup);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			ClayworksBlocks.setupTabEditors();
			SplashSerializers.register(new ResourceLocation(MOD_ID, "woodworks"), WoodworksSplash.CODEC);
		});

		context.registerConfig(ModConfig.Type.COMMON, ClayworksConfig.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ClayworksCompat.registerCompat();
		});
	}

	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ClayworksMenuTypes.registerScreenFactories();
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		boolean server = event.includeServer();
		ClayworksBlockTagsProvider blockTags = new ClayworksBlockTagsProvider(output, provider, helper);
		generator.addProvider(server, blockTags);
		generator.addProvider(server, new ClayworksItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
		generator.addProvider(server, new ClayworksLootTableProvider(output));
		generator.addProvider(server, new ClayworksRecipeProvider(output));
		generator.addProvider(server, new ClayworksPaintingVariantTagsProvider(output, provider, helper));
		generator.addProvider(server, new ClayworksLootModifierProvider(output, provider));

		boolean client = event.includeClient();
		generator.addProvider(client, new ClayworksSplashProvider(output));
		generator.addProvider(client, new ClayworksBlockStateProvider(output, helper));
		generator.addProvider(client, new ClayworksLanguageProvider(output));
		generator.addProvider(client, new ClayworksSpriteSourceProvider(output, helper));

		ClayworksPaintingIcons.addGalleryProviders(event);
	}
}