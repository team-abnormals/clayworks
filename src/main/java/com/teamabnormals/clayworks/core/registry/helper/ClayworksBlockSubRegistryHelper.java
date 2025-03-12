package com.teamabnormals.clayworks.core.registry.helper;

import com.teamabnormals.blueprint.client.MemoizedBEWLR;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.clayworks.client.DecoratedPotBlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class ClayworksBlockSubRegistryHelper extends BlockSubRegistryHelper {

	public ClayworksBlockSubRegistryHelper(RegistryHelper parent) {
		super(parent);
	}

	public <B extends Block> DeferredBlock<B> createdDecoratedPotBlock(String name, Supplier<? extends B> supplier) {
		DeferredBlock<B> block = this.deferredRegister.register(name, supplier);
		DeferredHolder<Item, BlockItem> item = this.itemRegister.register(name, () -> new BlockItem(block.get(), new Properties().stacksTo(1)));
		if (FMLEnvironment.dist == Dist.CLIENT) {
			this.clientItemExtensions.put(item, decoratedPotBEWLR(block));
		}
		return block;
	}

	@OnlyIn(Dist.CLIENT)
	private static IClientItemExtensions decoratedPotBEWLR(Supplier<? extends Block> block) {
		return MemoizedBEWLR.asCustomItemRenderer((dispatcher, entityModelSet) -> new DecoratedPotBlockEntityWithoutLevelRenderer<>(dispatcher, entityModelSet, new DecoratedPotBlockEntity(BlockPos.ZERO, block.get().defaultBlockState())));
	}
}
