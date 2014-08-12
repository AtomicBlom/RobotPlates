package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.client.model.ModelPlateAction;
import net.binaryvibrance.robotplates.client.model.ModelPlateEvent;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemRendererPlateEvent implements IItemRenderer {

	private final ModelPlateEvent model;

	public ItemRendererPlateEvent() {
		model = ModelPlateEvent.instance();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case ENTITY: {
				render(-0F, -0.38F, 0.0F);
				return;
			}
			case EQUIPPED: {
				render(0.0F, 0.5F, 0.5F);
				return;
			}
			case EQUIPPED_FIRST_PERSON: {
				render(0.0F, 1.0F, 1.0F);
				return;
			}
			case INVENTORY: {
				render(-0.5F, -0.8F, -0.5F);
				return;
			}
			default:
		}

	}

	private void render(float x, float y, float z) {
		GL11.glPushMatrix();

		GL11.glTranslatef(x, y, z);
		GL11.glScalef(model.scale, model.scale, model.scale);

		TextureManager renderEngine = FMLClientHandler.instance().getClient().renderEngine;
		renderEngine.bindTexture(Textures.Model.PLATE_EVENT);
		model.render();

		GL11.glPopMatrix();
	}
}
