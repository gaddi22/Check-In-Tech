package com.checknscan.checkntech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class checkInListener implements Runnable{
	
	public static void cardListener() {
		/*
		 * code relating to the card scanner
		 */
	}

	@Override
	public void run() {
		//Listener for Card reader and mobile check ins

		//create TCP socket
		try {
			ServerSocket servSoc = new ServerSocket(25467);
			servSoc.setSoTimeout(0);

			while(true) {

				//check and fulfill any mobile requests
				try {
					Socket toClient = servSoc.accept();
					while (!toClient.isClosed()) {
						//prep input and output stream
						BufferedReader clientIn = new BufferedReader(new InputStreamReader(toClient.getInputStream()));
						PrintWriter clientOut = new PrintWriter(toClient.getOutputStream());

						//read in client message as byte array then make it a string
						String msg = clientIn.readLine();

						//g == "get event info"
						//c == "check in"
						if (msg.equals("g")) {
							System.out.println(msg);
							//key of currEvents will be the ID of an event
							//Values array: Date, Duration, Name, End, OwnerID
							//TreeMap<String, String[]> currEvents = DBConnector.findActiveEvents();

							/*while (!currEvents.isEmpty()) {

								//send data to client
								//header for event segment: Begin event:
								clientOut.println("Begin event:");

								//format: eventID~Date~...
								clientOut.print(currEvents.lastKey());
								String[] values = (String[]) currEvents.get(currEvents.lastKey());
								for (String value : values) {
									System.out.print("~" + value);
								}
								clientOut.println();

								ArrayList<String[]> roster = DBConnector.getEventRoster((String) currEvents.lastKey());

								//send event roster
								//each user info is one row
								while (!roster.isEmpty()) {
									clientOut.println(Arrays.toString(roster.get(0)));
									roster.remove(0);
								}

								currEvents.remove(currEvents.lastKey());
								//end of current event's segment
							}*/

							for(Map.Entry row : DBConnector.findActiveEvents().entrySet())
							{
								String ID = (String)row.getKey();
								String[] nameArray = (String[])row.getValue();

								System.out.println(ID + "~" + Arrays.toString(nameArray));
								clientOut.println(ID + "~" + Arrays.toString(nameArray));
							}

						} else if (msg.equals("c")) {
							msg = clientIn.readLine();
							System.out.print(msg);
							//parse string: MAC~EventID~UserID
							String[] clientInf = new String[3];

							int i = 0;
							while (!msg.equals("")) {
								clientInf[i] = msg.substring(0, msg.indexOf("~"));
								msg = msg.substring(msg.indexOf("~") + 1);
								i++;
							}

							try {
								DBConnector.checkIn(clientInf[2], clientInf[1], "mobile", clientInf[0]);
							} catch (Exception e) {
								System.err.println("Check in failed");
							}
						}

						clientOut.println("END");

						toClient.close();
					}
				} catch (IOException se) {
					System.out.println("Socket timeout");
				}

				//check and fulfill any card scanner check ins
				if (cardScannerConnected()) {
					cardListener();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}


	private boolean cardScannerConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	public static String[][] treeToArray(TreeMap<String,String[]> tree){
		//instantiate variables
		ArrayList<String[]> table = new ArrayList<String[]>();
		TreeMap currEvents = tree;
		
		
		while(!currEvents .isEmpty()) {
			ArrayList<String> temp = new ArrayList<String>();
			
			//combine key into arrays
			temp.add((String) tree.lastKey());
			for(String column :(String[])tree.get(tree.lastKey())){
				temp.add(column);
			}
			
			//add arrays to table arraylist
			table.add((String[]) temp.toArray(new String[temp.size()]));
			tree.remove(tree.lastKey());
		}
		
		//convert arraylist to array
		String[][] tableArray = (String[][])table.toArray(new String[table.size()][table.get(0).length]);
		
		return tableArray;
	}
	
	
}
