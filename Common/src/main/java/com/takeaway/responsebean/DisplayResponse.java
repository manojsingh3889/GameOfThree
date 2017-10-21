package com.takeaway.responsebean;

import java.util.Map;

import com.takeaway.requestbean.NewGameRequest;

public class DisplayResponse implements ServiceResponse {
	private Map<String, NewGameRequest> games;

	public DisplayResponse() {
		super();
	}

	public DisplayResponse(Map<String, NewGameRequest> games) {
		this.games = games;
	}

	public Map<String, NewGameRequest> getGames() {
		return games;
	}

	public void setGames(Map<String, NewGameRequest> games) {
		this.games = games;
	}
}
