package net.binaryvibrance.robotplates.network.handler;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.binaryvibrance.robotplates.network.BaseMessagePlateUpdated;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;

public class DefaultPlateTileEntityMessageHandler extends BasePlateTileEntityMessageHandler<BaseRobotPlatesTileEntity, BaseMessagePlateUpdated> implements IMessageHandler<BaseMessagePlateUpdated, IMessage> {
	@Override
	public IMessage onMessage(BaseMessagePlateUpdated message, MessageContext ctx) {
		return super.onMessage(message);
	}

	@Override
	protected IMessage processMessage(BaseMessagePlateUpdated baseMessagePlateUpdated, BaseRobotPlatesTileEntity tileEntity) {
		return null;
	}
}
