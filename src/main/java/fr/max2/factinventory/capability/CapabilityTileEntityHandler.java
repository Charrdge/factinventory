package fr.max2.factinventory.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CapabilityTileEntityHandler
{
	@CapabilityInject(ITileEntityHandler.class)
	public static Capability<ITileEntityHandler> CAPABILITY_TILE;
	
	public static enum Storage implements IStorage<ITileEntityHandler>
	{
		INSTANCE;

		@Override
		public INBT writeNBT(Capability<ITileEntityHandler> capability, ITileEntityHandler instance, Direction side)
		{
			return ((InventoryLinkerHandler)instance).serializeNBT();
		}

		@Override
		public void readNBT(Capability<ITileEntityHandler> capability, ITileEntityHandler instance, Direction side, INBT nbt)
		{
			if (nbt instanceof CompoundNBT)
				((InventoryLinkerHandler)instance).deserializeNBT((CompoundNBT)nbt);
		}
		
	}
	
}
