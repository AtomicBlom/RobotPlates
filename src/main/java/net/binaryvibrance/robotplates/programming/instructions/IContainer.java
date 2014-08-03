package net.binaryvibrance.robotplates.programming.instructions;

public interface IContainer {
	boolean hasValue();
	Class getType();
	void setValue(Object value);
	Object getValue();
}
