package net.binaryvibrance.robotplates.programming.instructions.conditional;

import net.binaryvibrance.robotplates.api.programming.IContainer;
import net.binaryvibrance.robotplates.api.programming.IUseContainer;
import net.binaryvibrance.robotplates.programming.instructions.InstructionConditional;
import net.binaryvibrance.robotplates.programming.instructions.ProgramState;

import java.util.Dictionary;

public class ConditionalContainerEmpty extends InstructionConditional implements IUseContainer {
	private IContainer container;

	@Override
	protected boolean testCondition(ProgramState state) {
		return container.hasValue();
	}

	@Override
	public void setContainer(IContainer container) {

		this.container = container;
	}
}
