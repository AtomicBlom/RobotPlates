package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.binaryvibrance.robotplates.network.RobotPlatesTileEntityMessage;
import net.binaryvibrance.robotplates.reference.Reference;

public final class ModPackets {
	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

	private ModPackets() {
	}

	public static void init() {
		NETWORK.registerMessage(RobotPlatesTileEntityMessage.class, RobotPlatesTileEntityMessage.class, 0, Side.CLIENT);
	}
}
