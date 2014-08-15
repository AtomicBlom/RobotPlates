package net.binaryvibrance.robotplates.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.minecraft.tileentity.TileEntity;

public class RobotPlatesTileEntityMessage implements IMessage, IMessageHandler<RobotPlatesTileEntityMessage, IMessage> {
	private int x, y, z;
	private byte orientation, state;
	private String customName, owner;
	private boolean[] activeSignals;

	@SuppressWarnings("UnusedDeclaration")
	public RobotPlatesTileEntityMessage() {
		activeSignals = new boolean[4];
	}

	@SuppressWarnings("UnusedDeclaration")
	public RobotPlatesTileEntityMessage(BaseRobotPlatesTileEntity rpTileEntity) {
		this.x = rpTileEntity.xCoord;
		this.y = rpTileEntity.yCoord;
		this.z = rpTileEntity.zCoord;
		this.orientation = (byte) rpTileEntity.getOrientation().ordinal();
		this.state = (byte) rpTileEntity.getState();
		this.customName = rpTileEntity.getCustomName();
		this.owner = rpTileEntity.getOwner();
		this.activeSignals = new boolean[rpTileEntity.activeSignals.length];
		for (int i = 0; i < rpTileEntity.activeSignals.length; ++i) {
			this.activeSignals[i] = rpTileEntity.activeSignals[i];
		}
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.orientation = buf.readByte();
		this.state = buf.readByte();
		int customNameLength = buf.readInt();
		this.customName = new String(buf.readBytes(customNameLength).array());
		int ownerLength = buf.readInt();
		this.owner = new String(buf.readBytes(ownerLength).array());
		for (int i = 0; i < activeSignals.length; ++i) {
			this.activeSignals[i] = buf.readBoolean();
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeByte(orientation);
		buf.writeByte(state);
		buf.writeInt(customName.length());
		buf.writeBytes(customName.getBytes());
		buf.writeInt(owner.length());
		buf.writeBytes(owner.getBytes());
		for (int i = 0; i < activeSignals.length; ++i) {
			buf.writeBoolean(this.activeSignals[i]);
		}
	}

	@Override
	public IMessage onMessage(RobotPlatesTileEntityMessage message, MessageContext ctx) {
		TileEntity untypedTileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

		if (untypedTileEntity instanceof BaseRobotPlatesTileEntity) {

			BaseRobotPlatesTileEntity tileEntity = (BaseRobotPlatesTileEntity) untypedTileEntity;
			tileEntity.setOrientation(message.orientation);
			tileEntity.setState(message.state);
			tileEntity.setCustomName(message.customName);
			tileEntity.setOwner(message.owner);
			for (int i = 0; i < activeSignals.length; ++i) {
				tileEntity.activeSignals[i] = message.activeSignals[i];
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return String.format("TileEntityRobotPlates - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
	}

}