package com.teamabnormals.clayworks.common;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import net.minecraft.Util;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;

public record DecoratedPotTrimPattern(ResourceLocation texture, Component displayName) {
	public static final ResourceKey<DecoratedPotTrimPattern> BASE = createKey("base");
	public static final ResourceKey<DecoratedPotTrimPattern> STRAIGHT = createKey("straight");
	public static final ResourceKey<DecoratedPotTrimPattern> WAVY = createKey("wavy");

	public static void bootstrap(BootstapContext<DecoratedPotTrimPattern> context) {
		register(context, BASE);
		register(context, STRAIGHT);
		register(context, WAVY);
	}

	public static void register(BootstapContext<DecoratedPotTrimPattern> context, ResourceKey<DecoratedPotTrimPattern> key) {
		context.register(key, new DecoratedPotTrimPattern(key.location().withPrefix("entity/decorated_pot_trim_patterns/"),
				Component.translatable(Util.makeDescriptionId("decorated_pot_trim_pattern", key.location()))));
	}

	public static ResourceKey<DecoratedPotTrimPattern> createKey(String name) {
		return ResourceKey.create(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN, new ResourceLocation(Clayworks.MOD_ID, name));
	}

	public static final Codec<DecoratedPotTrimPattern> CODEC = RecordCodecBuilder.create(instance ->
			instance.group(
							ResourceLocation.CODEC.fieldOf("asset_id").forGetter(entry -> entry.texture),
							ExtraCodecs.COMPONENT.fieldOf("description").forGetter(entry -> entry.displayName))
					.apply(instance, DecoratedPotTrimPattern::new));
}