package net.binaryvibrance.robotplates.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public abstract class RobotPlatesEntity extends Entity {

	RobotPlatesEntity(World world) {
		super(world);
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}

	@Override
	public AxisAlignedBB getCollisionBox(Entity entity) {
		return entity.boundingBox;
	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompound) {

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {

	}
}
