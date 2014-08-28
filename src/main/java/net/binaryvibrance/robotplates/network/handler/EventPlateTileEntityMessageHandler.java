package net.binaryvibrance.robotplates.network.handler;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.binaryvibrance.robotplates.network.MessagePlateUpdatedEvent;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;

public class EventPlateTileEntityMessageHandler extends BasePlateTileEntityMessageHandler<TileEntityPlateEvent, MessagePlateUpdatedEvent> implements IMessageHandler<MessagePlateUpdatedEvent, IMessage> {
	public EventPlateTileEntityMessageHandler() {

	}

	@Override
	public IMessage onMessage(MessagePlateUpdatedEvent message, MessageContext ctx) {
		return super.onMessage(message);
	}

	@Override
	protected IMessage processMessage(MessagePlateUpdatedEvent messagePlateUpdatedEvent, TileEntityPlateEvent tileEntity) {
		tileEntity.setInstalledComponent(messagePlateUpdatedEvent.getInstalledComponent());
		return null;
	}
}
