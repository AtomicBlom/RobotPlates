package net.binaryvibrance.robotplates.utility;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class RobotLookHelper {
	private final Entity entity;
	/**
	 * The amount of change that is made each update for an entity facing a direction.
	 */
	private float deltaLookYaw;
	/**
	 * The amount of change that is made each update for an entity facing a direction.
	 */
	private float deltaLookPitch;
	/**
	 * Whether or not the entity is trying to look at something.
	 */
	private boolean isLooking;
	private double posX;
	private double posY;
	private double posZ;

	public RobotLookHelper(Entity entity) {
		this.entity = entity;
	}

	/**
	 * Sets position to look at using entity
	 */
	public void setLookPositionWithEntity(Entity entity, float yaw, float pitch) {
		this.posX = entity.posX;

		this.posY = entity.posY + (double) entity.getEyeHeight();

		this.posZ = entity.posZ;
		this.deltaLookYaw = yaw;
		this.deltaLookPitch = pitch;
		this.isLooking = true;
	}

	/**
	 * Sets position to look at
	 */
	public void setLookPosition(double posX, double posY, double posZ, float rotationYaw, float rotationPitch) {
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
	public void onUpdateLook() {
		this.entity.rotationPitch = 0.0F;

		if (this.isLooking) {
			this.isLooking = false;
			double deltaX = this.posX - this.entity.posX;
			double deltaY = this.posY - (this.entity.posY + (double) this.entity.getEyeHeight());
			double deltaZ = this.posZ - this.entity.posZ;
			double d3 = (double) MathHelper.sqrt_double(deltaX * deltaX + deltaZ * deltaZ);
			float destinationYawAngle = (float) (Math.atan2(deltaZ, deltaX) * 180.0D / Math.PI) - 90.0F;
			float destinationPitchAngle = (float) (-(Math.atan2(deltaY, d3) * 180.0D / Math.PI));
			this.entity.rotationPitch = this.updateRotation(this.entity.rotationPitch, destinationPitchAngle, this.deltaLookPitch);
			this.entity.rotationYaw = this.updateRotation(this.entity.rotationYaw, destinationYawAngle, this.deltaLookYaw);
		} else {
			this.entity.rotationYaw = this.updateRotation(this.entity.rotationYaw, 0, 1.0F);
		}
	}

	private float updateRotation(float angle, float p_75652_2_, float delta) {
		float f3 = MathHelper.wrapAngleTo180_float(p_75652_2_ - angle);

		if (f3 > delta) {
			f3 = delta;
		}

		if (f3 < -delta) {
			f3 = -delta;
		}

		return angle + f3;
	}
}
