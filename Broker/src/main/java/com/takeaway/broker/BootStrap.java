package com.takeaway.broker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BootStrap {
	public static void main(String[] args) {
		if(args.length>0){
			int port = Integer.parseInt(args[0]);
			initiateSocket(port);
		}else{
			System.out.println("port number missing");
			System.out.println("usage: java -jar broker.jar <port-number>");
			System.exit(1);
		}
	}

	public static void initiateSocket(int port){
		try(ServerSocket ss = new ServerSocket(port)) {
			System.out.println("Server started successfully. Announce ip:port to players.");
			while (true) {
				Socket s = ss.accept();
				System.out.println("connection Established");
				PlayerHandler playerHandler = new PlayerHandler(s);
				playerHandler.start();
			} 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Port "+port+" is not available. Please boot with different port.");
		}
	}
}
