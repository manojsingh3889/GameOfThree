package com.takeaway.requestbean;

public class RemoveGameRequest implements ServiceRequest {
	private String gameId;
	
	public RemoveGameRequest() {
	}

	public RemoveGameRequest(String gameId) {
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
