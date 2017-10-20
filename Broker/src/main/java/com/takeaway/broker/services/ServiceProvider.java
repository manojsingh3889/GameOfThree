package com.takeaway.broker.services;

import com.takeaway.requestbean.DisplayRequest;
import com.takeaway.requestbean.NewGameRequest;
import com.takeaway.requestbean.ServiceRequestWrapper;
import com.takeaway.responsebean.ServiceResponse;

public class ServiceProvider {
	public static ServiceResponse serve(ServiceRequestWrapper requestWrapper){
		switch (requestWrapper.getType()) {
		case NEWGAME:
			NewGameService newGameService = new NewGameService();
			NewGameRequest newGameRequest = (NewGameRequest) requestWrapper.getRequest();
			return newGameService.execute(newGameRequest);
		case DISPLAY:
			DisplayGamesService displayGamesService = new DisplayGamesService();
			DisplayRequest displayRequest = (DisplayRequest) requestWrapper.getRequest();
			return displayGamesService.execute(displayRequest);
		default:
			return null;
		}
	}
}
