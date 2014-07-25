package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.renderer.model.ModelStartPlate;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityStartPlate;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public class TileEntityRendererStartPlate extends TileEntitySpecialRenderer {
	private final ModelStartPlate modelStartPlate = new ModelStartPlate();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		if (!(tileEntity instanceof TileEntityStartPlate)) return;

		TileEntityStartPlate tileEntityStartPlate = (TileEntityStartPlate)tileEntity;

		GL11.glPushMatrix();

		scaleTranslateRotate(x, y, z, tileEntityStartPlate.getOrientation());

		bindTexture(Textures.Model.StartPlate);
		modelStartPlate.render();

		GL11.glPopMatrix();
	}

	private void scaleTranslateRotate(double x, double y, double z, ForgeDirection orientation)
	{
		if (orientation == ForgeDirection.NORTH)
		{
			GL11.glTranslated(x + 1, y, z);
			GL11.glRotatef(180F, 0F, 1F, 0F);
			GL11.glRotatef(-90F, 1F, 0F, 0F);
		}
		else if (orientation == ForgeDirection.EAST)
		{
			GL11.glTranslated(x + 1, y, z + 1);
			GL11.glRotatef(90F, 0F, 1F, 0F);
			GL11.glRotatef(-90F, 1F, 0F, 0F);
		}
		else if (orientation == ForgeDirection.SOUTH)
		{
			GL11.glTranslated(x, y, z + 1);
			GL11.glRotatef(0F, 0F, 1F, 0F);
			GL11.glRotatef(-90F, 1F, 0F, 0F);
		}
		else if (orientation == ForgeDirection.WEST)
		{
			GL11.glTranslated(x, y, z);
			GL11.glRotatef(-90F, 0F, 1F, 0F);
			GL11.glRotatef(-90F, 1F, 0F, 0F);
		}
	}
}
