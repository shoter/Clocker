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

public abstract class BaseArgument implements Argument
{
	public String arg;
	public Object parsed;
	
	@Override
	public Object parseArgument(String arg)
	{
		this.arg = arg;
		this.parsed = parse(arg);
		return parsed;
	}
	
	public abstract Object parse(String arg);

	@Override
	public abstract String format();

	@Override
	public abstract boolean isArgGood(String arg);
	
	public String getArg() {
		return arg;
	}

	public Object getParsed() {
		return parsed;
	}
	
	
}
