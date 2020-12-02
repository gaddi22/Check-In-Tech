import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SocketScan implements Runnable {

public ArrayList<String> bufferedCheckIns;
private boolean stop;
	
	public SocketScan(){
		bufferedCheckIns = new ArrayList<>();
	}
	
	public void stop() {
		/*
		 * signal to stop runnable
		 */
		stop = false;
	}
	
	public String nextCheckIn() {
		/*
		 * reads next String in buffer
		 */
		
		try {
			return bufferedCheckIns.get(0);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public String popCheckIn() {
		/*
		 * pops a check in off the buffered checkins of this Socket Scanner
		 */
		
		if (bufferedCheckIns.isEmpty())
			return null;
		else {
			System.out.println("sent a check in");
			String result = bufferedCheckIns.get(0);
			bufferedCheckIns.remove(0);
			return result;
		}
	}
	
	@Override
	public void run() {
		/*
		 * get socket checkIns until stopped
		 */
		
		//create TCP socket
		try {
			ServerSocket servSoc = new ServerSocket(25463);
			servSoc.setSoTimeout(0);
			
			while(!stop) {
						try {
						//read in client message as byte array then make it a string
						String msg = socketRead(servSoc);
						
						//g == "get event info"
						//c == "check in"
						if(msg.equals("g")) {
							//System.out.println("we got here");
							for(Map.Entry row : DBConnector.findActiveEvents().entrySet()) {
								//System.out.println("we got here");
								String ID = (String)row.getKey() + "";
					            String[] infoArray = (String[])row.getValue();
					            String infoArrayString = Arrays.toString(infoArray);
					            infoArrayString = infoArrayString.replace(",", "~");
					            infoArrayString = infoArrayString.replace("]", "");
					            infoArrayString = infoArrayString.replace("[", "");
					            
					            //send event
					            socketWrite(ID + "~" + infoArrayString,servSoc);
					            
					            //send roster of event
					            for(String[] rosterRow : DBConnector.getEventRoster(ID)) {
									//System.out.println("we got here");
									//String rosterID = (String)rosterRow.getKey() + "";
						            //String[] rosterInfoArray = (String[])rosterRow.getValue();
						            String rosterInfoArrayString = Arrays.toString(rosterRow);
						            rosterInfoArrayString = rosterInfoArrayString.replace(",", "~");
						            rosterInfoArrayString = rosterInfoArrayString.replace("]", "");
						            rosterInfoArrayString = rosterInfoArrayString.replace("[", "");
						            
						            //send roster row
						            socketWrite(rosterInfoArrayString,servSoc);
					            }
					            
							}
							
							socketWrite("END", servSoc);
							
						}
						else if(msg.equals("c")) {
							msg = socketRead(servSoc);
							bufferedCheckIns.add(msg);
							System.out.println("recording in buffer:"+ bufferedCheckIns.get(0));
							socketWrite("END", servSoc);
						}			
						
						}
						catch(SocketTimeoutException soe) {
							System.out.println("new socket attempt");
						}
					} 
		}catch (IOException e) {
			System.out.println("new socket attempt");
		}
		
	}
	private void socketWrite(String message, ServerSocket servSocket) throws SocketTimeoutException{
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
			//io.printStackTrace();
		}
		
	}
	
	private String socketRead(ServerSocket servSocket) throws SocketTimeoutException {
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
			while((input = servIn.readLine()) != null && !stop)message = message + input;
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
