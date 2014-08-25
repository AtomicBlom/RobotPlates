package net.binaryvibrance.robotplates.reference;

import net.minecraft.util.ResourceLocation;

public final class Models {
	private static final String MODEL_LOCATION = "models/";

	//Components
	public static final ResourceLocation COMPONENT_CONTAINER = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelComponentContainer.obj");
	public static final ResourceLocation COMPONENT_EVENT = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelComponentEvent.obj");

	//Plates
	public static final ResourceLocation PLATE_ACTION = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelPlateAction.obj");
	public static final ResourceLocation PLATE_CODE_PATH = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelPlateCodePath.obj");
	public static final ResourceLocation PLATE_CONDITIONAL = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelPlateConditional.obj");
	public static final ResourceLocation PLATE_EVENT = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelPlateEvent.obj");
	public static final ResourceLocation PLATE_PROGRAMMER = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelPlateProgrammer.obj");

	//Robots
	public static final ResourceLocation ROBOT_BOB = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelRobotBob.obj");

	//Tools
	public static final ResourceLocation TOOL_REMOTE_DEBUGGER = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelToolRemoteDebugger.obj");
	public static final ResourceLocation TOOL_SOLDERING_IRON = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "modelToolSolderingIron.obj");


	private Models() {
	}
}