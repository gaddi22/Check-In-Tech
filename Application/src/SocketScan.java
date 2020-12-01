import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SocketScan implements Runnable {

private ArrayList<String> bufferedCheckIns;
private boolean stop;
	
	SocketScan(){
		this.bufferedCheckIns = new ArrayList<>();
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
		 * get socket checkIns until stopped
		 */
		
		//create TCP socket
		try {
			ServerSocket servSoc = new ServerSocket(25463);
			servSoc.setSoTimeout(0);
			
			while(!stop) {
					
					//read in client message as byte array then make it a string
					String msg = socketRead(servSoc);
					
					//g == "get event info"
					//c == "check in"
					if(msg.equals("g")) {
						System.out.println("we got here");
						for(Map.Entry row : DBConnector.findActiveEvents().entrySet()) {
							System.out.println("we got here");
							String ID = (String)row.getKey() + "";
				            String[] infoArray = (String[])row.getValue();
				            String infoArrayString = Arrays.toString(infoArray);
				            infoArrayString = infoArrayString.replace(",", "~");
				            infoArrayString = infoArrayString.replace("]", "");
				            infoArrayString = infoArrayString.replace("[", "");

				            System.out.println(ID + "~" + infoArrayString);
				            
				            socketWrite(ID + "~" + infoArrayString,servSoc);
							
						}
						
					}
					else if(msg.equals("c")) {
						msg = socketRead(servSoc);
						//parse string: MAC~EventID~UserID
						String[] clientInf = new String[3];
						
						clientInf = msg.split("~");
						
						DBConnector.checkIn(clientInf[2],clientInf[1],"mobile",clientInf[0]);
						//DBConnector.checkOut(clientInf[2],clientInf[1]);
							
					}			
					
					socketWrite("END", servSoc);
			} 
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void socketWrite(String message, ServerSocket servSocket) {
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
	
	private String socketRead(ServerSocket servSocket) {
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
