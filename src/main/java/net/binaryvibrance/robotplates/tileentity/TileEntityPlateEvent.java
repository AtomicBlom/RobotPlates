package net.binaryvibrance.robotplates.tileentity;

import net.binaryvibrance.robotplates.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Random;

public class TileEntityPlateEvent extends BaseRobotPlatesTileEntity {
	private ItemStack event;
	private EventType eventType;

	public void setEvent(ItemStack event) {
		this.event = event;
		NBTTagCompound tag = event.getTagCompound();
		EventType eventType = EventType.TICK;
		if (tag != null && tag.hasKey("Type")) {
			int typeOrdinal = tag.getInteger("Type");
			if (typeOrdinal < EventType.values().length) {
				eventType = EventType.values()[typeOrdinal];
			}
		}
		this.eventType = eventType;
	}

	@Override
	public void onBroken() {
		if (eventType != null && eventType != EventType.UNKNOWN) {
			Random rand = new Random();
			ItemStack itemStack = new ItemStack(ModItems.COMPONENT_EVENT);

			NBTTagCompound tagCompound = new NBTTagCompound();
			tagCompound.setInteger("Type", eventType.ordinal());
			itemStack.setTagCompound(tagCompound);

			EntityItem entityItem = new EntityItem(this.worldObj, xCoord, yCoord, zCoord, itemStack.copy());
			entityItem.getEntityItem().setTagCompound(tagCompound);

			float factor = 0.05F;
			entityItem.motionX = rand.nextGaussian() * factor;
			entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
			entityItem.motionZ = rand.nextGaussian() * factor;
			worldObj.spawnEntityInWorld(entityItem);
			itemStack.stackSize = 0;
		}
	}

	public EventType getEventType() {
		return eventType;
	}

	public enum EventType {
		UNKNOWN,
		TICK
	}
}
