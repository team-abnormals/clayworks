package com.teamabnormals.clayworks.common.block;

import com.teamabnormals.clayworks.core.registry.ClayworksBlocks.ClayworksProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlassDoorBlock extends DoorBlock {
	private final DyeColor color;

	public GlassDoorBlock() {
		super(ClayworksProperties.GLASS_BLOCK_SET, ClayworksProperties.GLASS);
		this.color = null;
	}

	public GlassDoorBlock(DyeColor color) {
		super(ClayworksProperties.GLASS_BLOCK_SET, ClayworksProperties.stainedGlass(color));
		this.color = color;
	}

	@Override
	protected VoxelShape getVisualShape(BlockState p_309057_, BlockGetter p_308936_, BlockPos p_308956_, CollisionContext p_309006_) {
		return Shapes.empty();
	}
}