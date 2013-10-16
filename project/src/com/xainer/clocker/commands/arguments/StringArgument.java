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
