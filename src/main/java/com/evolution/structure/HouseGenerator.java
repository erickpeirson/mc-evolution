package com.evolution.structure;

import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;

import net.minecraft.util.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.util.Vec3;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.BlockState;

import com.evolution.structure.Excavator;
import java.util.Random;


public class HouseGenerator extends WorldGenerator
{
	public HouseGenerator() {
		
	}
	
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		IBlockState sstone = Blocks.sandstone.getDefaultState();
		IBlockState adoor = Blocks.acacia_door.getDefaultState();
		IBlockState air = Blocks.air.getDefaultState();
		IBlockState[][][] design = {
				{
					{air,air,air,air,air,air,air}, // Bottom
					{air,air,air,air,air,air,air},
					{air,air,air,air,air,air,air},
					{air,air,air,air,air,air,air}, // Top
					
				},
				{
					{air,sstone,sstone,air,sstone,sstone,air},
					{air,sstone,sstone,air,sstone,sstone,air},
					{air,sstone,sstone,sstone,sstone,sstone,air},
					{air,sstone,sstone,sstone,sstone,sstone,air},
					
				},
				{
					{air,sstone,air,air,air,sstone,air},
					{air,sstone,air,air,air,sstone,air},
					{air,sstone,air,air,air,sstone,air},
					{air,sstone,sstone,sstone,sstone,sstone,air}
				},
				{
					{air,air,air,air,air,air,air},
					{air,air,air,air,air,air,air},
					{air,sstone,air,air,air,sstone,air},
					{air,sstone,sstone,sstone,sstone,sstone,air}
				},
				{
					{air,sstone,air,air,air,sstone,air},
					{air,sstone,air,air,air,sstone,air},
					{air,sstone,air,air,air,sstone,air},
					{air,sstone,sstone,sstone,sstone,sstone,air}
				},
				{
					{air,sstone,sstone,air,sstone,sstone,air},
					{air,sstone,sstone,air,sstone,sstone,air},
					{air,sstone,sstone,sstone,sstone,sstone,air},
					{air,sstone,sstone,sstone,sstone,sstone,air},
				},
				{
					{air,air,air,air,air,air,air},
					{air,air,air,air,air,air,air},
					{air,air,air,air,air,air,air},
					{air,air,air,air,air,air,air},
					
				}
		};
		
		Excavator excavator = new Excavator(worldIn);
		Vec3 vec = new Vec3(pos.getX(), pos.getY(), pos.getZ());
		AxisAlignedBB ground_dimensions = new AxisAlignedBB(0, 0, 0, 7, 4, 7);
		AxisAlignedBB house_dimensions = new AxisAlignedBB(0, 0, 0, 7, 4, 7);
		
		boolean flag = true;
		
		if (excavator.canExcavate(vec, ground_dimensions)) {
			excavator.excavate(vec, ground_dimensions);
			
			for (int i = 0; i < house_dimensions.maxX; i++) {
				for (int j = 0; j < house_dimensions.maxY; j++) {
					for (int k = 0; k < house_dimensions.maxZ; k++) {
						
						if (design[i][j][k] != air) {
							IBlockState state = design[i][j][k];
							BlockPos newpos = new BlockPos(i+pos.getX(), j+pos.getY(), k+pos.getZ());
							worldIn.setBlockState(newpos, state);
						}
					}
				}
			}
		} else {
			flag = false;
		}
		
		return flag;
	}

}
