package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityStartPlate;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStartPlate extends BlockRobotPlate implements ITileEntityProvider {
	public BlockStartPlate()
	{
		super(Material.rock);
		this.setBlockName("startPlate");
		this.setBlockTextureName("startPlate");
		this.setBlockBounds(0.00F, 0.0F, 0.00F, 1.00F, (3f/16f), 1.00F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIds.startPlate;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityStartPlate();
	}
}
