package com.teamabnormals.clayworks.common.inventory;

import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksDataComponents;
import com.teamabnormals.clayworks.core.registry.ClayworksMenuTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DecoratedPotBlock;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

public class PotteryMenu extends AbstractContainerMenu {
	private static final int PATTERN_NOT_SET = -1;
	private static final int INV_SLOT_START = 4;
	private static final int INV_SLOT_END = 31;
	private static final int USE_ROW_SLOT_START = 31;
	private static final int USE_ROW_SLOT_END = 40;
	private final ContainerLevelAccess access;
	final DataSlot selectedBannerPatternIndex = DataSlot.standalone();
	private List<Holder<DecoratedPotTrimPattern>> selectablePatterns = List.of();
	Runnable slotUpdateListener = () -> {
	};
	private final RegistryAccess registryAccess;
	final Slot decoratedPotSlot;
	final Slot dyeSlot;
	private final Slot trimMaterialSlot;
	private final Slot resultSlot;
	long lastSoundTime;
	private final Container inputContainer = new SimpleContainer(3) {
		@Override
		public void setChanged() {
			super.setChanged();
			PotteryMenu.this.slotsChanged(this);
			PotteryMenu.this.slotUpdateListener.run();
		}
	};
	private final Container outputContainer = new SimpleContainer(1) {
		@Override
		public void setChanged() {
			super.setChanged();
			PotteryMenu.this.slotUpdateListener.run();
		}
	};

	public PotteryMenu(int containerId, Inventory playerInventory) {
		this(containerId, playerInventory, ContainerLevelAccess.NULL);
	}

