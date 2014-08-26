package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateConditional;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateConditional;

public class TileEntityRendererPlateConditional extends BasePlateTileEntityRenderer<TileEntityPlateConditional> {

	public TileEntityRendererPlateConditional() {
		super(ModelPlateConditional.instance());
	}

	@Override
	protected void render(TileEntityPlateConditional tileEntity) {
		bindTexture(Textures.Model.PLATE_CONDITIONAL);
		model.render();
	}
}
