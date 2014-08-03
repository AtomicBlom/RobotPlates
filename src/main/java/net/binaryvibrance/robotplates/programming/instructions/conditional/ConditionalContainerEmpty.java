package net.binaryvibrance.robotplates.programming.instructions.conditional;

import net.binaryvibrance.robotplates.programming.instructions.IContainer;
import net.binaryvibrance.robotplates.programming.instructions.IUseContainer;
import net.binaryvibrance.robotplates.programming.instructions.InstructionConditional;

import java.util.Dictionary;

public class ConditionalContainerEmpty extends InstructionConditional implements IUseContainer {
	private IContainer container;

	@Override
	protected boolean testCondition(Dictionary<Class, Object> state) {
		return container.hasValue();
	}

	@Override
	public void setContainer(IContainer container) {

		this.container = container;
	}
}
