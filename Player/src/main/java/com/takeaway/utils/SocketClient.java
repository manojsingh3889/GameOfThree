package com.takeaway.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.takeaway.requestbean.ServiceRequestWrapper;
import com.takeaway.responsebean.ServiceResponse;

public class SocketClient {
	private Socket socket;
	private BufferedReader keyBoardReader;
	private ObjectInputStream socketReader;
	private ObjectOutputStream  socketWriter;
	
	public SocketClient(String serverIP,int serverPort) throws UnknownHostException, IOException{
		socket=new Socket(serverIP, serverPort);
		keyBoardReader= new BufferedReader(new InputStreamReader(System.in));
		socketWriter = new ObjectOutputStream(socket.getOutputStream());
		socketReader = new ObjectInputStream(socket.getInputStream());
	}
	
	public ServiceResponse send(ServiceRequestWrapper request) throws IOException, ClassNotFoundException{
				socketWriter.reset();
				socketWriter.writeObject(request);
				socketWriter.flush();
				return (ServiceResponse) socketReader.readObject();
	}
	
	public void shutdown(){
		try {
			socket.close();
			socketWriter.close();
			keyBoardReader.close();
			socketReader.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
