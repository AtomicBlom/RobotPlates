package net.binaryvibrance.robotplates.client.renderer;

import com.google.common.collect.Maps;
import net.binaryvibrance.robotplates.compiler.component.EventPlateComponent;

import java.util.IdentityHashMap;

public class ComponentRegistry {
	private static IdentityHashMap<EventPlateComponent, IComponentRenderer> componentRenderers = Maps.newIdentityHashMap();

	public static void registerComponentRenderer(EventPlateComponent installedComponent, IComponentRenderer renderer)
	{
		componentRenderers.put(installedComponent, renderer);
	}

	public static IComponentRenderer getEventComponentRenderer(EventPlateComponent installedComponent) {
		return componentRenderers.get(installedComponent);
	}
}
