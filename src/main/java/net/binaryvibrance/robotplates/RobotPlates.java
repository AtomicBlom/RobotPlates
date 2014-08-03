package net.binaryvibrance.robotplates;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.binaryvibrance.robotplates.commands.DebugCommand;
import net.binaryvibrance.robotplates.init.*;
import net.binaryvibrance.robotplates.proxy.IProxy;
import net.binaryvibrance.robotplates.reference.Reference;
import net.binaryvibrance.robotplates.utility.LogHelper;

@Mod(modid = Reference.MOD_ID, name=Reference.MOD_NAME, version = Reference.VERSION)
public class RobotPlates {
	@Mod.Instance(Reference.MOD_ID)
	public static RobotPlates instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModPackets.init();
		ModItems.init();
		ModBlocks.init();
		ModEntities.init();
		ModEventHandlers.init();
		LogHelper.info("Pre Initialization Complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerTileEntities();
		proxy.initRenderingAndTextures();

		LogHelper.info("Initialization Complete");
	}
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.info("Initialization Complete");
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new DebugCommand());
	}
}
