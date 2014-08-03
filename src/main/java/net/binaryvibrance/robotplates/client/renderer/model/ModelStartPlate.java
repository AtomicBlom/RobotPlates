package net.binaryvibrance.robotplates.client.renderer.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelStartPlate implements IDebugReloadable {
	private static ModelStartPlate instance;
	private IModelCustom modelStartPlate;

	private ModelStartPlate() {
		reload();
	}

	public static ModelStartPlate instance() {
		return (instance != null ? instance : (instance = new ModelStartPlate()));
	}

	public void reload() {
		modelStartPlate = AdvancedModelLoader.loadModel(Models.START_PLATE);
	}

	public void render() {
		if (modelStartPlate == null) {
			reload();
		}
		modelStartPlate.renderPart("Plate");
	}
}
