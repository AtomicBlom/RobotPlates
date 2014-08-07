package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.binaryvibrance.robotplates.utility.modelLoading.AdvWavefrontObject;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelPlateCodePath implements IDebugReloadable {
	private static ModelPlateCodePath instance;
	private IModelCustom model;

	private ModelPlateCodePath() {
		reload();
	}

	public static ModelPlateCodePath instance() {
		return (instance != null ? instance : (instance = new ModelPlateCodePath()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.PLATE_CODE_PATH);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("Plate");
		model.renderPart("Powered_North");
	}
}
