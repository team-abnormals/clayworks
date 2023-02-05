package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.client.gui.screens.inventory.KilnScreen;
import com.teamabnormals.clayworks.common.inventory.KilnMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ClayworksMenuTypes {
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Clayworks.MOD_ID);

	public static final RegistryObject<MenuType<KilnMenu>> KILN = MENU_TYPES.register("kiln", () -> new MenuType<>(KilnMenu::new));

	public static void registerScreenFactories() {
		MenuScreens.register(ClayworksMenuTypes.KILN.get(), KilnScreen::new);
	}
}
