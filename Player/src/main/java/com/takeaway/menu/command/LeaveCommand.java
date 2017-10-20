package com.takeaway.menu.command;

import com.takeaway.menu.command.context.DummyContext;

public class LeaveCommand implements Command<DummyContext> {

	@Override
	public void execute(DummyContext context) {
		System.out.println("\n\n Leaving Game");
		System.exit(1);
	}
}
