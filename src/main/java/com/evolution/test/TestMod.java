package com.evolution.test;

import com.evolution.test.commands.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;

@Mod(modid = TestMod.MODID, version = TestMod.VERSION)
public class TestMod 
{
	public static final String MODID = "testmod";
	public static final String VERSION = "0.1";
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//
	}
	
    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
         MinecraftServer server = MinecraftServer.getServer();

         ICommandManager command = server.getCommandManager();
         ServerCommandManager manager = (ServerCommandManager) command;
         manager.registerCommand(new TestCommand());
    }    	
}
