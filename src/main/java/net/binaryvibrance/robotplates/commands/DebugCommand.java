package net.binaryvibrance.robotplates.commands;

import net.binaryvibrance.robotplates.client.renderer.model.ModelStartPlate;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by CodeWarrior on 26/07/2014.
 */
public class DebugCommand extends CommandBase {
	@Override
	public String getCommandName() {
		return "bvdbg";
	}

	@Override
	public String getCommandUsage(ICommandSender commandSender) {
		return "bvdbg";
	}

	@Override
	public void processCommand(ICommandSender commandSender, String[] arguments) {

		ModelStartPlate.reload();

		if (commandSender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)commandSender;
			player.addChatComponentMessage(new ChatComponentText("Debug command executed"));
		}
	}
}
