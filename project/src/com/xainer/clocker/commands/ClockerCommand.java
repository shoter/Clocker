package com.xainer.clocker.commands;

import org.bukkit.command.CommandSender;

import com.xainer.clocker.Clock;

public interface ClockerCommand
{
	public abstract boolean run(Clock clock, CommandSender sender, String[] args);
	public abstract void help(CommandSender sender);
	public abstract void noPermission();
	
	public abstract String getPermission();
	
	public abstract boolean canPlayerExecute();
	public abstract boolean canServerExecute();
	
	public abstract String getCommandName();
	public abstract String getName();
	public abstract int getMinArgs();
	
	//@Override
	public boolean equals(Object obj);
}
