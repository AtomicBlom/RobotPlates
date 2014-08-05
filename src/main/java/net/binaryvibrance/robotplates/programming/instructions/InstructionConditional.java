package net.binaryvibrance.robotplates.programming.instructions;

import net.binaryvibrance.robotplates.api.programming.IHaveSuccessAndFailInstructions;
import net.binaryvibrance.robotplates.api.programming.IInstruction;

import java.util.LinkedList;
import java.util.List;

public abstract class InstructionConditional implements IInstruction, IHaveSuccessAndFailInstructions {
	private List<IInstruction> successInstructions;
	private List<IInstruction> failInstructions;

	protected InstructionConditional() {
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
