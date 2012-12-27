package com.igate.dam.filenamingservice.exception;

public class FileNamingServiceException extends Exception
{

		private static final long serialVersionUID = 1L;
		private String customMessage;
		
		public FileNamingServiceException(String customMessage)
		{
			super(customMessage);
			this.customMessage=customMessage;
		}

		public String getCustomMessage() {
			return customMessage;
		}

		public void setCustomMessage(String customMessage) {
			this.customMessage = customMessage;
		}
}
