package com.igate.dam.smooks.controller;

import java.io.File;
import java.util.List;
import org.milyn.payload.JavaResult;

import com.igate.dam.smooks.Logger.SmooksLoggerUtil;
import com.igate.dam.smooks.bo.SmooksBO;
import com.igate.dam.smooks.dto.Person;
import com.igate.dam.smooks.exception.DamSmooksException;

public class TransformationMain {
	
	SmooksLoggerUtil smooksloggerutil=new SmooksLoggerUtil();
	/**
	 * @param args
	 * @throws DamSmooksException
	 */
	@SuppressWarnings("rawtypes")
	
	public void fileMapperOperationInput(File inputFile)
	{
		
		String fileName = null;
		int mid = 0;
		String ext = null;
		String configFileName = null;
		JavaResult javaResult = null;
		Person person = new Person();
		String outputFilePath = null;
		
		

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
				//System.out.println("XML to Java Transformation results in Java bean output --->"+person.getFirstName()); 
			}
			else if(ext.equalsIgnoreCase("java")){
				configFileName = "smooks-config-JavaToXml.xml";
				outputFilePath = "D:\\WIP\\destination1.xml";
				smooksBO.javaToXMLTransformation(person, configFileName, outputFilePath);
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

		catch (DamSmooksException damSmooksException) {
			System.out.println(damSmooksException.getMessage());
			
		}
		
	}

}
