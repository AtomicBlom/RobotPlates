package net.binaryvibrance.robotplates.client.renderer.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelRemoteDebugger implements IDebugReloadable {
	private IModelCustom modelStartPlate;
	private static ModelRemoteDebugger instance;
	private ModelRemoteDebugger() {
		reload();
	}

	public void reload() {
		modelStartPlate = AdvancedModelLoader.loadModel(Models.REMOTE_DEBUGGER);
	}

	public void render() {
		if (modelStartPlate == null) {
			reload();
		}
		modelStartPlate.renderPart("Cube");
	}

	public static ModelRemoteDebugger instance() {
		return (instance != null ? instance : (instance = new ModelRemoteDebugger()));
	}
}
