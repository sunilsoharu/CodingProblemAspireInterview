package com.aspireapp.SystemUtilities;

import org.apache.log4j.Logger;



public class LogsUtil {
	
	private static Logger Log = Logger.getLogger(LogsUtil.class.getName());//


public static Logger getLogger(Class clas) {
		
		if(Log != null)
			return Logger.getLogger(clas);
		
		Log = Logger.getRootLogger();
		
		return Logger.getLogger(clas);
	} 
	
	public static void thisIsStartOfTC(String varTestCaseName){
		 System.out.println("Test case start is happening");
		Log.info("____________________________________________________________________________________________________________");

		Log.info("____________________________________________________________________________________________________________");

		Log.info("************                 "+varTestCaseName+ "       ************ ");

		Log.info("____________________________________________________________________________________________________________");

		Log.info("____________________________________________________________________________________________________________");

		}

		//This is to print log for the ending of the test case

	 public static void thisIsEndOfTC(String varTestCaseName){

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("############################################################################################################");

		Log.info("############################################################################################################");

		Log.info("************                 "+varTestCaseName+ "       ************ ");

		Log.info("############################################################################################################");

		Log.info("############################################################################################################");

		}

		// Need to create these methods, so that they can be called  

	 public static void info(String message) {

		 Log.info(message);
		 System.out.println("message logged is "+message);
	 }

	 public static void warn(String message) {
		 Log.warn(message);
		 System.out.println("message logged is "+message);


	 }

	 public static void error(String message) {


		 Log.error(message);
		 System.out.println("message logged is "+message);
	 }

	 public static void fatal(String message) {
		 Log.fatal(message);
		 System.out.println("message logged is "+message);


	 }

	 public static void debug(String message) {

	    Log.debug(message);
	    System.out.println("message logged is "+message);
		}


}
