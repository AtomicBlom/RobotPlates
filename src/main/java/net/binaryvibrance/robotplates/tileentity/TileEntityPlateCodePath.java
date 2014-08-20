package net.binaryvibrance.robotplates.tileentity;

import net.binaryvibrance.robotplates.client.TileEntitySubObject.SubObject;
import net.binaryvibrance.robotplates.init.ModSubObjects;

public class TileEntityPlateCodePath extends BaseRobotPlatesTileEntity {
	public TileEntityPlateCodePath() {

	}

	@Override
	protected SubObject[] getSubObjects() {
		return ModSubObjects.codePathSubObjects;
	}
}
