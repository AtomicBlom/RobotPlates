package net.binaryvibrance.robotplates.item;

import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemComponentEvent extends BaseRobotPlateItem {
	public ItemComponentEvent() {
		super();
		this.setUnlocalizedName("componentEvent");
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		LogHelper.info("onItemUseFirst triggered on %s", world.isRemote ? "Client" : "Server");
		if (world.isRemote) return false;

		TileEntity hitTileEntity = world.getTileEntity(x, y, z);
		if (!(hitTileEntity instanceof TileEntityPlateEvent)) return false;

		TileEntityPlateEvent eventPlate = (TileEntityPlateEvent)hitTileEntity;
		if (eventPlate.getEventType() != TileEntityPlateEvent.EventType.NONE) return false;

		NBTTagCompound tag = stack.getTagCompound();
		TileEntityPlateEvent.EventType eventType = TileEntityPlateEvent.EventType.TICK;
		if (tag != null && tag.hasKey("Type")) {
			int typeOrdinal = tag.getInteger("Type");
			if (typeOrdinal < TileEntityPlateEvent.EventType.values().length) {
				eventType = TileEntityPlateEvent.EventType.values()[typeOrdinal];
			}
		}

		eventPlate.setEventType(eventType);

		if (!player.capabilities.isCreativeMode) {
			stack.stackSize--;
		}
		return true;
	}
}
