package net.binaryvibrance.robotplates.programming.event;

import cpw.mods.fml.common.Mod;
import net.binaryvibrance.robotplates.entity.BaseRobotPlatesEntityRobot;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EventPlayerInRangeHandler {
	public EventPlayerInRangeHandler() {

	}

	@Mod.EventHandler
	public void OnPlayerMoved(LivingEvent.LivingUpdateEvent event) {
		//Loop through all loaded robots that are registered to receive this event.

	}

	public void RegisterForEvent(BaseRobotPlatesEntityRobot robot) {

	}
}
