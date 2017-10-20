package com.takeaway.player;

public class BootStrap {
	public static void main(String[] args) {
		
		if(args.length>1){
			String server = args[0];
			int port = Integer.parseInt(args[1]);
			
			Game game = new Game(server,port);
			game.init();
		}else{
			System.out.println("server address missing");
			System.out.println("usage: java -jar Player.jar <server-ip>:<server-port>");
		}
		
		
	}
}
