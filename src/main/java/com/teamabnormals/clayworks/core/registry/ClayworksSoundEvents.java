package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ClayworksSoundEvents {
	public static final SoundSubRegistryHelper HELPER = Clayworks.REGISTRY_HELPER.getSoundSubHelper();

	public static final DeferredHolder<SoundEvent, SoundEvent> KILN_SMOKE = HELPER.createSoundEvent("block.kiln.smoke");
}