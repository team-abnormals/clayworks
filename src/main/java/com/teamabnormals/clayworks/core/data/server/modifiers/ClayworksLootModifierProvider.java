package com.teamabnormals.clayworks.core.data.server.modifiers;

import com.teamabnormals.blueprint.common.loot.modification.LootModifierProvider;
import com.teamabnormals.blueprint.common.loot.modification.modifiers.LootPoolsModifier;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider.ClayworksBlockLoot;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ClayworksLootModifierProvider extends LootModifierProvider {

	public ClayworksLootModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(Clayworks.MOD_ID, output, provider);
	}

	@Override
	protected void registerEntries(Provider provider) {
		this.entry("decorated_pot").selects("blocks/decorated_pot").addModifier(new LootPoolsModifier(List.of(ClayworksBlockLoot.createDynamicTrimDropPool().name("decorated_pot_trim").build(), ClayworksBlockLoot.createDecoratedPotPool(Blocks.DECORATED_POT).name("decorated_pot").build()), true));
	}
}