package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksPaintingVariants;
import com.teamabnormals.clayworks.integration.jei.BakingCategory;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;

import java.util.List;

public class ClayworksLanguageProvider extends LanguageProvider {

	public ClayworksLanguageProvider(PackOutput output) {
		super(output, Clayworks.MOD_ID, "en_us");
	}

	@Override
	public void addTranslations() {
		this.add(KilnBlockEntity.TRANSLATION.getString(), "Kiln");
		this.add(BakingCategory.TRANSLATION.getString(), "Baking");
		this.add("subtitles." + Clayworks.MOD_ID + ".block.kiln.smoke", "Kiln smokes");
		this.add(ClayworksPaintingVariants.BAKED, "Baked", "five");
		ClayworksBlocks.HELPER.getDeferredRegister().getEntries().forEach((registryObject -> this.add(registryObject.get())));
	}

	private void add(Block... blocks) {
		List.of(blocks).forEach((block -> this.add(block, format(ForgeRegistries.BLOCKS.getKey(block)))));
	}

	private void add(RegistryObject<PaintingVariant> variant, String title, String author) {
		ResourceLocation name = variant.getId();
		String key = "painting." + name.getNamespace() + "." + name.getPath() + ".";
		this.add(key + "title", title);
		this.add(key + "author", author);
	}

	private String format(ResourceLocation registryName) {
		return WordUtils.capitalizeFully(registryName.getPath().replace("_", " "));
	}
}