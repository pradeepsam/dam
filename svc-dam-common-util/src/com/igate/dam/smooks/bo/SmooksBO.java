
package com.igate.dam.smooks.bo;

import java.io.File;
import org.milyn.payload.JavaResult;

import com.igate.dam.smooks.Logger.SmooksLoggerUtil;
import com.igate.dam.smooks.datamapper.api.SmooksTransformerImpl;
import com.igate.dam.smooks.datamapper.api.SmooksTransformerIntf;
import com.igate.dam.smooks.exception.DamSmooksException;

public class SmooksBO {
	
	SmooksLoggerUtil smooksloggerutil=new SmooksLoggerUtil();
	
	/**
	 * @param inputFile
	 * @param configFileName
	 * @return
	 * @throws DamSmooksException
	 */
	public JavaResult xmlToJavaTransformation(File inputFile, String configFileName) throws DamSmooksException{
		JavaResult javaResult = null;
		try{
			SmooksTransformerIntf smooksTransformerIntf = new SmooksTransformerImpl();
			javaResult = smooksTransformerIntf.xmlToJavaTransformation(inputFile, configFileName);
			
		}
		catch(DamSmooksException damSmooksException){
			smooksloggerutil.damsmooksexception();
			throw new DamSmooksException("Check the input file");
		}
		return javaResult;
	}

	/**
	 * @param inputJavaObject
	 * @param configFileName
	 * @param outputFilePath
	 * @throws DamSmooksException
	 */
	public void javaToXMLTransformation(Object inputJavaObject,String configFileName, String outputFilePath) throws DamSmooksException{
		 
		try{
			SmooksTransformerIntf smooksTransformerIntf = new SmooksTransformerImpl();
			smooksTransformerIntf.javaToXMLTransformation(inputJavaObject, configFileName, outputFilePath);
		}
		catch(DamSmooksException damSmooksException){
			smooksloggerutil.damsmooksexception();
			throw new DamSmooksException("Unable to find the input File");
		}
		
	}
	
	/**
	 * @param inputFile
	 * @param configFileName
	 * @return
	 * @throws DamSmooksException
	 */
	public JavaResult csvToJavaTransformation(File inputFile, String configFileName) throws DamSmooksException{
		JavaResult javaResult = null;
		try{
			SmooksTransformerIntf smooksTransformerIntf = new SmooksTransformerImpl();
			javaResult = smooksTransformerIntf.csvToJavaTransformation(inputFile, configFileName);
		}
		catch(DamSmooksException damSmooksException){
			smooksloggerutil.damsmooksexception();
			throw new DamSmooksException("Unable to find the input File");
		}
		return javaResult;
	}
}
