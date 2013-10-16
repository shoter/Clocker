package com.xainer.clocker.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import com.xainer.clocker.MessageBuilder;
import com.xainer.clocker.commands.arguments.BaseArgument;

public abstract class BaseCommand implements ClockerCommand
{
	List<List<BaseArgument>> argumentsList;
	String msgNoPermission = MessageBuilder.build("You have no [R]permission[/R] to do that");
	
	public BaseCommand( int argsListCount )
	{
		argumentsList = new ArrayList<List<BaseArgument>>(argsListCount);
	}

	@Override
	public boolean run(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public abstract boolean execute(CommandSender sender, String[] args);

	@Override
	public void help(CommandSender sender) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noPermission() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean equals(Object arg) {
		if(arg instanceof String)
		{
			String name = (String) arg;
			return getCommandName().toLowerCase().equals(name.toLowerCase());
		}
		else
			return super.equals(arg);
	}

}
