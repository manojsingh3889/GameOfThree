package com.takeaway.broker.core;

import java.util.HashMap;
import java.util.Map;

import com.takeaway.requestbean.NewGameRequest;

public final class Inventory {
	private static Map<String, NewGameRequest> games = new HashMap<>();
	private Inventory(){}

	public static synchronized Map<String, NewGameRequest> display(){
		return games;
	}

	public static synchronized String add(NewGameRequest newGame){
		if(games.containsKey(newGame.getUserName()))
			return "duplicate";

		games.put(newGame.getUserName(), newGame);
		return "added";
	}

	public static synchronized NewGameRequest remove(String gameId){
		if(!games.containsKey(gameId))
			return null;
		
		return games.remove(gameId);
	}

}
