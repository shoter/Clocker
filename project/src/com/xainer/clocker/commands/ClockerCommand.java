package com.xainer.clocker.commands;

import org.bukkit.command.CommandSender;

public interface ClockerCommand
{
	public abstract boolean run(CommandSender sender, String[] args);
	public abstract void help(CommandSender sender);
	
	public abstract String getPermission();
	
	public abstract boolean canPlayerExecute();
	public abstract boolean canServerExecute();
	
	public abstract String getCommandName();
	public abstract String getName();
	public abstract int getMinArgs();
}
