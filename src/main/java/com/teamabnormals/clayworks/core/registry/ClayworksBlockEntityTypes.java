package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import com.teamabnormals.clayworks.common.block.KilnBlock;
import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ClayworksBlockEntityTypes {
	public static final BlockEntitySubRegistryHelper BLOCK_ENTITY_TYPES = Clayworks.REGISTRY_HELPER.getBlockEntitySubHelper();

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KilnBlockEntity>> KILN = BLOCK_ENTITY_TYPES.createBlockEntity("kiln", KilnBlockEntity::new, KilnBlock.class);
}
