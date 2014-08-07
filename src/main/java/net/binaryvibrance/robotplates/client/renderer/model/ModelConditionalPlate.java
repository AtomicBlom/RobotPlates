package net.binaryvibrance.robotplates.client.renderer.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.binaryvibrance.robotplates.utility.modelLoading.AdvWavefrontObject;
import net.minecraftforge.client.model.IModelCustom;

public class ModelConditionalPlate implements IDebugReloadable {
	private static ModelConditionalPlate instance;
	private IModelCustom model;

	private ModelConditionalPlate() {
		reload();
	}

	public static ModelConditionalPlate instance() {
		return (instance != null ? instance : (instance = new ModelConditionalPlate()));
	}

	public void reload() {
		model = new AdvWavefrontObject(Models.CONDITIONAL_PLATE);
		//model = AdvancedModelLoader.loadModel(Models.CONDITIONAL_PLATE);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("Plate");
		model.renderPart("Powered_North");
	}
}
