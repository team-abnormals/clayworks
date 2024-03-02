package com.teamabnormals.clayworks.core.data.server;

import com.google.common.collect.ImmutableList;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
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
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
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

	public static class ClayworksBlockLoot extends BlockLootSubProvider {
		private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.AIR).map(ItemLike::asItem).collect(Collectors.toSet());

		public static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
		public static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();

		protected ClayworksBlockLoot() {
			super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
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

		public static final ResourceLocation TRIM_DYNAMIC_DROP_ID = new ResourceLocation(Clayworks.MOD_ID, "trim");

		private LootTable.Builder createDecoratedPotTable(Block block) {
			return LootTable.lootTable().withPool(createDynamicTrimDropPool()).withPool(createDecoratedPotPool(block));
		}

		public static LootPool.Builder createDynamicTrimDropPool() {
			return LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(DynamicLoot.dynamicEntry(TRIM_DYNAMIC_DROP_ID).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.BREAKS_DECORATED_POTS))).when(HAS_NO_SILK_TOUCH));
		}

		public static LootPool.Builder createDecoratedPotPool(Block block) {
			return LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(DynamicLoot.dynamicEntry(DecoratedPotBlock.SHERDS_DYNAMIC_DROP_ID).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(ItemTags.BREAKS_DECORATED_POTS))).when(HAS_NO_SILK_TOUCH).otherwise(LootItem.lootTableItem(block).apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("sherds", "BlockEntityTag.sherds").copy("trim", "BlockEntityTag.trim"))));
		}

		@Override
		public Iterable<Block> getKnownBlocks() {
			return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> ForgeRegistries.BLOCKS.getKey(block).getNamespace().equals(Clayworks.MOD_ID)).collect(Collectors.toSet());
		}
	}
}