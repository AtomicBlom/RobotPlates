package net.binaryvibrance.robotplates.programming.instructions.action;

import net.binaryvibrance.robotplates.entity.BaseRobot;
import net.binaryvibrance.robotplates.programming.instructions.IHaveInstructions;
import net.binaryvibrance.robotplates.programming.instructions.IInstruction;
import net.binaryvibrance.robotplates.programming.instructions.ProgramState;
import net.binaryvibrance.robotplates.utility.RobotLookHelper;
import net.minecraft.entity.player.EntityPlayer;

import java.util.LinkedList;
import java.util.List;

public class ActionTurnTo implements IInstruction, IHaveInstructions {
	private final List<IInstruction> instructions;
	private RobotLookHelper lookHelper;

	public ActionTurnTo() {
		instructions = new LinkedList<IInstruction>();
	}

	@Override
	public List<IInstruction> execute(ProgramState state) {
		EntityPlayer player = (EntityPlayer)state.getState(EntityPlayer.class);

		if (player != null) {
			BaseRobot robot = state.getRobot();
			if (lookHelper == null) {
				lookHelper = new RobotLookHelper(robot);
			}
			lookHelper.setLookPositionWithEntity(player, 10f, 10f);
			lookHelper.onUpdateLook();
		}
		return instructions;
	}

	@Override
	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}
}
