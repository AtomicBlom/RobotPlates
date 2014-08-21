package net.binaryvibrance.robotplates.compiler;

import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.utility.CompassDirection;

import java.util.HashMap;

class InterconnectInfo {
	final BaseRobotPlatesTileEntity tileEntity;
	final HashMap<CompassDirection, InterconnectInfo> neighbour = new HashMap<CompassDirection, InterconnectInfo>();
	public CodePath codePath;

	public InterconnectInfo(BaseRobotPlatesTileEntity tileEntity) {

		this.tileEntity = tileEntity;
	}

	public void assignNeighbour(CompassDirection direction, InterconnectInfo neighbourTileEntity) {
		neighbour.put(direction, neighbourTileEntity);
	}
}
