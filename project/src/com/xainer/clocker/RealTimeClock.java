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

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

import com.xainer.clocker.commands.SetDayStart;

public class RealTimeClock extends BaseClock
{
	public static boolean initialized = false;
	AtomicReference<Long> cur_tick = new AtomicReference<Long>();
	int dayStart = 5*60*60;
	int nightStart = 23*60*60;
	
	public RealTimeClock()
	{
		if(initialized == false)
			initialize();
	}
	
	public static void initialize()
	{
		addCommand(new SetDayStart());
		addCommand(new SetDayStart());
		initialized = true;
	}
	
	
	public static int fullday_length = 24 * 60 * 60; // hrs * mins * secs
	@Override
	public long getCurrentTime() {
		return cur_tick.get();
	}

	@Override
	public void tick() {
		Calendar now = Calendar.getInstance();
		int day = now.get(Calendar.DAY_OF_YEAR);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		
		int time = timeDiffrence(dayStart, hour*60*60 + minute*60 + sec);
		int daytime = timeDiffrence(dayStart,nightStart);
		int nighttime = timeDiffrence(nightStart, dayStart);
		
		int dayTick = 0;
		if(time <= daytime)
		{
			float interp = (float)(time) / (float)daytime;
			if(interp > 1.0f)
				interp = 1.0f;
			else if(interp < 0.f)
				interp = 0.f;
			
			dayTick = (int)(12000 * interp);
		}
		else
		{
			float interp = (float)(time-daytime) / (float)nighttime;
			if(interp > 1.0f)
				interp = 1.0f;
			else if(interp < 0.f)
				interp = 0.f;
			
			dayTick = (int)(12000 * interp) + 12000;
		}
		double partDay = (double)(day*24000 + dayTick);
		cur_tick.set((long)(partDay));
		
	}
	
	public void setDayStart(int hour, int min)
	{
		dayStart = hour*60*60 + min*60;
	}
	public int timeDiffrence(int hour1, int min1, int sec1, int time2)
	{
		return timeDiffrence(hour1*60*60+min1+sec1, time2);
	}
	
	public int timeDiffrence(int time1, int time2)
	{
		if(time1 > time2)
			time2 += fullday_length;
		return time2 - time1;
	}

}
