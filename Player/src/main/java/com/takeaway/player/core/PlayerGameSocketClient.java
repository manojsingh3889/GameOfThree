package com.takeaway.player.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.takeaway.player.PlayerConsole;
import com.takeaway.requestbean.ServiceRequestWrapper;
import com.takeaway.responsebean.ServiceResponse;

public class PlayerGameSocketClient {
	private Socket socket;
	private BufferedReader keyBoardReader;
	private BufferedReader socketReader;
	private PrintStream  socketWriter;
	private String playerName;

	public PlayerGameSocketClient(String serverIP,int serverPort,String playerName) throws UnknownHostException, IOException{
		socket=new Socket(serverIP, serverPort);
		keyBoardReader= new BufferedReader(new InputStreamReader(System.in));
		socketWriter = new PrintStream(socket.getOutputStream());
		socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.playerName = playerName;
	}

	public void play(){
		start();
		shutdown();
	}
	
	public void start(){
		System.out.println("********************************************************************");
		GameSession session = new GameSession(socket);
		session.begin(false,this.playerName,PlayerConsole.userName);
		System.out.println("********************************************************************");
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
