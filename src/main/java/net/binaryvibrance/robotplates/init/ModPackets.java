package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.binaryvibrance.robotplates.network.MessageTileEntityRobotPlates;
import net.binaryvibrance.robotplates.reference.Reference;

/**
 * Created by CodeWarrior on 1/08/2014.
 */
public final class ModPackets {
	private ModPackets() {}

	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

	public static void init() {
		NETWORK.registerMessage(MessageTileEntityRobotPlates.class, MessageTileEntityRobotPlates.class, 0, Side.CLIENT);
	}
}
