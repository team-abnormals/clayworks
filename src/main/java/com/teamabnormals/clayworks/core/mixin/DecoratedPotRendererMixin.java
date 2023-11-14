package com.teamabnormals.clayworks.core.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksMaterials;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(DecoratedPotRenderer.class)
public abstract class DecoratedPotRendererMixin {

	@Shadow
	@Nullable
	private static Material getMaterial(Item item) {
		return null;
	}

	@Shadow
	@Final
	private ModelPart frontSide;

	@Shadow
	@Final
	private ModelPart backSide;

	@Shadow
	@Final
	private ModelPart leftSide;

	@Shadow
	@Final
	private ModelPart rightSide;

	@ModifyVariable(method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/resources/model/Material;buffer(Lnet/minecraft/client/renderer/MultiBufferSource;Ljava/util/function/Function;)Lcom/mojang/blaze3d/vertex/VertexConsumer;", shift = At.Shift.AFTER))
	private VertexConsumer render(VertexConsumer consumer, DecoratedPotBlockEntity entity, float p_273103_, PoseStack poseStack, MultiBufferSource buffer, int p_273407_, int p_273059_) {
		DyeColor color = ClayworksBlocks.getDyeColorFromPot(entity.getBlockState().getBlock());
		if (color != null) {
			return ClayworksMaterials.getDecoratedPotMaterial(DecoratedPotPatterns.BASE, color).buffer(buffer, RenderType::entitySolid);
		}

		return consumer;
	}

	@Redirect(method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/DecoratedPotRenderer;getMaterial(Lnet/minecraft/world/item/Item;)Lnet/minecraft/client/resources/model/Material;"))
	private Material render(Item item, DecoratedPotBlockEntity entity) {
		Material material = Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.getResourceKey(item));
		DyeColor color = ClayworksBlocks.getDyeColorFromPot(entity.getBlockState().getBlock());
		if (color != null) {
			return ClayworksMaterials.getDecoratedPotMaterial(DecoratedPotPatterns.getResourceKey(material == null ? Items.BRICK : item), color);
		}

		return getMaterial(item);
	}

	@Inject(method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V", shift = Shift.BEFORE))
	private void render(DecoratedPotBlockEntity entity, float p_273103_, PoseStack poseStack, MultiBufferSource buffer, int p_273407_, int p_273059_, CallbackInfo ci) {
		Material material = ClayworksMaterials.createTrimMaterial(new ResourceLocation(Clayworks.MOD_ID, "trims/decorated_pot_base"), ClayworksBlocks.getDyeColorFromPot(entity.getBlockState().getBlock()));
		this.frontSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), p_273407_, p_273059_);
		this.backSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), p_273407_, p_273059_);
		this.leftSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), p_273407_, p_273059_);
		this.rightSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), p_273407_, p_273059_);

		if (entity instanceof TrimmedPot trimmedPot && trimmedPot.getTrim().isPresent()) {
			ResourceLocation trimKey = ForgeRegistries.ITEMS.getKey(trimmedPot.getTrim().get());
			if (trimKey != null) {
				ResourceLocation trimTexture = new ResourceLocation(Clayworks.MOD_ID, "textures/entity/decorated_pot/trims/" + trimKey.getPath() + ".png");

				this.frontSide.render(poseStack, buffer.getBuffer(RenderType.entityCutout(trimTexture)), p_273407_, p_273059_);
				this.backSide.render(poseStack, buffer.getBuffer(RenderType.entityCutout(trimTexture)), p_273407_, p_273059_);
				this.leftSide.render(poseStack, buffer.getBuffer(RenderType.entityCutout(trimTexture)), p_273407_, p_273059_);
				this.rightSide.render(poseStack, buffer.getBuffer(RenderType.entityCutout(trimTexture)), p_273407_, p_273059_);
			}
		}
	}
}
