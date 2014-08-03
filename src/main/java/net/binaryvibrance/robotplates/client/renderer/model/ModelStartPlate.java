package net.binaryvibrance.robotplates.client.renderer.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelStartPlate implements IDebugReloadable {
	private IModelCustom modelStartPlate;
	private static ModelStartPlate instance;
	private ModelStartPlate() {
		reload();
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

	public static ModelStartPlate instance() {
		return (instance != null ? instance : (instance = new ModelStartPlate()));
	}
}
