package com.xainer.clocker.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.xainer.clocker.Log;

public class Commands implements CommandExecutor
{
	List<ClockerCommand> commands = new ArrayList<ClockerCommand>();
	
	public Commands()
	{
		commands.add(new SetDayStart());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias,
			String[] args) {
		
		return true;
		/*
		Log.i("Tu sie dostaje - " + commands.size());
		if(args.length > 0)
			for(ClockerCommand cCommand : commands)
			{
				String subCommand = args[0].toLowerCase();
				Log.i(cCommand.getCommandName() + " = " + subCommand);
				if(cCommand.getCommandName().toLowerCase().equals(subCommand))
				{
					if(args.length >= cCommand.getMinArgs())
						cCommand.run(sender, args);
					else
						cCommand.help(sender);
				}
			}
		return false;*/
	}
	
	public void addCommand(ClockerCommand command)
	{
		commands.add(command);
	}
}
