package net.binaryvibrance.robotplates.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.binaryvibrance.robotplates.tileentity.TileEntityRobotPlates;
import net.minecraft.tileentity.TileEntity;

public class MessageTileEntityRobotPlates implements IMessage, IMessageHandler<MessageTileEntityRobotPlates, IMessage> {
	public int x, y, z;
	public byte orientation, state;
	public String customName, owner;

	@SuppressWarnings("UnusedDeclaration")
	public MessageTileEntityRobotPlates()
	{
	}

	@SuppressWarnings("UnusedDeclaration")
	public MessageTileEntityRobotPlates(TileEntityRobotPlates tileEntityEE)
	{
		this.x = tileEntityEE.xCoord;
		this.y = tileEntityEE.yCoord;
		this.z = tileEntityEE.zCoord;
		this.orientation = (byte) tileEntityEE.getOrientation().ordinal();
		this.state = (byte) tileEntityEE.getState();
		this.customName = tileEntityEE.getCustomName();
		this.owner = tileEntityEE.getOwner();
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
		this.orientation = buf.readByte();
		this.state = buf.readByte();
		int customNameLength = buf.readInt();
		this.customName = new String(buf.readBytes(customNameLength).array());
		int ownerLength = buf.readInt();
		this.owner = new String(buf.readBytes(ownerLength).array());
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		buf.writeByte(orientation);
		buf.writeByte(state);
		buf.writeInt(customName.length());
		buf.writeBytes(customName.getBytes());
		buf.writeInt(owner.length());
		buf.writeBytes(owner.getBytes());
	}

	@Override
	public IMessage onMessage(MessageTileEntityRobotPlates message, MessageContext ctx)
	{
		TileEntity untypedTileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

		if (untypedTileEntity instanceof TileEntityRobotPlates)
		{

			TileEntityRobotPlates tileEntity = (TileEntityRobotPlates) untypedTileEntity;
			tileEntity.setOrientation(message.orientation);
			tileEntity.setState(message.state);
			tileEntity.setCustomName(message.customName);
			tileEntity.setOwner(message.owner);
		}

		return null;
	}

	@Override
	public String toString()
	{
		return String.format("TileEntityRobotPlates - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
	}

}
