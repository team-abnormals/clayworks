package com.teamabnormals.clayworks.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnSmokeParticle extends TextureSheetParticle {

	private KilnSmokeParticle(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		super(world, x, y, z);
		this.quadSize *= 2.5F;
		this.lifetime = this.random.nextInt(50) + 40;

		this.gravity = 3.0E-6F;
		this.xd = motionX;
		this.yd = motionY + (double) (this.random.nextFloat() / 500.0F);
		this.zd = motionZ;
	}

	@Override
	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
			this.xd += (this.random.nextFloat() / 5000.0F * (float) (this.random.nextBoolean() ? 1 : -1));
			this.zd += (this.random.nextFloat() / 5000.0F * (float) (this.random.nextBoolean() ? 1 : -1));
			this.yd -= this.gravity;
			this.move(this.xd, this.yd, this.zd);
			if (this.age >= this.lifetime - 60 && this.alpha > 0.01F) {
				this.alpha -= 0.015F;
			}

		} else {
			this.remove();
		}
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public Factory(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType type, ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ) {
			KilnSmokeParticle particle = new KilnSmokeParticle(world, x, y, z, motionX, motionY, motionZ);
			particle.setAlpha(0.9F);
			particle.pickSprite(this.spriteSet);
			return particle;
		}
	}
}
