package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.item.*;

public final class ModItems {
	//Components
	public static final ItemComponentContainer COMPONENT_CONTAINER = new ItemComponentContainer();

	//Tools
	public static final BaseRobotPlateItem TOOL_REMOTE_DEBUGGER = new ItemToolRemoteDebugger();
	public static final ItemToolSolderingIron TOOL_SOLDERING_IRON = new ItemToolSolderingIron();

	//Robots
	public static final ItemRobot ROBOT = new ItemRobot();

	private ModItems() {
	}

	public static void init() {
		GameRegistry.registerItem(COMPONENT_CONTAINER, "componentContainer");

		GameRegistry.registerItem(TOOL_REMOTE_DEBUGGER, "remoteDebugger");
		GameRegistry.registerItem(TOOL_SOLDERING_IRON, "toolSolderingIron");

		GameRegistry.registerItem(ROBOT, "robot");
	}
}
