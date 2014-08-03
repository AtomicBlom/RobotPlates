package net.binaryvibrance.robotplates.item;

import net.binaryvibrance.robotplates.creativetab.CreativeTabRobotPlate;
import net.binaryvibrance.robotplates.entity.BaseRobot;
import net.binaryvibrance.robotplates.entity.robot.RobotBob;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemRobot extends Item {

	public ItemRobot() {
		super();
		this.setCreativeTab(CreativeTabRobotPlate.ROBOTPLATES_TAB);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz) {
		if (world.isRemote) return true;

		x += Facing.offsetsXForSide[side];
		y += Facing.offsetsYForSide[side];
		z += Facing.offsetsZForSide[side];

		x += 0.5f;
		z += 0.5f;

		Entity e = spawnNewRobot(world, itemStack);
		e.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		world.spawnEntityInWorld(e);
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
		return super.onItemRightClick(p_77659_1_, p_77659_2_, p_77659_3_);
	}

	private Entity spawnNewRobot(World world, ItemStack itemStack) {
		BaseRobot bot = new RobotBob(world);
		return bot;
	}
}
