package com.takeaway.player;

import com.takeaway.player.core.PlayerShutDownHook;

public class BootStrap {
	public static void main(String[] args) {
		
		if(args.length>1){
			int listeningPort = Integer.parseInt(args[0]);
			String mode = args[1];
			
			if("broker".equalsIgnoreCase(mode)){
				if(args.length>3){
					String serverIP = args[2];
					int serverPort = Integer.parseInt(args[3]);
					Runtime.getRuntime().addShutdownHook(new PlayerShutDownHook());
					PlayerConsole console = new BrokerMode(serverIP,serverPort,listeningPort);
					console.init();
				}else{
					System.out.println("broker address missing");
					System.out.println("usage: \n\t1. broker mode :java -jar Player.jar <listening-port> broker <broker-ip> <broker-port>"
							+ "\n\t2. broker-less mode :java -jar Player.jar <listening-port> broker-less");
				}
			}else if("broker-less".equalsIgnoreCase(mode)){
				PlayerConsole console = new BrokerLessMode(listeningPort);
				console.init();
			}
		}else{
			System.out.println("Insufficient arguments.");
			System.out.println("usage: \n\t1. broker mode :java -jar Player.jar <listening-port> broker <broker-ip> <broker-port>"
					+ "\n\t2. broker-less mode :java -jar Player.jar <listening-port> broker-less");
		}
		
		
	}
}
