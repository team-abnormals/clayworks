package com.teamabnormals.clayworks.core.data.server;

import com.google.common.collect.ImmutableList;
import com.teamabnormals.blueprint.common.block.quark.VerticalSlabBlock;
import com.teamabnormals.blueprint.common.block.quark.VerticalSlabBlock.VerticalSlabType;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClayworksLootTableProvider extends LootTableProvider {

	public ClayworksLootTableProvider(PackOutput output) {
		super(output, BuiltInLootTables.all(), ImmutableList.of(new LootTableProvider.SubProviderEntry(ClayworksBlockLoot::new, LootContextParamSets.BLOCK)));
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
	}

	private static class ClayworksBlockLoot extends BlockLootSubProvider {
		private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.AIR).map(ItemLike::asItem).collect(Collectors.toSet());

		protected ClayworksBlockLoot() {
			super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
		}

		@Override
		public void generate() {
			ClayworksBlocks.HELPER.getDeferredRegister().getEntries().forEach((registryObject -> {
				Block block = registryObject.get();
				if (block instanceof KilnBlock) {
					this.add(block, this::createNameableBlockEntityTable);
				} else if (block instanceof SlabBlock) {
					this.add(block, this::createSlabItemTable);
				} else if (block instanceof VerticalSlabBlock) {
					this.add(block, this::createVerticalSlabItemTable);
				} else {
					this.dropSelf(block);
				}
			}));
		}

		protected LootTable.Builder createVerticalSlabItemTable(Block block) {
			return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(applyExplosionDecay(block, LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(VerticalSlabBlock.TYPE, VerticalSlabType.DOUBLE)))))));
		}

		@Override
		public Iterable<Block> getKnownBlocks() {
			return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> ForgeRegistries.BLOCKS.getKey(block).getNamespace().equals(Clayworks.MOD_ID)).collect(Collectors.toSet());
		}
	}
}