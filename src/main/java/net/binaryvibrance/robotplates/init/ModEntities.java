package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.binaryvibrance.robotplates.RobotPlates;
import net.binaryvibrance.robotplates.entity.robot.RobotBob;

public final class ModEntities {
	private ModEntities() {
	}

	@SuppressWarnings("unchecked")
	public static void init() {
		EntityRegistry.registerModEntity(RobotBob.class, "entityRobotBob", 0, RobotPlates.instance, 80, 3, true);

	}
}
