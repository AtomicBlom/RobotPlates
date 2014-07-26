package net.binaryvibrance.robotplates.reference;

import net.minecraft.util.ResourceLocation;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public final class Models {
	private Models() {}
	public static final String MODEL_LOCATION = "models/";
	public static final ResourceLocation START_PLATE = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "startPlate.obj");
	public static final ResourceLocation CONDITIONAL_PLATE = new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "conditionalPlate.obj");
	public static final ResourceLocation REMOTE_DEBUGGER =new ResourceLocation(Reference.MOD_ID, MODEL_LOCATION + "remoteDebugger.obj");
}