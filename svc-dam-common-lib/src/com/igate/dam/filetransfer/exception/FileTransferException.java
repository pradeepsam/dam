/**
 * 
 */
package com.igate.dam.filetransfer.exception;

/**
 * @author 706440
 *
 */
public class FileTransferException extends Exception{

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param customMessage
	 */
	public FileTransferException(String customMessage)
	{
		super(customMessage);
	}
	/**
	 * @param cause
	 */
	public FileTransferException(Throwable cause)
	{
		super(cause);
	}
	

}
