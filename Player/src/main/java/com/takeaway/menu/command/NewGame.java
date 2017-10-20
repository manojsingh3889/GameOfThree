package com.takeaway.menu.command;

import java.io.IOException;

import com.takeaway.menu.command.context.NewGameContext;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.responsebean.NewGameResponse;
import com.takeaway.utils.BrokerSocketClient;
import com.takeaway.utils.ListeningSocket;

public class NewGame implements Command<NewGameContext> {

	@Override
	public void execute(NewGameContext context) {
		try {
			informBroker(context.getUserName());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void informBroker(String userName) throws ClassNotFoundException, IOException{
		NewGameRequest gameRequest = new NewGameRequest(userName, ListeningSocket.host(), ListeningSocket.port());
		NewGameResponse gameResponse = BrokerSocketClient.submitGame(gameRequest);
		System.out.println("Game added with game id "+gameResponse.getGameId());
	}

}
