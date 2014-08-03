package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import net.binaryvibrance.robotplates.programming.event.EventPlayerInRangeHandler;

public final class ModEventHandlers {
	private ModEventHandlers() {}
	private static EventPlayerInRangeHandler eventPlayerInRangeHandler = new EventPlayerInRangeHandler();

	public static void init() {
		FMLCommonHandler.instance().bus().register(eventPlayerInRangeHandler);
	}

}
