package com.igate.dam.checksum.controller;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.igate.dam.checksum.dto.UserResponse;
import com.igate.dam.checksum.service.ChecksumServiceIntf;
import com.igate.dam.checksum.service.Impl.ChecksumServiceImpl;

public class UserEndpoint 
{
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ChecksumServiceIntf checksumServiceIntf = null;
		UserResponse respObj = null;
		boolean checkSumResponse = false;
		String userFile = null;
		String md5valueFile = null;
		String newmd5Value = null;
		String md5fileValue = null;
		Properties prop = null;
		try{
		checksumServiceIntf = new ChecksumServiceImpl();
		prop = new Properties();
		prop.load(new FileInputStream(new File("config\\resources\\checksum.properties")));
		userFile = prop.getProperty("userFile");
		md5valueFile = prop.getProperty("md5valueFile");
		newmd5Value=checksumServiceIntf.GenerateMD5value(userFile);
		md5fileValue=checksumServiceIntf.GetMD5ChecksumValue(md5valueFile);
		checkSumResponse = checksumServiceIntf.ValidateChecksumValues(newmd5Value,md5fileValue);
		respObj = new UserResponse();
		respObj.setChecksumvalueMatch(checkSumResponse);
		System.out.println(checkSumResponse);
		}catch(Exception ex){
			System.out.println("Error in CheckSum API-->"+ ex.getMessage());
			
		}
	}

}
