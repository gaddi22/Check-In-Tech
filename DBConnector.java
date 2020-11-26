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

}
