package net.binaryvibrance.robotplates.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.binaryvibrance.robotplates.client.renderer.entity.EntityRendererRobotBob;
import net.binaryvibrance.robotplates.client.renderer.item.*;
import net.binaryvibrance.robotplates.client.renderer.tileentity.TileEntityRendererPlateCodePath;
import net.binaryvibrance.robotplates.client.renderer.tileentity.TileEntityRendererPlateConditional;
import net.binaryvibrance.robotplates.client.renderer.tileentity.TileEntityRendererPlateProgrammer;
import net.binaryvibrance.robotplates.entity.robot.EntityRobotBaseBob;
import net.binaryvibrance.robotplates.init.ModBlocks;
import net.binaryvibrance.robotplates.init.ModItems;
import net.binaryvibrance.robotplates.reference.RenderIds;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateCodePath;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateConditional;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateProgrammer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	@Override
	public void initRenderingAndTextures() {
		//Render Ids
		RenderIds.plateStart = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.plateConditional = RenderingRegistry.getNextAvailableRenderId();
		RenderIds.plateCodePath = RenderingRegistry.getNextAvailableRenderId();

		//Item renderer
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.plateProgrammer), new ItemRendererPlateProgrammer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.plateConditional), new ItemRendererPlateConditional());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.plateCodePath), new ItemRendererPlateCodePath());
		MinecraftForgeClient.registerItemRenderer(ModItems.remoteDebugger, new ItemRendererToolRemoteDebugger());
		MinecraftForgeClient.registerItemRenderer(ModItems.robot, new ItemRendererRobotBob());
		MinecraftForgeClient.registerItemRenderer(ModItems.toolSolderingIron, new ItemRendererToolSolderingIron());

		//TileEntities
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlateProgrammer.class, new TileEntityRendererPlateProgrammer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlateConditional.class, new TileEntityRendererPlateConditional());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPlateCodePath.class, new TileEntityRendererPlateCodePath());

		//Entity Renderer
		RenderingRegistry.registerEntityRenderingHandler(EntityRobotBaseBob.class, new EntityRendererRobotBob());
	}
}
