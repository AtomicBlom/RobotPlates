package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPlateEvent extends RobotPlateBlockBase implements ITileEntityProvider {
	public BlockPlateEvent() {
		super(Material.rock);
		this.setBlockName("plateEvent");
		this.setBlockTextureName("modelPlateEvent");
		this.setBlockBounds(0.00F, 0.0F, 0.00F, 1.00F, (3f / 16f), 1.00F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIds.plateEvent;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityPlateEvent();
	}
}
