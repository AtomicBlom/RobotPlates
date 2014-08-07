package net.binaryvibrance.robotplates.programming.instructions.event;

import net.binaryvibrance.robotplates.api.programming.*;
import net.binaryvibrance.robotplates.programming.eventHandler.TickEventHandler;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class EventTick implements IEvent, IHaveInstructions {

	private final List<IInstruction> instructions;
	private final UUID id;
	private ITriggerListener triggerListener;

	public EventTick() {

		instructions = new LinkedList<IInstruction>();
		id = UUID.randomUUID();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EventTick eventTick = (EventTick) o;

		return id.equals(eventTick.id);

	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}

	@Override
	public void setTriggerListener(ITriggerListener triggerListener) {

		this.triggerListener = triggerListener;
	}

	@Override
	public Iterable<IInstruction> getInstructions() {
		return instructions;
	}

	@Override
	public void trigger() {
		if (triggerListener != null) {
			triggerListener.startEvent(this);
		}
	}

	@Override
	public IEventHandler getHandler() {
		return TickEventHandler.getInstance();
	}
	//FIXME: Trigger event
}
