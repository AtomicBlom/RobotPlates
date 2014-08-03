package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.renderer.model.ModelConditionalPlate;
import net.binaryvibrance.robotplates.client.renderer.model.ModelStartPlate;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityConditionalPlate;
import net.binaryvibrance.robotplates.tileentity.TileEntityStartPlate;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererConditionalPlate extends TileEntitySpecialRenderer {

	private final ModelConditionalPlate modelConditionalPlate;
	public TileEntityRendererConditionalPlate() {
		modelConditionalPlate = ModelConditionalPlate.instance();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		if (!(tileEntity instanceof TileEntityConditionalPlate)) return;

		TileEntityConditionalPlate tileEntityConditionalPlate = (TileEntityConditionalPlate)tileEntity;

		GL11.glPushMatrix();
		scaleTranslateRotate(x, y, z, tileEntityConditionalPlate.getOrientation());


		bindTexture(Textures.Model.ConditionalPlate);
		modelConditionalPlate.render();

		GL11.glPopMatrix();
	}

	private void scaleTranslateRotate(double x, double y, double z, ForgeDirection orientation)
	{
		if (orientation == ForgeDirection.NORTH)
		{
			GL11.glTranslated(x + 0.5, y, z + 0.5);
		}
		else if (orientation == ForgeDirection.EAST)
		{
			GL11.glTranslated(x + 0.5, y, z + 0.5);
			GL11.glRotatef(-90F, 0F, 1F, 0F);
		}
		else if (orientation == ForgeDirection.SOUTH)
		{
			GL11.glTranslated(x + 0.5, y, z + 0.5);
			GL11.glRotatef(180F, 0F, 1F, 0F);
		}
		else if (orientation == ForgeDirection.WEST)
		{
			GL11.glTranslated(x + 0.5, y, z + 0.5);
			GL11.glRotatef(90F, 0F, 1F, 0F);
		}
	}
}
