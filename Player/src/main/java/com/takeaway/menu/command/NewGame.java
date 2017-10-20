package com.takeaway.menu.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.takeaway.menu.command.context.NewGameContext;

public class NewGame implements Command<NewGameContext> {

	@Override
	public void execute(NewGameContext context) {
		//create socket
		//inform server

		Socket s1=null;
		String line=null;
		BufferedReader br=null;
		BufferedReader is=null;
		PrintWriter os=null;

		try {
			s1=new Socket(context.getServerIP(), context.getServerPort()); // You can use static final constant PORT_NUM
			br= new BufferedReader(new InputStreamReader(System.in));
			is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
			os= new PrintWriter(s1.getOutputStream());
		}
		catch (IOException e){
			e.printStackTrace();
			System.err.print("IO Exception");
		}

		System.out.println("Client Address : "+context.getServerIP());
		System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

		String response=null;
		try{
			line="Player "+context.getUserName(); 
			while(line.compareTo("QUIT")!=0){
				os.println(line);
				os.flush();
				response=is.readLine();
				System.out.println("Server Response : "+response);
				line=br.readLine();
			}
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("Socket read Error");
		}
		finally{

			try {
				is.close();
				os.close();
				br.close();
				s1.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			System.out.println("Connection Closed");

		}

	}

}
