package com.teamabnormals.clayworks.integration.jei;

import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.gui.widgets.IRecipeWidget;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static mezz.jei.api.recipe.RecipeIngredientRole.*;

public class BakingCategory implements IRecipeCategory<BakingRecipe> {
	public static final String TRANSLATION = "gui." + Clayworks.MOD_ID + ".category.baking";

	private final IDrawable background;
	private final IDrawable icon;
	private final Component localizedName;
	protected final IGuiHelper guiHelper;
	protected final int regularCookTime;
	protected final IDrawableAnimated animatedFlame;

	public BakingCategory(IGuiHelper guiHelper) {
		this(guiHelper, TRANSLATION, 100, 82, 54);
	}

	public BakingCategory(IGuiHelper guiHelper, String translationKey, int regularCookTime, int width, int height) {
		this.background = guiHelper.createBlankDrawable(width, height);
		this.regularCookTime = regularCookTime;
		this.icon = guiHelper.createDrawableItemLike(ClayworksBlocks.KILN.get());
		this.localizedName = Component.translatable(translationKey);
		this.guiHelper = guiHelper;
		this.animatedFlame = guiHelper.createAnimatedRecipeFlame(300);
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void draw(BakingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		animatedFlame.draw(guiGraphics, 1, 20);
		drawExperience(recipe, guiGraphics, 0);
		drawCookTime(recipe, guiGraphics, 45);
	}

	protected void drawExperience(BakingRecipe recipe, GuiGraphics guiGraphics, int y) {
		float experience = recipe.getExperience();
		if (experience > 0) {
			Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
			Minecraft minecraft = Minecraft.getInstance();
			Font fontRenderer = minecraft.font;
			int stringWidth = fontRenderer.width(experienceString);
			guiGraphics.drawString(fontRenderer, experienceString, getWidth() - stringWidth, y, 0xFF808080, false);
		}
	}

	protected void drawCookTime(BakingRecipe recipe, GuiGraphics guiGraphics, int y) {
		int cookTime = recipe.getCookingTime();
		if (cookTime > 0) {
			int cookTimeSeconds = cookTime / 20;
			Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
			Minecraft minecraft = Minecraft.getInstance();
			Font fontRenderer = minecraft.font;
			int stringWidth = fontRenderer.width(timeString);
			guiGraphics.drawString(fontRenderer, timeString, getWidth() - stringWidth, y, 0xFF808080, false);
		}
	}


	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, BakingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(INPUT, 1, 1)
				.setStandardSlotBackground()
				.addIngredients(recipe.getIngredients().get(0));

		builder.addSlot(RENDER_ONLY, 1, 37)
				.setStandardSlotBackground();

		builder.addSlot(OUTPUT, 61, 19)
				.setOutputSlotBackground()
				.addItemStack(ClayworksRecipes.getResultItem(recipe));
	}

	@Override
	public void createRecipeExtras(IRecipeExtrasBuilder acceptor, BakingRecipe recipe, IFocusGroup focuses) {
		acceptor.addWidget(createCookingArrowWidget(recipe, 26, 17));
	}

	@Override
	public boolean isHandled(BakingRecipe recipe) {
		return !recipe.isSpecial();
	}

	@Override
	public RecipeType<BakingRecipe> getRecipeType() {
		return ClayworksPlugin.BAKING;
	}

	@Override
	public Component getTitle() {
		return this.localizedName;
	}

	@Override
	public ResourceLocation getRegistryName(BakingRecipe recipe) {
		return recipe.getId();
	}

	protected IRecipeWidget createCookingArrowWidget(BakingRecipe recipe, int x, int y) {
		int cookTime = recipe.getCookingTime();
		if (cookTime <= 0) {
			cookTime = regularCookTime;
		}
		IDrawableAnimated recipeArrow = guiHelper.createAnimatedRecipeArrow(cookTime);
		return guiHelper.createWidgetFromDrawable(recipeArrow, x, y);
	}
}