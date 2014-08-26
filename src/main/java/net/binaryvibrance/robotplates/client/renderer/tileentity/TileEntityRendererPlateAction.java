package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateAction;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateAction;

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
