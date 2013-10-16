/*
 *  Copyright 2013 Xainer

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.xainer.clocker;

import java.util.ArrayList;
import java.util.List;

import com.xainer.clocker.commands.ClockerCommand;

public abstract class BaseClock implements Clock
{
	static List<ClockerCommand> commands = new ArrayList<ClockerCommand>();
	
	public static ClockerCommand getCommand(String name)
	{
		for(ClockerCommand c : commands)
		{
			Log.i(c + " ?= " + name);
			if(c.equals(name))
				return c;
		}
		return null;
	}
	public static ClockerCommand getCommand(ClockerCommand command)
	{
		return getCommand(command.getCommandName());
	}

	public static void addCommand(ClockerCommand command)
	{
		//check existence of previous command;
		if(getCommand(command)  != null)
		{
			Log.e("[R]Command[/R] [G]" + command.getCommandName() + "[/G][R] was added more than once![/R]");
			new Exception().printStackTrace();
			return;
		}
		Log.i("Dodaje komende");
		Log.i(commands.toString());
		commands.add(command);
	}
	
	public static List<ClockerCommand> getCommands()
	{
		return commands;
	}
}
