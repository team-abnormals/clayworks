package com.teamabnormals.clayworks.client.splashes;

import com.mojang.serialization.Codec;
import com.teamabnormals.blueprint.client.screen.splash.Splash;
import net.minecraft.client.User;
import net.minecraft.util.RandomSource;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;

public enum WoodworksSplash implements Splash {
	INSTANCE;

	public static final Codec<WoodworksSplash> CODEC = Codec.unit(INSTANCE);

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
	public Codec<? extends Splash> codec() {
		return CODEC;
	}
}