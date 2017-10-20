package com.takeaway.broker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.takeaway.broker.services.ServiceProvider;
import com.takeaway.requestbean.ServiceRequestWrapper;

public class PlayerHandler extends Thread{

	private Socket s;

	public PlayerHandler(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {

		ObjectInputStream reader = null;
		ObjectOutputStream writer = null;
		try{
			writer = new ObjectOutputStream(s.getOutputStream());
			reader= new ObjectInputStream(s.getInputStream());
			
			while(true){
				ServiceRequestWrapper requestWrapper = (ServiceRequestWrapper) reader.readObject();
				writer.reset();
				writer.writeUnshared(ServiceProvider.serve(requestWrapper));
				writer.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO Error/ Client "+this.getName()+" terminated abruptly");
		}catch(NullPointerException e){
			e.printStackTrace();
			System.out.println("Client "+this.getName()+" Closed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Client "+this.getName()+" Closed");
		}finally{    
			try{
				System.out.println("Connection Closing..");
				reader.close(); writer.close(); s.close();
			}catch(IOException ie){
				System.out.println("Socket Close Error");
			}
		}
	}

}
