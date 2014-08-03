package net.binaryvibrance.robotplates.client.renderer.entity;

import cpw.mods.fml.client.FMLClientHandler;
import net.binaryvibrance.robotplates.client.renderer.model.ModelBob;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RobotBobRenderer extends Render {
	public static ModelBob modelBob = ModelBob.instance();
	public void doRender(Entity entity, double posX, double posY, double posZ, float rotationYaw, float rotationPitch) {
		GL11.glPushMatrix();

		GL11.glTranslated(posX, posY, posZ);
		modelBob.render();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}
}
