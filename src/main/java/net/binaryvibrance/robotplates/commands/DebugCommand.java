package net.binaryvibrance.robotplates.commands;

import net.binaryvibrance.robotplates.RobotPlates;
import net.binaryvibrance.robotplates.utility.IDebugReloadable;
import net.binaryvibrance.robotplates.utility.LogHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class DebugCommand extends CommandBase {
	private List<IDebugReloadable> reloadableTypes;

	@Override
	public String getCommandName() {
		return "bvreload";
	}

	@Override
	public String getCommandUsage(ICommandSender commandSender) {
		return "bvreload";
	}

	@Override
	public void processCommand(ICommandSender commandSender, String[] arguments) {
		if (reloadableTypes == null) {
			reloadableTypes = buildReloadableTypes();
		}

		for (IDebugReloadable reloadable : reloadableTypes) {
			reloadable.reload();
		}

		if (commandSender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) commandSender;
			player.addChatComponentMessage(new ChatComponentText("Debug command executed"));
		}
	}

	@SuppressWarnings("unchecked")
	private List<IDebugReloadable> buildReloadableTypes() {
		List<IDebugReloadable> list = new LinkedList<IDebugReloadable>();

		try {
			Field f = ClassLoader.class.getDeclaredField("classes");
			f.setAccessible(true);

			Vector<Class> classLoaderClasses = (Vector<Class>) f.get(DebugCommand.class.getClassLoader());
			List<Class> classList = new ArrayList<Class>(classLoaderClasses);

			for (Class c : classList) {
				String rootPackageName = RobotPlates.class.getPackage().getName();
				String name = c.getName();
				if (name.startsWith(rootPackageName)) {
					for (Class i : c.getInterfaces()) {
						if (i == IDebugReloadable.class) {
							try {
								Method m = c.getMethod("instance");
								list.add((IDebugReloadable) m.invoke(null));
							} catch (Exception e) {
								LogHelper.warn("Unable to reload class %s because it isn't a simpleton", c.toString());
							}
						}
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return list;
	}
}
