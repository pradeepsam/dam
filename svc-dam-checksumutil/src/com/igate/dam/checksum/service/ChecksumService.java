package com.igate.dam.checksum.service;




public interface ChecksumService {

	public String GenerateMD5value(String userFile) throws Exception;

	public boolean ValidateChecksumValues(String newmd5Value, String md5fileValue);
	
	public String GetMD5ChecksumValue(String md5valueFile);
}
