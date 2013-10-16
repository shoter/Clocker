package com.xainer.clocker.commands.arguments;

public class StringArgument extends BaseArgument
{
	String format;
	
	public StringArgument( String argumentName )
	{
		this.format = argumentName;
	}
	
	@Override
	public Object parse(String arg) {
		return arg;
	}

	@Override
	public String format() {
		return this.format;
	}

	@Override
	public boolean isArgGood(String arg) {
		return arg != null;
	}


}
