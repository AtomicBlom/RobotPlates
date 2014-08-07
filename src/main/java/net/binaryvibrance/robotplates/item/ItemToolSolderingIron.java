package net.binaryvibrance.robotplates.item;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemToolSolderingIron extends ItemRobotPlate {
	public ItemToolSolderingIron() {
		super();
		this.setUnlocalizedName("toolSolderingIron");
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int posX, int posY, int posZ, int side, float px, float py, float pz) {

		double x = posX;
		double y = posY;
		double z = posZ;

		x += px;
		y += py;
		z += pz;

		//particleType, x, y, z, velX, velY, velZ
		world.spawnParticle("smoke", x, y + 0.2f, z, 0, 0, 0);
		world.spawnParticle("flame", x, y, z, 0, 0, 0);
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
		hitEntity.setFire(1);
		AxisAlignedBB boundingBox = hitEntity.boundingBox;
		double yOffset = (boundingBox.maxY - boundingBox.minY) / 2.0f;
		RenderManager.instance.worldObj.spawnParticle("smoke", hitEntity.posX, hitEntity.posY + yOffset + 0.2f, hitEntity.posZ, 0, 0, 0);
		RenderManager.instance.worldObj.spawnParticle("flame", hitEntity.posX, hitEntity.posY + yOffset, hitEntity.posZ, 0, 0, 0);
		return super.hitEntity(itemStack, hitEntity, attackingEntity);
	}
}
