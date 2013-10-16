package com.xainer.clocker.commands.arguments;

public abstract class BaseArgument implements Argument
{
	public String arg;
	public Object parsed;
	
	@Override
	public Object parseArgument(String arg)
	{
		this.arg = arg;
		return parse(arg);
	}
	
	public abstract Object parse(String arg);

	@Override
	public abstract String format();

	@Override
	public abstract boolean isArgGood(String arg);
}
