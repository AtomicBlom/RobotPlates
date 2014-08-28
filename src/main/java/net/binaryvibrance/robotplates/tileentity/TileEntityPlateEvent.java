package net.binaryvibrance.robotplates.tileentity;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.binaryvibrance.robotplates.init.ModItems;
import net.binaryvibrance.robotplates.init.ModPackets;
import net.binaryvibrance.robotplates.network.MessagePlateUpdatedEvent;
import net.binaryvibrance.robotplates.reference.Names;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;

import java.util.Random;

public class TileEntityPlateEvent extends BaseRobotPlatesTileEntity {
	private EventType eventType = EventType.NONE;

	@Override
	public void onBroken() {
		if (eventType != null && eventType != EventType.NONE) {
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

	public void setEventType(EventType eventType) {
		if (this.eventType != eventType) {
			this.eventType = eventType;

			this.markDirty();
			this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.state);
			ModPackets.NETWORK.sendToAllAround(new MessagePlateUpdatedEvent(this), new NetworkRegistry.TargetPoint(this.worldObj.provider.dimensionId, (double) this.xCoord, (double) this.yCoord, (double) this.zCoord, 128d));
			this.worldObj.notifyBlockChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);
		if (nbtTagCompound.hasKey(Names.NBT.INSTALLED_COMPONENT)) {
			eventType = EventType.values()[nbtTagCompound.getInteger(Names.NBT.INSTALLED_COMPONENT)];
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger(Names.NBT.INSTALLED_COMPONENT, eventType.ordinal());
	}

	@Override
	public Packet getDescriptionPacket() {

		MessagePlateUpdatedEvent message = new MessagePlateUpdatedEvent(this);
		LogHelper.info("Sending network message " + message);
		return ModPackets.NETWORK.getPacketFrom(message);
	}

	public enum EventType {
		NONE,
		TICK
	}
}
