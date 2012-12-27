package com.igate.dam.filenamingservice.service.impl;


import java.io.File;
import java.util.Iterator;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;

import com.igate.dam.filenamingservice.constants.FileNamingServiceConstants;
import com.igate.dam.filenamingservice.exception.FileNamingServiceException;
import com.igate.dam.filenamingservice.logger.FileNamingServiceLogger;
import com.igate.dam.filenamingservice.service.FileNamingServiceIntf;

public class VendorMain {

	
	
	 
	public static void main(String[] args){
		boolean result=false; 
		Iterator iterator=null;
		FileNamingServiceLogger fileNamingServiceLogger=new FileNamingServiceLogger();
		
		try{
			
			FileNamingServiceIntf fileNamingServiceIntf = new FileNamingServiceImpl();
			ResourceBundle resourceBundle=ResourceBundle.getBundle(FileNamingServiceConstants.VENDOR_PROPERTY_FILE_NAME);//Name of the prop file
			String vendors=resourceBundle.getString(FileNamingServiceConstants.VENDOR_NAMES);
			String baseFolder=resourceBundle.getString(FileNamingServiceConstants.BASE_FOLDER_LOCATION);
			String[] vendorNames=vendors.split(",");
			for(int count=0;count<vendorNames.length;count++){
				
				iterator = FileUtils.iterateFiles(new File(baseFolder+"/"+vendorNames[count]), null,false);
	            while(iterator.hasNext()){
	            	
	        	   String fileName=((File) iterator.next()).getName();
	        	   result=fileNamingServiceIntf.validateFileFormat(vendorNames[count], fileName);
	            }
			}
			
					
          }
		
          catch (FileNamingServiceException exception) {
        	  fileNamingServiceLogger.logFileNamingServiceException(exception.getMessage());
        	
        	 
		  }

	
	}
	
	
}
