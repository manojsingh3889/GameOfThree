package com.takeaway.menu.command.context;

import com.takeaway.menu.Menu;
import com.takeaway.menu.Menu.OPTIONS;

public class CommandExecutorContext implements CommandContext{
	private Menu.OPTIONS option;
	private String userName;
	
	public CommandExecutorContext(OPTIONS option,String userName) {
		this.option = option;
		this.userName = userName;
	}
	
	public Menu.OPTIONS getOption() {
		return option;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setOption(Menu.OPTIONS option) {
		this.option = option;
	}
}