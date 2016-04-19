package org.ff4j.cli;

/*
 * #%L
 * ff4j-cli
 * %%
 * Copyright (C) 2013 - 2016 FF4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class FF4jCliOptions {
	
	/**
	 * Options for command Line. The connect method will select an Environnement.
	 *
	 * @return
	 * 		elements
	 */
    public static Options connectOptions() {
        Options options = new Options();
        
        options.addOption(Option.builder("u").longOpt("user")
                .hasArg().argName("userName")
                .required(false)
                .desc("username to connect to env").build());
        
        options.addOption(Option.builder("p").longOpt("passwd")
                .hasArg().argName("password")
                .required(false)
                .desc("username to connect to env").build());
        
        return options;
    }
    

	
}
