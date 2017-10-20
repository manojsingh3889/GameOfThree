package com.takeaway.player;

import java.util.Scanner;

import com.takeaway.menu.Menu;
import com.takeaway.menu.command.CommandExecutor;
import com.takeaway.menu.command.context.CommandExecutorContext;

public class Game {

	private String userName;
	private String serverIP;
	private int port;
	
	public Game(String serverIP,int port){
		this.serverIP = serverIP;
		this.port = port;
	}
	
	public void init(){
		System.out.println("************Welcome to GAME_OF_THREE************\n\nCompete to become the Ruler of realm >>THREE<<\n");
		System.out.println("Please enter your display name");
		Scanner scan = new Scanner(System.in);
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
			commandExecutor.execute(new CommandExecutorContext(option, serverIP, userName, port));
			
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
	public String getServerIP() {
		return serverIP;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}