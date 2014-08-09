package net.binaryvibrance.robotplates.creativetab;

import net.binaryvibrance.robotplates.init.ModItems;
import net.binaryvibrance.robotplates.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabRobotPlate {
	public static final CreativeTabs ROBOTPLATES_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {

		@Override
		public Item getTabIconItem() {
			return ModItems.TOOL_REMOTE_DEBUGGER;
		}
	};
}
