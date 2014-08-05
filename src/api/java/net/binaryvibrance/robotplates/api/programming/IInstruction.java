package net.binaryvibrance.robotplates.api.programming;

import net.binaryvibrance.robotplates.programming.instructions.ProgramState;

import java.util.List;

public interface IInstruction {
	List<IInstruction> execute(ProgramState state);
}
