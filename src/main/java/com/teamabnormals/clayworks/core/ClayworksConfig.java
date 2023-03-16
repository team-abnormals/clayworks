package com.teamabnormals.clayworks.core;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class ClayworksConfig {

	public static class Common {
		@ConfigKey("kiln")
		public final BooleanValue kiln;
		@ConfigKey("chiseled_bricks")
		public final BooleanValue chiseledBricks;
		@ConfigKey("glazed_terracotta")
		public final BooleanValue glazedTerracotta;
		@ConfigKey("terracotta_variants")
		public final BooleanValue terracottaVariants;
		@ConfigKey("terracotta_bricks")
		public final BooleanValue terracottaBricks;

		public Common(ForgeConfigSpec.Builder builder) {
			builder.push("blocks");
			this.kiln = builder.define("Kiln", true);
			this.chiseledBricks = builder.define("Chiseled bricks", true);
			this.glazedTerracotta = builder.define("Glazed terracotta", true);
			this.terracottaVariants = builder.define("Terracotta slabs, stairs, and walls", true);
			this.terracottaBricks = builder.define("Terracotta bricks", true);
			builder.pop();
		}
	}

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = commonSpecPair.getRight();
		COMMON = commonSpecPair.getLeft();
	}
}