package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateCodePath;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateCodePath;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

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
