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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import com.xainer.clocker.commands.Commands;

public class Clocker extends JavaPlugin
{
	
	static Logger logger;
	
	public boolean initialized = false;
	
	public static Clocker instance;
	
	public Map<String, Clock> clocks = new HashMap<String, Clock>();
	
	@Override
	public void onEnable() {
		
		instance = this;
		
		for(World world : Bukkit.getWorlds())
		{
			RealTimeClock clock = new RealTimeClock();
			clocks.put(world.getName().toLowerCase(), clock);
		}
		super.onEnable();
		
		initialize();
		initialized = true;
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	
	public void initialize()
	{
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				tick();
				
			}
		}, 10, 20);
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				display();
				
			}
		}, 10, 1);
		logger = Bukkit.getLogger();
		
		getCommand("clocker").setExecutor(new Commands());
	}
	
	public void tick()
	{
		if(!initialized)
			return;
		for(Clock clock : clocks.values())
			clock.tick();
	}
	
	public void display()
	{
		if(!initialized)
			return;
		for(World world : Bukkit.getWorlds())
		{
			Clock clock = clocks.get(world.getName().toLowerCase());
			if(clock != null)
			{
				world.setFullTime(clock.getCurrentTime());
				//Log.i(world.getName() + " - " + world.getTime());
			}
		}
	}
	
	public static void log(Level level, String message)
	{
		message = "[Clocker]" + message;
	}
	

}
