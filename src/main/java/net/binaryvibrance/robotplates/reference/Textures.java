package net.binaryvibrance.robotplates.reference;

import net.minecraft.util.ResourceLocation;

public class Textures {
	public static final class Model {
		private static final String MODEL_TEXTURE_LOCATION = "textures/models/";

		public static final ResourceLocation StartPlate = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "startPlate.png");
		public static final ResourceLocation ConditionalPlate = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "conditionalPlate.png");
		public static final ResourceLocation RemoteDebugger = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "remoteDebugger.png");

		//Robot Textures
		public static final ResourceLocation BobBody = new ResourceLocation(Reference.MOD_ID, MODEL_TEXTURE_LOCATION + "bobBody.png");
	}
}
