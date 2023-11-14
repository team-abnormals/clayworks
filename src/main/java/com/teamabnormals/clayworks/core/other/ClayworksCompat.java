package com.teamabnormals.clayworks.core.other;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;

public class ClayworksCompat {

	public static void registerCompat() {
		addDecoratedPotBlockEntityTypes();
		registerCauldronInteractions();
	}

	public static void addDecoratedPotBlockEntityTypes() {
		HashSet<Block> blocks = Sets.newHashSet();
		blocks.addAll(BlockEntityType.DECORATED_POT.validBlocks);
		blocks.addAll(ClayworksBlocks.HELPER.getDeferredRegister().getEntries().stream().filter(registryObject -> registryObject.get() instanceof DecoratedPotBlock).map(RegistryObject::get).toList());
		BlockEntityType.DECORATED_POT.validBlocks = ImmutableSet.copyOf(blocks);
	}

	public static void registerCauldronInteractions() {
		ClayworksBlocks.HELPER.getDeferredRegister().getEntries().stream().filter(block -> block.get() instanceof DecoratedPotBlock).forEach(block -> {
			CauldronInteraction.WATER.put(block.get().asItem(), DECORATED_POT);
		});
	}

	public static final CauldronInteraction DECORATED_POT = (state, level, pos, player, hand, stack) -> {
		Block block = Block.byItem(stack.getItem());
		if (!(block instanceof DecoratedPotBlock)) {
			return InteractionResult.PASS;
		} else {
			if (!level.isClientSide) {
				ItemStack returnStack = new ItemStack(Blocks.DECORATED_POT);
				if (stack.hasTag()) {
					returnStack.setTag(stack.getTag().copy());
				}

				player.setItemInHand(hand, returnStack);
				LayeredCauldronBlock.lowerFillLevel(state, level, pos);
			}

			return InteractionResult.sidedSuccess(level.isClientSide);
		}
	};
}
