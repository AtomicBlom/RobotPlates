package net.binaryvibrance.robotplates.programming.event;

import cpw.mods.fml.common.Mod;
import net.binaryvibrance.robotplates.entity.BaseRobot;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;

/**
 * Created by CodeWarrior on 2/08/2014.
 */
public class EventPlayerInRangeHandler {
	public EventPlayerInRangeHandler() {

	}

	@Mod.EventHandler
	public void OnPlayerMoved(LivingEvent.LivingUpdateEvent event) {
		//Loop through all loaded robots that are registered to receive this event.

	}

	public void RegisterForEvent(BaseRobot robot) {

	}
}
