package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.block.*;
import net.binaryvibrance.robotplates.reference.Reference;
import net.minecraft.block.Block;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModBlocks {
	public static final BlockRobotPlate plateAction = new BlockPlateAction();
	public static final BlockRobotPlate plateConditional = new BlockPlateConditional();
	public static final BlockRobotPlate plateCodePath = new BlockPlateCodePath();
	public static final BlockRobotPlate plateEvent = new BlockPlateEvent();
	public static final BlockRobotPlate plateProgrammer = new BlockPlateProgrammer();

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
