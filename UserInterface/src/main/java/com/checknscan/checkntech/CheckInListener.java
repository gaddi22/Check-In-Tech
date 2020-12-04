package com.checknscan.checkntech;


public class CheckInListener implements Runnable{

	private boolean stop;
	
	@Override
	public void run() {
		//Listener for Card reader and mobile check ins
		CardScan card = new CardScan();
		SocketScan socketScanner = new SocketScan();
		Thread socketThread = new Thread(socketScanner);
		Thread cardThread = new Thread(card);
		
		//begin runnables
		socketThread.start();
		cardThread.start();
		
		stop = false;
		
		while(!stop) {
			//check and fulfill any card scanner check ins, doing five before moving to socket
			for(int i = 0; i<5;i++) {
				
				if(card.getNextID() != null) {
					DBConnector.checkIn(card.popNextID(), card.getDefaultEvent(), "card", null);
				}
				//shortcut to end of loop if no more in buffer
				else 
					i=5;
			}
			for(int i = 0; i<5;i++) {
					
				if(socketScanner.nextCheckIn() != null) {
					System.out.println("doing check in");
					String msg = socketScanner.popCheckIn();
					
					//parse string: MAC~EventID~UserID
					String[] clientInf = new String[3];
					
					clientInf = msg.split("~");
					
					
					DBConnector.checkIn(clientInf[2],clientInf[1],"mobile",clientInf[0]);
					//DBConnector.checkOut(clientInf[2],clientInf[1]);;
				}
				//shortcut to end of loop if no more in buffer
				else
					//System.out.println("Socket Buffer Null");
					i = 5;
			}
				
		}
			
		//stop runnables
		card.stop();
		socketScanner.stop();
		
		//interrupt in case stop failed
		cardThread.interrupt();
		socketThread.interrupt();
			
	}

	public void stop() {
		/*
		 * signal to stop runnable
		 */
		stop = true;
	}

	
	
	
	
}
