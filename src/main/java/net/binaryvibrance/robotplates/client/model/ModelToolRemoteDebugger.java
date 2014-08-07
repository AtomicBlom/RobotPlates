package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelToolRemoteDebugger implements IDebugReloadable {
	private static ModelToolRemoteDebugger instance;
	private IModelCustom iModelCustom;

	private ModelToolRemoteDebugger() {
		reload();
	}

	public static ModelToolRemoteDebugger instance() {
		return (instance != null ? instance : (instance = new ModelToolRemoteDebugger()));
	}

	public void reload() {
		iModelCustom = AdvancedModelLoader.loadModel(Models.TOOL_REMOTE_DEBUGGER);
	}

	public void render() {
		if (iModelCustom == null) {
			reload();
		}
		iModelCustom.renderPart("Cube");
	}
}
