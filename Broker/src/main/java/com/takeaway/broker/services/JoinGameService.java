package com.takeaway.broker.services;

import com.takeaway.broker.core.Inventory;
import com.takeaway.requestbean.JoinGameRequest;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.responsebean.JoinGameResponse;

public class JoinGameService implements Service<JoinGameRequest, JoinGameResponse>{

	@Override
	public JoinGameResponse execute(JoinGameRequest t) {
		NewGameRequest gameDetail = Inventory.remove(t.getGameId());
		if(gameDetail == null){
			return new JoinGameResponse(gameDetail,"FAILED");
		}else{
			return new JoinGameResponse(gameDetail,"SUCCESS");
		}
	}
}
