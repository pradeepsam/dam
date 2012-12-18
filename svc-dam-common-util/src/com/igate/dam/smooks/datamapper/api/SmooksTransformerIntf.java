/**
 * 
 */
package com.igate.dam.smooks.datamapper.api;

import java.io.File;
import org.milyn.payload.JavaResult;
import com.igate.dam.smooks.exception.DamSmooksException;

/**
 * @author 
 *
 */
public interface SmooksTransformerIntf {
	
	/**
	 * @param inputFile
	 * @param configFileName
	 * @return
	 * @throws DamSmooksException
	 */
	public JavaResult xmlToJavaTransformation(File inputFile, String configFileName) throws DamSmooksException;
	
	public void javaToXMLTransformation(Object inputJavaObject,String configFileName, String outputFilePath) throws DamSmooksException;
	
	public JavaResult csvToJavaTransformation(File inputFile, String configFileName) throws DamSmooksException;

}
