package com.igate.dam.checksum.controller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import com.igate.dam.checksum.dto.ObjectFactory;
import com.igate.dam.checksum.dto.User;
import com.igate.dam.checksum.dto.UserResponse;
import com.igate.dam.checksum.service.ChecksumService;
import com.igate.dam.checksum.service.ChecksumServiceImp;

public class UserEndpoint extends AbstractMarshallingPayloadEndpoint 
{
	ChecksumServiceImp service;
	public ChecksumServiceImp getService() {
		return service;
	}
	public void setService(ChecksumServiceImp service) {
		this.service = service;
	}
	public Object invokeInternal(Object arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("entered into endpoint");
		ObjectFactory obj = new ObjectFactory();
		System.out.println("Inside Invoke");
		User addReq = (User)arg0;
		 
		System.out.println(addReq.getUserFile());
		System.out.println(addReq.getMd5ValueFile());
		
		String md5valueFile=addReq.getMd5ValueFile();
		
		String newmd5Value=service.GenerateMD5value(addReq.getUserFile());
		String md5fileValue=service.GetMD5ChecksumValue(md5valueFile);
		
		System.out.println("----------newMD5value---------"+newmd5Value);
		System.out.println("----------MD5Filevalue---------"+md5fileValue);
		boolean checkSumResponse = service.ValidateChecksumValues(newmd5Value,md5fileValue);
		System.out.println("----------addResp---------"+checkSumResponse);
		UserResponse respObj = new UserResponse();
		respObj.setChecksumvalueMatch(checkSumResponse);
		System.out.println("----------respObj---------"+respObj.isChecksumvalueMatch());
	
		return respObj; 
	}

}
