/**
 * 
 */
package com.igate.dam.filenamingservice.service;

import com.igate.dam.filenamingservice.exception.FileNamingServiceException;

/**
 * @author pp802965
 *
 */
public interface FileNamingServiceIntf {
	
	/**
	 * @param vendorName
	 * @param fileName
	 * @return
	 * @throws FileNamingServiceException
	 */
	public boolean validateFileFormat(String vendorName,String fileName) throws FileNamingServiceException;

}
