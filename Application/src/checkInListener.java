
public class checkInListener implements Runnable{

	private boolean stop;
	
	@Override
	public void run() {
		//Listener for Card reader and mobile check ins
		CardScan card = new CardScan();
		SocketScan socketScanner = new SocketScan();
		
		socketScanner.run();
		card.run();
		
		while(!stop) {		
			//check and fulfill any card scanner check ins, doing five for each
			for(int i = 0; i<5;i++) {
				
				if(card.popNextID() != null) {
					DBConnector.checkIn(card.popNextID(), card.getDefaultEvent(), "card", null);
				}
			}
		}
		
		card.stop();
		socketScanner.stop();
			
	}

	public void stop() {
		/*
		 * signal to stop runnable
		 */
		stop = false;
	}

	
	
	
	
}
