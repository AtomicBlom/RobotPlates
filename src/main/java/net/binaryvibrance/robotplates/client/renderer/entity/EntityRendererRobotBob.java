package net.binaryvibrance.robotplates.client.renderer.entity;

import net.binaryvibrance.robotplates.client.model.ModelRobotBob;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class EntityRendererRobotBob extends Render {
	private static ModelRobotBob model = ModelRobotBob.instance();

	public void doRender(Entity entity, double posX, double posY, double posZ, float rotationYaw, float rotationPitch) {
		GL11.glPushMatrix();

		GL11.glTranslated(posX, posY, posZ);
		GL11.glRotatef(entity.rotationYaw, 0f, -1f, 0f);
		model.render();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return null;
	}
}
