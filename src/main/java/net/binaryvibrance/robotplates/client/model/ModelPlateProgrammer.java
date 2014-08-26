package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;

public class ModelPlateProgrammer extends BaseModelPlate {
	private static ModelPlateProgrammer instance;
	public static ModelPlateProgrammer instance() {
		return (instance != null ? instance : (instance = new ModelPlateProgrammer()));
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
			"SolderSpot008"
	};

	private ModelPlateProgrammer() {
		super(Models.PLATE_PROGRAMMER, parts);
	}
}
