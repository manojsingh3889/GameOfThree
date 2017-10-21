package com.takeaway.menu;

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

}
