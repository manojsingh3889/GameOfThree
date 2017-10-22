package com.takeaway.player.core;

import com.takeaway.player.BrokerMode;
import com.takeaway.requestbean.RemoveGameRequest;

public class PlayerShutDownHook extends Thread {
	
	public PlayerShutDownHook() {
		this.setDaemon(true);
	}
	
	@Override
	public void run() {
		System.out.println("Starting "+this.getClass());
		//send game remove signal to broker if exist
		System.out.println("removing any residual started game.");
//		Broker.removeGame(new RemoveGameRequest(BrokerMode.userName));
		System.out.println("Ending "+this.getClass());
	}

}
