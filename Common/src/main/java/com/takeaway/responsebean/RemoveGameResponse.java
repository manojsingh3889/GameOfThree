package com.takeaway.responsebean;

import com.takeaway.requestbean.NewGameRequest;

public class RemoveGameResponse implements ServiceResponse {
	private NewGameRequest gameDetail;
	private String response;
	
	public RemoveGameResponse() {
		super();
	}
	
	public RemoveGameResponse(NewGameRequest gameDetail, String response) {
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
