package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.item.ItemDummy;
import net.binaryvibrance.robotplates.item.ItemRobotPlate;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public final class ModItems {
	public static final ItemRobotPlate dummyItem = new ItemDummy();

	public static void init(){
		GameRegistry.registerItem(dummyItem, "dummyItem");
	}
}
