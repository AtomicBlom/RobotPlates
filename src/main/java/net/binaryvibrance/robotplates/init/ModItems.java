package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.item.ItemRemoteDebugger;
import net.binaryvibrance.robotplates.item.ItemRobot;
import net.binaryvibrance.robotplates.item.ItemRobotPlate;

public final class ModItems {
	public static final ItemRobotPlate remoteDebugger = new ItemRemoteDebugger();
	public static final ItemRobot robot = new ItemRobot();
	private ModItems() {
	}

	public static void init() {
		GameRegistry.registerItem(remoteDebugger, "remoteDebugger");
		GameRegistry.registerItem(robot, "robot");
	}
}
