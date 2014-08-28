package net.binaryvibrance.robotplates.client.renderer.tileentity;

import net.binaryvibrance.robotplates.client.model.ModelPlateEvent;
import net.binaryvibrance.robotplates.client.renderer.ComponentRegistry;
import net.binaryvibrance.robotplates.client.renderer.IComponentRenderer;
import net.binaryvibrance.robotplates.compiler.component.EventPlateComponent;
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

		EventPlateComponent installedComponent = tileEntity.getInstalledComponent();
		if (installedComponent == null) {
			return;
		}

		IComponentRenderer eventComponentRenderer = ComponentRegistry.getEventComponentRenderer(installedComponent);
		if (eventComponentRenderer != null) {
			eventComponentRenderer.render(installedComponent);
		}
	}
}
