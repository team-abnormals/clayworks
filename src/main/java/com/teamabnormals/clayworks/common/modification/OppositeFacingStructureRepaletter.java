package com.teamabnormals.clayworks.common.modification;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamabnormals.blueprint.common.world.modification.structure.StructureRepaletter;
import net.minecraft.core.Registry;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.Nullable;
import java.util.Random;

public record OppositeFacingStructureRepaletter(Block replacesBlock, Block replacesWith) implements StructureRepaletter {
	@SuppressWarnings("deprecation")
	public static final Codec<OppositeFacingStructureRepaletter> CODEC = RecordCodecBuilder.create(instance -> {
		return instance.group(
				Registry.BLOCK.byNameCodec().fieldOf("replaces_block").forGetter(repaletter -> repaletter.replacesBlock),
				Registry.BLOCK.byNameCodec().fieldOf("replaces_with").forGetter(repaletter -> repaletter.replacesWith)
		).apply(instance, OppositeFacingStructureRepaletter::new);
	});

	@Nullable
	@Override
	public BlockState getReplacement(ServerLevelAccessor level, BlockState state, Random random) {
		return state.is(this.replacesBlock) ? state.hasProperty(BlockStateProperties.FACING) ? this.replacesWith.withPropertiesOf(state).setValue(BlockStateProperties.FACING, state.getValue(BlockStateProperties.FACING).getOpposite()) : this.replacesWith.withPropertiesOf(state) : null;
	}

	@Override
	public Codec<? extends StructureRepaletter> codec() {
		return CODEC;
	}
}