package com.takeaway.menu.command;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.takeaway.menu.command.context.DummyContext;
import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.responsebean.DisplayResponse;
import com.takeaway.utils.BrokerSocketClient;

public class JoinExistingGame implements Command<DummyContext> {

	@Override
	public void execute(DummyContext context) {
		/** Query for existing game **/
		try {
			DisplayResponse displayResponse = BrokerSocketClient.showGames(new DisplayRequest());
			System.out.printf("%s %s\n",  StringUtils.center("Game ID", 30),StringUtils.center("UserName", 30));
			for(Long gameId : displayResponse.getGames().keySet()){
				
				System.out.printf("%s %s\n",StringUtils.center(gameId.toString(), 30),
						StringUtils.center(displayResponse.getGames().get(gameId).getUserName(), 30));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
