package net.binaryvibrance.robotplates.init;

import cpw.mods.fml.common.FMLCommonHandler;
import net.binaryvibrance.robotplates.programming.event.EventPlayerInRangeHandler;

public final class ModEventHandlers {
	private static EventPlayerInRangeHandler eventPlayerInRangeHandler = new EventPlayerInRangeHandler();

	private ModEventHandlers() {
	}

	public static void init() {
		FMLCommonHandler.instance().bus().register(eventPlayerInRangeHandler);
	}

}
