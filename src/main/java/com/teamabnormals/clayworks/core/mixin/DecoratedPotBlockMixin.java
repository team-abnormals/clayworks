package com.teamabnormals.clayworks.core.mixin;

import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.data.server.ClayworksLootTableProvider.ClayworksBlockLoot;
import com.teamabnormals.clayworks.core.registry.ClayworksDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.DecoratedPotBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
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

	@Inject(method = "appendHoverText", at = @At("HEAD"), cancellable = true)
	private void appendHoverText(ItemStack stack, TooltipContext context, List<Component> component, TooltipFlag flag, CallbackInfo ci) {
		PotDecorations sherds = stack.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
		boolean empty = sherds.equals(PotDecorations.EMPTY);

		if (!empty) {
			component.add(DecoratedPotTrim.SHERDS_COMPONENT);
			sherds.ordered().forEach(optional -> component.add(CommonComponents.space().append(optional.getDefaultInstance().getHoverName().plainCopy().withStyle(ChatFormatting.GRAY))));
		}

		if (ClayworksConfig.COMMON.decoratedPotTrims.get()) {
			DecoratedPotTrim trim = stack.get(ClayworksDataComponents.POT_TRIM);
			if (trim != null) {
				if (!empty) {
					component.add(CommonComponents.EMPTY);
				}
				trim.addToTooltip(context, component::add, flag);
			}
		}

		ci.cancel();
	}
}
