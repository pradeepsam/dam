/**
 * 
 */
package com.igate.dam.filetransfer.api;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.igate.dam.filetransfer.logger.FileTransferLogger;

/**
 * @author 706440
 *
 */
public class FileTransferMain {
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		FileTransferLogger logger = null;
		FileTransferIntf fileTransferIntf = null;
		Properties prop = null;
		
		try{
			fileTransferIntf = new FileTransferImpl();
			logger = new FileTransferLogger();
			prop = new Properties();
			prop.load(new FileInputStream(new File("config\\resources\\damUtil.properties"))); 
			
			
			/***********To Move File*******************/
			String move1File = prop.getProperty("fileName");
			String sourcePath = prop.getProperty("sourcePath");
			String destinationPath = prop.getProperty("destinationPath");
			boolean success = fileTransferIntf.moveFile(move1File, sourcePath, destinationPath);
			if(success){
				logger.info("Successfully moved");
			}else{
				logger.error("Error in moving file");
			}
			
			
			/***********To Copy File*******************/
			String fileNameCopy = prop.getProperty("fileName");
			String sourcePathCopy = prop.getProperty("sourcePath");
			String destinationPathCopy = prop.getProperty("destinationPath");
			boolean successCopy = fileTransferIntf.copyFile(fileNameCopy, sourcePathCopy, destinationPathCopy);
			if(success){
				logger.info("Successfully Copied");
			}else{
				logger.error("Error in copying file");
			}
			
			
			/***********To Create File*******************/
			String fileNameCreate = prop.getProperty("fileName");
			String destinationPathCreate = prop.getProperty("destinationPath");
			boolean successCreate = fileTransferIntf.createFile(fileNameCreate, destinationPathCreate); 
			if(success){
				logger.info("Successfully created file");
			}else{
				logger.error("Error in creating file");
			}
			
			/***********To Move All Files in a Folder*******************/
			String metadataFilePath = prop.getProperty("metadataFilePath");
			String sourcePathMoveaAll = getSourceFolder(metadataFilePath);
			String destinationPathMoveaAll = prop.getProperty("destinationPath");
			boolean successMoveaAll = fileTransferIntf.moveAllFiles(sourcePathMoveaAll, destinationPathMoveaAll);
			if(success){
				logger.info("Successfully moved all files");
				//call metadata API with metadataFilePath as input
			}else{
				logger.error("Error in moving all files");
			}
		}catch(Exception ex){
			logger.error("Error in file Transferring"+ex.getMessage());
		}
	}
	
	/***********To get Metadata Folder Path*******************/
	/**
	 * @param metadataFilePath
	 * @return
	 */
	private static String getSourceFolder(String metadataFilePath){
		String parent = new File(metadataFilePath).getParent();
		String sourceFolderPath = parent.substring(0,parent.lastIndexOf("\\"));
		System.out.println("sourceFolderPath-->"+sourceFolderPath);
		return sourceFolderPath;
	}

}
