package com.teamabnormals.clayworks.core.mixin;

import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider.ClayworksBlockLoot;
import com.teamabnormals.clayworks.core.registry.ClayworksDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(DecoratedPotBlock.class)
public class DecoratedPotBlockMixin {

	@Inject(method = "getDrops", at = @At("HEAD"))
	private void getDrops(BlockState state, LootParams.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
		if (ClayworksConfig.COMMON.decoratedPotTrims.get()) {
			BlockEntity entity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
			if (entity instanceof TrimmedPot trimmedPot && entity.getLevel() != null) {
				Optional<Item> item = trimmedPot.getTrimItem(entity.getLevel());
				item.ifPresent(value -> builder.withDynamicDrop(ClayworksBlockLoot.TRIM_DYNAMIC_DROP_ID, (stackConsumer) -> {
					stackConsumer.accept(new ItemStack(value));
				}));
			}
		}
	}

	@Inject(method = "appendHoverText", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/BaseEntityBlock;appendHoverText(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/Item$TooltipContext;Ljava/util/List;Lnet/minecraft/world/item/TooltipFlag;)V", shift = Shift.AFTER))
	private void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag flag, CallbackInfo ci) {
		if (ClayworksConfig.COMMON.decoratedPotTrims.get()) {
			DecoratedPotTrim trim = stack.get(ClayworksDataComponents.POT_TRIM);
			if (trim != null && trim.showInTooltip()) {
				trim.addToTooltip(context, component::add, flag);
			}
		}
	}
}
