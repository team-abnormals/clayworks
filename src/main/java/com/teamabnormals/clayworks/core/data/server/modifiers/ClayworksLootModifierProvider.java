package com.teamabnormals.clayworks.core.data.server.modifiers;

import com.google.common.collect.Maps;
import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolsModifier;
import com.teamabnormals.blueprint.core.api.conditions.ConfigValueCondition;
import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider.ClayworksBlockLoot;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ClayworksLootModifierProvider extends LootModifierProvider {

	public ClayworksLootModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(Clayworks.MOD_ID, output, provider);
	}

	@Override
	protected void registerEntries(Provider provider) {
		this.entry("decorated_pot").selector(new ConditionedResourceSelector(new NamesResourceSelector("blocks/decorated_pot"), new ConfigValueCondition(new ResourceLocation(Clayworks.MOD_ID, "config"), ClayworksConfig.COMMON.decoratedPotTrims, "decorated_pot_trims", Maps.newHashMap(), false)))
				.addModifier(new LootPoolsModifier(List.of(ClayworksBlockLoot.createDynamicTrimDropPool().name("decorated_pot_trim").build(), ClayworksBlockLoot.createDecoratedPotPool(Blocks.DECORATED_POT).name("decorated_pot").build()), true));
	}
}