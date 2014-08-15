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

public class TileEntityRendererPlateAction extends BasePlateTileEntityRenderer<TileEntityPlateAction> {
	public TileEntityRendererPlateAction() {
		super(ModelPlateAction.instance());
	}

	@Override
	protected void render(TileEntityPlateAction tileEntity) {
		bindTexture(Textures.Model.PLATE_ACTION);
		model.render();
	}
}
