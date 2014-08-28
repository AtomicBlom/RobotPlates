package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.binaryvibrance.robotplates.network.BaseMessagePlateUpdated;
import net.binaryvibrance.robotplates.network.MessagePlateUpdatedEvent;
import net.binaryvibrance.robotplates.network.handler.DefaultPlateTileEntityMessageHandler;
import net.binaryvibrance.robotplates.network.handler.EventPlateTileEntityMessageHandler;
import net.binaryvibrance.robotplates.reference.Reference;

public final class ModPackets {
	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

	private ModPackets() {
	}

	public static void init() {
		NETWORK.registerMessage(DefaultPlateTileEntityMessageHandler.class, BaseMessagePlateUpdated.class,0, Side.CLIENT);
		NETWORK.registerMessage(EventPlateTileEntityMessageHandler.class, MessagePlateUpdatedEvent.class, 1, Side.CLIENT);
	}
}
