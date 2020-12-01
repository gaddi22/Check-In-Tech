package com.checknscan.checkntech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class consoleCheckIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//instantiate kb reader
		Scanner kbIn = new Scanner(System.in);
		
		//String for server IP/network name
		System.out.println("Enter server IP or NetworkName (default is 'localhost'):");
		String servIP = kbIn.nextLine();
		
		//default IP if no string given
		if(servIP.isEmpty()) {
			servIP = "localhost";
		}

		//display user menu
		System.out.println("Menu\n"
				+ "g: get events and rosters\n"
				+ "c: check in\n"
				+ "h: enter new host\n"
				+ "e: exit\n");
		
		//initiate keyboard input
		String input = kbIn.nextLine();
		
		//menu loop
		while(!input.equals("e")) {
			switch(input) {
			case "g":
				getEventList(servIP);
				break;
			case "c":
				checkIn(servIP);
				break;
			case "h":
				System.out.println("enter new host network name or IP");
				servIP = kbIn.nextLine();
				break;
			//case "e":
			//	return;
			default:
				System.out.println("unknown command");
				break;
			}
			
			//display user menu
			System.out.println("Menu\n"
					+ "g: get events and rosters\n"
					+ "c: check in\n"
					+ "e: exit\n");
			
			input = kbIn.nextLine();
		}
		
		kbIn.close();

	}
	
	private static void checkIn(String servIP) {
		//keyboard in
		Scanner kbIn = new Scanner(System.in);
		
		//TCP connection
		try {
			
			//create socket, default port is 83456
			Socket clientSocket = new Socket(servIP,25467);
			
			//setup I/O streams
			PrintWriter servOut = new PrintWriter(clientSocket.getOutputStream());
			BufferedReader servIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			//get MAC	        
	        NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
	        byte[] mac = network.getHardwareAddress();
	        
	        StringBuilder strMAC = new StringBuilder();
	        for (int i = 0; i < mac.length; i++) {
	        	strMAC.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "" : ""));		
	        }
	        
			//prompt EventID
			System.out.println("Enter Event ID:");
			String eventID = kbIn.nextLine();
			
			//prompt UID
			System.out.println("Enter User ID:");
			String uid = kbIn.nextLine();
			
			servOut.write(strMAC.toString() +"~"+ eventID +"~"+ uid);
			servOut.close();
			servIn.close();
			clientSocket.close();
		}
		catch(IOException e) {
			System.out.println("No host found");
		}
		
	}

	public static ArrayList<ArrayList> getEventList(String servIP) {
		/*
		 * returns an arraylist who's first element is an arraylist representing event info
		 * and second element is an arraylist of rosters for each event
		 * both rosters and events are represented as array lists
		 */

		System.out.println("we got here");
		//container for events and rosters
		ArrayList<ArrayList> result = new ArrayList<>();		
		
		//TCP connection
		try {
			System.out.println("we got here");
			//create socket, default port is 25467
			Socket clientSocket = new Socket(servIP,25467);
			System.out.println("we got here");
			
			//setup I/O streams
			PrintWriter servOut = new PrintWriter(clientSocket.getOutputStream());
			BufferedReader servIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			//get event list
			servOut.println("g");
			ArrayList<ArrayList<ArrayList<String>>> rosters = new ArrayList<>();
			ArrayList<ArrayList<String>> events = new ArrayList<>();
			
			String next = servIn.readLine();
			while(!next.equals("END")) {
				next = servIn.readLine();
				//row conatiner
				ArrayList<String> row = new ArrayList<>();
				
				//add columns
				while(!next.equals("")) {
					row.add(next.substring(0,next.indexOf("~")));
					next = next.substring(next.indexOf("~")+1);
				}
				System.out.println(row.toString());
				
				//add row to event info
				events.add(row);
				
				//roster container
				ArrayList<ArrayList<String>> roster = new ArrayList<>();
				
				//add attendees to a roster
				while(!next.equals("Begin Event:")) {
					
					//move down one line of input
					next = servIn.readLine();
					
					//clean off brackets
					next = next.substring(0,next.length()-1);
					
					//attendee container
					ArrayList<String> attendee = new ArrayList<>();
					
					//get info of attendee
					//UID, Last, First
					for(int i = 0; i < 3; i++) {
						attendee.add(next.substring(0,next.indexOf("~")));
						next = next.substring(next.indexOf("~")+1);
					}
					
					System.out.println(attendee.toString());
				
					//add attendee to roster
					roster.add(attendee);
					
				}
				
				//add roster to list of rosters
				rosters.add(roster);	
			}
			
			//close socket
			servOut.close();
			servIn.close();
			clientSocket.close();
			
			//build and return result
			result.add(events);
			result.add(rosters);
			return result;
			
		}
		catch(IOException e) {
			System.out.println("No host found");
			return null;
		}
	}

}
