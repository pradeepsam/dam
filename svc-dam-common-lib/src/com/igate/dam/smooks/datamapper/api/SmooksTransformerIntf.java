/**
 * 
 */
package com.igate.dam.smooks.datamapper.api;

import org.milyn.payload.JavaResult;
import com.igate.dam.smooks.exception.DamSmooksException;

/**
 * @author 
 *
 */
public interface SmooksTransformerIntf {
	
	/**
	 * @param inputFileName
	 * @param configFileName
	 * @return
	 * @throws DamSmooksException
	 */
	public JavaResult xmlToJavaTransformation(String inputFileName, String configFileName) throws DamSmooksException;
	
	/**
	 * @param inputJavaObject
	 * @param configFileName
	 * @param outputFilePath
	 * @throws DamSmooksException
	 */
	public void javaToXMLTransformation(Object inputJavaObject,String configFileName, String outputFilePath) throws DamSmooksException;
	
	/**
	 * @param inputFileName
	 * @param configFileName
	 * @return
	 * @throws DamSmooksException
	 */
	public JavaResult csvToJavaTransformation(String inputFileName, String configFileName) throws DamSmooksException;

}
