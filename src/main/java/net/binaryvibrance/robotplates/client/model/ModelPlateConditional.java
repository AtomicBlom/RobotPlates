package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelPlateConditional implements IDebugReloadable {
	private static ModelPlateConditional instance;
	private IModelCustom model;

	private ModelPlateConditional() {
		reload();
	}

	public static ModelPlateConditional instance() {
		return (instance != null ? instance : (instance = new ModelPlateConditional()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.PLATE_CONDITIONAL);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("Plate");
		model.renderPart("Powered_North");
	}
}
