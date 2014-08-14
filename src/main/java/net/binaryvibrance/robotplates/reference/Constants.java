package net.binaryvibrance.robotplates.reference;

import net.minecraftforge.common.util.ForgeDirection;

public final class Constants {
	private Constants() {}

	public static final ForgeDirection[] COMPASS_DIRECTIONS = {ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH, ForgeDirection.WEST};
	public static final int[] COMPASS_ORDINALS = new int[7];
	static {
		COMPASS_ORDINALS[ForgeDirection.NORTH.ordinal()] = 0;
		COMPASS_ORDINALS[ForgeDirection.EAST.ordinal()] = 1;
		COMPASS_ORDINALS[ForgeDirection.SOUTH.ordinal()] = 2;
		COMPASS_ORDINALS[ForgeDirection.WEST.ordinal()] = 3;
	}
}
