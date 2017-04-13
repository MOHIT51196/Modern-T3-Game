package org.ttt17.application.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

/*
 * 	Utility class used to write logs in the Log4j log file.
 * 	Static function write takes the Exception and the logger object as arguments .
 * 	Object formation of StackTraceWriter is prohibited.
 * 	Currently in the DEBUG mode.
 */
public class StackTraceWriter {

	private StackTraceWriter(){}
	
	public static void write(Exception exception, Logger logger){
		
		
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			exception.printStackTrace(printWriter);
			
			logger.debug(stringWriter.toString());
		
	}
}
