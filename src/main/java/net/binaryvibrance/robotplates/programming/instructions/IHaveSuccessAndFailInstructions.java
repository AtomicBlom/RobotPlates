package net.binaryvibrance.robotplates.programming.instructions;

public interface IHaveSuccessAndFailInstructions {
	void addSuccessInstruction(IInstruction instruction);

	void addFailInstruction(IInstruction instruction);
}
