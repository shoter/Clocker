package com.xainer.clocker;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;

public class MessageBuilder
{
	public static boolean initialized = false;
	public static Map<String, String> replaceTable = new HashMap<String, String>();
	
	private static void initialize()
	{
		replaceTable.put("\\[B\\]", ""+ ChatColor.BLUE);
		replaceTable.put("\\[R\\]", ""+ ChatColor.RED);
		replaceTable.put("\\[G\\]", ""+ ChatColor.GREEN);
		
		replaceTable.put("\\[/B\\]", ""+ ChatColor.RESET);
		replaceTable.put("\\[/R\\]", ""+ ChatColor.RESET);
		replaceTable.put("\\[/G\\]", ""+ ChatColor.RESET);
		
		
		initialized = true;
	}
	
	public static String build(String passed)
	{
		if(!initialized)
			initialize();
		for (Map.Entry<String, String> entry : replaceTable.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    
		    passed = passed.replaceAll(key, value);
		}
		
		return passed;
	}	

}
