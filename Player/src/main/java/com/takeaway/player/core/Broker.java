package com.takeaway.player.core;

import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.requestbean.JoinGameRequest;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.requestbean.RemoveGameRequest;
import com.takeaway.responsebean.DisplayResponse;
import com.takeaway.responsebean.JoinGameResponse;
import com.takeaway.responsebean.NewGameResponse;
import com.takeaway.responsebean.RemoveGameResponse;

public class Broker {
	//	private static SocketClient client = null;
	private static RestClient client;
	public static Object HEALTH_CHECK_LOCK = new Object();
	public static boolean CONTINUE_HEALTH_CHECK = true;
	private static int FAIL_PING_COUNTER=0;
	private Broker(){}

	public static void init(String serverIP, int serverPort) throws UnknownHostException{
		if(client == null){
			client = new RestClient(serverIP, serverPort, "/broker/service");
		}

		//Test run
		if(!brokerCheck()){
			System.out.println("Broker is not alive. Shutting down game...");
			System.exit(1);
		}else{
			Timer timer = new Timer("Broker healt check");
			timer.schedule(new TimerTask() {
				@Override
				public void run() {

					//check if timer need to not to wait
					Broker.continueSig();

					if(Broker.brokerCheck())
						FAIL_PING_COUNTER=0;//reset 
					else
						++FAIL_PING_COUNTER;

					if(FAIL_PING_COUNTER>=5){
						//check if timer need to not to wait
						Broker.continueSig();
						System.out.println("Broker is down for continues 10 seconds.."
								+ "Exiting game");
						System.exit(1);
					}
				}
			},0, 1000);
		}
	}

	private static void continueSig(){
		if(!CONTINUE_HEALTH_CHECK){
			synchronized (HEALTH_CHECK_LOCK) {
				try {
					HEALTH_CHECK_LOCK.wait();
				} catch (Exception e) {}
			}
		}
	}

	public static void suspendHealthTimer(){
		CONTINUE_HEALTH_CHECK = false; // stop health check for moment
	}

	public static void resumeHealthTimer(){
		CONTINUE_HEALTH_CHECK = true; // stop health check for moment
		synchronized (HEALTH_CHECK_LOCK) {
			try {
				HEALTH_CHECK_LOCK.notifyAll();
			} catch (Exception e) {}
		}
	}

	public static boolean brokerCheck(){//Test run
		try {
			client.get("ping",String.class);
			return true;
		} catch (Exception e) {
			return false;
		}
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
	
	public static RemoveGameResponse removeGame(RemoveGameRequest request){
		RemoveGameResponse response = (RemoveGameResponse) client.post(request,"joingame",RemoveGameResponse.class);
		return response;
	}
}
