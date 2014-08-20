package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.common.eventhandler.EventBus;

public interface IProxy {
	void initRenderingAndTextures();

	void registerTileEntities();

	void registerEventHandlers(EventBus bus);
}
