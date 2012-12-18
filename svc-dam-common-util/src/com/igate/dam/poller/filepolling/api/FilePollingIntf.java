package com.igate.dam.poller.filepolling.api;

import com.igate.dam.poller.exception.DamJnotifyException;

public interface FilePollingIntf {
	
	 /**
	 * @param time
	 * @param path
	 * @throws DamJnotifyException
	 */
	public void filePolling(int time,String path) throws DamJnotifyException ;
	
	 /**
	 * @return
	 * @throws DamJnotifyException
	 */
	public int loadPropertyFile()throws DamJnotifyException;
}
