package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityStartPlate;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public class BlockStartPlate extends BlockRobotPlate implements ITileEntityProvider {
	public BlockStartPlate()
	{
		super(Material.rock);
		this.setBlockName("startPlate");
		this.setBlockTextureName("startPlate");
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
