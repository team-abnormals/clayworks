package com.teamabnormals.clayworks.common;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.List;

public record DecoratedPotTrimPattern(ResourceLocation assetId, Component description) {
	public static final List<ResourceKey<DecoratedPotTrimPattern>> PATTERNS = Lists.newArrayList();

	public static final ResourceKey<DecoratedPotTrimPattern> BASE = createKey("base");

	public static void bootstrap(BootstrapContext<DecoratedPotTrimPattern> context) {
		register(context, BASE);
		register(context, "border");
		register(context, "bunting");
		register(context, "closed");
		register(context, "curled");
		register(context, "dashes");
		register(context, "dots");
		register(context, "double");
		register(context, "fold");
		register(context, "frame");
		register(context, "inverted");
		register(context, "jaw");
		register(context, "jut");
		register(context, "lines");
		register(context, "loop");
		register(context, "octal");
		register(context, "opened");
		register(context, "quad");
		register(context, "ridged");
		register(context, "ripple");
		register(context, "steps");
		register(context, "straight");
		register(context, "striped");
		register(context, "studded");
		register(context, "thick");
		register(context, "twine");
		register(context, "wave");
		register(context, "zag");
		register(context, "zig");
	}

	public static void register(BootstrapContext<DecoratedPotTrimPattern> context, ResourceKey<DecoratedPotTrimPattern> key) {
		context.register(key, new DecoratedPotTrimPattern(key.location().withPrefix("entity/decorated_pot_trim_patterns/"), Component.translatable(Util.makeDescriptionId("decorated_pot_trim_pattern", key.location()))));
	}

	public static void register(BootstrapContext<DecoratedPotTrimPattern> context, String name) {
		register(context, createKey(name));
	}

	public static ResourceKey<DecoratedPotTrimPattern> createKey(String name) {
		ResourceKey<DecoratedPotTrimPattern> pattern = ResourceKey.create(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN, Clayworks.location(name));
		PATTERNS.add(pattern);
		return pattern;
	}

	public static final Codec<DecoratedPotTrimPattern> DIRECT_CODEC = RecordCodecBuilder.create(
			p_304350_ -> p_304350_.group(
							ResourceLocation.CODEC.fieldOf("asset_id").forGetter(DecoratedPotTrimPattern::assetId),
							ComponentSerialization.CODEC.fieldOf("description").forGetter(DecoratedPotTrimPattern::description)
					)
					.apply(p_304350_, DecoratedPotTrimPattern::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, DecoratedPotTrimPattern> DIRECT_STREAM_CODEC = StreamCodec.composite(
			ResourceLocation.STREAM_CODEC,
			DecoratedPotTrimPattern::assetId,
			ComponentSerialization.STREAM_CODEC,
			DecoratedPotTrimPattern::description,
			DecoratedPotTrimPattern::new
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<DecoratedPotTrimPattern>> STREAM_CODEC = ByteBufCodecs.holder(
			ClayworksRegistries.DECORATED_POT_TRIM_PATTERN, DIRECT_STREAM_CODEC
	);

	public Component copyWithStyle(Holder<TrimMaterial> trimMaterial) {
		return this.description.copy().withStyle(trimMaterial.value().description().getStyle());
	}
}