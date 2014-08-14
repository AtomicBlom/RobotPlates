package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateProgrammer;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPlateProgrammer extends TileEntitySpecialRenderer {

	private final ModelPlateProgrammer model;

	public TileEntityRendererPlateProgrammer() {
		model = ModelPlateProgrammer.instance();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		if (!(tileEntity instanceof TileEntityPlateProgrammer)) return;

		TileEntityPlateProgrammer castTileEntity = (TileEntityPlateProgrammer) tileEntity;

		GL11.glPushMatrix();

		scaleTranslateRotate(x, y, z, castTileEntity.getOrientation());

		bindTexture(Textures.Model.PLATE_PROGRAMMER);
		model.render();
		bindTexture(Textures.Model.PLATE_SIGNAL);
		model.renderActive(
				castTileEntity.getSignalActive(ForgeDirection.NORTH),
				castTileEntity.getSignalActive(ForgeDirection.EAST),
				castTileEntity.getSignalActive(ForgeDirection.SOUTH),
				castTileEntity.getSignalActive(ForgeDirection.WEST)
		);

		GL11.glPopMatrix();
	}

	private void scaleTranslateRotate(double x, double y, double z, ForgeDirection orientation) {
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
		GL11.glScalef(model.scale, model.scale, model.scale);
	}
}
