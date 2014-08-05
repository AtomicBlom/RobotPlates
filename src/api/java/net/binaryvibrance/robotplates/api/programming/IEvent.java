package net.binaryvibrance.robotplates.api.programming;

import java.util.UUID;

public interface IEvent {
	void setTriggerListener(ITriggerListener triggerListener);
	Iterable<IInstruction> getInstructions();
	void trigger();
	IEventHandler getHandler();
}
