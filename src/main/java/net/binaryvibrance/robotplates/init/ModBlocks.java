package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.block.BlockRobotPlate;
import net.binaryvibrance.robotplates.block.BlockStartPlate;
import net.binaryvibrance.robotplates.reference.Reference;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	public static final BlockRobotPlate startPlate = new BlockStartPlate();

	public static void init() {
		GameRegistry.registerBlock(startPlate, "startPlate");
	}
}
