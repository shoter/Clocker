package com.xainer.clocker;

import java.util.ArrayList;
import java.util.List;

import com.xainer.clocker.commands.ClockerCommand;

public abstract class BaseClock implements Clock
{
	List<ClockerCommand> commands = new ArrayList<ClockerCommand>();
	
	@Override
	public ClockerCommand getCommand(String name)
	{
		for(ClockerCommand c : commands)
		{
			if(c.equals(name))
				return c;
		}
		return null;
	}
	
	@Override
	public List<ClockerCommand> getCommands()
	{
		return commands;
	}
}
