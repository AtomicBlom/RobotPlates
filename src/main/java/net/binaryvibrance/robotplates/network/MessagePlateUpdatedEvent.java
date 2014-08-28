package net.binaryvibrance.robotplates.network;

import io.netty.buffer.ByteBuf;
import net.binaryvibrance.robotplates.compiler.component.EventPlateComponent;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;

public class MessagePlateUpdatedEvent extends BaseMessagePlateUpdated {
	private EventPlateComponent installedComponent;

	@SuppressWarnings("UnusedDeclaration")
	public MessagePlateUpdatedEvent() {

	}

	@SuppressWarnings("UnusedDeclaration")
	public MessagePlateUpdatedEvent(TileEntityPlateEvent eventPlateTileEntity) {
		super(eventPlateTileEntity);
		this.installedComponent = eventPlateTileEntity.getInstalledComponent();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		super.fromBytes(buf);
		this.installedComponent = EventPlateComponent.values()[buf.readInt()];
	}

	@Override
	public void toBytes(ByteBuf buf) {
		super.toBytes(buf);
		buf.writeInt(this.installedComponent.ordinal());
	}

	@Override
	public String toString() {
		return String.format("%s, eventType:%s", super.toString(), installedComponent);
	}

	public EventPlateComponent getInstalledComponent() {
		return installedComponent;
	}
}