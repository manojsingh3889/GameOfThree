package com.takeaway.player.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

	BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
	
	public Integer firstMove() throws IOException{
		System.out.print("Enter a random number :");
		int input = keyboardReader.read(); 
		return input;
	}

	public Integer nextMove(Integer input){
		int remainder = input % 3;
		if(remainder == 0){
			return input/3;
		}else if(remainder == 1){
			return (input-1)/3;
		}else{
			return (input+1)/3;
		}
	}
}
