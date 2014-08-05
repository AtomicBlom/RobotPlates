package net.binaryvibrance.robotplates.api.programming;

public interface IEventHandler {
	void register(IEvent event);
	void unregister(IEvent event);
}
