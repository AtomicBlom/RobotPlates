package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelPlateCodePath implements IDebugReloadable {
	private static ModelPlateCodePath instance;
	public final float scale = (1f/16f);
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
	}

	public void renderActive(boolean north, boolean south, boolean east, boolean west) {
		if (north) {
			model.renderPart("Active_North");
		}
		if (south) {
			model.renderPart("Active_South");
		}
		if (east) {
			model.renderPart("Active_East");
		}
		if (west) {
			model.renderPart("Active_West");
		}
	}
}
