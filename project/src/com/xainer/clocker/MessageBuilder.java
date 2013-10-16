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
		replaceTable.put("\\[Y\\]", ""+ ChatColor.YELLOW);
		replaceTable.put("\\[W\\]", ""+ ChatColor.WHITE);
		
		replaceTable.put("\\[/B\\]", ""+ ChatColor.RESET);
		replaceTable.put("\\[/R\\]", ""+ ChatColor.RESET);
		replaceTable.put("\\[/G\\]", ""+ ChatColor.RESET);
		replaceTable.put("\\[/Y\\]", ""+ ChatColor.RESET);
		replaceTable.put("\\[/W\\]", ""+ ChatColor.RESET);
		
		
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
