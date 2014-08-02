package net.binaryvibrance.robotplates.client.renderer.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.binaryvibrance.robotplates.utility.modelLoading.AdvWavefrontObject;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public class ModelConditionalPlate implements IDebugReloadable {
	private IModelCustom model;
	private static ModelConditionalPlate instance;
	private ModelConditionalPlate() {
		reload();
	}

	public void reload() {
		IModelCustom advWavefrontObject = new AdvWavefrontObject(Models.CONDITIONAL_PLATE);
		model = advWavefrontObject;
		//model = AdvancedModelLoader.loadModel(Models.CONDITIONAL_PLATE);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("Plate");
		model.renderPart("Powered_North");
	}

	public static ModelConditionalPlate instance() {
		return (instance != null ? instance : (instance = new ModelConditionalPlate()));
	}
}
