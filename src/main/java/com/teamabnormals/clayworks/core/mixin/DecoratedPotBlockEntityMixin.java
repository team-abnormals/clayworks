package com.teamabnormals.clayworks.core.mixin;

import com.teamabnormals.clayworks.common.block.TrimmedPot;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.Optional;

@Mixin(DecoratedPotBlockEntity.class)
public class DecoratedPotBlockEntityMixin implements TrimmedPot {
	@Unique
	private Optional<Item> clayworks$trim = Optional.empty();

	@Override
	@Nullable
	public Optional<Item> getTrim() {
		return this.clayworks$trim;
	}

	@Override
	public void setTrim(Item item) {
		this.clayworks$trim = (item == null || item == Items.AIR) ? Optional.empty() : Optional.of(item);
	}

	@Inject(method = "saveAdditional", at = @At("TAIL"))
	private void saveAdditional(CompoundTag tag, CallbackInfo ci) {
		if (this.clayworks$trim.isPresent()) {
			ResourceLocation trimLocation = ForgeRegistries.ITEMS.getKey(this.clayworks$trim.get());
			if (trimLocation != null) {
				tag.putString("trim", trimLocation.toString());
			}
		}
	}

	@Inject(method = "load", at = @At("TAIL"))
	private void load(CompoundTag tag, CallbackInfo ci) {
		if (tag != null && tag.contains("trim")) {
			this.setTrim(ForgeRegistries.ITEMS.getValue(new ResourceLocation(tag.getString("trim"))));
		} else {
			this.setTrim(null);
		}
	}

	@Inject(method = "setFromItem", at = @At("TAIL"))
	private void setFromItem(ItemStack stack, CallbackInfo ci) {
		CompoundTag tag = BlockItem.getBlockEntityData(stack);
		if (tag != null && tag.contains("trim")) {
			this.setTrim(ForgeRegistries.ITEMS.getValue(new ResourceLocation(tag.getString("trim"))));
		} else {
			this.setTrim(null);
		}
	}
}
