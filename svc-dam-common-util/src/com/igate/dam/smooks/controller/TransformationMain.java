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
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws DamSmooksException
	 */
	@SuppressWarnings("rawtypes")
	
	public void fileMapperOperationInput(File inputFile) throws DamSmooksException
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
		
			fileName=inputFile.getName();
			smooksloggerutil.logFileName(fileName);
			mid= fileName.lastIndexOf(".");
			ext=fileName.substring(mid+1,fileName.length());  
					
			SmooksBO smooksBO = new SmooksBO();
			
			if(ext.equalsIgnoreCase("xml")){
				configFileName = "smooks-config-XmlToJava.xml";
				javaResult  = smooksBO.xmlToJavaTransformation(inputFile, configFileName);
				person = (Person) javaResult.getBean("person");
				smooksloggerutil.display("XML to Java Transformation results in Java bean output --->"+person.getFirstName());
			}
			else if(ext.equalsIgnoreCase("java")){
				configFileName = "smooks-config-JavaToXml.xml";
				Properties properties=new Properties();
				properties.load(new FileInputStream(new File("resources\\FilePaths.properties")));
				outputFilePath =properties.getProperty("outputDirectory");
			    smooksBO.javaToXMLTransformation(person, configFileName,outputFilePath);
				smooksloggerutil.display("output xml is stored in :"+outputFilePath);
			}
			else if(ext.equalsIgnoreCase("csv")){
				configFileName= "smooks-config-CsvToJava.xml";
				javaResult = smooksBO.csvToJavaTransformation(inputFile, configFileName);
				Object list=(List)javaResult.getBean("person");
				smooksloggerutil.display("XML to Java Transformation results in Java bean output --->"+list);
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
