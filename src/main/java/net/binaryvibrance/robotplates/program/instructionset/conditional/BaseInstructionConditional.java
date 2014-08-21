package net.binaryvibrance.robotplates.program.instructionset.conditional;

import net.binaryvibrance.robotplates.api.programming.IHaveSuccessAndFailInstructions;
import net.binaryvibrance.robotplates.api.programming.IInstruction;
import net.binaryvibrance.robotplates.program.ProgramState;

import java.util.LinkedList;
import java.util.List;

public abstract class BaseInstructionConditional implements IInstruction, IHaveSuccessAndFailInstructions {
	private final List<IInstruction> successInstructions;
	private final List<IInstruction> failInstructions;

	protected BaseInstructionConditional() {
		successInstructions = new LinkedList<IInstruction>();
		failInstructions = new LinkedList<IInstruction>();
	}

	@Override
	public List<IInstruction> execute(ProgramState state) {
		if (testCondition(state)) {
			return successInstructions;
		} else {
			return failInstructions;
		}
	}

	protected abstract boolean testCondition(ProgramState state);

	@Override
	public void addSuccessInstruction(IInstruction instruction) {
		successInstructions.add(instruction);
	}

	@Override
	public void addFailInstruction(IInstruction instruction) {
		failInstructions.add(instruction);
	}
}
