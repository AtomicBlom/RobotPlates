package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateAction;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlateAction extends BaseRobotPlateBlock implements ITileEntityProvider {
	public BlockPlateAction() {
		super(Material.rock);
		this.setBlockName("plateAction");
		this.setBlockTextureName("modelPlateAction");
		this.setBlockBounds(0.00F, 0.0F, 0.00F, 1.00F, (3f / 16f), 1.00F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIds.plateAction;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityPlateAction();
	}
}
