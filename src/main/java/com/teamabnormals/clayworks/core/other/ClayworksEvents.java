package com.teamabnormals.clayworks.core.other;

import com.teamabnormals.blueprint.core.util.BlockUtil;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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

		if (stack.getItem() instanceof DyeItem dyeItem && state.getBlock() instanceof DecoratedPotBlock potBlock && !player.isSecondaryUseActive()) {
			DyeColor itemColor = dyeItem.getDyeColor();
			DyeColor blockColor = ClayworksBlocks.getDyeColorFromPot(potBlock);
			if (itemColor != blockColor) {
				level.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
				if (!player.isCreative()) {
					stack.shrink(1);
				}

				BlockEntity pot = level.getBlockEntity(pos);
				if (pot != null) {
					CompoundTag tag = pot.serializeNBT();
					level.setBlockAndUpdate(pos, BlockUtil.transferAllBlockStates(state, ClayworksBlocks.getPotFromDyeColor(itemColor).defaultBlockState()));
					pot = level.getBlockEntity(pos);
					if (pot != null) {
						pot.deserializeNBT(tag);
					}
				}

				event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
				event.setCanceled(true);
			}
		}
	}
}
