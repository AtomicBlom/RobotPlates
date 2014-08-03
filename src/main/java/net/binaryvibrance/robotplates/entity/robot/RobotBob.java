package net.binaryvibrance.robotplates.entity.robot;

import net.binaryvibrance.robotplates.entity.BaseRobot;
import net.binaryvibrance.robotplates.programming.instructions.Container;
import net.binaryvibrance.robotplates.programming.instructions.Program;
import net.binaryvibrance.robotplates.programming.instructions.action.ActionDetectPlayer;
import net.binaryvibrance.robotplates.programming.instructions.action.ActionSetContainerValue;
import net.binaryvibrance.robotplates.programming.instructions.action.ActionTurnTo;
import net.binaryvibrance.robotplates.programming.instructions.conditional.ConditionalContainerEmpty;
import net.binaryvibrance.robotplates.programming.instructions.event.EventTick;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class RobotBob extends BaseRobot {
	public RobotBob(World world) {
		super(world);
		setDetectionRange(50);
	}

	@Override
	protected void entityInit() {
		Container<EntityPlayer> trackedPlayerContainer = new Container<EntityPlayer>();

		//Level 1
		ConditionalContainerEmpty trackedPlayerEmpty = new ConditionalContainerEmpty();
		trackedPlayerEmpty.setContainer(trackedPlayerContainer);


		ActionDetectPlayer detectPlayerAction = new ActionDetectPlayer();
		//Level 2
		trackedPlayerEmpty.addFailInstruction(detectPlayerAction);

		ActionSetContainerValue setContainerValueAction = new ActionSetContainerValue();
		setContainerValueAction.setContainer(trackedPlayerContainer);
		//Level 3
		detectPlayerAction.addInstruction(setContainerValueAction);

		//Level 4
		ActionTurnTo turnToAction = new ActionTurnTo();

		setContainerValueAction.addSuccessInstruction(turnToAction);
		trackedPlayerEmpty.addSuccessInstruction(turnToAction);

		EventTick tickEvent = new EventTick();
		tickEvent.addInstruction(trackedPlayerEmpty);

		getProgram().AddEvent(tickEvent);
	}
}
