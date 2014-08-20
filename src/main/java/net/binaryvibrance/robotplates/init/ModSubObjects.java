package net.binaryvibrance.robotplates.init;

import net.binaryvibrance.robotplates.client.TileEntitySubObject.SubObject;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.minecraft.util.AxisAlignedBB;

public class ModSubObjects implements IDebugReloadable {
	private static ModSubObjects instance;
	private ModSubObjects() {}
	public static ModSubObjects instance() {
		return (instance != null ? instance : (instance = new ModSubObjects()));
	}

	@Override
	public void reload() {
		codePathSubObjects = initializeCodePathSubObjects();
	}

	private SubObject[] initializeCodePathSubObjects() {
		final float scale = 1f / 16f;
		final float e = 0.00001F;
		return new SubObject[] {
				new SubObject(AxisAlignedBB.getBoundingBox(
						6f * scale, 0f * scale, 0f * scale,
						10f * scale, 3.5f * scale, 6f * scale).expand(e, e, e)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						6f * scale, 0f * scale, 10f * scale,
						10f * scale, 3.5f * scale, 16f * scale).expand(e, e, e)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						0f * scale, 0f * scale, 6f * scale,
						6f * scale, 3.5f * scale, 10f * scale).expand(e, e, e)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						10f * scale, 0f * scale, 6f * scale,
						16f * scale, 3.5f * scale, 10f * scale).expand(e, e, e)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						6f * scale, 0f * scale, 6f * scale,
						10f * scale, 3.5f * scale, 10f * scale).expand(e, e, e))
		};
	}

	public static SubObject[] codePathSubObjects;
}
