package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.binaryvibrance.robotplates.server.handler.TickEventHandler;

public class ServerProxy extends CommonProxy {

	@Override
	public void registerEventHandlers(EventBus bus) {


		bus.register(TickEventHandler.getInstance());
	}
}
