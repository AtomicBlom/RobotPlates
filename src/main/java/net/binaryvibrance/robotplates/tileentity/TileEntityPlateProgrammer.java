package net.binaryvibrance.robotplates.tileentity;

import net.binaryvibrance.robotplates.programming.compiler.PlateCompiler;

public class TileEntityPlateProgrammer extends BaseRobotPlatesTileEntity {
	public void triggerCompile() {
		PlateCompiler compiler = new PlateCompiler();
		compiler.compile(this, worldObj);
	}
}
