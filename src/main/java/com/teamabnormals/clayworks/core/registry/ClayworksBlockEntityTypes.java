package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ClayworksBlockEntityTypes {
	public static final BlockEntitySubRegistryHelper BLOCK_ENTITY_TYPES = Clayworks.REGISTRY_HELPER.getBlockEntitySubHelper();

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KilnBlockEntity>> KILN = BLOCK_ENTITY_TYPES.createBlockEntity("kiln", KilnBlockEntity::new, KilnBlock.class);

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(ItemHandler.BLOCK, KILN.get(), (container, side) -> side == null ? new InvWrapper(container) : new SidedInvWrapper(container, side));
	}
}