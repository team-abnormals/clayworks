package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.common.inventory.KilnMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ClayworksMenuTypes {
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, Clayworks.MOD_ID);

	public static final DeferredHolder<MenuType<?>, MenuType<KilnMenu>> KILN = MENU_TYPES.register("kiln", () -> new MenuType<>(KilnMenu::new, FeatureFlags.VANILLA_SET));
}
