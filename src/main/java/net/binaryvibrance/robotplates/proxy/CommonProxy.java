package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.reference.Names;
import net.binaryvibrance.robotplates.tileentity.TileEntityStartPlate;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public abstract class CommonProxy implements IProxy {
	@Override
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityStartPlate.class, Names.Blocks.START_PLATE);
	}
}
