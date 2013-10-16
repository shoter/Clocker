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

package com.xainer.clocker.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;

import com.xainer.clocker.Clock;
import com.xainer.clocker.Log;
import com.xainer.clocker.MessageBuilder;
import com.xainer.clocker.commands.arguments.Argument;
import com.xainer.clocker.commands.arguments.BaseArgument;

public abstract class BaseCommand implements ClockerCommand
{
	List<List<Argument>> argumentsList;
	String msgNoPermission = MessageBuilder.build("You have no [R]permission[/R] to do that");
	
	public BaseCommand( int argsListCount )
	{
		argumentsList = new ArrayList<List<Argument>>(argsListCount);
	}

	@Override
	public boolean run(Clock clock, CommandSender sender, String[] args) {
		//Zle zrobione.
		//moze byc TAK :
		//<SUB> <WORLD> [ARGS]
		//<SUB> [ARGS] (Tylko dla playera badz dla serwera. Trzeba to sprawdzic!!!
		//Dziekuje za uwage jutro dokoncze :)
		for(int argCase = 0; argCase < argumentsList.size(); ++argCase)
		{
			List<Argument> arguments = argumentsList.get(argCase);
			if(arguments.size() == args.length)
			{
				for(int i = 0; i < arguments.size(); ++i)
				{
					Argument arg = arguments.get(i);
					if(arg.isArgGood(args[i]) == false)
							continue;
					arg.parseArgument(args[i]);
				}
				String newArgs = args.si
				
				exceute(clock, argCase, sender,)
				
			}
		}
		return false;
	}
	
	public abstract boolean execute(Clock clock, int argCase, CommandSender sender, String[] args);

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
		Log.i(getCommandName() + " ?= " + arg);
		if(arg instanceof String)
		{
			String name = (String) arg;
			Log.i("[G]Dzia³am na stringu[/G]");
			return getCommandName().toLowerCase().equals(name.toLowerCase());
		}
		else
			return super.equals(arg);
	}

}
