package net.binaryvibrance.robotplates.programming.instructions.event;

import net.binaryvibrance.robotplates.programming.instructions.*;

import java.util.LinkedList;
import java.util.List;

public class EventTick implements IEvent, IHaveInstructions {

	private final List<IInstruction> instructions;
	private ITriggerListener triggerListener;

	public EventTick() {
		instructions = new LinkedList<IInstruction>();
	}

	@Override
	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}

	@Override
	public void setTriggerListener(ITriggerListener triggerListener) {

		this.triggerListener = triggerListener;
	}

	//FIXME: Trigger event
}
