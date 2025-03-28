package com.teamabnormals.clayworks.core;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class ClayworksConfig {

	public static class Common {
		@ConfigKey("pottery_table")
		public final BooleanValue potteryTable;
		@ConfigKey("kiln")
		public final BooleanValue kiln;
		@ConfigKey("chiseled_bricks")
		public final BooleanValue chiseledBricks;
		@ConfigKey("glazed_terracotta")
		public final BooleanValue glazedTerracotta;
		@ConfigKey("concrete")
		public final BooleanValue concrete;
		@ConfigKey("terracotta_variants")
		public final BooleanValue terracottaVariants;
		@ConfigKey("terracotta_bricks")
		public final BooleanValue terracottaBricks;
		@ConfigKey("glass_doors")
		public final BooleanValue glassDoors;
		@ConfigKey("glass_trapdoors")
		public final BooleanValue glassTrapdoors;
		@ConfigKey("decorated_pot_colors")
		public final BooleanValue decoratedPotColors;
		@ConfigKey("decorated_pot_trims")
		public final BooleanValue decoratedPotTrims;

		public Common(ModConfigSpec.Builder builder) {
			builder.push("blocks");
			this.potteryTable = builder.define("Pottery Table", true);
			this.kiln = builder.define("Kiln", true);
			this.chiseledBricks = builder.define("Chiseled bricks", true);
			this.glazedTerracotta = builder.define("Glazed terracotta", true);
			this.concrete = builder.define("Concrete", true);
			this.terracottaVariants = builder.define("Terracotta slabs, stairs, and walls", true);
			this.terracottaBricks = builder.define("Terracotta bricks", true);
			this.glassDoors = builder.define("Glass doors", true);
			this.glassTrapdoors = builder.define("Glass trapdoors", true);
			builder.push("decorated_pot");
			this.decoratedPotColors = builder.define("Decorated pot colors", true);
			this.decoratedPotTrims = builder.define("Decorated pot trims", true);
			builder.pop();
			builder.pop();
		}
	}

	public static final ModConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		Pair<Common, ModConfigSpec> commonSpecPair = new ModConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = commonSpecPair.getRight();
		COMMON = commonSpecPair.getLeft();
	}
}