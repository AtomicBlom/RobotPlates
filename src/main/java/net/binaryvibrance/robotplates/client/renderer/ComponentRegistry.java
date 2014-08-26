package net.binaryvibrance.robotplates.client.renderer;

import com.google.common.collect.Maps;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;

import java.util.IdentityHashMap;

public class ComponentRegistry {
	private static IdentityHashMap<TileEntityPlateEvent.EventType, IComponentRenderer> componentRenderers = Maps.newIdentityHashMap();

	public static void registerComponentRenderer(TileEntityPlateEvent.EventType eventType, IComponentRenderer renderer)
	{
		componentRenderers.put(eventType, renderer);
	}

	public static IComponentRenderer getEventComponentRenderer(TileEntityPlateEvent.EventType eventType) {
		return componentRenderers.get(eventType);
	}
}
