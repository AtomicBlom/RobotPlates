package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateConditional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlateConditional extends BaseRobotPlateBlock implements ITileEntityProvider {
	public BlockPlateConditional() {
		super(Material.rock);
		this.setBlockName("plateConditional");
		this.setBlockTextureName("modelPlateConditional");
		this.setBlockBounds(0.00F, 0.0F, 0.00F, 1.00F, (3f / 16f), 1.00F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIds.plateConditional;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityPlateConditional();
	}
}
