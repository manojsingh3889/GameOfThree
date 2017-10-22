package com.takeaway.menu.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import com.takeaway.menu.command.context.DummyContext;
import com.takeaway.player.BrokerMode;
import com.takeaway.player.core.Broker;
import com.takeaway.player.core.PlayerGameSocketClient;
import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.requestbean.JoinGameRequest;
import com.takeaway.responsebean.DisplayResponse;
import com.takeaway.responsebean.JoinGameResponse;

public class JoinExistingGame implements Command<DummyContext> {

	@Override
	public void execute(DummyContext context) {
		/** Query for existing game **/
		int padding = 15;
		try {
			DisplayResponse displayResponse = Broker.showGames(new DisplayRequest());

			if(displayResponse.getGames().isEmpty() || 
					(displayResponse.getGames().size()==1 && displayResponse.getGames().containsKey(BrokerMode.userName))){
				System.out.println("No Games available at the moment."
						+ " Please try after sometime or start new games and wait for opponent");
			}else{
				System.out.printf("%s %s %s %s\n",  StringUtils.center("Game ID", padding),
						StringUtils.center("User Name", padding),
						StringUtils.center("Host Name", padding),
						StringUtils.center("Port", padding));
				for(String gameId : displayResponse.getGames().keySet()){

					if (!gameId.equals(BrokerMode.userName)) {
						System.out.printf("%s %s %s %s\n", StringUtils.center(gameId.toString(), padding),
								StringUtils.center(displayResponse.getGames().get(gameId).getUserName(), padding),
								StringUtils.center(displayResponse.getGames().get(gameId).getHost(), padding),
								StringUtils.center(displayResponse.getGames().get(gameId).getPort().toString(),
										padding));
					}
				}

				//Ask broker to allot game
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter game id to join (To skip type skip): ");
				String gameId = reader.readLine();
				
				if (!"skip".equals(gameId) || displayResponse.getGames().containsKey(gameId)) {
					Broker.suspendHealthTimer();
					JoinGameResponse joinGameResponse = Broker.joinGames(new JoinGameRequest(gameId));
					if ("SUCCESS".equalsIgnoreCase(joinGameResponse.getResponse())) {
						PlayerGameSocketClient client = new PlayerGameSocketClient(
								joinGameResponse.getGameDetail().getHost(), joinGameResponse.getGameDetail().getPort(),
								joinGameResponse.getGameDetail().getUserName());
						client.play();
					} else {
						System.out.println("Failed to join. Refresh list and try");
					}
					Broker.resumeHealthTimer();
				}else if(!displayResponse.getGames().containsKey(gameId)){
					System.out.println("Invalid game id.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
