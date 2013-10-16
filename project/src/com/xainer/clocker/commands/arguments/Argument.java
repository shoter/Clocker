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
