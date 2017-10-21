package com.takeaway.player.core;

import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;

import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.requestbean.JoinGameRequest;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.responsebean.DisplayResponse;
import com.takeaway.responsebean.JoinGameResponse;
import com.takeaway.responsebean.NewGameResponse;

public class Broker {
//	private static SocketClient client = null;
	private static RestClient client;
	private Broker(){}

	public static void init(String serverIP, int serverPort) throws UnknownHostException{
		if(client == null){
			client = new RestClient(serverIP, serverPort, "/broker/service");
		}
		
		//Test run
		String pingRes = client.get("ping",String.class);
		if(StringUtils.isEmpty(pingRes))
			throw new UnknownHostException("Broker not alive");
		
	}
	public static NewGameResponse submitGame(NewGameRequest request){
		NewGameResponse response = (NewGameResponse) client.post(request,"newgame",NewGameResponse.class);
		return response;
	}
	
	public static DisplayResponse showGames(DisplayRequest request){
		DisplayResponse response = (DisplayResponse) client.post(request,"displaygames",DisplayResponse.class);
		return response;
	}
	
	public static JoinGameResponse joinGames(JoinGameRequest request){
		JoinGameResponse response = (JoinGameResponse) client.post(request,"joingame",JoinGameResponse.class);
		return response;
	}
}