	public PotteryMenu(int containerId, Inventory playerInventory, final ContainerLevelAccess access) {
		super(ClayworksMenuTypes.POTTERY.get(), containerId);
		this.access = access;
		this.decoratedPotSlot = this.addSlot(new Slot(this.inputContainer, 0, 9, 26) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return Block.byItem(stack.getItem()) instanceof DecoratedPotBlock;
			}
		});
		this.dyeSlot = this.addSlot(new Slot(this.inputContainer, 1, 19, 45) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return stack.getItem() instanceof DyeItem;
			}
		});
		this.trimMaterialSlot = this.addSlot(new Slot(this.inputContainer, 2, 29, 26) {
			@Override
			public boolean mayPlace(ItemStack stack) {
				return stack.is(ItemTags.TRIM_MATERIALS);
			}
		});
		this.resultSlot = this.addSlot(new Slot(this.outputContainer, 0, 143, 33) {
			/**
			 * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
			 */
			@Override
			public boolean mayPlace(ItemStack stack) {
				return false;
			}

			@Override
			public void onTake(Player player, ItemStack stack) {
				PotteryMenu.this.decoratedPotSlot.remove(1);
				PotteryMenu.this.dyeSlot.remove(1);
				PotteryMenu.this.trimMaterialSlot.remove(1);

				access.execute((p_39952_, p_39953_) -> {
					long l = p_39952_.getGameTime();
					if (PotteryMenu.this.lastSoundTime != l) {
						p_39952_.playSound(null, p_39953_, SoundEvents.UI_LOOM_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
						PotteryMenu.this.lastSoundTime = l;
					}
				});
				super.onTake(player, stack);
			}
		});

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; k++) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}

		this.addDataSlot(this.selectedBannerPatternIndex);
		this.registryAccess = playerInventory.player.registryAccess();
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	@Override
	public boolean stillValid(Player player) {
		return stillValid(this.access, player, ClayworksBlocks.POTTERY_TABLE.get());
	}

	/**
	 * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
	 */
	@Override
	public boolean clickMenuButton(Player player, int id) {
		if (id >= 0 && id < this.selectablePatterns.size()) {
			this.selectedBannerPatternIndex.set(id);
			this.setupResultSlot(this.selectablePatterns.get(id));
			return true;
		} else {
			return false;
		}
	}

	private List<Holder<DecoratedPotTrimPattern>> getSelectablePatterns(ItemStack stack) {
		return this.registryAccess.registryOrThrow(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN).holders().collect(Collectors.toUnmodifiableList());
	}

	private boolean isValidPatternIndex(int index) {
		return index >= 0 && index < this.selectablePatterns.size();
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	@Override
	public void slotsChanged(Container inventory) {
		ItemStack potItem = this.decoratedPotSlot.getItem();
		ItemStack dyeItem = this.dyeSlot.getItem();
		ItemStack trimItem = this.trimMaterialSlot.getItem();
		if (!potItem.isEmpty() && (!dyeItem.isEmpty() || !trimItem.isEmpty())) {
			int i = this.selectedBannerPatternIndex.get();
			boolean flag = this.isValidPatternIndex(i);
			List<Holder<DecoratedPotTrimPattern>> list = this.selectablePatterns;
			this.selectablePatterns = this.getSelectablePatterns(trimItem);
			Holder<DecoratedPotTrimPattern> holder;
			if (this.selectablePatterns.size() == 1) {
				this.selectedBannerPatternIndex.set(0);
				holder = this.selectablePatterns.getFirst();
			} else if (!flag) {
				this.selectedBannerPatternIndex.set(-1);
				holder = null;
			} else {
				Holder<DecoratedPotTrimPattern> holder1 = list.get(i);
				int j = this.selectablePatterns.indexOf(holder1);
				if (j != -1) {
					holder = holder1;
					this.selectedBannerPatternIndex.set(j);
				} else {
					holder = null;
					this.selectedBannerPatternIndex.set(-1);
				}
			}

			this.setupResultSlot(holder);
			this.broadcastChanges();
		} else {
			this.resultSlot.set(ItemStack.EMPTY);
			this.selectablePatterns = List.of();
			this.selectedBannerPatternIndex.set(-1);
		}
	}

	public List<Holder<DecoratedPotTrimPattern>> getSelectablePatterns() {
		return this.selectablePatterns;
	}

	public int getSelectedBannerPatternIndex() {
		return this.selectedBannerPatternIndex.get();
	}

	public void registerUpdateListener(Runnable listener) {
		this.slotUpdateListener = listener;
	}

	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s).
	 */
	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index == this.resultSlot.index) {
				if (!this.moveItemStackTo(itemstack1, 4, 40, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(itemstack1, itemstack);
			} else if (index != this.dyeSlot.index && index != this.decoratedPotSlot.index && index != this.trimMaterialSlot.index) {
				if (Block.byItem(itemstack1.getItem()) instanceof DecoratedPotBlock) {
					if (!this.moveItemStackTo(itemstack1, this.decoratedPotSlot.index, this.decoratedPotSlot.index + 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if (itemstack1.getItem() instanceof DyeItem) {
					if (!this.moveItemStackTo(itemstack1, this.dyeSlot.index, this.dyeSlot.index + 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if (itemstack1.is(ItemTags.TRIM_MATERIALS)) {
					if (!this.moveItemStackTo(itemstack1, this.trimMaterialSlot.index, this.trimMaterialSlot.index + 1, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 4 && index < 31) {
					if (!this.moveItemStackTo(itemstack1, 31, 40, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 31 && index < 40 && !this.moveItemStackTo(itemstack1, 4, 31, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 4, 40, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.setByPlayer(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(player, itemstack1);
		}

		return itemstack;
	}

	/**
	 * Called when the container is closed.
	 */
	@Override
	public void removed(Player player) {
		super.removed(player);
		this.access.execute((p_39871_, p_39872_) -> this.clearContainer(player, this.inputContainer));
	}

	/**
	 * Creates an output banner ItemStack based on the patterns, dyes, etc. in the loom.
	 */
	public ItemStack getResultStack(@Nullable Holder<DecoratedPotTrimPattern> pattern) {
		ItemStack potItem = this.decoratedPotSlot.getItem();
		ItemStack dyeItem = this.dyeSlot.getItem();
		ItemStack trimItem = this.trimMaterialSlot.getItem();
		ItemStack output = ItemStack.EMPTY;
		if (!potItem.isEmpty()) {
			output = potItem.copyWithCount(1);
			if (!dyeItem.isEmpty()) {
				output = output.transmuteCopy(ClayworksBlocks.getPotFromDyeColor(((DyeItem) dyeItem.getItem()).getDyeColor()));
			}

			if (!trimItem.isEmpty() && pattern != null) {
				output.set(
						ClayworksDataComponents.POT_TRIM.get(),
						new DecoratedPotTrim(
								TrimMaterials.getFromIngredient(this.registryAccess, trimItem).get(),
								pattern,
								false
						)
				);
			}
		}

		return output;
	}

	private void setupResultSlot(@Nullable Holder<DecoratedPotTrimPattern> pattern) {
		ItemStack output = this.getResultStack(pattern);
		if (!ItemStack.matches(output, this.resultSlot.getItem())) {
			this.resultSlot.set(output);
		} else {
			this.resultSlot.set(ItemStack.EMPTY);
		}
	}

	public Slot getDecoratedPotSlot() {
		return this.decoratedPotSlot;
	}

	public Slot getDyeSlot() {
		return this.dyeSlot;
	}

	public Slot getTrimMaterialSlot() {
		return this.trimMaterialSlot;
	}

	public Slot getResultSlot() {
		return this.resultSlot;
	}
}
