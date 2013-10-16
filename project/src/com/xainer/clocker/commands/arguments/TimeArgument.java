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
