package com.teamabnormals.clayworks.client.gui.screens.inventory;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.common.inventory.PotteryMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class PotteryScreen extends AbstractContainerScreen<PotteryMenu> {
	private static final ResourceLocation BANNER_SLOT_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/banner_slot");
	private static final ResourceLocation DYE_SLOT_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/dye_slot");
	private static final ResourceLocation PATTERN_SLOT_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/pattern_slot");
	private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/scroller");
	private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/scroller_disabled");
	private static final ResourceLocation PATTERN_SELECTED_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/pattern_selected");
	private static final ResourceLocation PATTERN_HIGHLIGHTED_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/pattern_highlighted");
	private static final ResourceLocation PATTERN_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/pattern");
	private static final ResourceLocation ERROR_SPRITE = ResourceLocation.withDefaultNamespace("container/loom/error");
	private static final ResourceLocation BG_LOCATION = ResourceLocation.withDefaultNamespace("textures/gui/container/loom.png");
	private static final int PATTERN_COLUMNS = 4;
	private static final int PATTERN_ROWS = 4;
	private static final int SCROLLER_WIDTH = 12;
	private static final int SCROLLER_HEIGHT = 15;
	private static final int PATTERN_IMAGE_SIZE = 14;
	private static final int SCROLLER_FULL_HEIGHT = 56;
	private static final int PATTERNS_X = 60;
	private static final int PATTERNS_Y = 13;
	@Nullable
	private BannerPatternLayers resultBannerPatterns;
	private ItemStack decoratedPotStack = ItemStack.EMPTY;
	private ItemStack dyeStack = ItemStack.EMPTY;
	private ItemStack trimMaterialStack = ItemStack.EMPTY;
	private boolean displayPatterns;
	private boolean hasMaxPatterns;
	private float scrollOffs;
	private boolean scrolling;
	private int startRow;

	public PotteryScreen(PotteryMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		menu.registerUpdateListener(this::containerChanged);
		this.titleLabelY -= 2;
	}

	@Override
	protected void init() {
		super.init();
		// this.flag = this.minecraft.getEntityModels().bakeLayer(ModelLayers.BANNER).getChild("flag");
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
			guiGraphics.blitSprite(PATTERN_SLOT_SPRITE, i + slot2.x, j + slot2.y, 16, 16);
		}

		int k = (int) (41.0F * this.scrollOffs);
		ResourceLocation resourcelocation = this.displayPatterns ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
		guiGraphics.blitSprite(resourcelocation, i + 119, j + 13 + k, 12, 15);
		Lighting.setupForFlatItems();
		if (this.resultBannerPatterns != null && !this.hasMaxPatterns) {
			guiGraphics.pose().pushPose();
			guiGraphics.pose().translate((float) (i + 139), (float) (j + 52), 0.0F);
			guiGraphics.pose().scale(24.0F, 24.0F, 1.0F);
			guiGraphics.pose().translate(0.5F, -0.5F, 0.5F);
			float f = 0.6666667F;
			guiGraphics.pose().scale(0.6666667F, 0.6666667F, -0.6666667F);

//			DyeColor dyecolor = ((BannerItem) slot3.getItem().getItem()).getColor();
//			BannerRenderer.renderPatterns(
//					guiGraphics.pose(),
//					guiGraphics.bufferSource(),
//					15728880,
//					OverlayTexture.NO_OVERLAY,
//					this.flag,
//					ModelBakery.BANNER_BASE,
//					true,
//					dyecolor,
//					this.resultBannerPatterns
//			);
			guiGraphics.pose().popPose();
			guiGraphics.flush();
		} else if (this.hasMaxPatterns) {
			guiGraphics.blitSprite(ERROR_SPRITE, i + slot3.x - 5, j + slot3.y - 5, 26, 26);
		}

		if (this.displayPatterns) {
			int j2 = i + 60;
			int k2 = j + 13;
			List<Holder<DecoratedPotTrimPattern>> list = this.menu.getSelectablePatterns();

			label64:
			for (int l = 0; l < 4; l++) {
				for (int i1 = 0; i1 < 4; i1++) {
					int j1 = l + this.startRow;
					int k1 = j1 * 4 + i1;
					if (k1 >= list.size()) {
						break label64;
					}

					int l1 = j2 + i1 * 14;
					int i2 = k2 + l * 14;
					boolean flag = mouseX >= l1 && mouseY >= i2 && mouseX < l1 + 14 && mouseY < i2 + 14;
					ResourceLocation resourcelocation1;
					if (k1 == this.menu.getSelectedBannerPatternIndex()) {
						resourcelocation1 = PATTERN_SELECTED_SPRITE;
					} else if (flag) {
						resourcelocation1 = PATTERN_HIGHLIGHTED_SPRITE;
					} else {
						resourcelocation1 = PATTERN_SPRITE;
					}

					guiGraphics.blitSprite(resourcelocation1, l1, i2, 14, 14);
					this.renderPattern(guiGraphics, list.get(k1), l1, i2);
				}
			}
		}

		Lighting.setupFor3DItems();
	}

	private void renderPattern(GuiGraphics guiGraphics, Holder<DecoratedPotTrimPattern> pattern, int x, int y) {
		PoseStack posestack = new PoseStack();
		posestack.pushPose();
		posestack.translate((float) x + 0.5F, (float) (y + 16), 0.0F);
		posestack.scale(6.0F, -6.0F, 1.0F);
		posestack.translate(0.5F, 0.5F, 0.0F);
		posestack.translate(0.5F, 0.5F, 0.5F);
		float f = 0.6666667F;
		posestack.scale(0.6666667F, -0.6666667F, -0.6666667F);

//		BannerPatternLayers bannerpatternlayers = new BannerPatternLayers.Builder().add(pattern, DyeColor.WHITE).build();
//		BannerRenderer.renderPatterns(
//				posestack,
//				guiGraphics.bufferSource(),
//				15728880,
//				OverlayTexture.NO_OVERLAY,
//				this.flag,
//				ModelBakery.BANNER_BASE,
//				true,
//				DyeColor.GRAY,
//				bannerpatternlayers
//		);
		posestack.popPose();
		guiGraphics.flush();
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
			int i = this.leftPos + 60;
			int j = this.topPos + 13;

			for (int k = 0; k < 4; k++) {
				for (int l = 0; l < 4; l++) {
					double d0 = mouseX - (double) (i + l * 14);
					double d1 = mouseY - (double) (j + k * 14);
					int i1 = k + this.startRow;
					int j1 = i1 * 4 + l;
					if (d0 >= 0.0 && d1 >= 0.0 && d0 < 14.0 && d1 < 14.0 && this.menu.clickMenuButton(this.minecraft.player, j1)) {
						Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_LOOM_SELECT_PATTERN, 1.0F));
						this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, j1);
						return true;
					}
				}
			}

			i = this.leftPos + 119;
			j = this.topPos + 9;
			if (mouseX >= (double) i && mouseX < (double) (i + 12) && mouseY >= (double) j && mouseY < (double) (j + 56)) {
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
			int j = this.topPos + 13;
			int k = j + 56;
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
		ItemStack itemstack = this.menu.getResultSlot().getItem();

		ItemStack pot = this.menu.getDecoratedPotSlot().getItem();
		ItemStack dye = this.menu.getDyeSlot().getItem();
		ItemStack trimMaterial = this.menu.getTrimMaterialSlot().getItem();

		if (!ItemStack.matches(pot, this.decoratedPotStack)
				|| !ItemStack.matches(dye, this.dyeStack)
				|| !ItemStack.matches(trimMaterial, this.trimMaterialStack)) {
			this.displayPatterns = !pot.isEmpty() && !trimMaterial.isEmpty() && !this.hasMaxPatterns && !this.menu.getSelectablePatterns().isEmpty();
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
