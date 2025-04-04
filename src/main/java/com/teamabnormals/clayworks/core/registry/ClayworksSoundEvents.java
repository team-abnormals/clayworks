package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ClayworksSoundEvents {
	public static final SoundSubRegistryHelper SOUND_EVENTS = Clayworks.REGISTRY_HELPER.getSoundSubHelper();

	public static final DeferredHolder<SoundEvent, SoundEvent> KILN_SMOKE = SOUND_EVENTS.createSoundEvent("block.kiln.smoke");
}