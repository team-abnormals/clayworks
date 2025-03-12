package com.teamabnormals.clayworks.core.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.registry.ClayworksDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.component.DataComponentMap.Builder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.Optional;

@Mixin(DecoratedPotBlockEntity.class)
public abstract class DecoratedPotBlockEntityMixin extends BlockEntity implements TrimmedPot {
	@Unique
	private Optional<DecoratedPotTrim> clayworks$trim = Optional.empty();

	public DecoratedPotBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
	}

	@Override
	@Nullable
	public Optional<DecoratedPotTrim> getTrim() {
		return this.clayworks$trim;
	}

	@Override
	public void setTrim(DecoratedPotTrim trim) {
		this.clayworks$trim = trim != null ? Optional.of(trim) : Optional.empty();
	}

	@Inject(method = "saveAdditional", at = @At("TAIL"))
	private void saveAdditional(CompoundTag tag, Provider registries, CallbackInfo ci) {
		this.clayworks$trim.ifPresent(trim -> trim.save(registries, tag));
	}

	@Inject(method = "loadAdditional", at = @At("TAIL"))
	private void loadAdditional(CompoundTag tag, Provider registries, CallbackInfo ci) {
		this.clayworks$trim = DecoratedPotTrim.load(registries, tag);
	}

	@Inject(method = "collectImplicitComponents", at = @At("TAIL"))
	private void collectImplicitComponents(Builder components, CallbackInfo ci) {
		this.clayworks$trim.ifPresent(trim -> components.set(ClayworksDataComponents.POT_TRIM, trim));
	}

	@Inject(method = "applyImplicitComponents", at = @At("TAIL"))
	private void applyImplicitComponents(DataComponentInput componentInput, CallbackInfo ci) {
		this.clayworks$trim = Optional.ofNullable(componentInput.get(ClayworksDataComponents.POT_TRIM));
	}

	@Inject(method = "removeComponentsFromTag", at = @At("TAIL"))
	private void removeComponentsFromTag(CompoundTag tag, CallbackInfo ci) {
		tag.remove("trim");
	}

	@WrapOperation(method = "getPotAsItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getDefaultInstance()Lnet/minecraft/world/item/ItemStack;"))
	private ItemStack getPotAsItem(Item item, Operation<ItemStack> original) {
		return new ItemStack(this.getBlockState().getBlock().asItem());
	}
}
