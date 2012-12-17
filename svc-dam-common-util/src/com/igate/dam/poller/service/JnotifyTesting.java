package com.igate.dam.poller.service;

import java.util.Scanner;

import com.igate.dam.poller.exception.DamJnotifyException;
import com.igate.dam.poller.util.LoggerUtil;

public class JnotifyTesting {
	 public static void main(String[] args) {
		 
		LoggerUtil jNotifyLogger=new LoggerUtil();
		
		 JNotifyFilePoller jNotifyFilePoller=new JNotifyFilePoller();
		 try
		 {
		 int timeInterval=jNotifyFilePoller.loadPropertyFile();
		 Scanner scanner =new Scanner(System.in);
		 System.out.println("Enter the directory to be Monitored:");
		 String watchPath=scanner.next();
		 jNotifyLogger.loadDirectoryName(watchPath);
		 jNotifyFilePoller.filePolling(timeInterval,watchPath );
		 }
		 catch(DamJnotifyException damJnotifyException)
		 {
			System.out.println(damJnotifyException.getMessage());
		 }
		 
}

}
