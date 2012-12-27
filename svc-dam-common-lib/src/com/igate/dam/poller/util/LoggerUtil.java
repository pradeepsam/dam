package com.igate.dam.poller.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;





public class LoggerUtil {


	public static final Logger logger = Logger.getLogger(LoggerUtil.class);
	 
	public LoggerUtil()
	{
		  PropertyConfigurator.configure(".\\config\\resources\\log4j.properties");
	}
	 public void loadDirectoryName(String directoryName)
     {
   	  logger.info("The directory chosen for Monitoring:"+directoryName);
     }
	  public void loadPropertyFile()
      {
	  logger.info("property file loaded");
      }
	    public void renameFileLog( String rootPath, String oldName,
				String newName)
	  {
		  logger.info("renamed " + rootPath + " : " + oldName + " -> " + newName);
	  }
	  
	  public void createFileLog( String rootPath,String name)
	  {
		  logger.info("created " + rootPath + " : " + name);
	  }
	  
	  public void fileModifiedLog(int wd, String rootPath, String name)
	  {
		  logger.info("modified " + rootPath + " : " + name);
			
	  }
      public void fileDeletedLog(int wd, String rootPath, String name)
	   {
		   logger.info("deleted " + rootPath + " : " + name);
	   }
     public void jnotifyexception()
     {
    	 logger.info("Exception occured while Filepolling");
     }
     public void interruptedException()
     {
    	 logger.info("Interruption occured while processing");
     }
     public void display()
     {
    	 logger.info(" jnotify poller started monitoring...");
     }
}
