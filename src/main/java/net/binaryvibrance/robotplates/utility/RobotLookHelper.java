package net.binaryvibrance.robotplates.utility;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class RobotLookHelper
{
	private Entity entity;
	/**
	 * The amount of change that is made each update for an entity facing a direction.
	 */
	private float deltaLookYaw;
	/**
	 * The amount of change that is made each update for an entity facing a direction.
	 */
	private float deltaLookPitch;
	/** Whether or not the entity is trying to look at something. */
	private boolean isLooking;
	private double posX;
	private double posY;
	private double posZ;

	public RobotLookHelper(Entity entity)
	{
		this.entity = entity;
	}

	/**
	 * Sets position to look at using entity
	 */
	public void setLookPositionWithEntity(Entity entity, float yaw, float pitch)
	{
		this.posX = entity.posX;

		if (entity instanceof Entity)
		{
			this.posY = entity.posY + (double)entity.getEyeHeight();
		}
		else
		{
			this.posY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D;
		}

		this.posZ = entity.posZ;
		this.deltaLookYaw = yaw;
		this.deltaLookPitch = pitch;
		this.isLooking = true;
	}

	/**
	 * Sets position to look at
	 */
	public void setLookPosition(double posX, double posY, double posZ, float rotationYaw, float rotationPitch)
	{
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.deltaLookYaw = rotationYaw;
		this.deltaLookPitch = rotationPitch;
		this.isLooking = true;
	}

	/**
	 * Updates look
	 */
	public void onUpdateLook()
	{
		this.entity.rotationPitch = 0.0F;

		if (this.isLooking)
		{
			this.isLooking = false;
			double d0 = this.posX - this.entity.posX;
			double d1 = this.posY - (this.entity.posY + (double)this.entity.getEyeHeight());
			double d2 = this.posZ - this.entity.posZ;
			double d3 = (double) MathHelper.sqrt_double(d0 * d0 + d2 * d2);
			float f = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			float f1 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
			this.entity.rotationPitch = this.updateRotation(this.entity.rotationPitch, f1, this.deltaLookPitch);
			this.entity.rotationYaw = this.updateRotation(this.entity.rotationYaw, f, this.deltaLookYaw);
		}
		else
		{
			this.entity.rotationYaw = this.updateRotation(this.entity.rotationYaw, 0, 10.0F);
		}

		float f2 = MathHelper.wrapAngleTo180_float(this.entity.rotationYaw);

		if (f2 < -75.0F)
		{
			this.entity.rotationYaw = - 75.0F;
		}

		if (f2 > 75.0F)
		{
			this.entity.rotationYaw = + 75.0F;
		}
	}

	private float updateRotation(float angle, float p_75652_2_, float delta)
	{
		float f3 = MathHelper.wrapAngleTo180_float(p_75652_2_ - angle);

		if (f3 > delta)
		{
			f3 = delta;
		}

		if (f3 < -delta)
		{
			f3 = -delta;
		}

		return angle + f3;
	}
}
