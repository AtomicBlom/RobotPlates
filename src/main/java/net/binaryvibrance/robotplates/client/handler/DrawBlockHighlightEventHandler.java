package net.binaryvibrance.robotplates.client.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.binaryvibrance.robotplates.client.TileEntitySubObject.SubObject;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

public class DrawBlockHighlightEventHandler {
	private static DrawBlockHighlightEventHandler ourInstance = new DrawBlockHighlightEventHandler();
	public static DrawBlockHighlightEventHandler getInstance() {
		return ourInstance;
	}
	private DrawBlockHighlightEventHandler() {}

	@SubscribeEvent
	public void onBlockHighlightEvent(DrawBlockHighlightEvent highlightEvent) {
		MovingObjectPosition target = highlightEvent.target;
		//We're only interested in blocks...
		if (target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			World world = highlightEvent.player.worldObj;
			TileEntity tileEntity = world.getTileEntity(target.blockX, target.blockY, target.blockZ);
			//...From my mod
			if (tileEntity instanceof BaseRobotPlatesTileEntity) {
				//TODO: Recalculate the vector used to intersect the block so I can be more accurate with subblock detection.
				BaseRobotPlatesTileEntity rpTileEntity = (BaseRobotPlatesTileEntity)tileEntity;
				Vec3 targetBlockVec = Vec3.createVectorHelper(target.blockX, target.blockY, target.blockZ);
				Vec3 vec = targetBlockVec.subtract(target.hitVec);
				SubObject subObject = rpTileEntity.getSubObject(vec);
				//... and we're hovering over one of my Sub-Objects.
				if (subObject != null) {
					subObject.RenderBoundingBox(highlightEvent.player, rpTileEntity, highlightEvent.partialTicks);
					//Don't draw the block's highlight.
					highlightEvent.setCanceled(true);
				}
			}
		}
	}
}
