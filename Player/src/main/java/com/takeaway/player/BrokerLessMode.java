package com.takeaway.player;

import java.io.IOException;
import java.net.InetAddress;

import com.takeaway.player.core.ListeningServerSocket;
import com.takeaway.player.core.PlayerGameSocketClient;

public class BrokerLessMode extends PlayerConsole{

	public BrokerLessMode(int listeningPort){
		super(listeningPort);
	}

	public void init(){
		super.init();
		
		System.out.print("Please enter (J)oin or (C)reate game :");
		String step = PlayerConsole.scan.nextLine();
		if("J".equalsIgnoreCase(step) || "Join".equalsIgnoreCase(step)){
			joinGame();
		}else if("C".equalsIgnoreCase(step) || "Create".equalsIgnoreCase(step)){
			startNewGame();
		}else{
			System.out.println("Invalid input. Game Exiting.");
		}
	}

	public void joinGame(){
		System.out.println("Please enter opponent details.");
		System.out.print("Opponent IP:");
		String hostname = PlayerConsole.scan.nextLine();
		System.out.print("Opponent port:");
		int port = PlayerConsole.scan.nextInt();
		System.out.print("Opponent name:");
		String opponentName = PlayerConsole.scan.nextLine();
		System.out.println();
		PlayerGameSocketClient client = new PlayerGameSocketClient(
				hostname, port,opponentName);
		client.play();
	}

	public void startNewGame(){
		try {
			System.out.println("Your game details \n Server IP : "+InetAddress.getLocalHost()+""
					+ "\n Server Port : "+this.listeningPort);
			ListeningServerSocket.startSocket();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}