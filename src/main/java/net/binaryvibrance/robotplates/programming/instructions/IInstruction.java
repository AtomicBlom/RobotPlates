package net.binaryvibrance.robotplates.programming.instructions;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by CodeWarrior on 3/08/2014.
 */
public interface IInstruction {
	List<IInstruction> Execute(Dictionary<Class, Object> state);
}
