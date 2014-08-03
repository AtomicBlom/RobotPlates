package net.binaryvibrance.robotplates.programming.instructions;

import java.util.LinkedList;
import java.util.List;

public class Program {

	private final List<IEvent> events;

	public Program() {
		events = new LinkedList<IEvent>();
	}

	public void AddEvent(IEvent event) {
		events.add(event);
	}
}
