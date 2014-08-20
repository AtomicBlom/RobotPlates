package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;
import net.binaryvibrance.robotplates.programming.eventHandler.TickEventHandler;

public class ServerProxy extends CommonProxy {

	@Override
	public void registerEventHandlers(EventBus bus) {


		bus.register(TickEventHandler.getInstance());
	}
}
