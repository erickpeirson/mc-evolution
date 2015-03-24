package com.evolution.test.commands;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandBase;
import net.minecraft.util.ChatComponentText;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandException;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

import com.evolution.structure.StructureGenerator;
import net.minecraft.world.World;

public class TestCommand extends CommandBase
{
	
	public String getName()
	{
		return "evolutiontest";
	}
	
	public String getCommandUsage(ICommandSender sender)
	{
		return "commands.clear.usage";
	}
	
	public void execute(ICommandSender sender, String[] args) throws CommandException
	{
		BlockPos bp = sender.getPosition();
		StructureGenerator sg = new StructureGenerator();
		World worldIn = sender.getEntityWorld();
		
		int x = bp.getX();
		int y = bp.getY();
		int z = bp.getZ();
		boolean success = sg.generateHouse(worldIn, x, y, z);
		ChatComponentText message = new ChatComponentText("wooho" + success); 
		sender.addChatMessage(message);
		
	}
	
	@Override
	public boolean canCommandSenderUse(ICommandSender sender)
	{
		return true;
		
	}
	
}
