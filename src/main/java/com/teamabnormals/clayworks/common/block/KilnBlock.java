package com.teamabnormals.clayworks.common.block;

import com.teamabnormals.clayworks.common.block.entity.KilnBlockEntity;
import com.teamabnormals.clayworks.core.registry.ClayworksBlockEntityTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksParticleTypes;
import com.teamabnormals.clayworks.core.registry.ClayworksSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class KilnBlock extends AbstractFurnaceBlock {
	public KilnBlock(Properties properties) {
		super(properties);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new KilnBlockEntity(pos, state);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return createFurnaceTicker(level, blockEntityType, ClayworksBlockEntityTypes.KILN.get());
	}

	@Override
	protected void openContainer(Level worldIn, BlockPos pos, Player player) {
		BlockEntity tileentity = worldIn.getBlockEntity(pos);
		if (tileentity instanceof KilnBlockEntity) {
			player.openMenu((MenuProvider) tileentity);
			player.awardStat(Stats.INTERACT_WITH_SMOKER);
		}
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, RandomSource rand) {
		if (stateIn.getValue(LIT)) {
			double d0 = pos.getX() + 0.5D;
			double d1 = pos.getY();
			double d2 = pos.getZ() + 0.5D;
			if (rand.nextDouble() < 0.1D) {
				worldIn.playLocalSound(d0, d1, d2, ClayworksSoundEvents.KILN_SMOKE.get(), SoundSource.BLOCKS, 1.0F, 1.0F, false);
			}
			SimpleParticleType particleType = ClayworksParticleTypes.KILN_SMOKE.get();
			worldIn.addAlwaysVisibleParticle(particleType, true, d0 + rand.nextDouble() / 8.0D * (rand.nextBoolean() ? 1 : -1), d1 + rand.nextDouble() + rand.nextDouble() * 0.5D, d2 + rand.nextDouble() / 8.0D * (rand.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
		}
	}
}