package net.binaryvibrance.robotplates.api.programming;

import net.binaryvibrance.robotplates.program.ProgramState;

import java.util.List;

public interface IInstruction {
	List<IInstruction> execute(ProgramState state);
}
