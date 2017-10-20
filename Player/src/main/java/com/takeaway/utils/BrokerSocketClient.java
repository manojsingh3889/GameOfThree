package com.takeaway.utils;

import java.io.IOException;
import java.net.UnknownHostException;

import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.requestbean.ServiceRequestWrapper;
import com.takeaway.requestbean.ServiceRequestWrapper.TYPE;
import com.takeaway.responsebean.DisplayResponse;
import com.takeaway.responsebean.NewGameResponse;

public class BrokerSocketClient {
	private static SocketClient client = null;
	
	private BrokerSocketClient(){}

	public static void init(String serverIP, int serverPort) throws UnknownHostException, IOException{
		//since Player module is a single threaded so we don't need synchronization here
		if(client == null){
			client = new SocketClient(serverIP, serverPort);
		}
	}
	
	public static void shutdown(){
		client.shutdown();
	}
	
	public static NewGameResponse submitGame(NewGameRequest request) throws ClassNotFoundException, IOException{
		NewGameResponse response = (NewGameResponse) client.send(new ServiceRequestWrapper(TYPE.NEWGAME, request));
		return response;
	}
	
	public static DisplayResponse showGames(DisplayRequest request) throws ClassNotFoundException, IOException{
		DisplayResponse response = (DisplayResponse) client.send(new ServiceRequestWrapper(TYPE.DISPLAY, request));
		return response;
	}
	
	
}
