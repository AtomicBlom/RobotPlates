package net.binaryvibrance.robotplates.programming.instructions;

import net.binaryvibrance.robotplates.api.programming.IContainerOfT;

import java.util.UUID;

public class Container<T> implements IContainerOfT<T> {

	private final Class<T> typeOfT;
	private UUID identifier;
	private T value;

	public Container(Class type) {
		this(type, UUID.randomUUID());
	}

	@SuppressWarnings("unchecked")
	public Container(Class type, UUID identifier) {

		this.identifier = identifier;
		this.typeOfT = type;
	}

	@Override
	public boolean hasValue() {
		return value != null;
	}

	@Override
	public Class getType() {
		return typeOfT;
	}

	public Object getValue() {
		return value;
	}

	@SuppressWarnings("unchecked")
	public void setValue(Object value) {
		try {
			this.value = (T) value;
		} catch (Exception e) {
			//FIXME: Ok, somehow I've managed to pass the wrong type to this method.
		}
	}
}
