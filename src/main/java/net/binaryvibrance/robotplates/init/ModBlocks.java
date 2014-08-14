package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.block.*;
import net.binaryvibrance.robotplates.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModBlocks {
	public static final RobotPlateBlockBase plateAction = new BlockPlateAction();
	public static final RobotPlateBlockBase plateConditional = new BlockPlateConditional();
	public static final RobotPlateBlockBase plateCodePath = new BlockPlateCodePath();
	public static final RobotPlateBlockBase plateEvent = new BlockPlateEvent();
	public static final RobotPlateBlockBase plateProgrammer = new BlockPlateProgrammer();

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
