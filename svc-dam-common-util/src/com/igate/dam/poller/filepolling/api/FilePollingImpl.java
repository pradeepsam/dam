package com.igate.dam.poller.filepolling.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import net.contentobjects.jnotify.JNotifyListener;

import com.igate.dam.poller.exception.DamJnotifyException;
import com.igate.dam.poller.filepolling.constants.PollingConstants;
import com.igate.dam.poller.util.LoggerUtil;

public class FilePollingImpl implements FilePollingIntf{

	
	LoggerUtil jNotifyLogger=new LoggerUtil();
	
	Map<String,String> map=new HashMap<String,String>();
	
	Set<String> fileNamelist=new HashSet<String>();
	
	/* (non-Javadoc)
	 * @see com.igate.dam.poller.filepolling.api.FilePollingIntf#filePolling(int, java.lang.String)
	 */

	public void filePolling(int time, String path) throws DamJnotifyException {
		// TODO Auto-generated method stub
		jNotifyLogger.display();
	    // watch mask, specify events you care about, or JNotify.FILE_ANY for all events.
	    int mask = JNotify.FILE_CREATED  | 
	               JNotify.FILE_DELETED  | 
	               JNotify.FILE_MODIFIED | 
	               JNotify.FILE_RENAMED;

	    // watch subtree?
	    boolean watchSubtree = true;

	    // add actual watch
	 
	    int watchID;
		try {
			
			watchID = JNotify.addWatch(path,mask, watchSubtree, new Listener());
		   

	    // sleep a little, the application will exit if you
	    // don't (watching is asynchronous), depending on your
	    // application, this may not be required
	    Thread.sleep(1000000);
	    //(in order not to waste processing power by polling the directory)

	    // to remove watch the watch
	      boolean res = JNotify.removeWatch(watchID);
	       if (!res) {
	      // invalid watch ID specified.
	           }
	       }
	   catch (JNotifyException e)
	   {
		jNotifyLogger.jnotifyexception();
		throw new DamJnotifyException("Exception occured while Filepolling");
	   } 
	   catch (InterruptedException e)
	   {
		jNotifyLogger.interruptedException();
		throw new DamJnotifyException("Interruption occured while processing");
		
	    }
	  }
	  class Listener implements JNotifyListener 
	  {
	
	    public void fileRenamed(int wd, String rootPath, String oldName,String newName) 
	    {
	    	jNotifyLogger.renameFileLog(rootPath, oldName, newName);
	    }
	    public void fileModified(int wd, String rootPath, String name) 
	    {
	    	
	    	jNotifyLogger.fileModifiedLog(wd, rootPath, name);
	    }
	    public void fileDeleted(int wd, String rootPath, String name)
	    {
	    	jNotifyLogger.fileDeletedLog(wd, rootPath, name);
	    }
	    public void fileCreated(int wd, String rootPath, String name) 
	    {
	    	addFilename(name);
	    	jNotifyLogger.createFileLog(rootPath, name);
	      
	    }   
	  }
	

	/* (non-Javadoc)
	 * @see com.igate.dam.poller.filepolling.api.FilePollingIntf#loadPropertyFile()
	 */
	
	public int loadPropertyFile() throws DamJnotifyException {
		Properties properties=new Properties();
		try
		{
		properties.load(new FileInputStream(new File("config\\resources\\jnotify.properties")));
		jNotifyLogger.loadPropertyFile();
		String str=properties.getProperty("pollingInterval");
		int time=Integer.parseInt(str);
		return time;
		}
		catch (FileNotFoundException fileNotFoundException) {
			
			throw new DamJnotifyException("unable to find the property file");
		} catch (IOException e) {
			throw new DamJnotifyException("unable to load the property file");
		}
		
		
		 
	 }
	
	/**
	 * @param name
	 */
	public void addFilename(String name)
	{
		if(name.contains("."))
		{
			fileNamelist.add(name);
		}
		@SuppressWarnings("rawtypes")
		Iterator it=fileNamelist.iterator();
		while(it.hasNext())
		{
			String fileNamelist= (String) it.next();
		
			jNotifyLogger.show(fileNamelist);	
			
			if(fileNamelist.contains(PollingConstants.AXN))
			{
			if(fileNamelist.contains(PollingConstants.VIDEO))
			{
				map.put(PollingConstants.AXNVIDEO,fileNamelist);
			}
			else if(fileNamelist.contains(PollingConstants.METADATA))
			{
				map.put(PollingConstants.AXNMETADATA,fileNamelist);
			}
			else if(fileNamelist.contains(PollingConstants.MD5))
			{
				map.put(PollingConstants.AXNMD5,fileNamelist);
			}
			}
			if(fileNamelist.contains(PollingConstants.NDTV))
			{
				if(fileNamelist.contains(PollingConstants.VIDEO))
				{
					map.put(PollingConstants.NDTVVIDEO,fileNamelist);
				}
				else if(fileNamelist.contains(PollingConstants.METADATA))
				{
					map.put(PollingConstants.NDTVMETADATA,fileNamelist);
				}
				else if(fileNamelist.contains(PollingConstants.MD5))
				{
					map.put(PollingConstants.NDTVMD5,fileNamelist);
				}
				}
			if(fileNamelist.contains(PollingConstants.FOX))
			{
				if(fileNamelist.contains(PollingConstants.VIDEO))
				{
					map.put(PollingConstants.FOXVIDEO,fileNamelist);
				}
				else if(fileNamelist.contains(PollingConstants.METADATA))
				{
					map.put(PollingConstants.FOXMETADATA,fileNamelist);
				}
				else if(fileNamelist.contains(PollingConstants.MD5))
				{
					map.put(PollingConstants.FOXMD5,fileNamelist);
				}
				}
		}
		
			for (Map.Entry<String,String> entry : map.entrySet()) {
			    jNotifyLogger.showOutput("Key = " + entry.getKey() + ", Value = " + entry.getValue());

			}

	}
	}

