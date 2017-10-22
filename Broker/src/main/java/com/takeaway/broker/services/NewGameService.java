package com.takeaway.broker.services;

import com.takeaway.broker.core.Inventory;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.responsebean.NewGameResponse;

public class NewGameService implements Service<NewGameRequest, NewGameResponse> {

	@Override
	public  NewGameResponse execute(NewGameRequest t) {
		System.out.println("Recieved new game request.");
		System.out.println("Game added [userName="+t.getUserName()+","
				+ " host="+t.getHost()+","
						+ " port="+t.getPort()+"]");
		String result = Inventory.add(t);
		return new NewGameResponse(t.getUserName(), result);
	}

}
