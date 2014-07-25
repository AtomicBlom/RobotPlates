package net.binaryvibrance.robotplates.client.renderer.model;

import net.binaryvibrance.robotplates.reference.Models;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public class ModelStartPlate {
	private static IModelCustom modelStartPlate;
	public ModelStartPlate() {
		reload();
	}

	public static void reload() {
		modelStartPlate = AdvancedModelLoader.loadModel(Models.START_PLATE);
	}

	public void render() {
		modelStartPlate.renderPart("Cube");
	}
}
