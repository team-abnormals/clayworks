package com.teamabnormals.clayworks.core;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.clayworks.core.data.client.ClayworksBlockStateProvider;
import com.teamabnormals.clayworks.core.data.client.ClayworksLanguageProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider;
import com.teamabnormals.clayworks.core.data.server.ClayworksRecipeProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksBlockTagsProvider;
import com.teamabnormals.clayworks.core.data.server.tags.ClayworksItemTagsProvider;
import com.teamabnormals.clayworks.core.registry.ClayworksMenuTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksParticleTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeCategories;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeSerializers;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes.ClayworksRecipeTypes;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

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
		ClayworksMenuTypes.MENU_TYPES.register(bus);
		ClayworksRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
		ClayworksRecipeTypes.RECIPE_TYPES.register(bus);
		ClayworksParticleTypes.PARTICLE_TYPES.register(bus);

//		StructureRepalleterManager.registerSerializer(new ResourceLocation(MOD_ID, "opposite_facing"), OppositeFacingStructureRepaletter.CODEC);

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
		bus.addListener(this::dataSetup);

		bus.addGenericListener(Block.class, this::registerConfigConditions);

		context.registerConfig(ModConfig.Type.COMMON, ClayworksConfig.COMMON_SPEC);
	}

	private void registerConfigConditions(RegistryEvent.Register<Block> event) {
		DataUtil.registerConfigCondition(MOD_ID, ClayworksConfig.COMMON);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
//			ObfuscationReflectionHelper.setPrivateValue(PoiType.class, PoiType.MASON, ImmutableSet.copyOf(PoiType.getBlockStates(ClayworksBlocks.KILN.get())), "f_27325_");
//			ObfuscationReflectionHelper.setPrivateValue(VillagerProfession.class, VillagerProfession.MASON, ClayworksSoundEvents.VILLAGER_WORK_MASON.get(), "f_35604_");
		});
	}

	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ClayworksMenuTypes.registerScreenFactories();
			ClayworksRecipeCategories.registerCategories();
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			ClayworksBlockTagsProvider blockTags = new ClayworksBlockTagsProvider(generator, fileHelper);
			generator.addProvider(blockTags);
			generator.addProvider(new ClayworksItemTagsProvider(generator, blockTags, fileHelper));
			generator.addProvider(new ClayworksLootTableProvider(generator));
			generator.addProvider(new ClayworksRecipeProvider(generator));
//			generator.addProvider(new ClayworksStructureRepaletterProvider(generator));
		}

		if (event.includeClient()) {
			generator.addProvider(new ClayworksBlockStateProvider(generator, fileHelper));
			generator.addProvider(new ClayworksLanguageProvider(generator));
		}
	}
}