package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.client.model.ModelPlateEvent;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.renderer.texture.TextureManager;

@SideOnly(Side.CLIENT)
public class ItemRendererPlateEvent extends BasePlateItemRenderer {

	public ItemRendererPlateEvent() {
		super(ModelPlateEvent.instance());
	}

	@Override
	protected void render(TextureManager textureManager) {
		textureManager.bindTexture(Textures.Model.PLATE_EVENT);
		model.render();
	}
}
