package com.teamabnormals.clayworks.common.block;

import com.mojang.serialization.MapCodec;
import com.teamabnormals.clayworks.common.inventory.PotteryMenu;
import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class PotteryTableBlock extends CraftingTableBlock {
	public static final MapCodec<PotteryTableBlock> CODEC = simpleCodec(PotteryTableBlock::new);
	public static final Component CONTAINER_TITLE = Component.translatable("container." + Clayworks.MOD_ID + ".pottery_table");

	@Override
	public MapCodec<PotteryTableBlock> codec() {
		return CODEC;
	}

	public PotteryTableBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if (level.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			player.openMenu(state.getMenuProvider(level, pos));
			player.awardStat(Stats.INTERACT_WITH_LOOM);
			return InteractionResult.CONSUME;
		}
	}

	@Override
	protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
		return new SimpleMenuProvider(
				(p_54783_, p_54784_, p_54785_) -> new PotteryMenu(p_54783_, p_54784_, ContainerLevelAccess.create(level, pos)), CONTAINER_TITLE
		);
	}
}