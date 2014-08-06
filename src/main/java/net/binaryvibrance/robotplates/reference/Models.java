package net.binaryvibrance.robotplates.reference;

import net.minecraft.util.ResourceLocation;

public final class Models {
	public static final String MODEL_LOCATION = "models/";
	public static final ResourceLocation START_PLATE = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "startPlate.obj");
	public static final ResourceLocation CONDITIONAL_PLATE = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "conditionalPlate.obj");
	public static final ResourceLocation REMOTE_DEBUGGER = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "remoteDebugger.obj");
	public static final ResourceLocation BOB = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "bob.obj");
	public static final ResourceLocation TOOL_SOLDERING_IRON = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "toolSolderingIron.obj");
	;

	private Models() {
	}
}