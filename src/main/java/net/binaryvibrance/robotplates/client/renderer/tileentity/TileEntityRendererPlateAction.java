package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateAction;
import net.binaryvibrance.robotplates.client.model.ModelPlateConditional;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateAction;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateConditional;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPlateAction extends TileEntitySpecialRenderer {

	private final ModelPlateAction model;

	public TileEntityRendererPlateAction() {
		model = ModelPlateAction.instance();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		if (!(tileEntity instanceof TileEntityPlateAction)) return;

		TileEntityPlateAction tileEntityPlateConditional = (TileEntityPlateAction) tileEntity;

		GL11.glPushMatrix();
		scaleTranslateRotate(x, y, z, tileEntityPlateConditional.getOrientation());

		bindTexture(Textures.Model.PLATE_ACTION);
		model.render();

		GL11.glPopMatrix();
	}

	private void scaleTranslateRotate(double x, double y, double z, ForgeDirection orientation) {
		final float scale = (1f/16f);

		if (orientation == ForgeDirection.NORTH) {
			GL11.glTranslated(x + 0.5, y, z + 0.5);
		} else if (orientation == ForgeDirection.EAST) {
			GL11.glTranslated(x + 0.5, y, z + 0.5);
			GL11.glRotatef(-90F, 0F, 1F, 0F);
		} else if (orientation == ForgeDirection.SOUTH) {
			GL11.glTranslated(x + 0.5, y, z + 0.5);
			GL11.glRotatef(180F, 0F, 1F, 0F);
		} else if (orientation == ForgeDirection.WEST) {
			GL11.glTranslated(x + 0.5, y, z + 0.5);
			GL11.glRotatef(90F, 0F, 1F, 0F);
		}
		GL11.glScalef(scale, scale, scale);
	}
}
