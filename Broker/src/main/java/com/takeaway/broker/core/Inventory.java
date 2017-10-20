package com.takeaway.broker.core;

import java.util.HashMap;
import java.util.Map;

import com.takeaway.requestbean.NewGameRequest;

public final class Inventory {
	private static Map<Long, NewGameRequest> games = new HashMap<>();
	private Inventory(){}
	
	public static synchronized Map<Long, NewGameRequest> display(){
		return games;
	}
	
	public static synchronized Long add(NewGameRequest newGame){
		Long gameId = System.currentTimeMillis();
		games.put(gameId, newGame);
		return gameId;
	}
	
	public static synchronized void remove(long gameId){
		games.remove(gameId);
	}
	
}
