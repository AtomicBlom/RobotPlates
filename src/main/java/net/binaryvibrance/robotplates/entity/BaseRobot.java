package net.binaryvibrance.robotplates.entity;

import net.binaryvibrance.robotplates.programming.instructions.Program;
import net.minecraft.world.World;

import java.util.UUID;

public abstract class BaseRobot extends RobotPlatesEntity {
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		BaseRobot baseRobot = (BaseRobot) o;

		if (!id.equals(baseRobot.id)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + id.hashCode();
		return result;
	}

	private final UUID id;
	private Program program;
	private int detectionRange;

	public BaseRobot(World world) {
		this(world, UUID.randomUUID());
	}
	public BaseRobot(World world, UUID id) {
		super(world);
		this.id = id;
	}

	@Override
	protected final void entityInit() {
		if (!worldObj.isRemote) {
			this.program = new Program(this);
			OnEntityInitializing();
		}
	}

	protected abstract void OnEntityInitializing();

	@Override
	public void onUpdate() {

		super.onUpdate();
		if (!worldObj.isRemote) {
			program.update();
		}
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

	public UUID getId() {
		return id;
	}
}
