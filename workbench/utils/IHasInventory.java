package workbench.utils;

import net.minecraft.item.ItemStack;

public interface IHasInventory
{
	public void setStackInSlot(int slot, ItemStack stack);
	
	public ItemStack getStackInSlot(int slot);
	
	public int getSlotCount();
	
	public int getMaxStackSize(int slot);
	
	public boolean canInsert(int slot, ItemStack stack);
}
