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
				
				//default IP if no string given
				if(servIP.isEmpty()) {
					servIP = "localhost";
				}

				break;
			case "e":
				return;
			default:
				System.out.println("unknown command");
				break;
			}
			
			//display user menu
			System.out.println("Menu\n"
					+ "g: get events and rosters\n"
					+ "c: check in\n"
					+ "h: enter new host\n"
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
			
			//let server know check in is coming
			socketWrite("c",servIP);
			
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
			
			socketWrite(strMAC.toString() +"~"+ eventID +"~"+ uid, servIP);
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
		
		//container for events and rosters
		ArrayList<ArrayList> result = new ArrayList<>();		
		
		//get event list
		socketWrite("g",servIP);
		
		ArrayList<ArrayList<ArrayList<String>>> rosters = new ArrayList<>();
		ArrayList<ArrayList<String>> events = new ArrayList<>();
		System.out.println("We reached here");
		
		String next = socketRead(servIP);
		try {
			while(!next.equals("END")) {
				next = socketRead(servIP);
				//row conatiner
				ArrayList<String> row = new ArrayList<>();
				
				//add columns
				while(next.contains("~")) {
					row.add(next.substring(0,next.indexOf("~")));
					next = next.substring(next.indexOf("~")+1);
				}
				//add final substring
				row.add(next);
				System.out.println(row.toString());
				
				//add row to event info
				events.add(row);
				
				//roster container
				ArrayList<ArrayList<String>> roster = new ArrayList<>();
				
				//add attendees to a roster
				while(next != "Begin Event:") {
					
					//move down one line of input
					next = socketRead(servIP);
					
					//clean off brackets
					next = next.substring(0,next.length());
					
					//attendee container
					ArrayList<String> attendee = new ArrayList<>();
					
					//get info of attendee
					//UID, Last, First
					for(int i = 0; i < 3; i++) {
						attendee.add(next.substring(0,next.indexOf("~")));
						if(next != null)
							next = next.substring(next.indexOf("~")+1);
					}
					
					System.out.println(attendee.toString());
				
					//add attendee to roster
					roster.add(attendee);
					
				}
				
				//add roster to list of rosters
				rosters.add(roster);	
			}
		}
		catch(NullPointerException npe) {
			System.out.println("Unexpected end of output");
		}
		
		//build and return result
		result.add(events);
		result.add(rosters);
		return result;
	}
	
	public static void socketWrite(String message, String servIP) {
		/*
		 * tries to write a message to a socket
		 */
		
		System.out.println("writing: " + message);
		try {
			//create socket
			Socket clientSocket = new Socket(servIP,25463);
			PrintWriter servOut = new PrintWriter(clientSocket.getOutputStream());
			
			//send message
			servOut.println(message);
			servOut.close();
			clientSocket.close();

		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
	}
	
	public static String socketRead(String servIP) {
		/*
		 * reads a string and closes the message transfer
		 */
		System.out.print("reading...");
		String message = "";
		try {
			//make socket
			Socket clientSocket = new Socket(servIP,25463);
			BufferedReader servIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String input;
			
			//read message
			while((input = servIn.readLine()) != null)message = message + input;
			clientSocket.close();
			System.out.println(message);
			return message;
		}
		catch(IOException io) {
			//io.printStackTrace();
			System.out.print(message);
			return message;
		}
	}

}
