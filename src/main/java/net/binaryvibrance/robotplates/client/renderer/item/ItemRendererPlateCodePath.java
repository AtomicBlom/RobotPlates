package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.client.model.ModelPlateCodePath;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemRendererPlateCodePath extends BasePlateItemRenderer {
	public ItemRendererPlateCodePath() {
		super(ModelPlateCodePath.instance());
	}

	@Override
	protected void render(TextureManager textureManager) {
		textureManager.bindTexture(Textures.Model.PLATE_CODE_PATH);
		model.render();
	}
}
