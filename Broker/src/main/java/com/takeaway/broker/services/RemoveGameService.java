package com.takeaway.broker.services;

import com.takeaway.broker.core.Inventory;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.requestbean.RemoveGameRequest;
import com.takeaway.responsebean.RemoveGameResponse;

public class RemoveGameService implements Service<RemoveGameRequest, RemoveGameResponse>{

	@Override
	public RemoveGameResponse execute(RemoveGameRequest request) {
		NewGameRequest gameDetail = Inventory.remove(request.getGameId());
		if(gameDetail == null){
			return new RemoveGameResponse(gameDetail,"FAILED");
		}else{
			System.out.println("Game removed [userName="+gameDetail.getUserName()+","
					+ " host="+gameDetail.getHost()+","
							+ " port="+gameDetail.getPort()+"]");
			return new RemoveGameResponse(gameDetail,"SUCCESS");
		}
	}
}
