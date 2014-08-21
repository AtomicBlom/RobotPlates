package net.binaryvibrance.robotplates.program.instructionset.conditional;

import net.binaryvibrance.robotplates.api.programming.IContainer;
import net.binaryvibrance.robotplates.api.programming.IUseContainer;
import net.binaryvibrance.robotplates.program.ProgramState;

public class ConditionalContainerEmpty extends BaseInstructionConditional implements IUseContainer {
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
