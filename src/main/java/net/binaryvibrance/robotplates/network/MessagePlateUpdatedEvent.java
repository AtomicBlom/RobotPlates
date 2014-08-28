package net.binaryvibrance.robotplates.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.minecraft.tileentity.TileEntity;

public class MessagePlateUpdatedEvent extends BaseMessagePlateUpdated {
	private TileEntityPlateEvent.EventType eventType;

	@SuppressWarnings("UnusedDeclaration")
	public MessagePlateUpdatedEvent() {

	}

	@SuppressWarnings("UnusedDeclaration")
	public MessagePlateUpdatedEvent(TileEntityPlateEvent eventPlateTileEntity) {
		super(eventPlateTileEntity);
		this.eventType = eventPlateTileEntity.getEventType();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		this.eventType = TileEntityPlateEvent.EventType.values()[buf.readInt()];
	}

	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		buf.writeInt(this.eventType.ordinal());
	}

	@Override
	public String toString() {
		return String.format("%s, eventType:%s", super.toString(), eventType);
	}

	public TileEntityPlateEvent.EventType getEventType() {
		return eventType;
	}
}