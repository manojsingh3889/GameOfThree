package com.takeaway.menu;

import com.takeaway.menu.command.context.CommandExecutorContext;
import com.takeaway.player.PlayerConsole;
import com.takeaway.player.core.CommandExecutor;
import com.takeaway.player.core.Const;

public class Menu {
	
	public enum OPTIONS {
		START_NEW_GAME(Const.START_NEW_GAME),
		JOIN_EXISTING_GAME(Const.JOIN_EXISTING_GAME),
		RULES(Const.RULES),
		EXIT(Const.EXIT);

		String displayText;
		private OPTIONS(String s) {
			this.displayText=s;
		}
		public String toString(){
			return displayText;
		}
	}

	public void showMenu(String userName){
		for(Menu.OPTIONS option: Menu.OPTIONS.values()){
			System.out.println((option.ordinal()+1)+" : "+option);
		}
		System.out.print("Please select a option number:");
		int input = PlayerConsole.scan.nextInt();

		if(input>0 && input < 5){
			Menu.OPTIONS option = Menu.OPTIONS.values()[input-1];
			CommandExecutor commandExecutor = new CommandExecutor();
			commandExecutor.execute(new CommandExecutorContext(option, userName));

		}else{
			System.out.println("Invalid option selected");
		}
	}
}
