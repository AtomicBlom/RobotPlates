package net.binaryvibrance.robotplates.client.renderer.component;

import cpw.mods.fml.client.FMLClientHandler;
import net.binaryvibrance.robotplates.client.model.ModelComponentEvent;
import net.binaryvibrance.robotplates.client.renderer.IComponentRenderer;
import net.binaryvibrance.robotplates.compiler.component.EventPlateComponent;
import net.binaryvibrance.robotplates.reference.Textures;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class ComponentRendererEvent implements IComponentRenderer {
	private final ModelComponentEvent model;

	public ComponentRendererEvent() {
		model = ModelComponentEvent.instance();
	}

	@Override
	public void render(EventPlateComponent installedComponent) {
		TextureManager renderEngine = FMLClientHandler.instance().getClient().renderEngine;

		renderEngine.bindTexture(Textures.Model.COMPONENT_EVENT);
		model.render();

		renderEngine.bindTexture(getTextureFor(installedComponent));
		model.renderSpecialization();
	}

	private ResourceLocation getTextureFor(EventPlateComponent installedComponent) {
		switch (installedComponent) {
			case TICK:
				return Textures.Model.COMPONENT_EVENT_TICK;
			default:
				return null;
		}
	}
}
