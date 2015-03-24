package com.evolution.structure;

import net.minecraft.world.World;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.util.BlockPos;
import net.minecraft.init.Blocks;


public class Excavator {
	public double thresholdDensity = 0.3;
	public World world;
	
	public Excavator(World worldIn)
	{
		this.world = worldIn;
	}
	
	public boolean canExcavate(Vec3 vec, AxisAlignedBB dimensions)
	{
		if (this.world.getBlockDensity(vec, dimensions) <= this.thresholdDensity) {
			return true;
		} else {
			return false;
		}
	}

	public boolean excavate(Vec3 vec, AxisAlignedBB dimensions) {
		// Dig down 1 extra layer.
		for (double i=vec.xCoord+dimensions.minX; i < vec.xCoord+dimensions.maxX; i++)
		{
			for (double j=vec.yCoord+dimensions.minY-1; j < vec.yCoord+dimensions.maxY; j++)
			{
				for (double k=vec.zCoord+dimensions.minZ; k < vec.zCoord+dimensions.maxZ; k++)
				{
					this.world.destroyBlock(new BlockPos(i,j,k), false);
				}
			}
				
		}
		
		// Build back that extra layer.
		for (double i=vec.xCoord+dimensions.minX; i < vec.xCoord+dimensions.maxX; i++)
		{
				for (double k=vec.zCoord+dimensions.minZ; k < vec.zCoord+dimensions.maxZ; k++)
				{
					BlockPos newpos = new BlockPos(i,vec.yCoord+dimensions.minY-1,k); 
					this.world.setBlockState(newpos, Blocks.stone.getDefaultState());					
				}
				
		}
		return true;
		
	}
}
