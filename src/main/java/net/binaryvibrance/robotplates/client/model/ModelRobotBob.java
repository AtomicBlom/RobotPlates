package net.binaryvibrance.robotplates.client.model;

import cpw.mods.fml.client.FMLClientHandler;
import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelRobotBob implements IDebugReloadable {
	private static ModelRobotBob instance;
	private IModelCustom model;

	private ModelRobotBob() {
		reload();
	}

	public static ModelRobotBob instance() {
		return (instance != null ? instance : (instance = new ModelRobotBob()));
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(Models.ROBOT_BOB);
	}

	public void render() {
		if (model == null) {
			reload();
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.ROBOT_BOB_BODY);
		model.renderPart("RobotBase");

		model.renderPart("Wheel_Front_Left");
		model.renderPart("Wheel_Front_Right");
		model.renderPart("Wheel_Back_Left");
		model.renderPart("Wheel_Back_Right");
	}
}
