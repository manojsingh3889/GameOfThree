package com.takeaway.player;

public class BootStrap {
	public static void main(String[] args) {
		
		if(args.length>2){
			String serverIP = args[0];
			int serverPort = Integer.parseInt(args[1]);
			int listeningPort = Integer.parseInt(args[2]);
			Game game = new Game(serverIP,serverPort,listeningPort);
			game.init();
		}else{
			System.out.println("server address missing");
			System.out.println("usage: java -jar Player.jar <server-ip> <server-port> <listening-port>");
		}
		
		
	}
}
