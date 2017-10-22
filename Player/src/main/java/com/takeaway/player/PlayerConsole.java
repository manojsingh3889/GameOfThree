package com.takeaway.player;

import java.io.IOException;
import java.util.Scanner;

import com.takeaway.menu.Menu;
import com.takeaway.menu.command.context.CommandExecutorContext;
import com.takeaway.player.core.Broker;
import com.takeaway.player.core.CommandExecutor;
import com.takeaway.player.core.ListeningServerSocket;

public class PlayerConsole {

	private String serverIP;
	private int serverPort;
	private int listeningPort;
	public static String userName;
	public static String gameType;
	public static Scanner scan = new Scanner(System.in);
	
	public PlayerConsole(String serverIP,int serverPort,int listeningPort){
		this.serverIP = serverIP;
		this.serverPort = serverPort;
		this.listeningPort = listeningPort;
	}
	
	public void init(){
		
		try {
			Broker.init(serverIP, serverPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to establish connection with broker.\nExiting game");
			System.exit(1);
		}
		
		try {
			ListeningServerSocket.init(listeningPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to establish connection with broker.\nExiting game");
			System.exit(1);
		}
		
		System.out.println("************Welcome to GAME_OF_THREE************\n\nCompete to become the Ruler of realm >>THREE<<\n");
		
		System.out.print("Please enter your display name:");
		String uname = scan.nextLine();
		userName = uname+"_"+listeningPort;
		
		System.out.print("Please select game type [(A)uto , (M)anual]:");
		String gtype = scan.nextLine();
		if("M".equalsIgnoreCase(gtype) || "Manual".equalsIgnoreCase(gtype)){
			gameType="MANUAL";
		}else if("A".equalsIgnoreCase(gtype) || "Auto".equalsIgnoreCase(gtype)){
			gameType="AUTO";
		}else{
			System.out.println("Invalid input. Exiting program.");
			System.exit(1);
		}
			
		
		
		while (true) {
			showMenu();
		}
	}
	public void showMenu(){
//		Scanner scan = new Scanner(System.in);
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
//		scan.close();
	}
}