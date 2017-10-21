package com.takeaway.requestbean;

public class JoinGameRequest implements ServiceRequest {
	private String gameId;

	
	public JoinGameRequest() {
	}

	public JoinGameRequest(String gameId) {
		super();
		this.gameId = gameId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	
}
