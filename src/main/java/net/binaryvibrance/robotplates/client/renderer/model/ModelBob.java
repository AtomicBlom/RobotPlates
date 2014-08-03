package net.binaryvibrance.robotplates.client.renderer.model;

import cpw.mods.fml.client.FMLClientHandler;
import net.binaryvibrance.robotplates.reference.Models;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.binaryvibrance.robotplates.utility.modelLoading.AdvWavefrontObject;
import net.minecraftforge.client.model.IModelCustom;

public class ModelBob implements IDebugReloadable {
	private IModelCustom model;
	private static ModelBob instance;
	private ModelBob() {
		reload();
	}

	public void reload() {
		IModelCustom advWavefrontObject = new AdvWavefrontObject(Models.BOB);
		model = advWavefrontObject;
	}

	public void render() {
		if (model == null) {
			reload();
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.BobBody);
		model.renderPart("RobotBase");

		model.renderPart("Wheel_Front_Left");
		model.renderPart("Wheel_Front_Right");
		model.renderPart("Wheel_Back_Left");
		model.renderPart("Wheel_Back_Right");
	}

	public static ModelBob instance() {
		return (instance != null ? instance : (instance = new ModelBob()));
	}
}
