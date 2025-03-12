package com.teamabnormals.clayworks.client.splashes;

import com.mojang.serialization.MapCodec;
import com.teamabnormals.blueprint.client.screen.splash.Splash;
import net.minecraft.client.User;
import net.minecraft.util.RandomSource;
import net.neoforged.fml.ModList;

import javax.annotation.Nullable;

public enum WoodworksSplash implements Splash {
	INSTANCE;

	public static final MapCodec<WoodworksSplash> CODEC = MapCodec.unit(INSTANCE);

	@Nullable
	@Override
	public String getText(User user, RandomSource random) {
		return !ModList.get().isLoaded("woodworks") ? "Woodworks sold separately!" : null;
	}

	@Override
	public boolean isRandom() {
		return true;
	}

	@Override
	public MapCodec<? extends Splash> codec() {
		return CODEC;
	}
}