package net.binaryvibrance.robotplates.tileentity;

import net.binaryvibrance.robotplates.utility.subobject.SubObject;
import net.binaryvibrance.robotplates.init.ModPackets;
import net.binaryvibrance.robotplates.network.BaseMessagePlateUpdated;
import net.binaryvibrance.robotplates.reference.Names;
import net.binaryvibrance.robotplates.utility.CompassDirection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class BaseRobotPlatesTileEntity extends TileEntity {
	protected byte state;
	protected String customName;
	protected String owner;

	public boolean[] activeSignals = new boolean[4];

	BaseRobotPlatesTileEntity() {
		state = 0;
		customName = "";
		owner = "";
	}

	protected SubObject[] getSubObjects() {
		return new SubObject[0];
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

		if (nbtTagCompound.hasKey(Names.NBT.STATE)) {
			this.state = nbtTagCompound.getByte(Names.NBT.STATE);
		}

		if (nbtTagCompound.hasKey(Names.NBT.CUSTOM_NAME)) {
			this.customName = nbtTagCompound.getString(Names.NBT.CUSTOM_NAME);
		}

		if (nbtTagCompound.hasKey(Names.NBT.OWNER)) {
			this.owner = nbtTagCompound.getString(Names.NBT.OWNER);
		}

		if (nbtTagCompound.hasKey(Names.NBT.ACTIVE_SIGNALS)) {
			byte[] activeSignals = nbtTagCompound.getByteArray(Names.NBT.ACTIVE_SIGNALS);
			for (int i = 0; i < activeSignals.length; ++i) {
				this.activeSignals[i] = activeSignals[i] == 1;
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);

		nbtTagCompound.setByte(Names.NBT.STATE, state);

		if (this.hasCustomName()) {
			nbtTagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
		}

		if (this.hasOwner()) {
			nbtTagCompound.setString(Names.NBT.OWNER, owner);
		}

		byte[] activeSignals = new byte[this.activeSignals.length];
		for (int i = 0; i < this.activeSignals.length; i++) {
			activeSignals[i] = this.activeSignals[i] ? (byte)1 : 0;
		}
		nbtTagCompound.setByteArray(Names.NBT.ACTIVE_SIGNALS, activeSignals);
	}

	public boolean hasCustomName() {
		return customName != null && customName.length() > 0;
	}

	public boolean hasOwner() {
		return owner != null && owner.length() > 0;
	}

	@Override
	public Packet getDescriptionPacket() {
		return ModPackets.NETWORK.getPacketFrom(new BaseMessagePlateUpdated(this));
	}

	public void checkUpdate(BaseRobotPlatesTileEntity neighbour, CompassDirection directionToNeighbour) {
		//This should be based on the direction of the signal.
		int ordinal = directionToNeighbour.ordinal();
		boolean updated;
		if (neighbour == null) {
			updated = activeSignals[ordinal] != false;
			activeSignals[ordinal] = false;
		} else {
			updated = activeSignals[ordinal] != true;
			activeSignals[ordinal] = true;
		}
		if (updated) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}

	public void checkUpdate(boolean deleting) {

		for (CompassDirection direction : CompassDirection.VALID_DIRECTIONS) {
			TileEntity tileEntity = worldObj.getTileEntity(xCoord + direction.offsetX, yCoord + direction.offsetY, zCoord + direction.offsetZ);
			if (tileEntity instanceof BaseRobotPlatesTileEntity) {
				BaseRobotPlatesTileEntity robotPlatesTileEntity = (BaseRobotPlatesTileEntity)tileEntity;
				robotPlatesTileEntity.checkUpdate(deleting ? null : this, direction.getOpposite());
				activeSignals[direction.ordinal()] = true;
			} else {
				activeSignals[direction.ordinal()] = false;
			}
		}
	}

	public boolean getSignalActive(CompassDirection direction) {
		return activeSignals[direction.ordinal()];
	}

	public SubObject getSubObject(Vec3 hitVec) {
		for (SubObject subObject : getSubObjects()) {
			if (subObject.getBoundingBox().isVecInside(hitVec)) {
				return subObject;
			}
		}
		return null;
	}

	public boolean onActivated(World world, int x, int y, int z, EntityPlayer player, int side, float px, float py, float pz) {
		return false;
	}

	public void onBroken() {

	}
}
