package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponentType.Builder;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;

public class ClayworksDataComponents {
	public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Clayworks.MOD_ID);

	public static final DeferredHolder<DataComponentType<?>, DataComponentType<DecoratedPotTrim>> POT_TRIM = register("pot_trims", builder -> builder.persistent(DecoratedPotTrim.CODEC).networkSynchronized(DecoratedPotTrim.STREAM_CODEC).cacheEncoding());

	private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, UnaryOperator<Builder<T>> builder) {
		return DATA_COMPONENTS.register(name, () -> builder.apply(DataComponentType.builder()).build());
	}
}