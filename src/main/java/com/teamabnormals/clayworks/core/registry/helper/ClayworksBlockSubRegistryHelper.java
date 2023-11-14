package com.teamabnormals.clayworks.core.registry.helper;

import com.teamabnormals.blueprint.common.item.BEWLRBlockItem;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.clayworks.client.DecoratedPotBlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ClayworksBlockSubRegistryHelper extends BlockSubRegistryHelper {

	public ClayworksBlockSubRegistryHelper(RegistryHelper parent) {
		super(parent, parent.getItemSubHelper().getDeferredRegister(), parent.getBlockSubHelper().getDeferredRegister());
	}

	public <B extends Block> RegistryObject<B> createdDecoratedPotBlock(String name, Supplier<? extends B> supplier) {
		RegistryObject<B> block = this.deferredRegister.register(name, supplier);
		this.itemRegister.register(name, () -> new BEWLRBlockItem(block.get(), new Item.Properties().stacksTo(1), () -> () -> decoratedPotBEWLR(block.get())));
		return block;
	}

	@OnlyIn(Dist.CLIENT)
	private static BEWLRBlockItem.LazyBEWLR decoratedPotBEWLR(Block block) {
		return new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> new DecoratedPotBlockEntityWithoutLevelRenderer<>(dispatcher, entityModelSet, new DecoratedPotBlockEntity(BlockPos.ZERO, block.defaultBlockState())));
	}
}
