package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.reference.Models;

public class ModelPlateCodePath extends BaseModelPlate {
	private static ModelPlateCodePath instance;

	private ModelPlateCodePath() {
		super(Models.PLATE_CODE_PATH);
	}

	public static ModelPlateCodePath instance() {
		return (instance != null ? instance : (instance = new ModelPlateCodePath()));
	}
}
