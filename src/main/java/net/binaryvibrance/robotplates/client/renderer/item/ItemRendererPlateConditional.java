package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.client.model.ModelPlateConditional;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.renderer.texture.TextureManager;

@SideOnly(Side.CLIENT)
public class ItemRendererPlateConditional extends BasePlateItemRenderer {
	public ItemRendererPlateConditional() {
		super(ModelPlateConditional.instance());
	}

	@Override
	protected void render(TextureManager textureManager) {
		textureManager.bindTexture(Textures.Model.PLATE_CONDITIONAL);
		model.render();
	}
}
