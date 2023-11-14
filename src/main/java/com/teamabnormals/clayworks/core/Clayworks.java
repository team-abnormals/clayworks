package com.teamabnormals.clayworks.core;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.clayworks.core.data.client.ClayworksBlockStateProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksLanguageProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider;
import com.teamabnormals.clayworks.core.data.server.modifiers.ClayworksLootModifierProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksBlockTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksItemTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksPaintingVariantTagsProvider;
import com.teamabnormals.clayworks.core.registry.*;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import com.teamabnormals.clayworks.core.registry.helper.ClayworksBlockSubRegistryHelper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
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
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
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
		});

		context.registerConfig(ModConfig.Type.COMMON, ClayworksConfig.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		HashSet<Block> blocks = Sets.newHashSet();
		blocks.addAll(BlockEntityType.DECORATED_POT.validBlocks);
		blocks.addAll(ClayworksBlocks.HELPER.getDeferredRegister().getEntries().stream().filter(registryObject -> registryObject.get() instanceof DecoratedPotBlock).map(RegistryObject::get).toList());
		BlockEntityType.DECORATED_POT.validBlocks = ImmutableSet.copyOf(blocks);
	}

	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ClayworksMenuTypes.registerScreenFactories();
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		boolean includeServer = event.includeServer();
		ClayworksBlockTagsProvider blockTags = new ClayworksBlockTagsProvider(output, lookupProvider, helper);
		generator.addProvider(includeServer, blockTags);
		generator.addProvider(includeServer, new ClayworksItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), helper));
		generator.addProvider(includeServer, new ClayworksLootTableProvider(output));
		generator.addProvider(includeServer, new ClayworksRecipeProvider(output));
		generator.addProvider(includeServer, new ClayworksPaintingVariantTagsProvider(output, lookupProvider, helper));
		generator.addProvider(includeServer, new ClayworksLootModifierProvider(output, lookupProvider));

		boolean includeClient = event.includeServer();
		generator.addProvider(includeClient, new ClayworksBlockStateProvider(output, helper));
		generator.addProvider(includeClient, new ClayworksLanguageProvider(output));
	}
}