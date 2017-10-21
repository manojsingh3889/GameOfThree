package com.takeaway.broker;

import java.net.URI;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import nl.amis.rest.RestServer;

public class BootStrap {
	public static void main(String[] args) {
		if(args.length>1){
			String host = args[0];
			int port = Integer.parseInt(args[1]);
			initiateChannel(host,port);
		}else{
			System.out.println("port number missing");
			System.out.println("usage: java -jar broker.jar <hostname> <port-number>");
			System.exit(1);
		}
	}

	public static void initiateChannel(String host,int port){
		 
		URI baseUri = URI.create(new StringBuilder("http://").append(host).append(":")
				.append(port).append("/").toString());
		ResourceConfig config = new ResourceConfig(RestServer.class);
		JdkHttpServerFactory.createHttpServer(baseUri, config);
		
//		try(ServerSocket ss = new ServerSocket(port)) {
//			System.out.println("Server started successfully. Announce ip:port to players.");
//			while (true) {
//				Socket s = ss.accept();
//				System.out.println("connection Established");
//				PlayerHandler playerHandler = new PlayerHandler(s);
//				playerHandler.start();
//			} 
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("Port "+port+" is not available. Please boot with different port.");
//		}
		
//		URI baseUri = UriBuilder.fromUri("http://localhost").port(4444).build();
	}
}
