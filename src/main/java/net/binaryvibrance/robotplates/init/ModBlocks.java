package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.block.BlockConditionalPlate;
import net.binaryvibrance.robotplates.block.BlockRobotPlate;
import net.binaryvibrance.robotplates.block.BlockStartPlate;
import net.binaryvibrance.robotplates.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModBlocks {
	public static final BlockRobotPlate startPlate = new BlockStartPlate();
	public static final BlockRobotPlate conditionalPlate = new BlockConditionalPlate();
	private ModBlocks() {
	}

	public static void init() {
		GameRegistry.registerBlock(startPlate, "startPlate");
		GameRegistry.registerBlock(conditionalPlate, "conditionalPlate");
	}
}
