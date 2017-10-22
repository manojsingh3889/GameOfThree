package com.takeaway.player;

import java.io.IOException;
import java.util.Scanner;

import com.takeaway.menu.Menu;
import com.takeaway.menu.command.context.CommandExecutorContext;
import com.takeaway.player.core.Broker;
import com.takeaway.player.core.CommandExecutor;
import com.takeaway.player.core.ListeningServerSocket;

public class PlayerConsole {

	protected int listeningPort;
	public static String userName;
	public static String gameType;
	public static Boolean brokerBased = true;
	public static Scanner scan = new Scanner(System.in);
	
	public PlayerConsole(int listeningPort){
		this.listeningPort = listeningPort;
	}
	
	public void init(){
		
		try {
			ListeningServerSocket.init(listeningPort);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to establish server socket.\nExiting game");
			System.exit(1);
		}
		
		System.out.println("************Welcome to GAME_OF_THREE************\n\nCompete to become the Ruler of realm >>THREE<<\n");
		
		System.out.print("Please enter your display name:");
		String uname = scan.nextLine();
		userName = uname.trim()+"_"+listeningPort;
		
		System.out.print("Please select game type [(A)uto , (M)anual]:");
		String gtype = scan.nextLine();
		gtype = gtype.trim();
		if("M".equalsIgnoreCase(gtype) || "Manual".equalsIgnoreCase(gtype)){
			gameType="MANUAL";
		}else if("A".equalsIgnoreCase(gtype) || "Auto".equalsIgnoreCase(gtype)){
			gameType="AUTO";
		}else{
			System.out.println("Invalid input. Exiting program.");
			System.exit(1);
		}

	}

}