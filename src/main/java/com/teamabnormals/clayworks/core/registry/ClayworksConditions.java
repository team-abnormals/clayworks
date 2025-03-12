package com.teamabnormals.clayworks.core.registry;

import com.mojang.serialization.MapCodec;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition.Serializer;
import com.teamabnormals.blueprint.core.api.conditions.loot.ConfigLootCondition.ConfigSerializer;
import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ClayworksConditions {
	public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.CONDITION_SERIALIZERS, Clayworks.MOD_ID);

	public static final DeferredHolder<MapCodec<? extends ICondition>, Serializer> CONFIG = CONDITION_SERIALIZERS.register("config", () -> new Serializer(DataUtil.getConfigValues(ClayworksConfig.COMMON)));

	public static final class ClayworksLootConditions {
		public static final DeferredRegister<LootItemConditionType> LOOT_ITEM_CONDITIONS = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, Clayworks.MOD_ID);

		public static final DeferredHolder<LootItemConditionType, LootItemConditionType> CONFIG = LOOT_ITEM_CONDITIONS.register("config", () -> ConfigSerializer.asType(DataUtil.getConfigValues(ClayworksConfig.COMMON)));
	}
}