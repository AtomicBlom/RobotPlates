package net.binaryvibrance.robotplates.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.binaryvibrance.robotplates.client.TileEntitySubObject.SubObject;
import net.binaryvibrance.robotplates.client.renderer.tileentity.BasePlateTileEntityRenderer;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;

public class BlockHoverHelper {
	private static BlockHoverHelper ourInstance = new BlockHoverHelper();
	public static BlockHoverHelper getInstance() {
		return ourInstance;
	}
	private BlockHoverHelper() {}

	@SubscribeEvent
	public void onBlockHighlightEvent(DrawBlockHighlightEvent highlightEvent) {
		MovingObjectPosition target = highlightEvent.target;
		if (target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
			World world = highlightEvent.player.worldObj;
			TileEntity tileEntity = world.getTileEntity(target.blockX, target.blockY, target.blockZ);
			if (tileEntity instanceof BaseRobotPlatesTileEntity) {
				BaseRobotPlatesTileEntity rpTileEntity = (BaseRobotPlatesTileEntity)tileEntity;
				Vec3 targetBlockVec = Vec3.createVectorHelper(target.blockX, target.blockY, target.blockZ);
				Vec3 vec = targetBlockVec.subtract(target.hitVec);
				SubObject subObject = rpTileEntity.getSubObject(vec);
				if (subObject != null) {
					subObject.RenderBoundingBox(highlightEvent.player, rpTileEntity, highlightEvent.partialTicks);
					highlightEvent.setCanceled(true);
				}
			}
		}
	}
}
