package com.teamabnormals.clayworks.core.other;

import com.teamabnormals.blueprint.core.util.BlockUtil;
import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

import java.util.Optional;

@EventBusSubscriber(modid = Clayworks.MOD_ID)
public class ClayworksEvents {

	@SubscribeEvent
	public static void onRightClickBlock(RightClickBlock event) {
		Level level = event.getLevel();
		BlockPos pos = event.getPos();
		BlockState state = level.getBlockState(pos);
		Player player = event.getEntity();
		ItemStack stack = event.getItemStack();

		if (state.getBlock() instanceof DecoratedPotBlock && player.isSecondaryUseActive()) {
			if (stack.is(ItemTags.TRIM_MATERIALS) && ClayworksConfig.COMMON.decoratedPotTrims.get()) {
				BlockEntity blockEntity = level.getBlockEntity(pos);
				if (blockEntity instanceof TrimmedPot trimmedPot) {
					RegistryAccess registryAccess = level.registryAccess();
					Optional<Item> item = trimmedPot.getTrimItem(level);
					Optional<Reference<TrimMaterial>> material = TrimMaterials.getFromIngredient(registryAccess, stack);
					Optional<Reference<DecoratedPotTrimPattern>> pattern = level.registryAccess().registryOrThrow(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN).getHolder(DecoratedPotTrimPattern.BASE);
					if (item.isEmpty() && material.isPresent() && pattern.isPresent()) {
						trimmedPot.setTrim(new DecoratedPotTrim(material.get(), pattern.get(), true));

						level.playSound(null, pos, SoundEvents.COPPER_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
						if (!player.isCreative()) {
							stack.shrink(1);
						}

						event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
						event.setCanceled(true);
					}
				}
			} else if (stack.is(ItemTags.PICKAXES) && ClayworksConfig.COMMON.decoratedPotTrims.get()) {
				BlockEntity blockEntity = level.getBlockEntity(pos);
				if (blockEntity instanceof TrimmedPot trimmedPot) {
					Optional<Item> item = trimmedPot.getTrimItem(level);
					if (item.isPresent()) {
						level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.COPPER_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
						Block.popResource(level, pos, new ItemStack(item.get()));
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));

						trimmedPot.setTrim(null);

						event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
						event.setCanceled(true);
					}
				}
			}
		}
	}
}
