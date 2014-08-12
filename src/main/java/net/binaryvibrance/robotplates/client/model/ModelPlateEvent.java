package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelPlateEvent implements IDebugReloadable {
	private static ModelPlateEvent instance;
	public final float scale = (1f/16f);
	private final static String[] solderSpotElements = {
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

	private IModelCustom model;

	private ModelPlateEvent() {
		reload();
	}

	public static ModelPlateEvent instance() {
		return (instance != null ? instance : (instance = new ModelPlateEvent()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.PLATE_EVENT);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		model.renderPart("plate");
		for (String solderSpot : solderSpotElements) {
			model.renderPart(solderSpot);
		}
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
