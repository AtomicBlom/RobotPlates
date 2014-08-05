package net.binaryvibrance.robotplates.programming.instructions;

import net.binaryvibrance.robotplates.entity.BaseRobot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class ProgramState {
	private final Map<Class, Object> state;

	private BaseRobot robot;

	public ProgramState(BaseRobot robot) {
		this.robot = robot;
		state = new HashMap<Class, Object>();
	}

	public void setState(Object stateObject) {
		Class type = stateObject.getClass();
		state.put(type, stateObject);
	}


	public void setState(Class<EntityPlayer> type, Object stateObject) {
		state.put(type, stateObject);
	}

	public Object getState(Class clazz) {
		if (state.containsKey(clazz)) {
			return state.get(clazz);
		}
		return null;
	}

	public boolean hasState(Class clazz) {
		return state.containsKey(clazz);
	}

	public BaseRobot getRobot() {
		return robot;
	}

	public World getWorld() {
		return robot.worldObj;
	}

	public void removeState(Class clazz) {
		if (state.containsKey(clazz)) {
			state.remove(clazz);
		}
	}
}
