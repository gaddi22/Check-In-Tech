package com.checknscan.checkntech;

import java.util.ArrayList;
import java.util.Scanner;

public class CardScan implements Runnable{
	
	private ArrayList<String> bufferedIDs;
	private boolean stop;
	private String defaultEvent;
	
	CardScan(){
		bufferedIDs = new ArrayList<>();
		stop = false;
		defaultEvent = getDefaultEvent();
	}
	
	public String getDefaultEvent() {
		// Default event is first active event
		return DBConnector.findActiveEvents().firstKey();
	}

	public void stop() {
		/*
		 * signal to stop runnable
		 */
		stop = false;
	}
	
	@Override
	public void run() {
		/*
		 * code relating to the card scanner
		 * adds IDs scanned to a buffer over time
		 */
		
		while(!stop) {
			System.out.println("Please Swipe Your Card");
			Scanner scan = new Scanner(System.in);
			String cardID = scan.next();
			cardID = cardID.substring(14, 24);
			System.out.println("Your ID: " + cardID);
			
			//update default event
			defaultEvent = getDefaultEvent();
		
			this.bufferedIDs.add(cardID);
		}
	}
	
	public String popNextID(){
		/*
		 * returns next card id from buffer and removes it from the list
		 */
		
		//null if no more ids
		
		try {
			String msg = bufferedIDs.get(0);
			bufferedIDs.remove(0);
			return msg;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public String getNextID(){
		/*
		 * returns next card id from buffer and removes it from the list
		 */
		
		//null if no more ids
		
		if(this.bufferedIDs.isEmpty())
			return null;
		else {
			return bufferedIDs.get(0);
		}
	}

}
