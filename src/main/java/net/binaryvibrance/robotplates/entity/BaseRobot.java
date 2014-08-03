package net.binaryvibrance.robotplates.entity;

import net.binaryvibrance.robotplates.programming.instructions.Program;
import net.minecraft.world.World;

public class BaseRobot extends RobotPlatesEntity {

	private final Program program = new Program();
	private int detectionRange;

	public BaseRobot(World world) {
		super(world);
	}

	@Override
	protected void entityInit() {

	}

	@Override
	public void onUpdate() {
		super.onUpdate();
	}

	public int getDetectionRange() {
		return detectionRange;
	}

	public void setDetectionRange(int range) {
		detectionRange = range;
	}

	protected Program getProgram()
	{
		return this.program;
	}

}
