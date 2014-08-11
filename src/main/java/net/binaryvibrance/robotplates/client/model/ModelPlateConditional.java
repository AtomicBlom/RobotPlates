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

	public void renderContacts() {
		if (model == null) {
			reload();
		}

		final String[] parts = {
				"SolderSpot001",
				"SolderSpot002",
				"SolderSpot003",
				"SolderSpot004",
				"SolderSpot005",
				"SolderSpot006",
				"SolderSpot007",
				"SolderSpot008",
				"SolderSpot009",
				"SolderSpot010",
				"SolderSpot011",
				"SolderSpot012",
				"SolderSpot013",
				"SolderSpot014",
				"SolderSpot015",
				"SolderSpot016",
		};

		for (String part : parts) {
			model.renderPart(part);
		}
	}
}
