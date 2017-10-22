package com.takeaway.player;

import java.io.IOException;
import java.util.Scanner;

import com.takeaway.menu.Menu;
import com.takeaway.menu.command.context.CommandExecutorContext;
import com.takeaway.player.core.Broker;
import com.takeaway.player.core.CommandExecutor;
import com.takeaway.player.core.ListeningServerSocket;

public class BrokerMode extends PlayerConsole{

	private String serverIP;
	private int serverPort;

	public BrokerMode(String serverIP,int serverPort,int listeningPort){
		super(listeningPort);
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		PlayerConsole.brokerBased = true;
	}

	public void init(){
		
		initBrokerClient();
		super.init();
		Menu menu = new Menu();
		
		while (true) {
			System.out.println("\n\nHi "+userName+", Please select option from menu");
			menu.showMenu(userName);
		}
	}

	public void initBrokerClient(){
		try {
			Broker.init(serverIP, serverPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to establish connection with broker.\nExiting game");
			System.exit(1);
		}
	}
}