package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.binaryvibrance.robotplates.reference.Names;
import net.binaryvibrance.robotplates.tileentity.*;

public abstract class CommonProxy implements IProxy {
	@Override
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityPlateAction.class, Names.Blocks.PLATE_ACTION);
		GameRegistry.registerTileEntity(TileEntityPlateCodePath.class, Names.Blocks.PLATE_CODE_PATH);
		GameRegistry.registerTileEntity(TileEntityPlateConditional.class, Names.Blocks.PLATE_CONDITIONAL);
		GameRegistry.registerTileEntity(TileEntityPlateEvent.class, Names.Blocks.PLATE_EVENT);
		GameRegistry.registerTileEntity(TileEntityPlateProgrammer.class, Names.Blocks.PLATE_PROGRAMMER);
	}

	@Override
	public void initRenderingAndTextures() {
		//No-op
	}


}
