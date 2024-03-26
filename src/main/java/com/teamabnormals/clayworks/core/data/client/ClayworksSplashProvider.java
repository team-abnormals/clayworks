package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.blueprint.client.screen.splash.SplashProvider;
import com.teamabnormals.clayworks.client.splashes.WoodworksSplash;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.data.PackOutput;

public final class ClayworksSplashProvider extends SplashProvider {

	public ClayworksSplashProvider(PackOutput packOutput) {
		super(Clayworks.MOD_ID, packOutput);
	}

	@Override
	protected void registerSplashes() {
		this.add("The clay works!");
		this.add(WoodworksSplash.INSTANCE);
	}
}