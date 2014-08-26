package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateProgrammer;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;

public class TileEntityRendererPlateProgrammer extends BasePlateTileEntityRenderer<TileEntityPlateProgrammer> {
	public TileEntityRendererPlateProgrammer() {
		super(ModelPlateProgrammer.instance());
	}

	@Override
	protected void render(TileEntityPlateProgrammer tileEntity) {
		bindTexture(Textures.Model.PLATE_PROGRAMMER);
		model.render();
	}
}
