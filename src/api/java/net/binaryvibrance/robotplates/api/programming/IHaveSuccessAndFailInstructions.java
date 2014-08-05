package net.binaryvibrance.robotplates.api.programming;

public interface IHaveSuccessAndFailInstructions {
	void addSuccessInstruction(IInstruction instruction);

	void addFailInstruction(IInstruction instruction);
}
