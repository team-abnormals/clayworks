package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.core.events.LoadThisClassEvent;
import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ClayworksBlockEntityTypes {
	@SubscribeEvent
	public static void $(LoadThisClassEvent event) {
	}

	public static final BlockEntitySubRegistryHelper HELPER = Clayworks.REGISTRY_HELPER.getBlockEntitySubHelper();

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KilnBlockEntity>> KILN = HELPER.createBlockEntity("kiln", KilnBlockEntity::new, KilnBlock.class);
}
