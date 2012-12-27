package com.igate.dam.poller.exception;

public class DamJnotifyException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	private String customMessage;
	
	public DamJnotifyException(String customMessage)
	{
		super(customMessage);
		this.customMessage=customMessage;
	}

	@Override
	public String toString() {
		return "DamSmooksException [customMessage=" + customMessage + "]";
	}
	
	 public String getMessage(String customMessage) {
	        return customMessage;
	    }
	


}
