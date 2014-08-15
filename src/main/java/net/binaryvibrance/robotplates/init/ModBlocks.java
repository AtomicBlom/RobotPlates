package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.block.*;
import net.binaryvibrance.robotplates.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModBlocks {
	public static final BaseRobotPlateBlock plateAction = new BlockPlateAction();
	public static final BaseRobotPlateBlock plateConditional = new BlockPlateConditional();
	public static final BaseRobotPlateBlock plateCodePath = new BlockPlateCodePath();
	public static final BaseRobotPlateBlock plateEvent = new BlockPlateEvent();
	public static final BaseRobotPlateBlock plateProgrammer = new BlockPlateProgrammer();

	private ModBlocks() {
	}

	public static void init() {
		GameRegistry.registerBlock(plateAction, "plateAction");
		GameRegistry.registerBlock(plateConditional, "plateConditional");
		GameRegistry.registerBlock(plateCodePath, "plateCodePath");
		GameRegistry.registerBlock(plateEvent, "plateEvent");
		GameRegistry.registerBlock(plateProgrammer, "plateProgrammer");
	}
}
