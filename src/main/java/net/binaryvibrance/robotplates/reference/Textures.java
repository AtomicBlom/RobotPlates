package net.binaryvibrance.robotplates.reference;

import net.minecraft.util.ResourceLocation;

public class Textures {
	public static final class Model {
		private static final String MODEL_TEXTURE_LOCATION = "textures/models/";

		//Plates
		public static final ResourceLocation PLATE_ACTION = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateAction.png");
		public static final ResourceLocation PLATE_CODE_PATH = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateCodePath.png");
		public static final ResourceLocation PLATE_CONDITIONAL = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateConditional.png");
		public static final ResourceLocation PLATE_EVENT = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateEvent.png");
		public static final ResourceLocation PLATE_PROGRAMMER = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateProgrammer.png");

		public static final ResourceLocation PLATE_SIGNAL = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelPlateSignal.png");

		//Components
		public static final ResourceLocation COMPONENT_CONTAINER = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelComponentContainer.png");

		//Tools
		public static final ResourceLocation TOOL_REMOTE_DEBUGGER = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelToolRemoteDebugger.png");
		public static final ResourceLocation TOOL_SOLDERING_IRON = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelToolSolderingIron.png");

		//Robot Textures
		public static final ResourceLocation ROBOT_BOB_BODY = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "modelRobotBobBody.png");



	}
}
