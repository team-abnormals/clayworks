package com.teamabnormals.clayworks.core.data.server;

import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.common.remolder.data.RemolderProvider;
import com.teamabnormals.blueprint.common.remolder.util.LootRemolders;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider.ClayworksBlockLoot;
import com.teamabnormals.clayworks.core.registry.ClayworksConditions;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.PackOutput.Target;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.concurrent.CompletableFuture;

public class ClayworksDataRemolderProvider extends RemolderProvider {

	public ClayworksDataRemolderProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(Clayworks.MOD_ID, Target.DATA_PACK, output, provider);
	}

	@Override
	protected void registerEntries(Provider provider) {
		this.entry("decorated_pot")
				.path(new ConditionedResourceSelector(new NamesResourceSelector("minecraft:loot_table/blocks/decorated_pot"), config(ClayworksConfig.COMMON.decoratedPotTrims, "decorated_pot_trims", false)))
				.remolder(LootRemolders.replacePools(
						ClayworksBlockLoot.createDynamicTrimDropPool(Blocks.DECORATED_POT).name("decorated_pot_trim").build(),
						ClayworksBlockLoot.createDecoratedPotPool(Blocks.DECORATED_POT).name("decorated_pot").build()

				));
	}

	public static ConfigValueCondition config(ModConfigSpec.ConfigValue<?> value, String key, boolean inverted) {
		return new ConfigValueCondition(ClayworksConditions.CONFIG.get(), value, key, Maps.newHashMap(), inverted);
	}
}