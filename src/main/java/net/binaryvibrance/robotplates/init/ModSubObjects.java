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
		//Most of the models were implemented at 16x scale, which made it easy to model,
		// I've calculated the subobject bounding boxes using the same grid, hence the need to scale.
		final float scale = 1f / 16f;
		//I use an epsilon to ensure that a ray falling on the boundry of a block actually goes in the bounding box.
		final float e = 0.00001F;
		return new SubObject[] {
				new SubObject(AxisAlignedBB.getBoundingBox(
						6f * scale, 0f * scale - e, 0f * scale - e,
						10f * scale, 3f * scale + e, 6f * scale)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						6f * scale, 0f * scale - e, 10f * scale,
						10f * scale, 3f * scale + e, 16f * scale + e)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						0f * scale - e, 0f * scale - e, 6f * scale,
						6f * scale, 3f * scale + e, 10f * scale)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						10f * scale, 0f * scale - e, 6f * scale,
						16f * scale + e, 3f * scale + e, 10f * scale)),
				new SubObject(AxisAlignedBB.getBoundingBox(
						6f * scale, 0f * scale - e, 6f * scale,
						10f * scale, 3f * scale + e, 10f * scale))
		};
	}

	public static SubObject[] codePathSubObjects;
}
