package com.teamabnormals.clayworks.common.block;

import net.minecraft.world.item.Item;

import java.util.Optional;

public interface TrimmedPot {
	Optional<Item> getTrim();
	void setTrim(Item item);
}
