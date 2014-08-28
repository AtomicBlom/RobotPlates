package net.binaryvibrance.robotplates.network.handler;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.binaryvibrance.robotplates.network.BaseMessagePlateUpdated;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.client.multiplayer.WorldClient;

public abstract class BasePlateTileEntityMessageHandler<TTileEntity extends BaseRobotPlatesTileEntity, TMessage extends BaseMessagePlateUpdated> {
	public IMessage onMessage(TMessage message) {
		LogHelper.debug("Received Message" + message);
		WorldClient world = FMLClientHandler.instance().getClient().theWorld;
		TTileEntity tileEntity = null;
		try {
			tileEntity = (TTileEntity) world.getTileEntity(message.getX(), message.getY(), message.getZ());
		} catch (ClassCastException cce) {
		}
		if (tileEntity == null) {
			LogHelper.warn("Tile Entity at (%d, %d, %d) either did not exist, or was not a RobotPlates Plate");
			return null;
		}

		tileEntity.setState(message.getState());
		tileEntity.setCustomName(message.getCustomName());
		tileEntity.setOwner(message.getOwner());
		boolean[] activeSignals = message.getActiveSignals();
		for (int i = 0; i < activeSignals.length; ++i) {
			tileEntity.activeSignals[i] = activeSignals[i];
		}
		return processMessage(message, tileEntity);
	}

	protected abstract IMessage processMessage(TMessage message, TTileEntity tileEntity);
}
