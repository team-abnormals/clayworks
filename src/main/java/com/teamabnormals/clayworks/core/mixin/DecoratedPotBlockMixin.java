package com.teamabnormals.clayworks.core.mixin;

import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider.ClayworksBlockLoot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(DecoratedPotBlock.class)
public class DecoratedPotBlockMixin {

	@Inject(method = "getDrops", at = @At("HEAD"))
	private void getDrops(BlockState state, LootParams.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
		if (ClayworksConfig.COMMON.decoratedPotTrims.get()) {
			BlockEntity blockentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
			if (blockentity instanceof TrimmedPot trimmedPot && trimmedPot.getTrim().isPresent()) {
				builder.withDynamicDrop(ClayworksBlockLoot.TRIM_DYNAMIC_DROP_ID, (stackConsumer) -> {
					stackConsumer.accept(new ItemStack(trimmedPot.getTrim().get()));
				});
			}
		}
	}
}
