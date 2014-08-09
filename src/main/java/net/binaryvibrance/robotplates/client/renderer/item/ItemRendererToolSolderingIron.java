package net.binaryvibrance.robotplates.client.renderer.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.binaryvibrance.robotplates.client.model.ModelToolSolderingIron;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemRendererToolSolderingIron implements IItemRenderer {

	private final ModelToolSolderingIron model;

	public ItemRendererToolSolderingIron() {
		model = ModelToolSolderingIron.instance();
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
		GL11.glPushMatrix();
		switch (type) {
			case ENTITY: {
				GL11.glTranslatef(-0.5F, -0.38F, 0.5F);
				renderIron();
				break;
			}
			case EQUIPPED: {
				GL11.glTranslatef(0.0F, 0.0F, 1.0F);
				renderIron();
				break;
			}
			case EQUIPPED_FIRST_PERSON: {
				GL11.glTranslatef(1.5F, 1.0F, 1F);
				GL11.glRotatef(-33.0f, 0, 1, 0);

				renderIron();
				renderHand(((AbstractClientPlayer) data[1]).getLocationSkin());
				break;
			}
			case INVENTORY: {
				GL11.glTranslatef(0F, -0.1F, 0.0F);
				renderIron();
				break;
			}
			default:
		}
		GL11.glPopMatrix();
	}

	private void renderHand(ResourceLocation locationSkin) {
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(locationSkin);
		model.renderHand();
	}

	private void renderIron() {
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.TOOL_SOLDERING_IRON);
		model.render();


	}
}
