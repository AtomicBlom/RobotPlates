package net.binaryvibrance.robotplates.entity.robot;

import net.binaryvibrance.robotplates.entity.BaseRobotPlatesEntityRobot;
import net.binaryvibrance.robotplates.programming.instructions.Container;
import net.binaryvibrance.robotplates.programming.instructions.Program;
import net.binaryvibrance.robotplates.programming.instructions.action.ActionDetectPlayer;
import net.binaryvibrance.robotplates.programming.instructions.action.ActionGetContainerValue;
import net.binaryvibrance.robotplates.programming.instructions.action.ActionSetContainerValue;
import net.binaryvibrance.robotplates.programming.instructions.action.ActionTurnTo;
import net.binaryvibrance.robotplates.programming.instructions.conditional.ConditionalContainerEmpty;
import net.binaryvibrance.robotplates.programming.instructions.event.EventTick;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityRobotBaseBob extends BaseRobotPlatesEntityRobot {
	public EntityRobotBaseBob(World world) {
		super(world);
		setDetectionRange(50);
	}

	@Override
	protected void OnEntityInitializing() {
		Program program = getProgram();

		Container<EntityPlayer> trackedPlayerContainer = new Container<EntityPlayer>(EntityPlayer.class);

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

		ActionGetContainerValue getContainerValueAction = new ActionGetContainerValue();
		getContainerValueAction.setContainer(trackedPlayerContainer);

		getContainerValueAction.addInstruction(turnToAction);

		trackedPlayerEmpty.addSuccessInstruction(getContainerValueAction);

		EventTick tickEvent = new EventTick();
		tickEvent.addInstruction(trackedPlayerEmpty);

		program.AddEvent(tickEvent);

		program.start();
	}
}
