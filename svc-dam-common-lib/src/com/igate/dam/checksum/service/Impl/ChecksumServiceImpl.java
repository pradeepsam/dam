package com.igate.dam.checksum.service.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;
import com.igate.dam.checksum.logger.ChecksumLoggerUtil;
import com.igate.dam.checksum.service.ChecksumServiceIntf;
import com.twmacinta.util.MD5;

public class ChecksumServiceImpl implements ChecksumServiceIntf
{

	public static final Logger logger = Logger.getLogger(ChecksumServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.igate.dam.checksum.service.ChecksumServiceIntf#GenerateMD5value(java.lang.String)
	 */
	@Override
	public String GenerateMD5value(String userFile) throws Exception
	{
		ChecksumLoggerUtil logger = new ChecksumLoggerUtil();
		File file = new File(userFile);
		byte[] fileByteArr = null;
		String md5Value = null;
		try {
			
			if (file != null) 
			{
				fileByteArr = MD5.getHash(file);
				if (fileByteArr != null) {
					md5Value = MD5.asHex(fileByteArr);
				}
				logger.info("MD5 value of file " + file.getName()
						+ " is --- " + md5Value);
			}
			System.out.println("Exiting MD5HashCodeGenerator.getMD5Value");
			logger.info("Exiting MD5HashCodeGenerator.getMD5Value");
			return md5Value;
		} catch (Exception MD5Ex) {
			logger.info(" Exception in MD5HashCodeGenerator.getMD5Value "
					+ MD5Ex);
			//throw new Exception("Failed to Generate MD5 Checksum:", MD5Ex);
		}
		return md5Value;
	}

	/* (non-Javadoc)
	 * @see com.igate.dam.checksum.service.ChecksumServiceIntf#ValidateChecksumValues(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean ValidateChecksumValues(String newmd5value, String md5Filevalue) {
		boolean isValidateChecksum = false;
		
		
		System.out.println("----------System.getProperty(line.separator)---------"+System.getProperty("line.separator"));
		
		md5Filevalue = md5Filevalue.replace("\n", "").replace("\r", "");
		
		if (md5Filevalue != null && !(md5Filevalue.trim()).equalsIgnoreCase(newmd5value.trim())) 
		{
			isValidateChecksum = false;
			logger.info("Validate Checksum is not successfull !!");
			
		} 
		else if (md5Filevalue != null && md5Filevalue.equalsIgnoreCase(newmd5value)) 
		{
			isValidateChecksum = true;
			logger.info("Validate Checksum is successfull !!");
			
		}
		
		return isValidateChecksum;
	}

	/* (non-Javadoc)
	 * @see com.igate.dam.checksum.service.ChecksumServiceIntf#GetMD5ChecksumValue(java.lang.String)
	 */
	@Override
	public String GetMD5ChecksumValue(String md5Value) {
		
		String strValue=null;
		try {
			
			File f = new File(md5Value);
			InputStream is = new FileInputStream(f);
			System.out.println("entered"+is);
			if (is != null) {
				StringBuilder sb = new StringBuilder();
				String line;

				try {
					BufferedReader reader = new BufferedReader (new InputStreamReader(is, "UTF-8"));
					while ((line = reader.readLine()) != null) {
						sb.append(line).append("\n");
					}
				} finally {
					is.close();
				}
				strValue = sb.toString();
				//System.out.println("value...."+strValue);
				/*if (strValue.indexOf("*") > 0) {
					strValue = strValue.substring(0, strValue.indexOf("*"))
					.trim();
					System.out.println("somthing in middle"+strValue);
				} else {
					strValue = "";
				}*/
				return strValue;
				
			} else {
				return "";
			}
			
		}
		
		catch (Exception ex) {
			logger.error(" Exception in getMd5Checksum value " + ex);
		//	throw new Exception("Failed to Generate MD5 Checksum:", ex);
		}
		return strValue;
	}
}
	
	

		
	


