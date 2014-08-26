package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateCodePath;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateCodePath;

public class TileEntityRendererPlateCodePath extends BasePlateTileEntityRenderer<TileEntityPlateCodePath> {

	public TileEntityRendererPlateCodePath() {
		super(ModelPlateCodePath.instance());
	}

	@Override
	protected void render(TileEntityPlateCodePath tileEntity) {
		bindTexture(Textures.Model.PLATE_CODE_PATH);
		model.render();
	}
}
