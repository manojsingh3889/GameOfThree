package com.takeaway.player.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import com.takeaway.menu.command.Command;
import com.takeaway.menu.command.context.DummyContext;
import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.requestbean.JoinGameRequest;
import com.takeaway.responsebean.DisplayResponse;
import com.takeaway.responsebean.JoinGameResponse;

public class JoinExistingGame implements Command<DummyContext> {

	@Override
	public void execute(DummyContext context) {
		/** Query for existing game **/
		try {
			DisplayResponse displayResponse = Broker.showGames(new DisplayRequest());

			if(displayResponse.getGames().isEmpty()){
				System.out.println("No Games available at the moment."
						+ " Please try after sometime or start new games and wait for opponent");
			}else{
				System.out.printf("%s %s %s %s\n",  StringUtils.center("Game ID", 30),
						StringUtils.center("User Name", 30),
						StringUtils.center("Host Name", 30),
						StringUtils.center("Port", 30));
				for(String gameId : displayResponse.getGames().keySet()){

					System.out.printf("%s %s %s %s\n",StringUtils.center(gameId.toString(), 30),
							StringUtils.center(displayResponse.getGames().get(gameId).getUserName(),30),
							StringUtils.center(displayResponse.getGames().get(gameId).getHost(), 30),
							StringUtils.center(displayResponse.getGames().get(gameId).getPort().toString(), 30));
				}

				//Ask broker to allot game
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter game id to join: ");
				String gameId = reader.readLine();

				JoinGameResponse joinGameResponse = Broker.joinGames(new JoinGameRequest(gameId));

				if("SUCCESS".equalsIgnoreCase(joinGameResponse.getResponse())){
					PlayerGameSocketClient client = new PlayerGameSocketClient(joinGameResponse.getGameDetail().getHost(),
							joinGameResponse.getGameDetail().getPort(),joinGameResponse.getGameDetail().getUserName());
					client.play();
				}else{
					System.out.println("Failed to join. Refresh list and try");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
