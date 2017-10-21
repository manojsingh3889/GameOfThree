package com.takeaway.requestbean;

public class DisplayRequest implements ServiceRequest {
	
	private String userName;
	
	public DisplayRequest() {
		super();
	}
	
	public DisplayRequest(String userName) {
		this.userName = userName;
	}


	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
