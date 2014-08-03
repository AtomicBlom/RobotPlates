package net.binaryvibrance.robotplates.programming.instructions.action;

import net.binaryvibrance.robotplates.programming.instructions.*;

import java.util.LinkedList;
import java.util.List;

public class ActionGetContainerValue implements IInstruction, IHaveInstructions, IUseContainer {

	private final List<IInstruction> instructions;
	private IContainer container;

	public ActionGetContainerValue() {
		instructions = new LinkedList<IInstruction>();
	}

	@Override
	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}

	@Override
	public List<IInstruction> execute(ProgramState state) {
		if (container.hasValue()) {
			state.setState(container.getValue());
		}
		return instructions;
	}

	@Override
	public void setContainer(IContainer container) {

		this.container = container;
	}
}
