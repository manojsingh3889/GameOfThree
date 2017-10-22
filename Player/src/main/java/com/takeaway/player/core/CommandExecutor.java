package com.takeaway.player.core;

import com.takeaway.menu.command.Command;
import com.takeaway.menu.command.JoinExistingGame;
import com.takeaway.menu.command.LeaveCommand;
import com.takeaway.menu.command.NewGame;
import com.takeaway.menu.command.ShowRules;
import com.takeaway.menu.command.context.CommandExecutorContext;
import com.takeaway.menu.command.context.DummyContext;
import com.takeaway.menu.command.context.NewGameContext;

public class CommandExecutor implements Command<CommandExecutorContext>{

	@Override
	public void execute(CommandExecutorContext context) {
		switch(context.getOption()){
		case START_NEW_GAME: new NewGame().execute(new NewGameContext(context.getUserName()));break;
		case JOIN_EXISTING_GAME:new JoinExistingGame().execute(new DummyContext());break;
		case RULES: new ShowRules().execute(new DummyContext()); break;
		case EXIT: new LeaveCommand().execute(new DummyContext()); break;
		default: System.out.println("Invalid command");
		}
	}
}
