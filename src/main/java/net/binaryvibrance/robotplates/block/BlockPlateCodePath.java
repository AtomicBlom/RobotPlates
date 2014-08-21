package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateCodePath;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlateCodePath extends BaseRobotPlateBlock implements ITileEntityProvider {
	public BlockPlateCodePath() {
		super(Material.rock);
		this.setBlockName("plateCodePath");
		this.setBlockTextureName("modelPlateCodePath");
		this.setBlockBounds(0.00F, 0.0F, 0.00F, 1.00F, (3f / 16f), 1.00F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIds.plateCodePath;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityPlateCodePath();
	}


}
