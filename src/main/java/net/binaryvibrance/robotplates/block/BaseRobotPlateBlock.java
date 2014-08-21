package net.binaryvibrance.robotplates.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.creativetab.CreativeTabRobotPlate;
import net.binaryvibrance.robotplates.reference.Reference;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BaseRobotPlateBlock extends Block {
	BaseRobotPlateBlock(Material material) {
		super(material);
		this.setCreativeTab(CreativeTabRobotPlate.ROBOTPLATES_TAB);
	}

	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof BaseRobotPlatesTileEntity) {
			BaseRobotPlatesTileEntity rpTileEntity = (BaseRobotPlatesTileEntity)tileEntity;
			//Update neighbours.
			rpTileEntity.checkUpdate(true);
		}
		dropInventory(world, x, y, z);
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float px, float py, float pz) {
		if (world.isRemote) {
			return true;
		}

		BaseRobotPlatesTileEntity tileEntity = (BaseRobotPlatesTileEntity) world.getTileEntity(x, y, z);

		return tileEntity.onActivated(world, x, y, z, player, side, px, py, pz);

	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof BaseRobotPlatesTileEntity) {
			BaseRobotPlatesTileEntity rpTileEntity = (BaseRobotPlatesTileEntity)tileEntity;
			int direction = 0;
			int facing = MathHelper.floor_double((entityLiving.rotationYaw + 180.0f) * 4.0F / 360.0F + 0.5D) & 3;

			if (facing == 0) {
				LogHelper.info("Block facing North");
				direction = ForgeDirection.NORTH.ordinal();
			} else if (facing == 1) {
				LogHelper.info("Block facing East");
				direction = ForgeDirection.EAST.ordinal();
			} else if (facing == 2) {
				LogHelper.info("Block facing South");
				direction = ForgeDirection.SOUTH.ordinal();
			} else if (facing == 3) {
				LogHelper.info("Block facing West");
				direction = ForgeDirection.WEST.ordinal();
			}

			if (itemStack.hasDisplayName()) {
				rpTileEntity.setCustomName(itemStack.getDisplayName());
			}

			//rpTileEntity.setOrientation(direction);
			rpTileEntity.checkUpdate(false);
		}
	}

	protected void dropInventory(World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (!(tileEntity instanceof IInventory)) {
			return;
		}

		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack itemStack = inventory.getStackInSlot(i);

			if (itemStack != null && itemStack.stackSize > 0) {
				Random rand = new Random();

				float dX = rand.nextFloat() * 0.8F + 0.1F;
				float dY = rand.nextFloat() * 0.8F + 0.1F;
				float dZ = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, itemStack.copy());

				if (itemStack.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				itemStack.stackSize = 0;
			}
		}
	}

}
