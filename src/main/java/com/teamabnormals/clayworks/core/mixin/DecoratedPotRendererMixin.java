package com.teamabnormals.clayworks.core.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.teamabnormals.clayworks.common.DecoratedPotTrim;
import com.teamabnormals.clayworks.common.DecoratedPotTrimPattern;
import com.teamabnormals.clayworks.common.block.TrimmedPot;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.ClayworksConfig;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksMaterials;
import com.teamabnormals.clayworks.core.registry.ClayworksRegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(DecoratedPotRenderer.class)
public abstract class DecoratedPotRendererMixin {

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

	@Shadow
	private static Material getSideMaterial(Optional<Item> item) {
		return null;
	}

	@ModifyVariable(method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/client/resources/model/Material;buffer(Lnet/minecraft/client/renderer/MultiBufferSource;Ljava/util/function/Function;)Lcom/mojang/blaze3d/vertex/VertexConsumer;", shift = At.Shift.AFTER))
	private VertexConsumer render(VertexConsumer consumer, DecoratedPotBlockEntity entity, float p_273103_, PoseStack poseStack, MultiBufferSource buffer, int p_273407_, int p_273059_) {
		DyeColor color = ClayworksBlocks.getDyeColorFromPot(entity.getBlockState().getBlock());
		if (color != null) {
			return ClayworksMaterials.DECORATED_POT_BASE_MATERIALS.get(color).buffer(buffer, RenderType::entitySolid);
		}

		return consumer;
	}

	@Redirect(method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/DecoratedPotRenderer;getSideMaterial(Ljava/util/Optional;)Lnet/minecraft/client/resources/model/Material;"))
	private Material render(Optional<Item> optional, DecoratedPotBlockEntity entity) {
		Item item = optional.orElse(Items.BRICK);
		Material material = Sheets.getDecoratedPotMaterial(DecoratedPotPatterns.getPatternFromItem(item));
		DyeColor color = ClayworksBlocks.getDyeColorFromPot(entity.getBlockState().getBlock());
		if (color != null) {
			return ClayworksMaterials.getDecoratedPotMaterial(DecoratedPotPatterns.getPatternFromItem(material == null ? Items.BRICK : item), color);
		}

		return getSideMaterial(optional);
	}

	@Inject(method = "render(Lnet/minecraft/world/level/block/entity/DecoratedPotBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V", shift = Shift.BEFORE))
	private void render(DecoratedPotBlockEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay, CallbackInfo ci) {
		if (ClayworksConfig.COMMON.decoratedPotTrims.get()) {
			Material material = ClayworksMaterials.createTrimMaterial(Clayworks.location("decorated_pot_trim_base"), ClayworksBlocks.getDyeColorFromPot(entity.getBlockState().getBlock()));
			this.frontSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
			this.backSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
			this.leftSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
			this.rightSide.render(poseStack, material.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);

			if (entity instanceof TrimmedPot trimmedPot && trimmedPot.getTrim().isPresent()) {
				Optional<DecoratedPotTrim> potTrim = trimmedPot.getTrim();

				Holder<TrimMaterial> potMaterial = potTrim.get().material();
				Holder<DecoratedPotTrimPattern> potPattern = potTrim.get().pattern();

				ResourceLocation trimPattern = Minecraft.getInstance().level.registryAccess().registryOrThrow(ClayworksRegistries.DECORATED_POT_TRIM_PATTERN).get(potPattern.getKey()).assetId();
				Material trimMaterial = ClayworksMaterials.createTrimMaterial(trimPattern, (potMaterial.getKey().location().getNamespace() + "_" + potMaterial.getKey().location().getPath()).replace("minecraft_", ""));
				this.frontSide.render(poseStack, trimMaterial.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
				this.backSide.render(poseStack, trimMaterial.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
				this.leftSide.render(poseStack, trimMaterial.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
				this.rightSide.render(poseStack, trimMaterial.buffer(buffer, RenderType::entityCutout), packedLight, packedOverlay);
			}
		}
	}
}
