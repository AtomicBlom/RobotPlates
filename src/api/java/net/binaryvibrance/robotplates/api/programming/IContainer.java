package net.binaryvibrance.robotplates.api.programming;

public interface IContainer {
	boolean hasValue();
	Class getType();
	void setValue(Object value);
	Object getValue();
}

