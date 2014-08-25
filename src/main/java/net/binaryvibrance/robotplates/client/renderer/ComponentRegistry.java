package net.binaryvibrance.robotplates.client.renderer;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;

import java.util.IdentityHashMap;

public class ComponentRegistry {
	private static IdentityHashMap<Item, IComponentRenderer> componentRenderers = Maps.newIdentityHashMap();

	public static void registerComponentRenderer(Item item, IComponentRenderer renderer)
	{
		componentRenderers.put(item, renderer);
	}
}
