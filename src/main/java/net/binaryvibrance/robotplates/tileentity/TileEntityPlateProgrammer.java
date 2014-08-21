package net.binaryvibrance.robotplates.tileentity;

import net.binaryvibrance.robotplates.compiler.PlateCompiler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TileEntityPlateProgrammer extends BaseRobotPlatesTileEntity {

	@Override
	public boolean onActivated(World world, int x, int y, int z, EntityPlayer player, int side, float px, float py, float pz) {
		triggerCompile();
		return true;
	}

	public void triggerCompile() {
		PlateCompiler compiler = new PlateCompiler();
		compiler.compile(this, worldObj);
	}
}
