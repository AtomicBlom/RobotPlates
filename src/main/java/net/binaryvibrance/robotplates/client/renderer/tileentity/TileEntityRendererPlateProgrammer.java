package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateProgrammer;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;
import net.binaryvibrance.robotplates.utility.CompassDirection;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

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
