package com.takeaway.menu.command;

import com.takeaway.menu.command.context.DummyContext;
import com.takeaway.utils.BrokerSocketClient;
import com.takeaway.utils.ListeningSocket;

public class LeaveCommand implements Command<DummyContext> {

	@Override
	public void execute(DummyContext context) {
		System.out.println("\n\n Leaving Game");
		BrokerSocketClient.shutdown();
		ListeningSocket.shutdown();
		System.exit(1);
	}
}
