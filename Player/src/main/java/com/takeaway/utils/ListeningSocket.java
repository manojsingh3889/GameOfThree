package com.takeaway.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class ListeningSocket {
	private static ServerSocket listeningSocket;
	
	private ListeningSocket(){}

	public static void init(int listeningPort) throws UnknownHostException, IOException{
		//since Player module is a single threaded so we don't need synchronization here
		if(listeningSocket == null){
			listeningSocket = new ServerSocket(listeningPort);
		}
	}
	
	public static int port(){
		return listeningSocket.getLocalPort();
	}
	
	public static String host(){
		return listeningSocket.getInetAddress().getHostAddress();
	}
	
	public static void shutdown(){
		try {
			listeningSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
