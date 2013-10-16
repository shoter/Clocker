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

package com.xainer.clocker.commands.arguments;

import com.xainer.clocker.Time;

public class TimeArgument extends BaseArgument
{	
	Time time = new Time(0,0);
	
	@Override
	public Object parse(String arg) {
		String part1 = arg.substring(0 , arg.indexOf(":"));
		String part2 = arg.substring(arg.indexOf(":") + 1, arg.length());
		
		int hour = Integer.valueOf(part1);
		int minute = Integer.valueOf(part2);
		time.setTime(hour, minute);
		return time;
	}

	@Override
	public String format() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isArgGood(String arg) {
		if(arg.matches("[0-9]{1,2}:[0-9]{1,2}"))
			return true;
		return false;
	}

}
