package net.binaryvibrance.robotplates.utility;

import net.minecraftforge.common.util.ForgeDirection;

public enum CompassDirection {
	/** -Z */
	NORTH(0, 0, -1),

	/** +Z */
	SOUTH(0, 0, 1),

	/** -X */
	WEST(-1, 0, 0),

	/** +X */
	EAST(1, 0, 0),

	/**
	 * Used only by getOrientation, for invalid inputs
	 */
	UNKNOWN(0, 0, 0);

	public final int offsetX;
	public final int offsetY;
	public final int offsetZ;
	public final int flag;
	public static final CompassDirection[] VALID_DIRECTIONS = {NORTH, SOUTH, WEST, EAST};
	private static final int[] FROM_FORGE_MAPPINGS = {4, 4, 0, 1, 2, 3, 4};
	private static final int[] TO_FORGE_MAPPINGS = {2, 3, 4, 5, 6};
	private static final int[] OPPOSITES = {1, 0, 3, 2, 4};
	// Left hand rule rotation matrix for all possible axes of rotation
	/*public static final int[][] ROTATION_MATRIX = {
			{0, 1, 4, 5, 3, 2, 6},
			{0, 1, 5, 4, 2, 3, 6},
			{5, 4, 2, 3, 0, 1, 6},
			{4, 5, 2, 3, 1, 0, 6},
			{2, 3, 1, 0, 4, 5, 6},
			{3, 2, 0, 1, 4, 5, 6},
			{0, 1, 2, 3, 4, 5, 6},
	};*/

	private CompassDirection(int x, int y, int z)
	{
		offsetX = x;
		offsetY = y;
		offsetZ = z;
		flag = 1 << ordinal();
	}

	public static CompassDirection getOrientation(int id)
	{
		if (id >= 0 && id < VALID_DIRECTIONS.length)
		{
			return VALID_DIRECTIONS[id];
		}
		return UNKNOWN;
	}

	public CompassDirection getOpposite()
	{
		return getOrientation(OPPOSITES[ordinal()]);
	}

	/*public CompassDirection getRotation(CompassDirection axis)
	{
		return getOrientation(ROTATION_MATRIX[axis.ordinal()][ordinal()]);
	}*/

	public static CompassDirection fromForgeDirection(ForgeDirection forgeDirection) {
		return VALID_DIRECTIONS[FROM_FORGE_MAPPINGS[forgeDirection.ordinal()]];
	}

	public ForgeDirection toForgeDirection() {
		return ForgeDirection.getOrientation(TO_FORGE_MAPPINGS[ordinal()]);
	}
}