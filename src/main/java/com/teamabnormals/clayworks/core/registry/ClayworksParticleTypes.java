package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.client.particle.KilnSmokeParticle;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClayworksParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, Clayworks.MOD_ID);

	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> KILN_SMOKE = PARTICLE_TYPES.register("kiln_smoke", () -> new SimpleParticleType(true));

	@SubscribeEvent
	public static void registerParticleFactorys(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(KILN_SMOKE.get(), KilnSmokeParticle.Factory::new);
	}
}