package com.takeaway.menu.command.context;

public class NewGameContext implements CommandContext {
	private String serverIP;
	private String userName;
	private int serverPort;
	
	public NewGameContext(String serverIP,int serverPort,String userName) {
		this.serverIP = serverIP;
		this.userName = userName;
		this.serverPort = serverPort;
	}
	public String getServerIP() {
		return serverIP;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getServerPort() {
		return serverPort;
	}
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}
	
	
}
