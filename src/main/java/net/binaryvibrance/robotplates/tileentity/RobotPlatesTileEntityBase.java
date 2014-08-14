package net.binaryvibrance.robotplates.tileentity;

import net.binaryvibrance.robotplates.init.ModPackets;
import net.binaryvibrance.robotplates.network.RobotPlatesTileEntityMessage;
import net.binaryvibrance.robotplates.reference.Constants;
import net.binaryvibrance.robotplates.reference.Names;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class RobotPlatesTileEntityBase extends TileEntity {
	protected ForgeDirection orientation;
	protected byte state;
	protected String customName;
	protected String owner;

	protected boolean[] signalActive = new boolean[7];

	RobotPlatesTileEntityBase() {
		orientation = ForgeDirection.NORTH;
		state = 0;
		customName = "";
		owner = "";
	}

	public ForgeDirection getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = ForgeDirection.getOrientation(orientation);
	}

	public void setOrientation(ForgeDirection orientation) {
		this.orientation = orientation;
	}

	public short getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {
		super.readFromNBT(nbtTagCompound);

		if (nbtTagCompound.hasKey(Names.NBT.DIRECTION)) {
			byte aByte = nbtTagCompound.getByte(Names.NBT.DIRECTION);
			this.orientation = ForgeDirection.getOrientation(aByte);
		}

		if (nbtTagCompound.hasKey(Names.NBT.STATE)) {
			this.state = nbtTagCompound.getByte(Names.NBT.STATE);
		}

		if (nbtTagCompound.hasKey(Names.NBT.CUSTOM_NAME)) {
			this.customName = nbtTagCompound.getString(Names.NBT.CUSTOM_NAME);
		}

		if (nbtTagCompound.hasKey(Names.NBT.OWNER)) {
			this.owner = nbtTagCompound.getString(Names.NBT.OWNER);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setByte(Names.NBT.DIRECTION, (byte) orientation.ordinal());
		nbtTagCompound.setByte(Names.NBT.STATE, state);

		if (this.hasCustomName()) {
			nbtTagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
		}

		if (this.hasOwner()) {
			nbtTagCompound.setString(Names.NBT.OWNER, owner);
		}
	}

	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}

	public boolean hasOwner() {
		return owner != null && owner.length() > 0;
	}

	@Override
	public Packet getDescriptionPacket() {
		return ModPackets.NETWORK.getPacketFrom(new RobotPlatesTileEntityMessage(this));
	}

	public void checkUpdate(RobotPlatesTileEntityBase neighbour, ForgeDirection directionToNeighbour) {
		//This should be based on the direction of the signal.
		if (neighbour == null) {
			signalActive[directionToNeighbour.ordinal() - 2] = false;
		} else {
			signalActive[directionToNeighbour.ordinal() - 2] = true;
		}
	}

	public void checkUpdate(boolean deleting) {

		for (ForgeDirection direction : Constants.COMPASS_DIRECTIONS) {
			TileEntity tileEntity = worldObj.getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
			if (tileEntity instanceof RobotPlatesTileEntityBase) {
				RobotPlatesTileEntityBase robotPlatesTileEntity = (RobotPlatesTileEntityBase)tileEntity;
				robotPlatesTileEntity.checkUpdate(deleting ? null : this, direction.getOpposite());
				signalActive[direction.ordinal() - 2] = true;
			} else {
				signalActive[direction.ordinal() - 2] = false;
			}
		}
	}

	public boolean getSignalActive(ForgeDirection direction) {
		return signalActive[direction.ordinal() - 2];
	}
}
