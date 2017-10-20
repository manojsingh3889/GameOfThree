package com.takeaway.broker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerHandler extends Thread{

	private Socket s;

	public PlayerHandler(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {

		String line=null;
		BufferedReader reader = null;
		BufferedReader writer = null;
		PrintWriter os=null;
		try{
			reader= new BufferedReader(new InputStreamReader(s.getInputStream()));
			writer = new BufferedReader(new InputStreamReader(System.in));
			os=new PrintWriter(s.getOutputStream());

			String response=null;
			
			long gameId= System.currentTimeMillis();
			line="Welcome player.\n"; 
			while(line.compareTo("QUIT")!=0){
				os.println(line);
				os.flush();
				response=reader.readLine();
				System.out.println("Client Response : "+response);
				line=writer.readLine();
			}
			
		} catch (IOException e) {
			line=this.getName(); 
			System.out.println("IO Error/ Client "+line+" terminated abruptly");
		}catch(NullPointerException e){
			line=this.getName();
			System.out.println("Client "+line+" Closed");
		}finally{    
			try{
				System.out.println("Connection Closing..");
				reader.close(); os.close(); s.close();
			}catch(IOException ie){
				System.out.println("Socket Close Error");
			}
		}
	}

}
