package net.binaryvibrance.robotplates.block;

import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BlockPlateProgrammer extends BaseRobotPlateBlock implements ITileEntityProvider {
	public BlockPlateProgrammer() {
		super(Material.rock);
		this.setBlockName("plateProgrammer");
		this.setBlockTextureName("modelPlateProgrammer");
		this.setBlockBounds(0.00F, 0.0F, 0.00F, 1.00F, (3f / 16f), 1.00F);

	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIds.plateProgrammer;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityPlateProgrammer();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float px, float py, float pz) {
		if (world.isRemote) {
			return true;
		}

		LogHelper.info("Create Blocks");

		TileEntityPlateProgrammer tileEntity = (TileEntityPlateProgrammer) world.getTileEntity(x, y, z);
		tileEntity.triggerCompile();




		return true;
	}
}
