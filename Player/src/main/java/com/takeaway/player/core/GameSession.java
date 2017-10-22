//package com.takeaway.player.core;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class GameSession {
//
//	private Socket s;
//
//	public GameSession(Socket s) {
//		this.s = s;
//	}
//
//	public void begin(boolean owner,String opponent,String you) {
//
//		BufferedReader socketReader = null;
//		PrintWriter socketWriter = null;
//		try{
//			socketWriter = new PrintWriter(s.getOutputStream());
//			socketReader= new BufferedReader(new InputStreamReader(s.getInputStream()));
//			Game game = new Game();
//			
//			if (owner) {
//				//read response from challenger
//				String response = socketReader.readLine();
//				System.out.println(response);
//				//make first move
////				int first = game.firstMove();
//				System.out.println("\n\nYou Started");
//				System.out.println("\tYou:" + first);
//				
//				//-2 to indicate that its a first move
//				socketWriter.write(new StringBuilder(-2).append(":").append(first).toString());
//			}else{
//				//ask to make first move
//				socketWriter.write("Hi "+opponent+".\nI am "+you+".\nPlease start the game...");
//				//read first move from owner
//				System.out.println("\n\nPlayer Started");
//			}
////			while(true){
////				String playerResponse = socketReader.readLine();
////				int playerAdded = Integer.parseInt(playerResponse.split(":")[0]);
////				int result = Integer.parseInt(playerResponse.split(":")[1]);
////				
////				if (playerAdded == -2) {
////					System.out.println("Player: [First move =" + result + "]");
////				}else{
////					System.out.println("Player: [added=" + playerAdded + " , resultant=" + result + "]");
////				}
////				
////				if(result == 1){
////					System.out.println("Player won the game... Better luck next time");
////					break;
////				}
////				
////				int yourResponse = game.nextMove(result);
////				int youAdded = (yourResponse*3)-result;
////				System.out.println("You:"+playerResponse);
////				socketWriter.write(new StringBuilder(youAdded).append(":").append(yourResponse).toString());
////				socketWriter.flush();
////				
////				if(yourResponse == 1){
////					System.out.println("Congratulations!!...You won the game.");
////					break;
////				}
////			}
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("IO Error/ Client "+Thread.currentThread().getName()+" terminated abruptly");
//		}catch(NullPointerException e){
//			e.printStackTrace();
//			System.out.println("Client "+Thread.currentThread().getName()+" Closed");
//		}finally{    
//			try{
//				System.out.println("Connection Closing..");
//				socketReader.close(); socketWriter.close(); s.close();
//			}catch(IOException ie){
//				System.out.println("Socket Close Error");
//			}
//		}
//	}
//	
//	
//}
