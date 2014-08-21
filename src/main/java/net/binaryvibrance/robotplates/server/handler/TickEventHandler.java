package net.binaryvibrance.robotplates.server.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.binaryvibrance.robotplates.api.programming.IEvent;
import net.binaryvibrance.robotplates.api.programming.IEventHandler;

import java.util.HashSet;

public final class TickEventHandler implements IEventHandler {
	private static final TickEventHandler instance = new TickEventHandler();
	private final HashSet<IEvent> registeredEvents = new HashSet<IEvent>();
	private TickEventHandler() {
	}

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
