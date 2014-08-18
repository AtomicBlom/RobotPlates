package net.binaryvibrance.robotplates.programming.compiler;

import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.utility.CompassDirection;

import java.util.HashMap;

class InterconnectInfo {
	private final BaseRobotPlatesTileEntity tileEntity;
	private final HashMap<CompassDirection, BaseRobotPlatesTileEntity> neighbour = new HashMap<CompassDirection, BaseRobotPlatesTileEntity>();

	public InterconnectInfo(BaseRobotPlatesTileEntity tileEntity) {

		this.tileEntity = tileEntity;
	}

	public void assignNeighbour(CompassDirection direction, BaseRobotPlatesTileEntity neighbourTileEntity) {
		neighbour.put(direction, neighbourTileEntity);
	}
}
