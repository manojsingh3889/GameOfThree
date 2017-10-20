package com.takeaway.responsebean;

public class NewGameResponse implements ServiceResponse {
	private Long gameId;
	private String response;

	public NewGameResponse(Long gameId, String response) {
		this.gameId = gameId;
		this.response = response;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
