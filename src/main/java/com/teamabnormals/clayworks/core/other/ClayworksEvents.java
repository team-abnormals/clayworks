package com.teamabnormals.clayworks.core.other;

import com.teamabnormals.blueprint.core.util.TradeUtil;
import com.teamabnormals.blueprint.core.util.TradeUtil.BlueprintTrade;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import com.teamabnormals.clayworks.core.registry.ClayworksVillagerProfessions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = Clayworks.MOD_ID)
public class ClayworksEvents {

	//TODO: Fix
	@SubscribeEvent
	public static void onCeramistTradesEvent(VillagerTradesEvent event) {
		Block[] terracottas = new Block[]{Blocks.WHITE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, Blocks.LIME_TERRACOTTA, Blocks.PINK_TERRACOTTA, Blocks.GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, Blocks.BROWN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, Blocks.RED_TERRACOTTA, Blocks.BLACK_TERRACOTTA};
		Block[] glazed_terracottas = new Block[]{Blocks.WHITE_GLAZED_TERRACOTTA, Blocks.ORANGE_GLAZED_TERRACOTTA, Blocks.MAGENTA_GLAZED_TERRACOTTA, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Blocks.YELLOW_GLAZED_TERRACOTTA, Blocks.LIME_GLAZED_TERRACOTTA, Blocks.PINK_GLAZED_TERRACOTTA, Blocks.GRAY_GLAZED_TERRACOTTA, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Blocks.CYAN_GLAZED_TERRACOTTA, Blocks.PURPLE_GLAZED_TERRACOTTA, Blocks.BLUE_GLAZED_TERRACOTTA, Blocks.BROWN_GLAZED_TERRACOTTA, Blocks.GREEN_GLAZED_TERRACOTTA, Blocks.RED_GLAZED_TERRACOTTA, Blocks.BLACK_GLAZED_TERRACOTTA};
		Block[] terracotta_bricks = new Block[]{ClayworksBlocks.WHITE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.ORANGE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.MAGENTA_TERRACOTTA_BRICKS.get(), ClayworksBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.YELLOW_TERRACOTTA_BRICKS.get(), ClayworksBlocks.LIME_TERRACOTTA_BRICKS.get(), ClayworksBlocks.PINK_TERRACOTTA_BRICKS.get(), ClayworksBlocks.GRAY_TERRACOTTA_BRICKS.get(), ClayworksBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CYAN_TERRACOTTA_BRICKS.get(), ClayworksBlocks.PURPLE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.BLUE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.BROWN_TERRACOTTA_BRICKS.get(), ClayworksBlocks.GREEN_TERRACOTTA_BRICKS.get(), ClayworksBlocks.RED_TERRACOTTA_BRICKS.get(), ClayworksBlocks.BLACK_TERRACOTTA_BRICKS.get()};
		Block[] chiseled_terracotta_bricks = new Block[]{ClayworksBlocks.CHISELED_WHITE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_ORANGE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_MAGENTA_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_LIGHT_BLUE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_YELLOW_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_LIME_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_PINK_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_GRAY_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_LIGHT_GRAY_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_CYAN_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_PURPLE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_BLUE_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_BROWN_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_GREEN_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_RED_TERRACOTTA_BRICKS.get(), ClayworksBlocks.CHISELED_BLACK_TERRACOTTA_BRICKS.get()};

		TradeUtil.addVillagerTrades(event, ClayworksVillagerProfessions.CERAMIST.get(), TradeUtil.NOVICE,
				new BlueprintTrade(Items.CLAY_BALL, 10, 1, 16, 2),
				new BlueprintTrade(1, Items.BRICK, 10, 16, 1)
		);
		TradeUtil.addVillagerTrades(event, ClayworksVillagerProfessions.CERAMIST.get(), TradeUtil.APPRENTICE,
				new BlueprintTrade(1, Items.FLOWER_POT, 1, 10, 2),
				//new BlueprintTrade(1, ClayworksBlocks.SLABFISH_EFFIGY.get().asItem(), 1, 10, 2),
				new BlueprintTrade(1, ClayworksBlocks.CHISELED_BRICKS.get().asItem(), 4, 16, 10)
		);

		for (Block terracotta : terracottas)
			TradeUtil.addVillagerTrades(event, ClayworksVillagerProfessions.CERAMIST.get(), TradeUtil.JOURNEYMAN, new BlueprintTrade(terracotta.asItem(), 1, 1, 12, 15));
		for (Block glazed_terracotta : glazed_terracottas)
			TradeUtil.addVillagerTrades(event, ClayworksVillagerProfessions.CERAMIST.get(), TradeUtil.JOURNEYMAN, new BlueprintTrade(glazed_terracotta.asItem(), 1, 1, 12, 15));

		for (Block terracotta_brick : terracotta_bricks)
			TradeUtil.addVillagerTrades(event, ClayworksVillagerProfessions.CERAMIST.get(), TradeUtil.EXPERT, new BlueprintTrade(1, terracotta_brick.asItem(), 1, 12, 15));
		for (Block chiseled_terracotta_brick : chiseled_terracotta_bricks)
			TradeUtil.addVillagerTrades(event, ClayworksVillagerProfessions.CERAMIST.get(), TradeUtil.EXPERT, new BlueprintTrade(1, chiseled_terracotta_brick.asItem(), 1, 12, 15));

		TradeUtil.addVillagerTrades(event, ClayworksVillagerProfessions.CERAMIST.get(), TradeUtil.MASTER, new BlueprintTrade(24, Items.CHICKEN_SPAWN_EGG, 1, 1, 5));
	}
}
