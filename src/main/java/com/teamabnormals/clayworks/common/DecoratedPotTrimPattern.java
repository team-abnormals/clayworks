package com.teamabnormals.clayworks.common;

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
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;

public record DecoratedPotTrimPattern(ResourceLocation assetId, Component description, boolean decal) {
	public static final ResourceKey<DecoratedPotTrimPattern> BASE = createKey("base");
	public static final ResourceKey<DecoratedPotTrimPattern> STRAIGHT = createKey("straight");
	public static final ResourceKey<DecoratedPotTrimPattern> WAVY = createKey("wavy");

	public static void bootstrap(BootstrapContext<DecoratedPotTrimPattern> context) {
		register(context, BASE);
		register(context, STRAIGHT);
		register(context, WAVY);
	}

	public static void register(BootstrapContext<DecoratedPotTrimPattern> context, ResourceKey<DecoratedPotTrimPattern> key) {
		context.register(key, new DecoratedPotTrimPattern(key.location().withPrefix("entity/decorated_pot_trim_patterns/"),
				Component.translatable(Util.makeDescriptionId("decorated_pot_trim_pattern", key.location())), false));
	}

	public static ResourceKey<DecoratedPotTrimPattern> createKey(String name) {
		return ResourceKey.create(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN, Clayworks.location(name));
	}

	public static final Codec<DecoratedPotTrimPattern> DIRECT_CODEC = RecordCodecBuilder.create(
			p_304350_ -> p_304350_.group(
							ResourceLocation.CODEC.fieldOf("asset_id").forGetter(DecoratedPotTrimPattern::assetId),
							ComponentSerialization.CODEC.fieldOf("description").forGetter(DecoratedPotTrimPattern::description),
							Codec.BOOL.fieldOf("decal").orElse(false).forGetter(DecoratedPotTrimPattern::decal)
					)
					.apply(p_304350_, DecoratedPotTrimPattern::new)
	);
	public static final StreamCodec<RegistryFriendlyByteBuf, DecoratedPotTrimPattern> DIRECT_STREAM_CODEC = StreamCodec.composite(
			ResourceLocation.STREAM_CODEC,
			DecoratedPotTrimPattern::assetId,
			ComponentSerialization.STREAM_CODEC,
			DecoratedPotTrimPattern::description,
			ByteBufCodecs.BOOL,
			DecoratedPotTrimPattern::decal,
			DecoratedPotTrimPattern::new
	);

	public static final Codec<Holder<DecoratedPotTrimPattern>> CODEC = RegistryFileCodec.create(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN, DIRECT_CODEC);
	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<DecoratedPotTrimPattern>> STREAM_CODEC = ByteBufCodecs.holder(
			ClayworksRegistries.DECORATED_POT_TRIM_PATTERN, DIRECT_STREAM_CODEC
	);

	public Component copyWithStyle(Holder<TrimMaterial> trimMaterial) {
		return this.description.copy().withStyle(trimMaterial.value().description().getStyle());
	}
}