package com.teamabnormals.clayworks.core.registry;

import com.teamabnormals.clayworks.client.gui.screens.inventory.KilnScreen;
import com.teamabnormals.clayworks.client.gui.screens.inventory.PotteryScreen;
import com.teamabnormals.clayworks.common.inventory.KilnMenu;
import com.teamabnormals.clayworks.common.inventory.PotteryMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = Clayworks.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClayworksMenuTypes {
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, Clayworks.MOD_ID);

	public static final DeferredHolder<MenuType<?>, MenuType<KilnMenu>> KILN = MENU_TYPES.register("kiln", () -> new MenuType<>(KilnMenu::new, FeatureFlags.VANILLA_SET));
	public static final DeferredHolder<MenuType<?>, MenuType<PotteryMenu>> POTTERY = MENU_TYPES.register("pottery", () -> new MenuType<>(PotteryMenu::new, FeatureFlags.VANILLA_SET));

	@SubscribeEvent
	public static void registerScreens(RegisterMenuScreensEvent event) {
		event.register(ClayworksMenuTypes.KILN.get(), KilnScreen::new);
		event.register(ClayworksMenuTypes.POTTERY.get(), PotteryScreen::new);
	}
}
