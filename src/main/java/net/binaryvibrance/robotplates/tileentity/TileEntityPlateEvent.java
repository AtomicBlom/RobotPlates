package net.binaryvibrance.robotplates.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileEntityPlateEvent extends BaseRobotPlatesTileEntity {
	private ItemStack event;

	public void setEvent(ItemStack event) {
		this.event = event;
	}
}
