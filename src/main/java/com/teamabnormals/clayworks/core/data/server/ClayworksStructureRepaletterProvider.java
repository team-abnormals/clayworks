package com.teamabnormals.clayworks.core.data.server;

import com.teamabnormals.blueprint.common.world.modification.structure.SimpleStructureRepaletter;
import com.teamabnormals.blueprint.common.world.modification.structure.StructureRepaletterProvider;
import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
import com.teamabnormals.clayworks.common.modification.OppositeFacingStructureRepaletter;
import com.teamabnormals.clayworks.core.Clayworks;
import com.teamabnormals.clayworks.core.registry.ClayworksBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraftforge.eventbus.api.EventPriority;

public final class ClayworksStructureRepaletterProvider extends StructureRepaletterProvider {

	public ClayworksStructureRepaletterProvider(DataGenerator dataGenerator) {
		super(dataGenerator, Clayworks.MOD_ID);
	}

	@Override
	protected void registerRepaletters() {
		this.registerRepaletter("replace_stonecutter_with_kiln",
				new ConditionedResourceSelector(new NamesResourceSelector(
						BuiltinStructures.VILLAGE_PLAINS.location(),
						BuiltinStructures.VILLAGE_DESERT.location())),
				EventPriority.NORMAL,
				new OppositeFacingStructureRepaletter(Blocks.STONECUTTER, ClayworksBlocks.KILN.get()));

		this.registerRepaletter("replace_stonecutter_with_kiln_and_flip",
				new ConditionedResourceSelector(new NamesResourceSelector(
						BuiltinStructures.VILLAGE_SAVANNA.location())),
				EventPriority.NORMAL,
				new SimpleStructureRepaletter(Blocks.STONECUTTER, ClayworksBlocks.KILN.get()));
	}

}