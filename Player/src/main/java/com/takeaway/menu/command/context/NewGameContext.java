package com.takeaway.menu.command.context;

public class NewGameContext implements CommandContext {
	private String userName;
	
	public NewGameContext(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
