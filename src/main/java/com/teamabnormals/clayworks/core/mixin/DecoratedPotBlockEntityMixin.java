package com.teamabnormals.clayworks.core.mixin;

import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(DecoratedPotBlockEntity.class)
public class DecoratedPotBlockEntityMixin implements TrimmedPot {
	@Unique
	private ResourceLocation clayworks$trim = new ResourceLocation("air");

	@Unique
	private ResourceLocation clayworks$trimPattern = new ResourceLocation(Clayworks.MOD_ID, "base");

	@Override
	@Nullable
	public ResourceLocation getTrim() {
		return this.clayworks$trim;
	}

	@Override
	public void setTrim(ResourceLocation name) {
		this.clayworks$trim = name != null ? name : new ResourceLocation("air");
	}

	@Override
	@Nullable
	public ResourceLocation getTrimPattern() {
		return this.clayworks$trimPattern;
	}

	@Override
	public void setTrimPattern(ResourceLocation name) {
		this.clayworks$trimPattern = name != null ? name : new ResourceLocation(Clayworks.MOD_ID, "base");
	}

	@Inject(method = "saveAdditional", at = @At("TAIL"))
	private void saveAdditional(CompoundTag tag, CallbackInfo ci) {
		tag.putString("trim", this.clayworks$trim.toString());
		tag.putString("trim_pattern", this.clayworks$trimPattern.toString());
	}

	@Inject(method = "load", at = @At("TAIL"))
	private void load(CompoundTag tag, CallbackInfo ci) {
		this.setTag(tag);
	}

	@Inject(method = "setFromItem", at = @At("TAIL"))
	private void setFromItem(ItemStack stack, CallbackInfo ci) {
		this.setTag(BlockItem.getBlockEntityData(stack));
	}

	@Unique
	private void setTag(CompoundTag tag) {
		if (tag != null && tag.contains("trim")) {
			this.setTrim(new ResourceLocation(tag.getString("trim")));
		} else {
			this.setTrim(null);
		}

		if (tag != null && tag.contains("trim_pattern")) {
			this.setTrimPattern(new ResourceLocation(tag.getString("trim_pattern")));
		} else {
			this.setTrimPattern(null);
		}
	}
}
