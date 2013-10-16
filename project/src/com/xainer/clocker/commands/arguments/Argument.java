package com.xainer.clocker.commands.arguments;

public interface Argument
{
	/**
	 * 
	 * @param arg argument that is going to be parsed.
	 * @return null if error otherwise parsed value
	 */
	public Object parseArgument(String arg);
	
	/**
	 * DON'T ADD COLORS!!! Only raw format.
	 * @return format in which argument should be passed
	 */
	public String format();
	
	public boolean isArgGood(String arg);
}
