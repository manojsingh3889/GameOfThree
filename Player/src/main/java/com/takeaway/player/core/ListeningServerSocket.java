package com.takeaway.player.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.takeaway.player.PlayerConsole;

public class ListeningServerSocket {
	private static ServerSocket serverSocket;
	private static Socket s;

	private ListeningServerSocket(){}

	public static void init(int listeningPort) throws UnknownHostException, IOException{
		//since Player module is a single threaded so we don't need synchronization here
		if(serverSocket == null){
			serverSocket = new ServerSocket(listeningPort);
		}
	}

	public static int port(){
		return serverSocket.getLocalPort();
	}

	public static String host(){
		return serverSocket.getInetAddress().getHostAddress();
	}

	public static void shutdown(){
		try {
			//close and release
			s.close();
			s=null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void startSocket() throws IOException{
		System.out.println("********************************************************************");
		System.out.println("Waiting for other user");
		Socket s = serverSocket.accept();
		System.out.println("connection Established");
		GameSession session = new GameSession(s);
		session.begin(true,null,PlayerConsole.userName);
		shutdown();
		System.out.println("connection Closed");
		System.out.println("********************************************************************");
	} 
}
