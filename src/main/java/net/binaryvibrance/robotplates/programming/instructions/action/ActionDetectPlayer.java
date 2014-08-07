package net.binaryvibrance.robotplates.programming.instructions.action;

import net.binaryvibrance.robotplates.api.programming.IHaveInstructions;
import net.binaryvibrance.robotplates.api.programming.IInstruction;
import net.binaryvibrance.robotplates.entity.EntityRobotBase;
import net.binaryvibrance.robotplates.programming.instructions.ProgramState;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.*;

public class ActionDetectPlayer implements IInstruction, IHaveInstructions {
	private Iterator<EntityPlayer> iterator;
	private List<IInstruction> instructions;

	public ActionDetectPlayer() {
		instructions = new LinkedList<IInstruction>();
	}

	@Override
	public List<IInstruction> execute(ProgramState state) {
		EntityRobotBase robot = state.getRobot();
		World world = state.getWorld();
		int range = robot.getDetectionRange();

		AxisAlignedBB boundingBox = AxisAlignedBB.getBoundingBox(
				robot.posX - range, robot.posY - range, robot.posZ - range,
				robot.posX + range, robot.posY + range, robot.posZ + range);
		IEntitySelector selector = new IEntitySelector() {
			@Override
			public boolean isEntityApplicable(Entity entity) {
				return entity instanceof EntityPlayer;
			}
		};

		final Vec3 robotLocation = Vec3.createVectorHelper(robot.posX, robot.posY, robot.posZ);

		TreeSet<EntityPlayer> list = new TreeSet<EntityPlayer>(new Comparator<EntityPlayer>() {
			@Override
			public int compare(EntityPlayer entity, EntityPlayer entity2) {
				Vec3 entity1Pos = Vec3.createVectorHelper(entity.posX, entity.posY, entity.posZ);
				Vec3 entity2Pos = Vec3.createVectorHelper(entity2.posX, entity2.posY, entity2.posZ);

				double entity1Distance = robotLocation.distanceTo(entity1Pos);
				double entity2Distance = robotLocation.distanceTo(entity2Pos);

				if (entity1Distance < entity2Distance) {
					return -1;
				} else if (entity1Distance > entity2Distance) {
					return 1;
				}
				return 0;
			}
		});

		//FIXME: Correct for square bounding box, verify against sphere.
		List entities = world.getEntitiesWithinAABBExcludingEntity(robot, boundingBox, selector);
		if (entities != null) {
			for (Object o : entities) {
				if (o instanceof EntityPlayer) {
					list.add((EntityPlayer) o);
				}
			}
		}

		iterator = list.iterator();
		if (iterator.hasNext()) {
			state.setState(EntityPlayer.class, iterator.next());
		} else {
			state.removeState(EntityPlayer.class);
		}

		return instructions;
	}

	@Override
	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}
}
