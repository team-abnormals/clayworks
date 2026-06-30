package com.teamabnormals.clayworks.core.data.server.tags;

import com.teamabnormals.clayworks.core.Clayworks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ClayworksTags {
    public static class Items {
        public static final TagKey<Item> TERRACOTTA_BRICKS = createItemTag("terracotta_bricks");
        public static final TagKey<Item> TERRACOTTA_CHISELED_BRICKS = createItemTag("chiseled_terracotta_bricks");
		public static final TagKey<Item> TERRACOTTA_STAIRS = createItemTag("terracotta_stairs");
		public static final TagKey<Item> TERRACOTTA_SLABS = createItemTag("terracotta_slabs");
		public static final TagKey<Item> TERRACOTTA_WALLS = createItemTag("terracotta_walls");
		public static final TagKey<Item> TERRACOTTA_BRICK_STAIRS = createItemTag("terracotta_brick_stairs");
		public static final TagKey<Item> TERRACOTTA_BRICK_SLABS = createItemTag("terracotta_brick_slabs");
		public static final TagKey<Item> TERRACOTTA_BRICK_WALLS = createItemTag("terracotta_brick_walls");

		public static final TagKey<Item> GLASS_DOORS = createItemTag("glass_doors");
		public static final TagKey<Item> GLASS_TRAPDOORS = createItemTag("glass_trapdoors");

        private static TagKey<Item> createItemTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Clayworks.MOD_ID, name));
        }
    }
}
