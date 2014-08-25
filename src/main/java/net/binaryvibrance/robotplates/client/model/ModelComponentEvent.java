package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelComponentEvent implements IDebugReloadable {
	private static ModelComponentEvent instance;
	private IModelCustom model;

	private ModelComponentEvent() {
		reload();
	}

	public static ModelComponentEvent instance() {
		return (instance != null ? instance : (instance = new ModelComponentEvent()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.COMPONENT_EVENT);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("EventComponent");
		model.renderPart("Legs");
	}

	public void renderSpecialization() {
		model.renderPart("Image");
	}
}
