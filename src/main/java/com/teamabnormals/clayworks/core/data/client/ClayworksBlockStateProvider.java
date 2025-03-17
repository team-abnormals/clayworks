package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.other.ClayworksBlockFamilies;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelFile.ExistingModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Map;

import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

public class ClayworksBlockStateProvider extends BlueprintBlockStateProvider {

	public ClayworksBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, Clayworks.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.furnace(KILN);
		this.craftingTable(POTTERY_TABLE);
		this.block(CHISELED_BRICKS);
		this.glazedTerracotta(GLAZED_TERRACOTTA);
		this.block(CONCRETE);
		this.concretePowder(CONCRETE_POWDER);

		this.blockFamily(ClayworksBlockFamilies.TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.WHITE_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.ORANGE_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.MAGENTA_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.YELLOW_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.LIME_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.PINK_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.GRAY_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.CYAN_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.PURPLE_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.BLUE_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.BROWN_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.GREEN_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.RED_TERRACOTTA);
		this.blockFamily(ClayworksBlockFamilies.BLACK_TERRACOTTA);

		this.blockFamily(ClayworksBlockFamilies.TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.WHITE_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.ORANGE_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.MAGENTA_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.YELLOW_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.LIME_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.PINK_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.GRAY_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.CYAN_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.PURPLE_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.BLUE_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.BROWN_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.GREEN_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.RED_TERRACOTTA_BRICKS);
		this.blockFamily(ClayworksBlockFamilies.BLACK_TERRACOTTA_BRICKS);

		this.decoratedPot(WHITE_DECORATED_POT, Blocks.WHITE_TERRACOTTA);
		this.decoratedPot(ORANGE_DECORATED_POT, Blocks.ORANGE_TERRACOTTA);
		this.decoratedPot(MAGENTA_DECORATED_POT, Blocks.MAGENTA_TERRACOTTA);
		this.decoratedPot(LIGHT_BLUE_DECORATED_POT, Blocks.LIGHT_BLUE_TERRACOTTA);
		this.decoratedPot(YELLOW_DECORATED_POT, Blocks.YELLOW_TERRACOTTA);
		this.decoratedPot(LIME_DECORATED_POT, Blocks.LIME_TERRACOTTA);
		this.decoratedPot(PINK_DECORATED_POT, Blocks.PINK_TERRACOTTA);
		this.decoratedPot(GRAY_DECORATED_POT, Blocks.GRAY_TERRACOTTA);
		this.decoratedPot(LIGHT_GRAY_DECORATED_POT, Blocks.LIGHT_GRAY_TERRACOTTA);
		this.decoratedPot(CYAN_DECORATED_POT, Blocks.CYAN_TERRACOTTA);
		this.decoratedPot(PURPLE_DECORATED_POT, Blocks.PURPLE_TERRACOTTA);
		this.decoratedPot(BLUE_DECORATED_POT, Blocks.BLUE_TERRACOTTA);
		this.decoratedPot(BROWN_DECORATED_POT, Blocks.BROWN_TERRACOTTA);
		this.decoratedPot(GREEN_DECORATED_POT, Blocks.GREEN_TERRACOTTA);
		this.decoratedPot(RED_DECORATED_POT, Blocks.RED_TERRACOTTA);
		this.decoratedPot(BLACK_DECORATED_POT, Blocks.BLACK_TERRACOTTA);
	}

	public void decoratedPot(DeferredBlock<Block> block, Block parent) {
		this.simpleBlock(block.get(), particle(block, blockTexture(parent)));
		this.itemModels().getBuilder(name(block.get())).parent(new ExistingModelFile(ResourceLocation.withDefaultNamespace("item/decorated_pot"), this.models().existingFileHelper));
	}

	public void glazedTerracotta(DeferredBlock<Block> block) {
		this.horizontalBlock(block.get(), models().withExistingParent(name(block.get()), "template_glazed_terracotta").texture("pattern", blockTexture(block.get())), 0);
		this.blockItem(block);
	}

	public void concretePowder(DeferredBlock<Block> block) {
		ModelFile model = models().cubeAll(name(block.get()), blockTexture(block.get()));
		this.getVariantBuilder(block.get()).forAllStates(state ->
				ConfiguredModel.builder()
						.modelFile(model).nextModel()
						.modelFile(model).rotationY(90).nextModel()
						.modelFile(model).rotationY(180).nextModel()
						.modelFile(model).rotationY(270).build());
		this.simpleBlockItem(block.get(), model);
	}

	public void furnace(DeferredBlock<Block> DeferredBlock) {
		Block block = DeferredBlock.get();
		ModelFile furnace = models().cube(name(block), suffix(blockTexture(block), "_bottom"), suffix(blockTexture(block), "_top"), suffix(blockTexture(block), "_front"), suffix(blockTexture(block), "_back"), suffix(blockTexture(block), "_left"), suffix(blockTexture(block), "_right")).texture("particle", suffix(blockTexture(block), "_back"));
		ModelFile furnaceOn = models().cube(name(block) + "_on", suffix(blockTexture(block), "_bottom"), suffix(blockTexture(block), "_top_on"), suffix(blockTexture(block), "_front_on"), suffix(blockTexture(block), "_back"), suffix(blockTexture(block), "_left"), suffix(blockTexture(block), "_right")).texture("particle", suffix(blockTexture(block), "_back"));
		this.horizontalBlock(block, (state -> state.getValue(BlockStateProperties.LIT) ? furnaceOn : furnace));
		this.blockItem(block);
	}

	public void craftingTable(DeferredBlock<Block> registryObject) {
		Block block = registryObject.get();
		ResourceLocation texture = suffix(blockTexture(block), "_");
		this.simpleBlock(registryObject.get(), models()
				.cube(name(block),
						suffix(texture, "bottom"),
						suffix(texture, "top"),
						suffix(texture, "front"),
						suffix(texture, "front"),
						suffix(texture, "side"),
						suffix(texture, "side")
				).texture("particle", suffix(texture, "front")));
		this.blockItem(block);
	}

	@Override
	public void blockFamily(BlockFamily family) {
		super.blockFamily(family);
		Map<Variant, Block> variants = family.getVariants();
		if (variants.containsKey(Variant.CHISELED)) {
			this.block(family.get(Variant.CHISELED));
		}
	}

	@Override
	public void baseBlocks(Block block, Block stairs, Block slab, Block wall) {
		if (!BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("minecraft"))
			this.block(block);
		this.stairsBlock(block, stairs);
		this.slabBlock(block, slab);
		this.wallBlock(block, wall);
	}
}