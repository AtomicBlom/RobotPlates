package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.binaryvibrance.robotplates.client.renderer.item.ItemRendererStartPlate;
import net.binaryvibrance.robotplates.client.renderer.tileentity.TileEntityRendererStartPlate;
import net.binaryvibrance.robotplates.init.ModBlocks;
import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityStartPlate;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by CodeWarrior on 25/07/2014.
 */
public class ClientProxy extends CommonProxy {
	@Override
	public void initRenderingAndTextures() {
		RenderIds.startPlate = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.startPlate), new ItemRendererStartPlate());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStartPlate.class, new TileEntityRendererStartPlate());
	}
}
