package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.reference.Names;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateAction;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateCodePath;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateConditional;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;

public abstract class CommonProxy implements IProxy {
	@Override
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityPlateAction.class, Names.Blocks.PLATE_ACTION);
		GameRegistry.registerTileEntity(TileEntityPlateProgrammer.class, Names.Blocks.PLATE_PROGRAMMER);
		GameRegistry.registerTileEntity(TileEntityPlateConditional.class, Names.Blocks.PLATE_CONDITIONAL);
		GameRegistry.registerTileEntity(TileEntityPlateCodePath.class, Names.Blocks.PLATE_CODE_PATH);
	}
}
