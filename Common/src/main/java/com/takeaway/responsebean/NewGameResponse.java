package com.takeaway.responsebean;

public class NewGameResponse implements ServiceResponse {
	private String gameId;
	private String response;

	
	public NewGameResponse() {
	}

	public NewGameResponse(String gameId, String response) {
		this.gameId = gameId;
		this.response = response;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
