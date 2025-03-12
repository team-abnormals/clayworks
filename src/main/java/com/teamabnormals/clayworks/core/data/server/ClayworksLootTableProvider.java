package com.teamabnormals.clayworks.core.data.server;

import com.google.common.collect.ImmutableList;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksDataComponents;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClayworksLootTableProvider extends LootTableProvider {

	public ClayworksLootTableProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(output, BuiltInLootTables.all(), ImmutableList.of(
				new LootTableProvider.SubProviderEntry(ClayworksBlockLoot::new, LootContextParamSets.BLOCK)
		), provider);
	}

	@Override
	protected void validate(WritableRegistry<LootTable> registry, ValidationContext context, ProblemReporter.Collector collector) {
	}

	public static class ClayworksBlockLoot extends BlockLootSubProvider {
		private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.AIR).map(ItemLike::asItem).collect(Collectors.toSet());


		protected ClayworksBlockLoot(Provider provider) {
			super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags(), provider);
		}

		@Override
		public void generate() {
			ClayworksBlocks.HELPER.getDeferredRegister().getEntries().forEach((registryObject -> {
				Block block = registryObject.get();
				if (block instanceof KilnBlock) {
					this.add(block, this::createNameableBlockEntityTable);
				} else if (block instanceof DecoratedPotBlock) {
					this.add(block, this::createDecoratedPotTable);
				} else if (block instanceof SlabBlock) {
					this.add(block, this::createSlabItemTable);
				} else {
					this.dropSelf(block);
				}
			}));
		}

		public static final ResourceLocation TRIM_DYNAMIC_DROP_ID = Clayworks.location("trim");

		private LootTable.Builder createDecoratedPotTable(Block block) {
			return LootTable.lootTable().withPool(createDynamicTrimDropPool(block)).withPool(createDecoratedPotPool(block));
		}

		public static LootPool.Builder createDynamicTrimDropPool(Block block) {
			return LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(DynamicLoot.dynamicEntry(TRIM_DYNAMIC_DROP_ID).when(
					LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
							.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DecoratedPotBlock.CRACKED, true))));
		}

		public static LootPool.Builder createDecoratedPotPool(Block block) {
			return LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(DynamicLoot.dynamicEntry(DecoratedPotBlock.SHERDS_DYNAMIC_DROP_ID).when(
							LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
									.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DecoratedPotBlock.CRACKED, true))
					)
					.otherwise(
							LootItem.lootTableItem(block)
									.apply(
											CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
													.include(DataComponents.POT_DECORATIONS)
													.include(ClayworksDataComponents.POT_TRIM.get())
									)
					));
		}

		@Override
		public Iterable<Block> getKnownBlocks() {
			return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(Clayworks.MOD_ID)).collect(Collectors.toSet());
		}
	}
}