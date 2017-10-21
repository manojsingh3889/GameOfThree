package com.takeaway.menu.command;

import java.io.IOException;

import com.takeaway.menu.command.context.NewGameContext;
import com.takeaway.player.core.Broker;
import com.takeaway.player.core.ListeningServerSocket;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.responsebean.NewGameResponse;

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
		NewGameRequest gameRequest = new NewGameRequest(userName, ListeningServerSocket.host(), ListeningServerSocket.port());
		NewGameResponse gameResponse = Broker.submitGame(gameRequest);

		if("added".equalsIgnoreCase(gameResponse.getResponse()))
			System.out.println("Game added  game id "+gameResponse.getGameId());
		else
			System.out.println("Duplicate game,  game id "+gameResponse.getGameId());
		
		ListeningServerSocket.startSocket();
	}

}
