package com.teamabnormals.clayworks.client.gui.screens.inventory;

import com.mojang.blaze3d.platform.Lighting;
import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.common.inventory.PotteryMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CyclingSlotBackground;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class PotteryScreen extends AbstractContainerScreen<PotteryMenu> {
	private static final ResourceLocation BANNER_SLOT_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/banner_slot");
	private static final ResourceLocation DYE_SLOT_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/dye_slot");
	private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller");
	private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/scroller_disabled");
	private static final ResourceLocation PATTERN_SELECTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_selected");
	private static final ResourceLocation PATTERN_HIGHLIGHTED_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_highlighted");
	private static final ResourceLocation PATTERN_SPRITE = ResourceLocation.withDefaultNamespace("container/stonecutter/recipe");

	private static final ResourceLocation BG_LOCATION = Clayworks.location("textures/gui/container/pottery_table.png");

	private ItemStack decoratedPotStack = ItemStack.EMPTY;
	private ItemStack dyeStack = ItemStack.EMPTY;
	private ItemStack trimMaterialStack = ItemStack.EMPTY;

	private boolean displayPatterns;
	private float scrollOffs;
	private boolean scrolling;
	private int startRow;

	private final CyclingSlotBackground additionalIcon = new CyclingSlotBackground(2);

	public PotteryScreen(PotteryMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		menu.registerUpdateListener(this::containerChanged);
		this.titleLabelY -= 2;
	}

	@Override
	protected void init() {
		super.init();
	}

	/**
	 * Renders the graphical user interface (GUI) element.
	 *
	 * @param guiGraphics the GuiGraphics object used for rendering.
	 * @param mouseX      the x-coordinate of the mouse cursor.
	 * @param mouseY      the y-coordinate of the mouse cursor.
	 * @param partialTick the partial tick time.
	 */
	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
		super.render(guiGraphics, mouseX, mouseY, partialTick);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		this.additionalIcon.tick(SmithingTemplateItem.createTrimmableMaterialIconList());
	}

	private int totalRowCount() {
		return Mth.positiveCeilDiv(this.menu.getSelectablePatterns().size(), 4);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
		int i = this.leftPos;
		int j = this.topPos;
		guiGraphics.blit(BG_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
		Slot slot = this.menu.getDecoratedPotSlot();
		Slot slot1 = this.menu.getDyeSlot();
		Slot slot2 = this.menu.getTrimMaterialSlot();
		Slot slot3 = this.menu.getResultSlot();
		if (!slot.hasItem()) {
			guiGraphics.blitSprite(BANNER_SLOT_SPRITE, i + slot.x, j + slot.y, 16, 16);
		}

		if (!slot1.hasItem()) {
			guiGraphics.blitSprite(DYE_SLOT_SPRITE, i + slot1.x, j + slot1.y, 16, 16);
		}

		if (!slot2.hasItem()) {
			this.additionalIcon.render(this.menu, guiGraphics, partialTick, i, j);
		}

		int k = (int) (41.0F * this.scrollOffs);
		ResourceLocation resourcelocation = this.displayPatterns ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
		guiGraphics.blitSprite(resourcelocation, i + 119, j + 15 + k, 12, 15);
		Lighting.setupForFlatItems();

		if (this.displayPatterns) {
			int j2 = i + 52;
			int k2 = j + 14;
			List<Holder<DecoratedPotTrimPattern>> list = this.menu.getSelectablePatterns();

			label64:
			for (int l = 0; l < 4; l++) {
				for (int i1 = 0; i1 < 4; i1++) {
					int j1 = l + this.startRow;
					int k1 = j1 * 4 + i1;
					if (k1 >= list.size()) {
						break label64;
					}

					int l1 = j2 + i1 * 16;
					int i2 = k2 + l * 18;
					boolean flag = mouseX >= l1 && mouseY >= i2 && mouseX < l1 + 16 && mouseY < i2 + 18;
					ResourceLocation resourcelocation1;
					if (k1 == this.menu.getSelectedBannerPatternIndex()) {
						resourcelocation1 = PATTERN_SELECTED_SPRITE;
					} else if (flag) {
						resourcelocation1 = PATTERN_HIGHLIGHTED_SPRITE;
					} else {
						resourcelocation1 = PATTERN_SPRITE;
					}

					guiGraphics.blitSprite(resourcelocation1, l1, i2 + 1, 16, 18);
					this.renderPattern(guiGraphics, list.get(k1), l1, i2 + 2);
				}
			}
		}

		Lighting.setupFor3DItems();
	}

	private void renderPattern(GuiGraphics guiGraphics, Holder<DecoratedPotTrimPattern> pattern, int x, int y) {
		guiGraphics.renderItem(this.menu.getResultStack(pattern), x, y);
	}

	/**
	 * Called when a mouse button is clicked within the GUI element.
	 * <p>
	 *
	 * @param mouseX the X coordinate of the mouse.
	 * @param mouseY the Y coordinate of the mouse.
	 * @param button the button that was clicked.
	 * @return {@code true} if the event is consumed, {@code false} otherwise.
	 */
	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		this.scrolling = false;
		if (this.displayPatterns) {
			int i = this.leftPos + 52;
			int j = this.topPos + 14;

			for (int k = 0; k < 4; k++) {
				for (int l = 0; l < 4; l++) {
					double d0 = mouseX - (double) (i + l * 16);
					double d1 = mouseY - (double) (j + k * 18);
					int i1 = k + this.startRow;
					int j1 = i1 * 4 + l;
					if (d0 >= 0.0 && d1 >= 0.0 && d0 < 16.0 && d1 < 18.0 && this.menu.clickMenuButton(this.minecraft.player, j1)) {
						Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_LOOM_SELECT_PATTERN, 1.0F));
						this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, j1);
						return true;
					}
				}
			}

			i = this.leftPos + 119;
			j = this.topPos + 9;
			if (mouseX >= (double) i && mouseX < (double) (i + 12) && mouseY >= (double) j && mouseY < (double) (j + 54)) {
				this.scrolling = true;
			}
		}

		return super.mouseClicked(mouseX, mouseY, button);
	}

	/**
	 * Called when the mouse is dragged within the GUI element.
	 * <p>
	 *
	 * @param mouseX the X coordinate of the mouse.
	 * @param mouseY the Y coordinate of the mouse.
	 * @param button the button that is being dragged.
	 * @param dragX  the X distance of the drag.
	 * @param dragY  the Y distance of the drag.
	 * @return {@code true} if the event is consumed, {@code false} otherwise.
	 */
	@Override
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		int i = this.totalRowCount() - 4;
		if (this.scrolling && this.displayPatterns && i > 0) {
			int j = this.topPos + 14;
			int k = j + 54;
			this.scrollOffs = ((float) mouseY - (float) j - 7.5F) / ((float) (k - j) - 15.0F);
			this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
			this.startRow = Math.max((int) ((double) (this.scrollOffs * (float) i) + 0.5), 0);
			return true;
		} else {
			return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
		}
	}

	@Override
	public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
		int i = this.totalRowCount() - 4;
		if (this.displayPatterns && i > 0) {
			float f = (float) scrollY / (float) i;
			this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
			this.startRow = Math.max((int) (this.scrollOffs * (float) i + 0.5F), 0);
		}

		return true;
	}

	@Override
	protected boolean hasClickedOutside(double mouseX, double mouseY, int guiLeft, int guiTop, int mouseButton) {
		return mouseX < (double) guiLeft
				|| mouseY < (double) guiTop
				|| mouseX >= (double) (guiLeft + this.imageWidth)
				|| mouseY >= (double) (guiTop + this.imageHeight);
	}

	private void containerChanged() {
		ItemStack pot = this.menu.getDecoratedPotSlot().getItem();
		ItemStack dye = this.menu.getDyeSlot().getItem();
		ItemStack trimMaterial = this.menu.getTrimMaterialSlot().getItem();

		if (!ItemStack.matches(pot, this.decoratedPotStack)
				|| !ItemStack.matches(dye, this.dyeStack)
				|| !ItemStack.matches(trimMaterial, this.trimMaterialStack)) {
			this.displayPatterns = !pot.isEmpty() && !this.menu.getSelectablePatterns().isEmpty();
		}

		if (this.startRow >= this.totalRowCount()) {
			this.startRow = 0;
			this.scrollOffs = 0.0F;
		}

		this.decoratedPotStack = pot.copy();
		this.dyeStack = dye.copy();
		this.trimMaterialStack = trimMaterial.copy();
	}
}
