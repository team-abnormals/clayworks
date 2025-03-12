package com.teamabnormals.clayworks.integration.jei;

import com.mojang.serialization.Codec;
import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.placement.HorizontalAlignment;
import mezz.jei.api.gui.placement.VerticalAlignment;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.ICodecHelper;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.IRecipeManager;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;

public class BakingCategory extends AbstractRecipeCategory<RecipeHolder<BakingRecipe>> {
	public static final String TRANSLATION = "gui." + Clayworks.MOD_ID + ".category.baking";

	protected final int regularCookTime = 100;

	public BakingCategory(IGuiHelper guiHelper) {
		super(ClayworksPlugin.BAKING, Component.translatable(TRANSLATION), guiHelper.createDrawableItemLike(ClayworksBlocks.KILN.get()), 82, 54);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<BakingRecipe> recipeHolder, IFocusGroup focuses) {
		BakingRecipe recipe = recipeHolder.value();

		builder.addInputSlot(1, 1)
				.setStandardSlotBackground()
				.addIngredients(recipe.getIngredients().getFirst());

		builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 1, 37)
				.setStandardSlotBackground();

		builder.addOutputSlot(61, 19)
				.setOutputSlotBackground()
				.addItemStack(ClayworksRecipes.getResultItem(recipe));
	}

	@Override
	public void createRecipeExtras(IRecipeExtrasBuilder builder, RecipeHolder<BakingRecipe> recipeHolder, IFocusGroup focuses) {
		BakingRecipe recipe = recipeHolder.value();
		int cookTime = recipe.getCookingTime();
		if (cookTime <= 0) {
			cookTime = regularCookTime;
		}
		builder.addAnimatedRecipeArrow(cookTime)
				.setPosition(26, 17);
		builder.addAnimatedRecipeFlame(300)
				.setPosition(1, 20);

		addExperience(builder, recipeHolder);
		addCookTime(builder, recipeHolder);
	}

	protected void addExperience(IRecipeExtrasBuilder builder, RecipeHolder<BakingRecipe> recipeHolder) {
		BakingRecipe recipe = recipeHolder.value();
		float experience = recipe.getExperience();
		if (experience > 0) {
			Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
			builder.addText(experienceString, getWidth() - 20, 10)
					.setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.RIGHT, VerticalAlignment.TOP)
					.setTextAlignment(HorizontalAlignment.RIGHT)
					.setColor(0xFF808080);
		}
	}

	protected void addCookTime(IRecipeExtrasBuilder builder, RecipeHolder<BakingRecipe> recipeHolder) {
		BakingRecipe recipe = recipeHolder.value();
		int cookTime = recipe.getCookingTime();
		if (cookTime <= 0) {
			cookTime = regularCookTime;
		}
		if (cookTime > 0) {
			int cookTimeSeconds = cookTime / 20;
			Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
			builder.addText(timeString, getWidth() - 20, 10)
					.setPosition(0, 0, getWidth(), getHeight(), HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM)
					.setTextAlignment(HorizontalAlignment.RIGHT)
					.setTextAlignment(VerticalAlignment.BOTTOM)
					.setColor(0xFF808080);
		}
	}

	@Override
	public boolean isHandled(RecipeHolder<BakingRecipe> recipeHolder) {
		BakingRecipe recipe = recipeHolder.value();
		return !recipe.isSpecial();
	}

	@Override
	public ResourceLocation getRegistryName(RecipeHolder<BakingRecipe> recipe) {
		return recipe.id();
	}

	@Override
	public Codec<RecipeHolder<BakingRecipe>> getCodec(ICodecHelper codecHelper, IRecipeManager recipeManager) {
		return codecHelper.getRecipeHolderCodec();
	}
}