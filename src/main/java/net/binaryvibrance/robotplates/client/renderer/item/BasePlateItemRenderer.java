package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.client.FMLClientHandler;
import net.binaryvibrance.robotplates.client.model.BaseModelPlate;
import net.binaryvibrance.robotplates.client.model.ModelPlateEvent;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public abstract class BasePlateItemRenderer implements IItemRenderer {
	protected final BaseModelPlate model;

	public BasePlateItemRenderer(BaseModelPlate model) {
		this.model = model;
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
				renderInternal(-0F, -0.38F, 0.0F);
				return;
			}
			case EQUIPPED: {
				renderInternal(0.0F, 0.5F, 0.5F);
				return;
			}
			case EQUIPPED_FIRST_PERSON: {
				renderInternal(0.0F, 1.0F, 1.0F);
				return;
			}
			case INVENTORY: {
				renderInternal(-0.5F, -0.8F, -0.5F);
				return;
			}
			default:
		}

	}

	private void renderInternal(float x, float y, float z) {
		GL11.glPushMatrix();

		GL11.glTranslatef(x, y, z);
		GL11.glScalef(model.scale, model.scale, model.scale);

		TextureManager renderEngine = FMLClientHandler.instance().getClient().renderEngine;
		render(renderEngine);

		GL11.glPopMatrix();
	}

	protected abstract void render(TextureManager textureManager);
}
