package com.teamabnormals.clayworks.common;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFixedCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.component.TooltipProvider;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Consumer;

public record DecoratedPotTrim(Holder<TrimMaterial> material, Holder<DecoratedPotTrimPattern> pattern, boolean showInTooltip) implements TooltipProvider {
	public static final Codec<DecoratedPotTrim> CODEC = RecordCodecBuilder.create(
			p_337943_ -> p_337943_.group(
							RegistryFixedCodec.create(Registries.TRIM_MATERIAL).fieldOf("material").forGetter(DecoratedPotTrim::material),
							RegistryFixedCodec.create(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN).fieldOf("pattern").forGetter(DecoratedPotTrim::pattern),
							Codec.BOOL.optionalFieldOf("show_in_tooltip", true).forGetter(DecoratedPotTrim::showInTooltip)
					)
					.apply(p_337943_, DecoratedPotTrim::new)
	);
	public static final StreamCodec<RegistryFriendlyByteBuf, DecoratedPotTrim> STREAM_CODEC = StreamCodec.composite(
			TrimMaterial.STREAM_CODEC,
			DecoratedPotTrim::material,
			DecoratedPotTrimPattern.STREAM_CODEC,
			DecoratedPotTrim::pattern,
			ByteBufCodecs.BOOL,
			DecoratedPotTrim::showInTooltip,
			DecoratedPotTrim::new
	);

	@Override
	public boolean equals(Object other) {
		return other instanceof DecoratedPotTrim trim && this.showInTooltip() == trim.showInTooltip() && this.pattern.equals(trim.pattern) && this.material.equals(trim.material);
	}

	@Override
	public int hashCode() {
		int i = this.material.hashCode();
		i = 31 * i + this.pattern.hashCode();
		return 31 * i + (this.showInTooltip() ? 1 : 0);
	}

	@Override
	public void addToTooltip(Item.TooltipContext context, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
		if (this.showInTooltip()) {
			tooltipAdder.accept(CommonComponents.space().append(this.pattern.value().copyWithStyle(this.material)));
			tooltipAdder.accept(CommonComponents.space().append(this.material.value().description()));
		}
	}

	public CompoundTag save(Provider access, CompoundTag tag) {
		tag.put("trim", CODEC.encodeStart(access.createSerializationContext(NbtOps.INSTANCE), this).getOrThrow());
		return tag;
	}

	public static Optional<DecoratedPotTrim> load(Provider access, @Nullable CompoundTag tag) {
		return tag != null && tag.contains("trim") ? Optional.of(CODEC.parse(access.createSerializationContext(NbtOps.INSTANCE), tag.get("trim")).result()).orElse(Optional.empty()) : Optional.empty();
	}
}