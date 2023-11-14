package com.teamabnormals.clayworks.core.data.client;

import com.teamabnormals.blueprint.common.block.quark.VerticalSlabBlock;
import com.teamabnormals.blueprint.common.block.quark.VerticalSlabBlock.VerticalSlabType;
import com.teamabnormals.blueprint.core.Blueprint;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.other.ClayworksBlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.BlockFamily.Variant;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import static com.teamabnormals.clayworks.core.registry.ClayworksBlocks.*;

public class ClayworksBlockStateProvider extends BlockStateProvider {

	public ClayworksBlockStateProvider(PackOutput output, ExistingFileHelper fileHelper) {
		super(output, Clayworks.MOD_ID, fileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.furnace(KILN.get());
		this.block(CHISELED_BRICKS.get());
		this.glazedTerracotta(GLAZED_TERRACOTTA.get());

		this.blockFamily(ClayworksBlockFamilies.TERRACOTTA, TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.WHITE_TERRACOTTA, WHITE_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.ORANGE_TERRACOTTA, ORANGE_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.MAGENTA_TERRACOTTA, MAGENTA_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA, LIGHT_BLUE_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.YELLOW_TERRACOTTA, YELLOW_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.LIME_TERRACOTTA, LIME_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.PINK_TERRACOTTA, PINK_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.GRAY_TERRACOTTA, GRAY_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA, LIGHT_GRAY_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.CYAN_TERRACOTTA, CYAN_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.PURPLE_TERRACOTTA, PURPLE_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.BLUE_TERRACOTTA, BLUE_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.BROWN_TERRACOTTA, BROWN_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.GREEN_TERRACOTTA, GREEN_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.RED_TERRACOTTA, RED_TERRACOTTA_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.BLACK_TERRACOTTA, BLACK_TERRACOTTA_VERTICAL_SLAB.get());

		this.blockFamily(ClayworksBlockFamilies.TERRACOTTA_BRICKS, TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.WHITE_TERRACOTTA_BRICKS, WHITE_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.ORANGE_TERRACOTTA_BRICKS, ORANGE_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.MAGENTA_TERRACOTTA_BRICKS, MAGENTA_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.LIGHT_BLUE_TERRACOTTA_BRICKS, LIGHT_BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.YELLOW_TERRACOTTA_BRICKS, YELLOW_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.LIME_TERRACOTTA_BRICKS, LIME_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.PINK_TERRACOTTA_BRICKS, PINK_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.GRAY_TERRACOTTA_BRICKS, GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.LIGHT_GRAY_TERRACOTTA_BRICKS, LIGHT_GRAY_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.CYAN_TERRACOTTA_BRICKS, CYAN_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.PURPLE_TERRACOTTA_BRICKS, PURPLE_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.BLUE_TERRACOTTA_BRICKS, BLUE_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.BROWN_TERRACOTTA_BRICKS, BROWN_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.GREEN_TERRACOTTA_BRICKS, GREEN_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.RED_TERRACOTTA_BRICKS, RED_TERRACOTTA_BRICK_VERTICAL_SLAB.get());
		this.blockFamily(ClayworksBlockFamilies.BLACK_TERRACOTTA_BRICKS, BLACK_TERRACOTTA_BRICK_VERTICAL_SLAB.get());

		this.decoratedPot(WHITE_DECORATED_POT.get(), Blocks.WHITE_TERRACOTTA);
		this.decoratedPot(ORANGE_DECORATED_POT.get(), Blocks.ORANGE_TERRACOTTA);
		this.decoratedPot(MAGENTA_DECORATED_POT.get(), Blocks.MAGENTA_TERRACOTTA);
		this.decoratedPot(LIGHT_BLUE_DECORATED_POT.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
		this.decoratedPot(YELLOW_DECORATED_POT.get(), Blocks.YELLOW_TERRACOTTA);
		this.decoratedPot(LIME_DECORATED_POT.get(), Blocks.LIME_TERRACOTTA);
		this.decoratedPot(PINK_DECORATED_POT.get(), Blocks.PINK_TERRACOTTA);
		this.decoratedPot(GRAY_DECORATED_POT.get(), Blocks.GRAY_TERRACOTTA);
		this.decoratedPot(LIGHT_GRAY_DECORATED_POT.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
		this.decoratedPot(CYAN_DECORATED_POT.get(), Blocks.CYAN_TERRACOTTA);
		this.decoratedPot(PURPLE_DECORATED_POT.get(), Blocks.PURPLE_TERRACOTTA);
		this.decoratedPot(BLUE_DECORATED_POT.get(), Blocks.BLUE_TERRACOTTA);
		this.decoratedPot(BROWN_DECORATED_POT.get(), Blocks.BROWN_TERRACOTTA);
		this.decoratedPot(GREEN_DECORATED_POT.get(), Blocks.GREEN_TERRACOTTA);
		this.decoratedPot(RED_DECORATED_POT.get(), Blocks.RED_TERRACOTTA);
		this.decoratedPot(BLACK_DECORATED_POT.get(), Blocks.BLACK_TERRACOTTA);
	}

	public void decoratedPot(Block block, Block parent) {
		this.simpleBlock(block, this.models().getBuilder(name(block)).texture("particle", blockTexture(parent)));
		this.itemModels().getBuilder(name(block)).parent(new ExistingModelFile(new ResourceLocation("item/decorated_pot"), this.models().existingFileHelper));
	}

	public void blockItem(Block block) {
		this.simpleBlockItem(block, new ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
	}

	public void block(Block block) {
		simpleBlock(block, cubeAll(block));
		blockItem(block);
	}

	public void glazedTerracotta(Block block) {
		this.horizontalBlock(block, models().withExistingParent(name(block), "template_glazed_terracotta").texture("pattern", blockTexture(block)), 0);
		blockItem(block);
	}

	public void furnace(Block block) {
		ModelFile furnace = models().cube(name(block), suffix(blockTexture(block), "_bottom"), suffix(blockTexture(block), "_top"), suffix(blockTexture(block), "_front"), suffix(blockTexture(block), "_back"), suffix(blockTexture(block), "_left"), suffix(blockTexture(block), "_right")).texture("particle", suffix(blockTexture(block), "_back"));
		ModelFile furnaceOn = models().cube(name(block) + "_on", suffix(blockTexture(block), "_bottom"), suffix(blockTexture(block), "_top_on"), suffix(blockTexture(block), "_front_on"), suffix(blockTexture(block), "_back"), suffix(blockTexture(block), "_left"), suffix(blockTexture(block), "_right")).texture("particle", suffix(blockTexture(block), "_back"));
		this.horizontalBlock(block, (state -> state.getValue(BlockStateProperties.LIT) ? furnaceOn : furnace));
		blockItem(block);
	}

	public void blockFamily(BlockFamily family, Block verticalSlab) {
		Block parent = family.getBaseBlock();
		if (!ForgeRegistries.BLOCKS.getKey(parent).getNamespace().equals("minecraft"))
			this.block(parent);

		if (family.getVariants().containsKey(Variant.CHISELED)) {
			this.block(family.get(Variant.CHISELED));
		}

		if (family.getVariants().containsKey(Variant.SLAB)) {
			SlabBlock slab = (SlabBlock) family.get(Variant.SLAB);
			this.slabBlock(slab, blockTexture(parent), blockTexture(parent));
			this.blockItem(slab);

			this.verticalSlabBlock(parent, (VerticalSlabBlock) verticalSlab);
			this.blockItem(verticalSlab);
		}

		if (family.getVariants().containsKey(Variant.STAIRS)) {
			StairBlock stairs = (StairBlock) family.get(Variant.STAIRS);
			this.stairsBlock(stairs, blockTexture(parent));
			this.blockItem(stairs);
		}

		if (family.getVariants().containsKey(Variant.WALL)) {
			WallBlock wall = (WallBlock) family.get(Variant.WALL);
			this.wallBlock(wall, blockTexture(parent));
			this.itemModels().getBuilder(name(wall)).parent(this.models().wallInventory(name(wall) + "_inventory", blockTexture(parent)));
		}
	}

	public ModelFile verticalSlab(String name, ResourceLocation texture) {
		return models().getBuilder(name).parent(new UncheckedModelFile(new ResourceLocation(Blueprint.MOD_ID, "block/vertical_slab"))).texture("side", texture).texture("bottom", texture).texture("top", texture);
	}

	public void verticalSlabBlock(Block planks, VerticalSlabBlock slab) {
		ModelFile verticalSlab = this.verticalSlab(name(slab), blockTexture(planks));
		this.getVariantBuilder(slab)
				.partialState().with(VerticalSlabBlock.TYPE, VerticalSlabType.NORTH).addModels(new ConfiguredModel(verticalSlab, 0, 0, true))
				.partialState().with(VerticalSlabBlock.TYPE, VerticalSlabType.SOUTH).addModels(new ConfiguredModel(verticalSlab, 0, 180, true))
				.partialState().with(VerticalSlabBlock.TYPE, VerticalSlabType.EAST).addModels(new ConfiguredModel(verticalSlab, 0, 90, true))
				.partialState().with(VerticalSlabBlock.TYPE, VerticalSlabType.WEST).addModels(new ConfiguredModel(verticalSlab, 0, 270, true))
				.partialState().with(VerticalSlabBlock.TYPE, VerticalSlabType.DOUBLE).addModels(new ConfiguredModel(models().cubeAll(name(planks), blockTexture(planks))));
	}

	private String name(Block block) {
		return ForgeRegistries.BLOCKS.getKey(block).getPath();
	}

	private ResourceLocation prefix(String prefix, ResourceLocation rl) {
		return new ResourceLocation(rl.getNamespace(), prefix + rl.getPath());
	}

	private ResourceLocation suffix(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}
}