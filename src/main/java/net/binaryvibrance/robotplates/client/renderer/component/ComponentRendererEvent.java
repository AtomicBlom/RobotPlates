package net.binaryvibrance.robotplates.client.renderer.component;

import cpw.mods.fml.client.FMLClientHandler;
import net.binaryvibrance.robotplates.client.model.ModelComponentEvent;
import net.binaryvibrance.robotplates.client.renderer.IComponentRenderer;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class ComponentRendererEvent implements IComponentRenderer {
	private final ModelComponentEvent model;

	public ComponentRendererEvent() {
		model = ModelComponentEvent.instance();
	}

	@Override
	public void render(TileEntityPlateEvent.EventType eventType) {
		TextureManager renderEngine = FMLClientHandler.instance().getClient().renderEngine;

		renderEngine.bindTexture(Textures.Model.COMPONENT_EVENT);
		model.render();

		renderEngine.bindTexture(getTextureFor(eventType));
		model.renderSpecialization();
	}

	private ResourceLocation getTextureFor(TileEntityPlateEvent.EventType eventType) {
		switch (eventType) {
			case TICK:
				return Textures.Model.COMPONENT_EVENT_TICK;
			default:
				return null;
		}
	}
}
