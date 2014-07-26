package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.binaryvibrance.robotplates.client.renderer.item.ItemRendererConditionalPlate;
import net.binaryvibrance.robotplates.client.renderer.item.ItemRendererRemoteDebugger;
import net.binaryvibrance.robotplates.client.renderer.item.ItemRendererStartPlate;
import net.binaryvibrance.robotplates.client.renderer.tileentity.TileEntityRendererConditionalPlate;
import net.binaryvibrance.robotplates.client.renderer.tileentity.TileEntityRendererStartPlate;
import net.binaryvibrance.robotplates.init.ModBlocks;
import net.binaryvibrance.robotplates.init.ModItems;
import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityConditionalPlate;
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
		RenderIds.conditionalPlate = RenderingRegistry.getNextAvailableRenderId();

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.startPlate), new ItemRendererStartPlate());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.conditionalPlate), new ItemRendererConditionalPlate());
		MinecraftForgeClient.registerItemRenderer(ModItems.remoteDebugger, new ItemRendererRemoteDebugger());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStartPlate.class, new TileEntityRendererStartPlate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConditionalPlate.class, new TileEntityRendererConditionalPlate());
	}
}
