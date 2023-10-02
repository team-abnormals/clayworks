package com.teamabnormals.clayworks.integration.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.teamabnormals.clayworks.common.item.crafting.BakingRecipe;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksRecipes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class BakingCategory implements IRecipeCategory<BakingRecipe> {
	public static final ResourceLocation RECIPE_GUI_VANILLA = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");
	public static final MutableComponent TRANSLATION = Component.translatable("gui." + Clayworks.MOD_ID + ".category.baking");

	private final IDrawable background;
	private final int regularCookTime;
	private final IDrawable icon;
	private final Component localizedName;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedFlame;

	public BakingCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(RECIPE_GUI_VANILLA, 0, 114, 82, 54);
		this.regularCookTime = 100;
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ClayworksBlocks.KILN.get()));
		this.localizedName = TRANSLATION;
		this.cachedArrows = CacheBuilder.newBuilder()
				.maximumSize(25)
				.build(new CacheLoader<>() {
					@Override
					public IDrawableAnimated load(Integer cookTime) {
						return guiHelper.drawableBuilder(RECIPE_GUI_VANILLA, 82, 128, 24, 17)
								.buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
					}
				});
		staticFlame = guiHelper.createDrawable(RECIPE_GUI_VANILLA, 82, 114, 14, 14);
		animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
	}

	protected IDrawableAnimated getArrow(BakingRecipe recipe) {
		int cookTime = recipe.getCookingTime();
		if (cookTime <= 0) {
			cookTime = regularCookTime;
		}
		return this.cachedArrows.getUnchecked(cookTime);
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

		IDrawableAnimated arrow = getArrow(recipe);
		arrow.draw(guiGraphics, 24, 18);

		drawExperience(recipe, guiGraphics, 0);
		drawCookTime(recipe, guiGraphics, 45);
	}

	protected void drawExperience(BakingRecipe recipe, GuiGraphics guiGraphics, int y) {
		float experience = recipe.getExperience();
		if (experience > 0) {
			MutableComponent experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
			Minecraft minecraft = Minecraft.getInstance();
			Font fontRenderer = minecraft.font;
			int stringWidth = fontRenderer.width(experienceString);
			guiGraphics.drawString(fontRenderer, experienceString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}

	protected void drawCookTime(BakingRecipe recipe, GuiGraphics guiGraphics, int y) {
		int cookTime = recipe.getCookingTime();
		if (cookTime > 0) {
			int cookTimeSeconds = cookTime / 20;
			MutableComponent timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
			Minecraft minecraft = Minecraft.getInstance();
			Font fontRenderer = minecraft.font;
			int stringWidth = fontRenderer.width(timeString);
			guiGraphics.drawString(fontRenderer, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
		}
	}


	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, BakingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(INPUT, 1, 1).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(OUTPUT, 61, 19).addItemStack(ClayworksRecipes.getResultItem(recipe));
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
}