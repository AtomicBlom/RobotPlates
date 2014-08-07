package net.binaryvibrance.robotplates.reference;

import net.minecraft.util.ResourceLocation;

public class Textures {
	public static final class Model {
		private static final String MODEL_TEXTURE_LOCATION = "textures/models/";

		public static final ResourceLocation PlateProgrammer = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateProgrammer.png");
		public static final ResourceLocation PlateConditional = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateConditional.png");
		public static final ResourceLocation PlateCodePath = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateCodePath.png");
		public static final ResourceLocation ToolRemoteDebugger = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelToolRemoteDebugger.png");
		public static final ResourceLocation ToolSolderingIron = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelToolSolderingIron.png");

		//Robot Textures
		public static final ResourceLocation RobotBobBody = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelRobotBobBody.png");


	}
}
