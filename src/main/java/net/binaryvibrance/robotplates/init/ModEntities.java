package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.binaryvibrance.robotplates.RobotPlates;
import net.binaryvibrance.robotplates.client.renderer.entity.RobotBobRenderer;
import net.binaryvibrance.robotplates.entity.robot.RobotBob;
import net.minecraft.client.renderer.entity.RenderManager;

/**
 * Created by CodeWarrior on 3/08/2014.
 */
public final class ModEntities {
	private ModEntities() {}

	@SuppressWarnings("unchecked")
	public static void init() {
		EntityRegistry.registerModEntity(RobotBob.class, "entityRobotBob", 0, RobotPlates.instance, 80, 3, true);

	}
}
