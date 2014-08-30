package net.binaryvibrance.robotplates.utility.subobject;

import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class SubObject {
	private final AxisAlignedBB boundingBox;

	public SubObject(AxisAlignedBB boundingBox) {

		this.boundingBox = boundingBox;
	}

	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}

	public void RenderBoundingBox(EntityPlayer player, BaseRobotPlatesTileEntity tileEntity, float partialTicks) {

		double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double)partialTicks;
		double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double)partialTicks;
		double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double)partialTicks;

		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(false);
		float e = 0.01f;
		AxisAlignedBB drawBoundingBox =  AxisAlignedBB.getBoundingBox(
				(double)tileEntity.xCoord + boundingBox.minX, (double)tileEntity.yCoord + boundingBox.minY, (double)tileEntity.zCoord + boundingBox.minZ,
				(double)tileEntity.xCoord + boundingBox.maxX, (double)tileEntity.yCoord + boundingBox.maxY, (double)tileEntity.zCoord + boundingBox.maxZ);

		RenderGlobal.drawOutlinedBoundingBox(drawBoundingBox.expand(e, e, e).getOffsetBoundingBox(-d0, -d1, -d2), -1);

		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
	}
}
