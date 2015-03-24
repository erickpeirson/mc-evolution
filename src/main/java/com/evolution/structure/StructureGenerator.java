package com.evolution.structure;

import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.util.BlockPos;

import java.util.Random;

import com.evolution.structure.HouseGenerator;

public class StructureGenerator {

	
	public boolean generateHouse(World worldIn, final int x, final int y, final int z)
	{
	
		
		WorldGenerator generator = new HouseGenerator();
		return generator.generate(worldIn, new Random(), new BlockPos(x,y,z));
		
	}
}
