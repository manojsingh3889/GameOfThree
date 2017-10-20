package com.takeaway.menu.command;

import com.takeaway.menu.command.context.DummyContext;

public class ShowRules implements Command<DummyContext> {

	@Override
	public void execute(DummyContext context) {
		System.out.println("\n\n[GAME RULES]\nWhen a player starts, it incepts a random (whole) number and"
				+ " sends it to the second player as an approach of starting the game.\n"
				+ "The receiving player can now always choose between adding one of {-1,0,1}"
				+ " to get to a number that is divisible by 3.\nDivide it by three. "
				+ "The resulting whole number is then sent back to the original sender.\n"
				+ "The same rules are applied until one player reaches the number 1 (after the division).");
	}

}
