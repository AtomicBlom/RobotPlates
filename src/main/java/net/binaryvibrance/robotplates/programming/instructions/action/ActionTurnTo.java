package net.binaryvibrance.robotplates.programming.instructions.action;

import net.binaryvibrance.robotplates.entity.BaseRobot;
import net.binaryvibrance.robotplates.api.programming.IHaveInstructions;
import net.binaryvibrance.robotplates.api.programming.IInstruction;
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

			/*double deltaX = robot.posX - player.posX;
			double deltaY = robot.posX - player.posY;

			double angle = Math.atan2(deltaY, deltaX) * 180 / Math.PI;
			if (robot.rotationYaw)*/


			if (lookHelper == null) {
				lookHelper = new RobotLookHelper(robot);
			}
			lookHelper.setLookPositionWithEntity(player, 1f, 1f);
			lookHelper.onUpdateLook();
		}
		return instructions;
	}

	@Override
	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}
}
