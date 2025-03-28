package com.teamabnormals.clayworks.core.other;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

public class ClayworksClientCompat {

    public static void registerClientCompat() {
        registerRenderLayers();
    }

    public static void registerRenderLayers() {
        ItemBlockRenderTypes.setRenderLayer(GLASS_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WHITE_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ORANGE_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MAGENTA_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(YELLOW_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LIME_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(PINK_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(GRAY_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CYAN_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(PURPLE_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BLUE_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BROWN_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(GREEN_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RED_STAINED_GLASS_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BLACK_STAINED_GLASS_DOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(GLASS_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(WHITE_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ORANGE_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MAGENTA_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_BLUE_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(YELLOW_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LIME_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(PINK_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(GRAY_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(LIGHT_GRAY_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(CYAN_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(PURPLE_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BLUE_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BROWN_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(GREEN_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RED_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(BLACK_STAINED_GLASS_TRAPDOOR.get(), RenderType.translucent());
    }
}