package com.takeaway.menu.command;

import com.takeaway.menu.command.context.DummyContext;
import com.takeaway.player.core.ListeningServerSocket;

public class LeaveCommand implements Command<DummyContext> {

	@Override
	public void execute(DummyContext context) {
		System.out.println("\n\n Leaving Game");
//		BrokerSocketClient.shutdown();
		ListeningServerSocket.shutdown();
		System.exit(1);
	}
}
