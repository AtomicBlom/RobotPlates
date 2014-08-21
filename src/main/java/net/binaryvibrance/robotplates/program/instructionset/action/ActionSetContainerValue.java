package net.binaryvibrance.robotplates.program.instructionset.action;

import net.binaryvibrance.robotplates.api.programming.IContainer;
import net.binaryvibrance.robotplates.api.programming.IHaveSuccessAndFailInstructions;
import net.binaryvibrance.robotplates.api.programming.IInstruction;
import net.binaryvibrance.robotplates.api.programming.IUseContainer;
import net.binaryvibrance.robotplates.program.ProgramState;

import java.util.LinkedList;
import java.util.List;

public class ActionSetContainerValue implements IInstruction, IUseContainer, IHaveSuccessAndFailInstructions {

	private final List<IInstruction> successInstructions;
	private final List<IInstruction> failInstructions;
	private IContainer container;

	public ActionSetContainerValue() {
		successInstructions = new LinkedList<IInstruction>();
		failInstructions = new LinkedList<IInstruction>();
	}

	@Override
	public void setContainer(IContainer container) {
		this.container = container;
	}

	@Override
	public List<IInstruction> execute(ProgramState state) {
		boolean success = false;

		try {
			Class containerType = container.getType();
			if (state.hasState(containerType)) {
				Object value = state.getState(containerType);
				container.setValue(value);
				success = true;
			}
		} catch (Exception e) {
		}

		return success ? successInstructions : failInstructions;
	}

	@Override
	public void addSuccessInstruction(IInstruction instruction) {
		successInstructions.add(instruction);
	}

	@Override
	public void addFailInstruction(IInstruction instruction) {
		failInstructions.add(instruction);
	}
}
