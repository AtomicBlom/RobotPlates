package net.binaryvibrance.robotplates.item;

import net.binaryvibrance.robotplates.compiler.component.EventPlateComponent;
import net.binaryvibrance.robotplates.tileentity.TileEntityPlateEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ItemComponentEvent extends BaseRobotPlateItem {
	public ItemComponentEvent() {
		super();
		this.setUnlocalizedName("componentEvent");
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) return false;

		TileEntity hitTileEntity = world.getTileEntity(x, y, z);
		if (!(hitTileEntity instanceof TileEntityPlateEvent)) return false;

		TileEntityPlateEvent eventPlate = (TileEntityPlateEvent)hitTileEntity;
		if (eventPlate.getInstalledComponent() != EventPlateComponent.NONE) return false;

		NBTTagCompound tag = stack.getTagCompound();
		EventPlateComponent installedComponent = EventPlateComponent.TICK;
		if (tag != null && tag.hasKey("Type")) {
			int typeOrdinal = tag.getInteger("Type");
			if (typeOrdinal < EventPlateComponent.values().length) {
				installedComponent = EventPlateComponent.values()[typeOrdinal];
			}
		}

		eventPlate.setInstalledComponent(installedComponent);

		if (!player.capabilities.isCreativeMode) {
			stack.stackSize--;
		}
		return true;
	}
}
