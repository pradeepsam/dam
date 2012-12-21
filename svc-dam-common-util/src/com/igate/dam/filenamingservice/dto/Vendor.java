package com.igate.dam.filenamingservice.dto;

import java.util.ArrayList;
import java.util.List;



public class Vendor 
{
	
	private String vendorName;
	private List<String> fileFormats=new ArrayList<String>();
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public List<String> getFileFormats() {
		return fileFormats;
	}
	public void setFileFormats(List<String> fileFormats) {
		this.fileFormats = fileFormats;
	}

}
