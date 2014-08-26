package net.binaryvibrance.robotplates.entity.robot;

import net.binaryvibrance.robotplates.entity.BaseRobotPlatesEntityRobot;
import net.binaryvibrance.robotplates.program.Program;
import net.binaryvibrance.robotplates.program.instructionset.action.ActionDetectPlayer;
import net.binaryvibrance.robotplates.program.instructionset.action.ActionGetContainerValue;
import net.binaryvibrance.robotplates.program.instructionset.action.ActionSetContainerValue;
import net.binaryvibrance.robotplates.program.instructionset.action.ActionTurnTo;
import net.binaryvibrance.robotplates.program.instructionset.conditional.ConditionalContainerEmpty;
import net.binaryvibrance.robotplates.program.instructionset.event.EventTick;
import net.binaryvibrance.robotplates.program.variable.Container;
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
