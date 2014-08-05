package net.binaryvibrance.robotplates.programming.eventHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import net.binaryvibrance.robotplates.api.programming.IEvent;
import net.binaryvibrance.robotplates.api.programming.IEventHandler;

import java.util.HashSet;

public final class TickEventHandler implements IEventHandler {
	private TickEventHandler() {}
	private static TickEventHandler instance = new TickEventHandler();
	private HashSet<IEvent> registeredEvents = new HashSet<IEvent>();

	public static TickEventHandler getInstance() {
		return instance;
	}

	@Override
	public void register(IEvent event) {
		if (!registeredEvents.contains(event)) {
			registeredEvents.add(event);
		}
	}

	@Override
	public void unregister(IEvent event) {
		registeredEvents.remove(event);
	}

	@SubscribeEvent
	public void onTick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			for (IEvent registeredEvent : registeredEvents) {
				registeredEvent.trigger();
			}
		}
	}
}
