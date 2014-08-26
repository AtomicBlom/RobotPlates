package net.binaryvibrance.robotplates.client.renderer;

import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;

public interface IComponentRenderer {
	void render(TileEntityPlateEvent.EventType eventType);
}
