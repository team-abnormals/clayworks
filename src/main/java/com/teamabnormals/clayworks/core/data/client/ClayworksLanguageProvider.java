package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.integration.jei.BakingRecipeCategory;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.text.WordUtils;

import java.util.List;

public class ClayworksLanguageProvider extends LanguageProvider {

	public ClayworksLanguageProvider(DataGenerator gen) {
		super(gen, Clayworks.MOD_ID, "en_us");
	}

	@Override
	public void addTranslations() {
		this.add(KilnBlockEntity.TRANSLATION.getKey(), "Kiln");
		this.add(BakingRecipeCategory.TRANSLATION.getKey(), "Baking");
		this.add("subtitles." + Clayworks.MOD_ID + ".block.kiln.smoke", "Kiln smokes");
		ClayworksBlocks.HELPER.getDeferredRegister().getEntries().forEach((registryObject -> this.add(registryObject.get())));
	}

	private void add(Block... blocks) {
		List.of(blocks).forEach((block -> this.add(block, format(block.getRegistryName()))));
	}

	private String format(ResourceLocation registryName) {
		return WordUtils.capitalizeFully(registryName.getPath().replace("_", " "));
	}
}