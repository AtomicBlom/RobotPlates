package net.binaryvibrance.robotplates.client.model;

import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public abstract class BaseModelPlate implements IDebugReloadable {
	public final float scale = (1f/16f);
	private final ResourceLocation modelLocation;
	private final String[] modelParts;
	protected IModelCustom model;

	protected BaseModelPlate(ResourceLocation modelLocation, String[] modelParts) {
		this.modelLocation = modelLocation;
		this.modelParts = modelParts;
		reload();
	}

	protected BaseModelPlate(ResourceLocation modelLocation) {
		this(modelLocation, new String[] { "plate" });
	}

	public void reload() {
		model = AdvancedModelLoader.loadModel(modelLocation);
	}

	public void render() {
		if (model == null) {
			reload();
		}

		for (String part : modelParts) {
			model.renderPart(part);
		}
	}

	public void renderActive(boolean north, boolean south, boolean east, boolean west) {
		if (north) {
			model.renderPart("Active_North");
		}
		if (south) {
			model.renderPart("Active_South");
		}
		if (east) {
			model.renderPart("Active_East");
		}
		if (west) {
			model.renderPart("Active_West");
		}
		if (north || south || east || west) {
			model.renderPart("Active_Centre");
		}
	}
}
