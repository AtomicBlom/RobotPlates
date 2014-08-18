package net.binaryvibrance.robotplates.programming.compiler;

import net.binaryvibrance.robotplates.programming.instructions.Program;
import net.binaryvibrance.robotplates.tileentity.BaseRobotPlatesTileEntity;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateCodePath;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;
import net.binaryvibrance.robotplates.utility.CompassDirection;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.HashSet;

public class PlateCompiler {
	public void compile(TileEntityPlateProgrammer programmerPlate, World world) {
		readBlocksFromWorld(programmerPlate, world);
		createCodePaths();
		createInstructions();
	}

	private void createInstructions() {
	}

	private void createCodePaths() {
	}

	private void readBlocksFromWorld(TileEntityPlateProgrammer programmerPlate, World world) {
		HashSet<BaseRobotPlatesTileEntity> processedBlocks = new HashSet<BaseRobotPlatesTileEntity>();
		HashMap<BaseRobotPlatesTileEntity, InterconnectInfo> interconnects = new HashMap<BaseRobotPlatesTileEntity, InterconnectInfo>();
		ModifiableLinkedList<BaseRobotPlatesTileEntity> blocksToProcess = new ModifiableLinkedList<BaseRobotPlatesTileEntity>();
		blocksToProcess.add(programmerPlate);
		ModifiableLinkedList<BaseRobotPlatesTileEntity>.Node currentNode = blocksToProcess.beforeFirstNode();

		while (currentNode.hasNext()) {
			currentNode = currentNode.getNext();
			BaseRobotPlatesTileEntity currentTileEntity = currentNode.getData();
			processedBlocks.add(currentTileEntity);
			InterconnectInfo interconnect;
			if (!interconnects.containsKey(currentTileEntity)) {
				interconnect = new InterconnectInfo(currentTileEntity);
				interconnects.put(currentTileEntity, interconnect);
			} else {
				interconnect = interconnects.get(currentTileEntity);
			}

			//Gather next set of blocks to process.
			for (CompassDirection direction : CompassDirection.VALID_DIRECTIONS) {
				TileEntity tileEntity = world.getTileEntity(
						currentTileEntity.xCoord + direction.offsetX,
						currentTileEntity.yCoord + direction.offsetY,
						currentTileEntity.zCoord + direction.offsetZ);
				if (tileEntity != null && tileEntity instanceof BaseRobotPlatesTileEntity && !processedBlocks.contains(tileEntity)) {
					BaseRobotPlatesTileEntity neighbour = (BaseRobotPlatesTileEntity) tileEntity;
					currentNode.addLast(neighbour);
					interconnect.assignNeighbour(direction, neighbour);
				}
			}

			LogHelper.info("Found Plate - %s at %d, %d, %d", currentTileEntity.getClass().getSimpleName(), currentTileEntity.xCoord, currentTileEntity.yCoord, currentTileEntity.zCoord);
		}
	}


}
