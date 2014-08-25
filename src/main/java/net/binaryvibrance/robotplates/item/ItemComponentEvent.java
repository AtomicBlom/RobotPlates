package net.binaryvibrance.robotplates.item;

import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemComponentEvent extends BaseRobotPlateItem {
	public ItemComponentEvent() {
		super();
		this.setUnlocalizedName("componentEvent");
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) return true;

		TileEntity hitTileEntity = world.getTileEntity(x, y, z);
		if (!(hitTileEntity instanceof TileEntityPlateEvent)) return false;

		TileEntityPlateEvent eventPlate = (TileEntityPlateEvent)hitTileEntity;
		eventPlate.setEvent(stack);

		if (!player.capabilities.isCreativeMode) {
			stack.stackSize--;
		}
		return true;
	}
}
