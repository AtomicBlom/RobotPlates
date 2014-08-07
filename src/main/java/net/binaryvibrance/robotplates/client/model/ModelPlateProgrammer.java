package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelPlateProgrammer implements IDebugReloadable {
	private static ModelPlateProgrammer instance;
	private IModelCustom model;

	private ModelPlateProgrammer() {
		reload();
	}

	public static ModelPlateProgrammer instance() {
		return (instance != null ? instance : (instance = new ModelPlateProgrammer()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.PLATE_PROGRAMMER);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("Plate");
	}
}
