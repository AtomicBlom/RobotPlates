package net.binaryvibrance.robotplates.tileentity;

import net.binaryvibrance.robotplates.utility.subobject.SubObject;
import net.binaryvibrance.robotplates.init.ModSubObjects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TileEntityPlateCodePath extends BaseRobotPlatesTileEntity {
	public TileEntityPlateCodePath() {

	}

	@Override
	protected SubObject[] getSubObjects() {
		return ModSubObjects.codePathSubObjects;
	}

	@Override
	public boolean onActivated(World world, int x, int y, int z, EntityPlayer player, int side, float px, float py, float pz) {
		for (SubObject subObject : getSubObjects()) {
			if (subObject.getBoundingBox().isVecInside(Vec3.createVectorHelper(px, py, pz))) {
				//TODO:Ok, found a subObject, what's it for, what do I trigger?
				//TODO: Notify client.
			}
		}
		return true;
	}
}
