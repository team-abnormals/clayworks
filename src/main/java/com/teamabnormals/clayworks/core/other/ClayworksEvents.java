package com.teamabnormals.clayworks.core.other;

import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import com.teamabnormals.blueprint.core.util.BlockUtil;
import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = Clayworks.MOD_ID)
public class ClayworksEvents {

	@SubscribeEvent
	public static void onRightClickBlock(RightClickBlock event) {
		Level level = event.getLevel();
		BlockPos pos = event.getPos();
		BlockState state = level.getBlockState(pos);
		Player player = event.getEntity();
		ItemStack stack = event.getItemStack();

		if (state.getBlock() instanceof DecoratedPotBlock potBlock && !player.isSecondaryUseActive()) {
			if (stack.getItem() instanceof DyeItem dyeItem && ClayworksConfig.COMMON.decoratedPotColors.get()) {
				DyeColor itemColor = dyeItem.getDyeColor();
				DyeColor blockColor = ClayworksBlocks.getDyeColorFromPot(potBlock);
				if (itemColor != blockColor) {
					level.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
					if (!player.isCreative()) {
						stack.shrink(1);
					}

					BlockEntity blockEntity = level.getBlockEntity(pos);
					if (blockEntity != null) {
						CompoundTag tag = blockEntity.serializeNBT();
						level.setBlockAndUpdate(pos, BlockUtil.transferAllBlockStates(state, ClayworksBlocks.getPotFromDyeColor(itemColor).defaultBlockState()));
						blockEntity = level.getBlockEntity(pos);
						if (blockEntity != null) {
							blockEntity.deserializeNBT(tag);
						}
					}

					event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
					event.setCanceled(true);
				}
			} else if (stack.is(ItemTags.TRIM_MATERIALS) && ClayworksConfig.COMMON.decoratedPotTrims.get()) {
				BlockEntity blockEntity = level.getBlockEntity(pos);
				if (blockEntity instanceof TrimmedPot trimmedPot) {
					if (trimmedPot.getTrim().isEmpty()) {
						trimmedPot.setTrim(stack.getItem());

						level.playSound(null, pos, SoundEvents.COPPER_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
						if (!player.isCreative()) {
							stack.shrink(1);
						}

						event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
						event.setCanceled(true);
					}
				}
			} else if (stack.is(BlueprintItemTags.TOOLS_PICKAXES) && ClayworksConfig.COMMON.decoratedPotTrims.get()) {
				BlockEntity blockEntity = level.getBlockEntity(pos);
				if (blockEntity instanceof TrimmedPot trimmedPot) {
					if (trimmedPot.getTrim().isPresent()) {
						level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.COPPER_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
						Block.popResource(level, pos, new ItemStack(trimmedPot.getTrim().get()));
						stack.hurtAndBreak(1, player, (p_49571_) -> p_49571_.broadcastBreakEvent(event.getHand()));

						trimmedPot.setTrim(null);

						event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
						event.setCanceled(true);
					}
				}
			}
		}
	}
}
