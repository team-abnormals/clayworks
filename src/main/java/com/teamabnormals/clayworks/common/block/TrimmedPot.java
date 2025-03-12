package com.teamabnormals.clayworks.common.block;

import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.level.Level;

import java.util.Optional;

public interface TrimmedPot {
	Optional<DecoratedPotTrim> getTrim();

	void setTrim(DecoratedPotTrim trim);

	default Optional<TrimMaterial> getTrimMaterial(Level level) {
		if (this.getTrim().isPresent()) {
			return Optional.ofNullable(level.registryAccess().registryOrThrow(Registries.TRIM_MATERIAL).get(this.getTrim().get().material().getKey()));
		} else {
			return Optional.empty();
		}
	}

	default Optional<Item> getTrimItem(Level level) {
		return this.getTrimMaterial(level).map(material -> material.ingredient().value());
	}
}
