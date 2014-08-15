package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateEvent;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.binaryvibrance.robotplates.utility.CompassDirection;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererPlateEvent extends BasePlateTileEntityRenderer<TileEntityPlateEvent> {

	public TileEntityRendererPlateEvent() {
		super(ModelPlateEvent.instance());
	}

	@Override
	protected void render(TileEntityPlateEvent tileEntity) {
		bindTexture(Textures.Model.PLATE_EVENT);
		model.render();
	}
}
