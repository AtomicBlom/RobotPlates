package net.binaryvibrance.robotplates.programming.instructions;

import java.util.List;

public interface IInstruction {
	List<IInstruction> execute(ProgramState state);
}
