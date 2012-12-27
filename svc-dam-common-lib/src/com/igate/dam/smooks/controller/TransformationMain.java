package com.igate.dam.smooks.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.milyn.payload.JavaResult;

import com.igate.dam.smooks.Logger.SmooksLoggerUtil;
import com.igate.dam.smooks.bo.SmooksBO;
import com.igate.dam.smooks.dto.Person;
import com.igate.dam.smooks.exception.DamSmooksException;

public class TransformationMain {
	
	SmooksLoggerUtil smooksloggerutil=new SmooksLoggerUtil();
	
	/**
	 * @param inputFileName
	 * @throws DamSmooksException
	 */
	@SuppressWarnings("rawtypes")
	
	public void fileMapperOperationInput(String inputFileName) throws DamSmooksException
	{
		
		String fileName = null;
		int mid = 0;
		String ext = null;
		String configFileName = null;
		JavaResult javaResult = null;
		Person person = new Person();
		String outputFilePath=null;
				
		try
		{
			smooksloggerutil.logFileName(inputFileName);
			mid= inputFileName.lastIndexOf(".");
			ext=inputFileName.substring(mid+1,inputFileName.length());  
					
			SmooksBO smooksBO = new SmooksBO();
			File inputFile=new File(inputFileName);
		    fileName=inputFile.getAbsolutePath();
			
			if(ext.equalsIgnoreCase("xml")){
				configFileName = "smooks-config-XmlToJava.xml";
				javaResult  = smooksBO.xmlToJavaTransformation(fileName, configFileName);
				person = (Person) javaResult.getBean("person");
				smooksloggerutil.display("XML to Java Transformation results in Java bean output --->"+person.getFirstName());
			}
			else if(ext.equalsIgnoreCase("java")){
				configFileName = "smooks-config-JavaToXml.xml";
				Properties properties=new Properties();
				properties.load(new FileInputStream(new File("config\\resources\\FilePaths.properties")));
				outputFilePath =properties.getProperty("outputDirectory");
			    smooksBO.javaToXMLTransformation(person, configFileName,outputFilePath);
				smooksloggerutil.display("output xml is stored in :"+outputFilePath);
			}
			else if(ext.equalsIgnoreCase("csv")){
				configFileName= "smooks-config-CsvToJava.xml";
				javaResult = smooksBO.csvToJavaTransformation(fileName, configFileName);
				Object list=(List)javaResult.getBean("person");
				smooksloggerutil.display("CSV to Java Transformation results in Java bean output --->"+list);
			}
			else{
				smooksloggerutil.display("Invaild input file");
			}
		}

       catch (FileNotFoundException fileNotFoundException) {
    	  	smooksloggerutil.fileNotFound();
			throw new DamSmooksException("unable to find the property file");
		} catch (IOException e) {
			smooksloggerutil.Ioexception();
			throw new DamSmooksException("unable to load the property file");
		}
		catch (DamSmooksException damSmooksException) {
			System.out.println(damSmooksException.getMessage());
			
		}
		
	}

}
