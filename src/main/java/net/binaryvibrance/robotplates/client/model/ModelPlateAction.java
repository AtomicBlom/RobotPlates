package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;

public class ModelPlateAction extends BaseModelPlate {
	private static ModelPlateAction instance;
	public static ModelPlateAction instance() {
		return (instance != null ? instance : (instance = new ModelPlateAction()));
	}

	private final static String[] parts = {
			"plate",
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

	private ModelPlateAction() {
		super(Models.PLATE_ACTION, parts);
	}

}
