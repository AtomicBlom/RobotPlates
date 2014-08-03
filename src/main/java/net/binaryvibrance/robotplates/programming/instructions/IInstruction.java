package net.binaryvibrance.robotplates.programming.instructions;

import java.util.Dictionary;
import java.util.List;

public interface IInstruction {
	List<IInstruction> Execute(Dictionary<Class, Object> state);
}
