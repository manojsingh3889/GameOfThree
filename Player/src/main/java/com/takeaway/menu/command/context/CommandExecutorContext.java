package com.takeaway.menu.command.context;

import com.takeaway.menu.Menu;
import com.takeaway.menu.Menu.OPTIONS;

public class CommandExecutorContext implements CommandContext{
	private Menu.OPTIONS option;
	private String serverIP;
	private String userName;
	private int port;
	
	public CommandExecutorContext(OPTIONS option, String serverIP, String userName, int port) {
		this.option = option;
		this.serverIP = serverIP;
		this.userName = userName;
		this.port = port;
	}
	
	public Menu.OPTIONS getOption() {
		return option;
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
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setOption(Menu.OPTIONS option) {
		this.option = option;
	}
}