package com.takeaway.requestbean;

public class NewGameRequest implements ServiceRequest {
	private String userName;
	private String host;
	private Integer port;
	
	
	public NewGameRequest() {
		super();
	}

	public NewGameRequest(String userName, String host, Integer port) {
		this.userName = userName;
		this.host = host;
		this.port = port;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "NewGameRequest [userName=" + userName + ", host=" + host + ", port=" + port + "]";
	}
}
