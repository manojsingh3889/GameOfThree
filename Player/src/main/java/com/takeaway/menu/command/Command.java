package com.takeaway.menu.command;

import com.takeaway.menu.command.context.CommandContext;

public interface Command<T extends CommandContext> {
	void execute(T context);
}
