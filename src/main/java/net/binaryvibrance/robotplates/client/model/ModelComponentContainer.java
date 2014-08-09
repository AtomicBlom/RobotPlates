package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelComponentContainer implements IDebugReloadable {
	private static ModelComponentContainer instance;
	private IModelCustom model;

	private ModelComponentContainer() {
		reload();
	}

	public static ModelComponentContainer instance() {
		return (instance != null ? instance : (instance = new ModelComponentContainer()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.COMPONENT_CONTAINER);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("Container");
	}
}
