package com.teamabnormals.clayworks.core.registry;

import com.google.common.collect.ImmutableSet;
import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.data.worldgen.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ClayworksVillagerProfessions {
	public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Clayworks.MOD_ID);
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Clayworks.MOD_ID);

	public static final RegistryObject<PoiType> KILN = POI_TYPES.register("kiln", () -> new PoiType("ceramist", PoiType.getBlockStates(ClayworksBlocks.KILN.get()), 1, 1));

	public static final RegistryObject<VillagerProfession> CERAMIST = PROFESSIONS.register("ceramist", () -> new VillagerProfession("Clayworks:ceramist", KILN.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));

	public static void setupVillagerHouses() {
		PlainVillagePools.bootstrap();
		SnowyVillagePools.bootstrap();
		SavannaVillagePools.bootstrap();
		DesertVillagePools.bootstrap();
		TaigaVillagePools.bootstrap();

		addVillagerHouse("ceramist", "plains", 2);
		addVillagerHouse("ceramist", "snowy", 4);
		addVillagerHouse("ceramist", "savanna", 6);
		addVillagerHouse("ceramist", "desert", 5);
		addVillagerHouse("ceramist", "taiga", 7);
	}

	private static void addVillagerHouse(String type, String biome, int weight) {
		DataUtil.addToJigsawPattern(new ResourceLocation("village/" + biome + "/houses"), StructurePoolElement.single(Clayworks.MOD_ID + ":village/" + type + "_house_" + biome + "_1").apply(StructureTemplatePool.Projection.RIGID), weight);
	}
}