package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintLanguageProvider;
import com.teamabnormals.clayworks.client.gui.screens.recipebook.BakingRecipeBookComponent;
import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.datapack.ClayworksPaintingVariants;
import com.teamabnormals.clayworks.integration.jei.BakingCategory;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class ClayworksLanguageProvider extends BlueprintLanguageProvider {

	public ClayworksLanguageProvider(PackOutput output) {
		super(output, Clayworks.MOD_ID);
	}

	@Override
	public void addTranslations() {
		this.add(KilnBlockEntity.TRANSLATION.getString(), "Kiln");
		this.add(BakingCategory.TRANSLATION, "Baking");
		this.add("subtitles." + Clayworks.MOD_ID + ".block.kiln.smoke", "Kiln smokes");
		this.add(BakingRecipeBookComponent.FILTER_NAME, "Showing Bakeable");
		this.add(ClayworksPaintingVariants.BAKED, "Baked", "five");
		ClayworksBlocks.HELPER.getDeferredRegister().getEntries().forEach(block -> this.add(block.get()));
	}

	private void add(ResourceKey<PaintingVariant> variant, String title, String author) {
		ResourceLocation name = variant.location();
		String key = "painting." + name.getNamespace() + "." + name.getPath() + ".";
		this.add(key + "title", title);
		this.add(key + "author", author);
	}
}