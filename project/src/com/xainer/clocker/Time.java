package com.xainer.clocker;

public class Time
{
	int hour, minute, second;
	
	public Time(int hour, int minute)
	{
		setTime(hour, minute);
	}
	
	public void setTime(int hour, int minute)
	{
		this.hour = hour;
		this.minute = minute;
		second = 0;
	}

}
