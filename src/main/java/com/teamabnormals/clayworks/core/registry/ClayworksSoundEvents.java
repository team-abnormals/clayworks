package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ClayworksSoundEvents {
	public static final SoundSubRegistryHelper HELPER = Clayworks.REGISTRY_HELPER.getSoundSubHelper();

	public static final RegistryObject<SoundEvent> KILN_SMOKE = HELPER.createSoundEvent("block.kiln.smoke");
	public static final RegistryObject<SoundEvent> VILLAGER_WORK_MASON = HELPER.createSoundEvent("entity.villager.work_mason");
}