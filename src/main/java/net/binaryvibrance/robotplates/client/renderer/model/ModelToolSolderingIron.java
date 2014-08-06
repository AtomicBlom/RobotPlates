package net.binaryvibrance.robotplates.client.renderer.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelToolSolderingIron implements IDebugReloadable {
	private static ModelToolSolderingIron instance;
	private IModelCustom model;

	private ModelToolSolderingIron() {
		reload();
	}

	public static ModelToolSolderingIron instance() {
		return (instance != null ? instance : (instance = new ModelToolSolderingIron()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.TOOL_SOLDERING_IRON);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("SolderingIron");
	}

	public void renderHand() {
		if (model == null) {
			reload();
		}
		model.renderPart("Hand");
	}
}
