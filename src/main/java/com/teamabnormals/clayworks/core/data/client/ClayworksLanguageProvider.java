package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintLanguageProvider;
import com.teamabnormals.clayworks.client.gui.screens.recipebook.BakingRecipeBookComponent;
import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.common.block.PotteryTableBlock;
import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.datapack.ClayworksPaintingVariants;
import com.teamabnormals.clayworks.integration.jei.BakingCategory;
import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import org.apache.commons.lang3.text.WordUtils;


public class ClayworksLanguageProvider extends BlueprintLanguageProvider {

	public ClayworksLanguageProvider(PackOutput output) {
		super(output, Clayworks.MOD_ID);
	}

	@Override
	public void addTranslations() {
		this.add(KilnBlockEntity.CONTAINER_TITLE.getString(), "Kiln");
		this.add(PotteryTableBlock.CONTAINER_TITLE.getString(), "Pottery Table");
		this.add(BakingCategory.TRANSLATION, "Baking");
		this.add(DecoratedPotTrim.DESIGN_TITLE, "Design: ");
		this.add(DecoratedPotTrim.SHERDS_TITLE, "Sherds: ");
		this.add("subtitles." + Clayworks.MOD_ID + ".block.kiln.smoke", "Kiln smokes");
		this.add(BakingRecipeBookComponent.FILTER_NAME, "Showing Bakeable");
		this.add(ClayworksPaintingVariants.BAKED, "Baked", "five");
		ClayworksBlocks.BLOCKS.getDeferredRegister().getEntries().forEach(block -> this.add(block.get()));

		this.addDecoratedPotTrimPatterns();
	}

	private void add(ResourceKey<PaintingVariant> variant, String title, String author) {
		ResourceLocation name = variant.location();
		String key = "painting." + name.getNamespace() + "." + name.getPath() + ".";
		this.add(key + "title", title);
		this.add(key + "author", author);
	}

	private void addDecoratedPotTrimPatterns() {
		for (ResourceKey<DecoratedPotTrimPattern> pattern : DecoratedPotTrimPattern.PATTERNS) {
			String name = WordUtils.capitalize(pattern.location().getPath().replace("_", " "));
			this.add(Util.makeDescriptionId("decorated_pot_trim_pattern", pattern.location()), name + " Trim");
		}
	}
}