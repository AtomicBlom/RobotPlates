package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateEvent;
import net.binaryvibrance.robotplates.client.renderer.ComponentRegistry;
import net.binaryvibrance.robotplates.client.renderer.IComponentRenderer;
import net.binaryvibrance.robotplates.reference.Textures;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;

public class TileEntityRendererPlateEvent extends BasePlateTileEntityRenderer<TileEntityPlateEvent> {

	public TileEntityRendererPlateEvent() {
		super(ModelPlateEvent.instance());
	}

	@Override
	protected void render(TileEntityPlateEvent tileEntity) {
		bindTexture(Textures.Model.PLATE_EVENT);
		model.render();

		TileEntityPlateEvent.EventType eventType = tileEntity.getEventType();
		if (eventType == null) {
			return;
		}

		IComponentRenderer eventComponentRenderer = ComponentRegistry.getEventComponentRenderer(eventType);
		eventComponentRenderer.render(eventType);
	}
}
