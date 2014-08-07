package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.item.ItemToolRemoteDebugger;
import net.binaryvibrance.robotplates.item.ItemRobot;
import net.binaryvibrance.robotplates.item.ItemRobotPlate;
import net.binaryvibrance.robotplates.item.ItemToolSolderingIron;

public final class ModItems {
	public static final ItemRobotPlate remoteDebugger = new ItemToolRemoteDebugger();
	public static final ItemRobot robot = new ItemRobot();
	public static final ItemToolSolderingIron toolSolderingIron = new ItemToolSolderingIron();

	private ModItems() {
	}

	public static void init() {
		GameRegistry.registerItem(remoteDebugger, "remoteDebugger");
		GameRegistry.registerItem(robot, "robot");
		GameRegistry.registerItem(toolSolderingIron, "toolSolderingIron");
	}
}
