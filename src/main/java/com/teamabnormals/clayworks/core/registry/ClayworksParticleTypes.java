package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.client.particle.KilnSmokeParticle;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = Clayworks.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClayworksParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Clayworks.MOD_ID);

	public static final RegistryObject<SimpleParticleType> KILN_SMOKE = PARTICLE_TYPES.register("kiln_smoke", () -> new SimpleParticleType(true));

	@SubscribeEvent
	public static void registerParticleFactorys(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(KILN_SMOKE.get(), KilnSmokeParticle.Factory::new);
	}
}