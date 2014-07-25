package net.binaryvibrance.robotplates.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public abstract class TileEntityRobotPlates extends TileEntity {
	protected ForgeDirection orientation;
	protected byte state;
	protected String customName;
	protected String owner;

	public TileEntityRobotPlates()
	{
		orientation = ForgeDirection.SOUTH;
		state = 0;
		customName = "";
		owner = "";
	}

	public ForgeDirection getOrientation()
	{
		return orientation;
	}

	public void setOrientation(ForgeDirection orientation)
	{
		this.orientation = orientation;
	}

	public void setOrientation(int orientation)
	{
		this.orientation = ForgeDirection.getOrientation(orientation);
	}

	public short getState()
	{
		return state;
	}

	public void setState(byte state)
	{
		this.state = state;
	}

	public String getCustomName()
	{
		return customName;
	}

	public void setCustomName(String customName)
	{
		this.customName = customName;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	/*@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);

		if (nbtTagCompound.hasKey(Names.NBT.DIRECTION))
		{
			this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(Names.NBT.DIRECTION));
		}

		if (nbtTagCompound.hasKey(Names.NBT.STATE))
		{
			this.state = nbtTagCompound.getByte(Names.NBT.STATE);
		}

		if (nbtTagCompound.hasKey(Names.NBT.CUSTOM_NAME))
		{
			this.customName = nbtTagCompound.getString(Names.NBT.CUSTOM_NAME);
		}

		if (nbtTagCompound.hasKey(Names.NBT.OWNER))
		{
			this.owner = nbtTagCompound.getString(Names.NBT.OWNER);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setByte(Names.NBT.DIRECTION, (byte) orientation.ordinal());
		nbtTagCompound.setByte(Names.NBT.STATE, state);

		if (this.hasCustomName())
		{
			nbtTagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
		}

		if (this.hasOwner())
		{
			nbtTagCompound.setString(Names.NBT.OWNER, owner);
		}
	}*/

	public boolean hasCustomName()
	{
		return customName != null && customName.length() > 0;
	}

	public boolean hasOwner()
	{
		return owner != null && owner.length() > 0;
	}

	/*@Override
	public Packet getDescriptionPacket()
	{
		//return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityEE(this));
	}*/

}
