package com.xainer.clocker.commands;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.xainer.clocker.Clock;
import com.xainer.clocker.Clocker;
import com.xainer.clocker.Log;
import com.xainer.clocker.MessageBuilder;
import com.xainer.clocker.RealTimeClock;

public class SetDayStart implements ClockerCommand
{
	public static String helpMsg = "/clocker " + ChatColor.GREEN + "setDayStart" + ChatColor.RESET +
							ChatColor.YELLOW + " [WORLD] " + ChatColor.RESET +
							ChatColor.GREEN + "HH:MM" + ChatColor.RESET;
	public static String severCantWithoutWorld = ChatColor.RED + "Server can't issue that command without givin the world name" + ChatColor.RESET;
	public String noRealTimeClock = ChatColor.YELLOW + "Real time clock is not set on this world.";
	
	@Override
	public boolean run(CommandSender sender, String[] args) {		
		try
		{
			sender.sendMessage(MessageBuilder.build("[B]Niebieski tez[/B] moze byc [R] Fajny :) [/B] [G] Zielony? [/G]"));
			String world;
			String time;
			if(args.length == 3)
			{
				world = args[1];
				time = args[2];
			}
			else if(args.length == 2)
			{
				if(sender instanceof Player)
				{
					world = ((Player) sender).getWorld().getName().toLowerCase();
				}
				else
				{
					Log.i("Bukkit serwers = " + Bukkit.getWorlds().size());
					if(Bukkit.getWorlds().size() == 1)
						world = Bukkit.getWorlds().get(0).getName().toLowerCase();
					else
					{
						sender.sendMessage(severCantWithoutWorld);
						return true;
					}
				}
				time = args[0];
			}
			else
			{
				help(sender);
				return true;
			}
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateFormat.parse(time));
			
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int min = cal.get(Calendar.MINUTE);
			
			Clock clock = Clocker.instance.clocks.get(world);
			if(clock == null)
			{
				clock = new RealTimeClock();
				Clocker.instance.clocks.put(world, clock);
			}
			if(clock instanceof RealTimeClock)
			{
				RealTimeClock rClock = (RealTimeClock) clock;
				rClock.setDayStart(hour, min);
				String timeSet = "Day start set at " + ChatColor.GREEN + hour + ":" + min + ChatColor.RESET +
						         " at " + ChatColor.GREEN + world + ChatColor.RESET + " world";
				sender.sendMessage(timeSet);
				return true;
			}
			else
			{
				sender.sendMessage(noRealTimeClock);
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			help(sender);
			return true;
		}
	}

	@Override
	public void help(CommandSender sender) {
		sender.sendMessage(helpMsg);
	}

	@Override
	public String getPermission() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canPlayerExecute() {
		return true;
	}

	@Override
	public boolean canServerExecute() {
		return true;
	}

	@Override
	public String getCommandName() {
		return "DayStart";
	}

	@Override
	public int getMinArgs() {
		return 2;
	}

	@Override
	public String getName() {
		return "Real time clock";
	}

	@Override
	public void noPermission() {
		// TODO Auto-generated method stub
		
	}
}
