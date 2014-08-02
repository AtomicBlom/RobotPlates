package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.item.ItemRemoteDebugger;
import net.binaryvibrance.robotplates.item.ItemRobotPlate;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public final class ModItems {
	private ModItems() {}

	public static final ItemRobotPlate remoteDebugger = new ItemRemoteDebugger();

	public static void init(){
		GameRegistry.registerItem(remoteDebugger, "remoteDebugger");
	}
}
