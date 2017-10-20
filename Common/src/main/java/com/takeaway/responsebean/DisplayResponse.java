package com.takeaway.responsebean;

import java.util.Map;

import com.takeaway.requestbean.NewGameRequest;

public class DisplayResponse implements ServiceResponse {
	private Map<Long, NewGameRequest> games;

	public DisplayResponse(Map<Long, NewGameRequest> games) {
		this.games = games;
	}

	public Map<Long, NewGameRequest> getGames() {
		return games;
	}

	public void setGames(Map<Long, NewGameRequest> games) {
		this.games = games;
	}
}
