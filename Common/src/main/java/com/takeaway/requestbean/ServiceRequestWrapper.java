package com.takeaway.requestbean;

import java.io.Serializable;

public class ServiceRequestWrapper implements Serializable{
	public static enum TYPE{NEWGAME,DISPLAY}
	
	private TYPE type;
	private ServiceRequest request;

	public ServiceRequestWrapper(TYPE type, ServiceRequest request) {
		this.type = type;
		this.request = request;
	}
	
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public ServiceRequest getRequest() {
		return request;
	}
	public void setRequest(ServiceRequest request) {
		this.request = request;
	}
	
	
}
