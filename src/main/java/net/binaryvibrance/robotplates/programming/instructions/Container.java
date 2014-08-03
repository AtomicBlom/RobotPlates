package net.binaryvibrance.robotplates.programming.instructions;

import java.util.UUID;

public class Container<T> implements IContainer {

	private UUID identifier;
	private T value;

	public Container() {
		identifier = UUID.randomUUID();
	}

	public Container(UUID identifier) {

		this.identifier = identifier;
	}

	@Override
	public boolean hasValue() {
		return value != null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
