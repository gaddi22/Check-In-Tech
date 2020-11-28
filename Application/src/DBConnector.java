/*
 * 
 */
import com.mysql.*;
import java.sql.*;
import java.util.Arrays;

public class DBConnector {

	DBConnector(){
		
	}
	
	public static void main(String[] args) {
		try{
			System.out.println(Arrays.deepToString(getEvents()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String[][] getEvents() throws ClassNotFoundException{
		//make connection to database
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = null;
		try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/checkintech", "root", "Docubase20");
            System.out.println("SQL Connection to database established!");
 
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            //return null;
        }
            
		//initialize variables
		Object[][] eventsRaw = null;
		Statement stmnt;
		ResultSet eventResults;
		try{
			stmnt = connection.createStatement();
			eventResults = stmnt.executeQuery("SELECT Name,Date,End FROM event;");
			
			int i = 0;
			while(eventResults.next()) {
				Object[][] temp = {{new Object(),new Object(),new Object(),new Object()}};
				if(eventsRaw != null) {			
					temp = Arrays.copyOf(eventsRaw,eventsRaw.length+1);
					Object[] tempObj = {new Object(),new Object(),new Object(),new Object()};
					temp[temp.length-1] = tempObj;
				}
				
				//System.out.println(Arrays.toString(temp));
				//System.out.println(Arrays.deepToString(eventsRaw));
				
				//fill array with row info
				temp[i][0] = new String(eventResults.getString(1));
				temp[i][1] = eventResults.getDate(2);
				temp[i][2] = eventResults.getTime(2);
				temp[i][3] = eventResults.getTime(3);
				
				eventsRaw = temp;
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//format to string array
		String[][] events = new String[eventsRaw.length][eventsRaw[0].length];
		
		for(int i = 0; i < eventsRaw.length; i++)
			for(int j = 0; j <eventsRaw[i].length;j++) {
				events[i][j] = String.valueOf(eventsRaw[i][j]);
			}
		
		return events;
	}
	
	public static String[][] getEventRoster(String eventID) throws SQLException{
		/*
		 * Will attempt to use event ID to return the roster of students who will be attending targeted event
		 * Its possible targetted event may not exist
		 */
		
		//change to string array of roster info
		return null;
		
	}

	public static boolean verifyLogin(String username, String Password) throws SQLException{
		/*
		 * Will query database to get list of users (eventOwner table) and their passwords
		 * returns true if user is in database, false if they aren't
		 */
		
		//change this to match purpose of method
		return false;
	}
	
	public static void createEvent(String eventName, String eventStartDate, String eventEndDate, String minAttTime) {
		/*
		 * Creates new event using info provided by event creating form
		 * eventID will be created by system based on already created eventIDs
		 * 
		 * Notes:
		 * minAttTime is duration of time a user must have between checkins for event to be counted present
		 * 
		 * JDBC drivers think SQL time and date are seperate, we need to merge them when posting to MySQL
		 * 
		 */
		
		
	}
	
	public static void createAttendee(String first, String last, String eventID) {
		/*
		 * Creates attendee in attendee table and creates relationship to given event.
		 * AttendeeID must be made by system; first available unused ID.
		 * 
		 * Notes:
		 * create the attendee first, then fill in the relationship table with a default info (attended = false,
		 * check-in methods null, etc,)
		 */
	}
	
	
	
}