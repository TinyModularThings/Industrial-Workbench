package workbench.block;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import workbench.utils.IHasInventory;

public class TileEntityIndustrialWorkbench extends TileEntity implements IHasInventory
{
	public NonNullList<ItemStack> inventory = NonNullList.withSize(27, ItemStack.EMPTY);
	public NonNullList<ItemStack> craftingInventory = NonNullList.withSize(10, ItemStack.EMPTY);
	public NonNullList<ItemStack> memorySlots = NonNullList.withSize(2, ItemStack.EMPTY);
	
	public boolean[] usedSlots = flagsFromNumber(27, 511);
	public boolean isCentered = false;
	
	
	@Override
	public void setStackInSlot(int slot, ItemStack stack)
	{
		inventory.set(slot, stack);
		if(stack.getCount() >= getMaxStackSize(slot))
		{
			stack.setCount(getMaxStackSize(slot));
		}
	}
	
	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory.get(slot);
	}
	
	@Override
	public int getSlotCount()
	{
		return inventory.size();
	}
	
	@Override
	public int getMaxStackSize(int slot)
	{
		return 64;
	}
	
	@Override
	public boolean canInsert(int slot, ItemStack stack)
	{
		return true;
	}
	
	static boolean[] flagsFromNumber(int size, int initialNumber)
	{
		boolean[] flags = new boolean[size];
		for(int i = 0;i < size;i++)
		{
			flags[i] = (initialNumber & 1 << i) != 0;
		}
		return flags;
	}
}
