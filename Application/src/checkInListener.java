import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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
			ServerSocket servSoc = new ServerSocket(25463);
			servSoc.setSoTimeout(0);
			
			while(true) {
					
					//read in client message as byte array then make it a string
					String msg = socketRead(servSoc);
					
					//g == "get event info"
					//c == "check in"
					if(msg.equals("g")) {
						System.out.println("we got here");
						for(Map.Entry row : DBConnector.findActiveEvents().entrySet()) {
							
							String ID = (String)row.getKey();
				            String[] infoArray = (String[])row.getValue();
				            String infoArrayString = Arrays.toString(infoArray);
				            infoArrayString = infoArrayString.replace(",", "~");
				            infoArrayString = infoArrayString.replace("[", "");
				            infoArrayString = infoArrayString.replace("]", "");
				            infoArrayString = infoArrayString.replace("\"", "");

				            System.out.println(ID + "~" + Arrays.toString(infoArray));
				            
				            socketWrite(ID + "~" + Arrays.toString(infoArray),servSoc);
							
							
						}
						
					}
					else if(msg.equals("c")) {
						msg = socketRead(servSoc);
						//parse string: MAC~EventID~UserID
						String[] clientInf = new String[3];
						
						int i = 0;
						while(!msg.equals("")) {
							clientInf[i] = msg.substring(0, msg.indexOf("~"));
							msg = msg.substring(msg.indexOf("~")+1);
							i++;
						}
						
						DBConnector.checkIn(clientInf[2],clientInf[1],"mobile",clientInf[0]);
							
					}			
					
					socketWrite("END", servSoc);
				
				
				//check and fulfill any card scanner check ins
				if(cardScannerConnected()) {
					cardListener();
				}
				
			} 
		}catch (IOException e) {
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
	
	public static void socketWrite(String message, ServerSocket servSocket) {
		/*
		 * tries to write a message to a socket
		 */
		System.out.println("writing: " + message);
		try {
			//accept client socket
			Socket client = servSocket.accept();
			PrintWriter servOut = new PrintWriter(client.getOutputStream());
			
			//send message
			servOut.println(message);
			servOut.close();
			client.close();
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
	}
	
	public static String socketRead(ServerSocket servSocket) {
		/*
		 * reads a string and closes the message transfer
		 */
		System.out.print("reading...");
		String message = "";
		try {
			//accept client socket
			Socket client = servSocket.accept();
			BufferedReader servIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String input;
			//read message
			while((input = servIn.readLine()) != null)message = message + input;
			client.close();
			System.out.println(message);
			return message;
		
		}
		catch(IOException io) {
			//io.printStackTrace();
			System.out.println(message);
			return message;
		}
	}
	
}
