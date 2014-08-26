package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.client.model.ModelPlateAction;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.renderer.texture.TextureManager;

@SideOnly(Side.CLIENT)
public class ItemRendererPlateAction extends BasePlateItemRenderer {
	public ItemRendererPlateAction() {
		super(ModelPlateAction.instance());
	}

	@Override
	protected void render(TextureManager textureManager) {
		textureManager.bindTexture(Textures.Model.PLATE_ACTION);
		model.render();
	}
}
