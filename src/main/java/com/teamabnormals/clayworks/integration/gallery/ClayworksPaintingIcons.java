package com.teamabnormals.clayworks.integration.gallery;

import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.gallery.core.data.client.GalleryAssetsRemolderProvider;
import com.teamabnormals.gallery.core.data.client.GalleryItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;

public class ClayworksPaintingIcons {

	public static void addGalleryProviders(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		boolean client = event.includeClient();

		generator.addProvider(client, new GalleryItemModelProvider(Clayworks.MOD_ID, output, event.getExistingFileHelper()));
		generator.addProvider(client, new GalleryAssetsRemolderProvider(Clayworks.MOD_ID, output, event.getLookupProvider()));
	}
}
