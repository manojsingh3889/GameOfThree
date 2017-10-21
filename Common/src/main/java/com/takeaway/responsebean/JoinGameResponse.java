package com.takeaway.responsebean;

import com.takeaway.requestbean.NewGameRequest;

public class JoinGameResponse implements ServiceResponse {
	private NewGameRequest gameDetail;
	private String response;
	
	public JoinGameResponse() {
		super();
	}
	
	public JoinGameResponse(NewGameRequest gameDetail, String response) {
		super();
		this.gameDetail = gameDetail;
		this.response = response;
	}

	public NewGameRequest getGameDetail() {
		return gameDetail;
	}

	public void setGameDetail(NewGameRequest gameDetail) {
		this.gameDetail = gameDetail;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
