package com.takeaway.player.core;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.takeaway.requestbean.ServiceRequest;

public class RestClient {

	private ClientConfig clientConfig;
	private Client client;
	private String baseURL;

	public RestClient(String host,int port,String basePath) {
		clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		client = Client.create(clientConfig);
		baseURL = new StringBuilder("http://").append(host).append(":")
				.append(port).append(basePath).toString();
	}

	public <T> T post(ServiceRequest request,String serviceName,Class<T> responseType){
		String postURL = baseURL+"/"+serviceName;
		WebResource webResourcePost = client.resource(postURL);
		return webResourcePost.type(MediaType.APPLICATION_JSON).post(responseType, request);
	}
	
	public <T> T get(String serviceName,Class<T> responseType){
		String getURL = baseURL+"/"+serviceName;
		WebResource webResourcePost = client.resource(getURL);
		return webResourcePost.type(MediaType.APPLICATION_JSON).get(responseType);
	}
}
