package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.BaseModelPlate;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.binaryvibrance.robotplates.utility.CompassDirection;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BasePlateTileEntityRenderer<T extends BaseRobotPlatesTileEntity> extends TileEntitySpecialRenderer {
	protected final BaseModelPlate model;

	public BasePlateTileEntityRenderer(BaseModelPlate model) {
		this.model = model;
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		T castTileEntity = (T) tileEntity;

		GL11.glPushMatrix();
		scaleTranslateRotate(x, y, z, castTileEntity.getOrientation());

		renderInternal(castTileEntity);

		GL11.glPopMatrix();
	}

	private final void renderInternal(T tileEntity) {
		render(tileEntity);
		bindTexture(Textures.Model.PLATE_SIGNAL);
		model.renderActive(
				tileEntity.getSignalActive(CompassDirection.NORTH),
				tileEntity.getSignalActive(CompassDirection.EAST),
				tileEntity.getSignalActive(CompassDirection.SOUTH),
				tileEntity.getSignalActive(CompassDirection.WEST)
		);
	}

	protected abstract void render(T tileEntity);

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
