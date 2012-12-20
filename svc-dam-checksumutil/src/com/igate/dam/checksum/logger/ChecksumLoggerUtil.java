package com.igate.dam.checksum.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.igate.dam.checksum.service.ChecksumServiceImp;


public class ChecksumLoggerUtil {
	public static final Logger logger = Logger.getLogger(ChecksumServiceImp.class);
	 
	public ChecksumLoggerUtil()
	{
		PropertyConfigurator.configure("C:\\DAM-Tasks\\svc-dam-checksumutil\\src\\log4j.properties");
		//PropertyConfigurator.configure("..\\..\\config\\resources\\log4j.properties");
		  
	}
	public void display(Object message) 
	{
		logger.info("Message:"+message);
	}
	public void logFileName(String name)
	{
		logger.info("Input File for Transformation:"+name);
	}
	public void fileNotFound()
	{
		logger.info("Unable to find the Input File");
	}
	public void Ioexception()
	{
		logger.info("Unable to find the checksum confiugration File");
    }
	
	public void checksumException()
	{
		logger.info(" Exception occured in checksum while filtering the source");
    }
	public void saxexception()
	{
		logger.info("exception occured while parsing the xml file");
    }
	
	
	public void debug(String message)
	{
		logger.info("message" + message);
	}
	public void info(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
