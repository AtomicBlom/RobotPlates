package net.binaryvibrance.robotplates.programming;

import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;
import net.binaryvibrance.robotplates.utility.CompassDirection;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Stack;

public class PlateCompiler {
	public void compile(TileEntityPlateProgrammer programmerTileEntity, World world) {

		HashSet<BaseRobotPlatesTileEntity> processedBlocks = new HashSet<BaseRobotPlatesTileEntity>();

		Stack<BaseRobotPlatesTileEntity> blocksToProcess = new Stack<BaseRobotPlatesTileEntity>();
		blocksToProcess.push(programmerTileEntity);
		while (!blocksToProcess.empty()) {
			BaseRobotPlatesTileEntity currentTileEntity = blocksToProcess.pop();
			processedBlocks.add(currentTileEntity);

			//Gather next set of blocks to process.
			for (CompassDirection direction : CompassDirection.VALID_DIRECTIONS) {
				TileEntity tileEntity = world.getTileEntity(currentTileEntity.xCoord + direction.offsetX, currentTileEntity.yCoord + direction.offsetY, currentTileEntity.zCoord + direction.offsetZ);
				if (tileEntity != null && tileEntity instanceof BaseRobotPlatesTileEntity && !processedBlocks.contains(tileEntity)) {
					blocksToProcess.push((BaseRobotPlatesTileEntity)tileEntity);
				}
			}

			LogHelper.info("Found Plate - %s at %d, %d, %d", currentTileEntity.getClass().getSimpleName(), currentTileEntity.xCoord, currentTileEntity.yCoord, currentTileEntity.zCoord);

		}
	}
}
