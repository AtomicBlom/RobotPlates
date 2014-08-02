package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityConditionalPlate;
import net.binaryvibrance.robotplates.tileentity.TileEntityStartPlate;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public class BlockConditionalPlate extends BlockRobotPlate implements ITileEntityProvider {
	public BlockConditionalPlate()
	{
		super(Material.rock);
		this.setBlockName("conditionalPlate");
		this.setBlockTextureName("conditionalPlate");
		this.setBlockBounds(0.00F, 0.0F, 0.00F, 1.00F, (3f/16f), 1.00F);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIds.conditionalPlate;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityConditionalPlate();
	}
}
