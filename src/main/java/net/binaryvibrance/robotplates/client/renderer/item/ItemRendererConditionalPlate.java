package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.client.renderer.model.ModelConditionalPlate;
import net.binaryvibrance.robotplates.client.renderer.model.ModelStartPlate;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
@SideOnly(Side.CLIENT)
public class ItemRendererConditionalPlate implements IItemRenderer {

	public ItemRendererConditionalPlate() {
		model = ModelConditionalPlate.instance();
	}
	private final ModelConditionalPlate model;

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
		switch (type)
		{
			case ENTITY:
			{
				render(-0.5F, -0.38F, 0.5F);
				return;
			}
			case EQUIPPED:
			{
				render(0.0F, 0.5F, 1.0F);
				return;
			}
			case EQUIPPED_FIRST_PERSON:
			{
				render(0.0F, 1.0F, 1.0F);
				return;
			}
			case INVENTORY:
			{
				render(-0.5F, -0.9F, 0.0F);
				return;
			}
			default:
		}

	}

	private void render(float x, float y, float z) {
		GL11.glPushMatrix();

		//GL11.glScalef(1f, 1f, 1f);
		GL11.glTranslatef(x, y, z);
		GL11.glTranslatef(0, 0, -0.5f);
		//GL11.glRotatef(-90f, 1f, 0, 0);

		FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.ConditionalPlate);
		model.render();

		GL11.glPopMatrix();
	}
}
