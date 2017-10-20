package com.takeaway.player;

import java.io.IOException;
import java.util.Scanner;

import com.takeaway.menu.Menu;
import com.takeaway.menu.command.CommandExecutor;
import com.takeaway.menu.command.context.CommandExecutorContext;
import com.takeaway.utils.BrokerSocketClient;
import com.takeaway.utils.ListeningSocket;

public class Game {

	private String userName;
	private String serverIP;
	private int serverPort;
	private int listeningPort;
	
	public Game(String serverIP,int serverPort,int listeningPort){
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.listeningPort = listeningPort;
	}
	
	public void init(){
		Scanner scan = new Scanner(System.in);
		
		try {
			BrokerSocketClient.init(serverIP, serverPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to establish connection with broker.\nExiting game");
			System.exit(1);
		}
		
		try {
			ListeningSocket.init(listeningPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to establish connection with broker.\nExiting game");
			System.exit(1);
		}
		
		System.out.println("************Welcome to GAME_OF_THREE************\n\nCompete to become the Ruler of realm >>THREE<<\n");
		
		System.out.println("Please enter your display name");
		String userName = scan.nextLine();
		this.userName = userName;
		
		while (true) {
			showMenu(scan);
		}
	}
	public void showMenu(Scanner scan){

		System.out.println("\n\nHi "+userName+", Please select option from menu");
		for(Menu.OPTIONS option: Menu.OPTIONS.values()){
			System.out.println((option.ordinal()+1)+" : "+option);
		}
		int input = scan.nextInt();
		
		if(input>0 && input < 5){
			Menu.OPTIONS option = Menu.OPTIONS.values()[input-1];
			CommandExecutor commandExecutor = new CommandExecutor();
			commandExecutor.execute(new CommandExecutorContext(option, userName));
			
		}else{
			System.out.println("Invalid option selected");
		}
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}