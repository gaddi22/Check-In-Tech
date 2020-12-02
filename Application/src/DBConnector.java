import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

public class DBConnector
{
    public static void main(String[] args) throws SQLException {
    	//run listener
    	checkInListener listener = new checkInListener();
    	listener.run();
    	
    }

    //Method to get list of every single attendee
    public TreeMap<String, String[]> getAllAttendees()
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT * FROM attendees";
            queryResult = statement.executeQuery(sqlSelect);

            //Declare treemap to hold results of query
            TreeMap<String, String[]> attendeeMap = new TreeMap<String, String[]>();

            //Iterate through results of query
            while(queryResult.next())
            {
                String[] nameArray = {queryResult.getString("First") , queryResult.getString("Last")};
                attendeeMap.put(queryResult.getString("ID"), nameArray);
            }

            return attendeeMap;
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to find full name of attendee if ID is known
    public String[] findAttendee(String targetAttendeeID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT  *\n" +
                                "FROM attendees\n" +
                                "WHERE ID = '" + targetAttendeeID + "' ";
            queryResult = statement.executeQuery(sqlSelect);

            //Store result of query in String array { "First" , "Last" }
            String[] nameArray = {};
            while(queryResult.next())
            {
                nameArray = new String[]{
                        queryResult.getString("First"),
                        queryResult.getString("Last")
                };
            }

            return nameArray;
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to find full name of attendee if ID is known, echos ID back
    public static String[] findAttendeeECHO(String targetAttendeeID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT  *\n" +
                    "FROM attendees\n" +
                    "WHERE ID = '" + targetAttendeeID + "' ";
            queryResult = statement.executeQuery(sqlSelect);

            //Store result of query in String array { "First" , "Last" }
            String[] attendeeArray = {};
            while(queryResult.next())
            {
                attendeeArray = new String[]{
                        queryResult.getString("ID") ,
                        queryResult.getString("First"),
                        queryResult.getString("Last")
                };
            }

            return attendeeArray;
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to get list of every single event owner
    public TreeMap<String, String[]> getAllEventOwners()
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT * FROM eventowner";
            queryResult = statement.executeQuery(sqlSelect);

            //Declare treemap to hold results of query
            TreeMap<String, String[]> ownerMap = new TreeMap<String, String[]>();

            //Iterate through results of query
            while(queryResult.next())
            {
                String[] nameArray = {queryResult.getString("First") , queryResult.getString("Last")};
                ownerMap.put(queryResult.getString("ID"), nameArray);
            }

            return ownerMap;
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to get list of every single event
    public TreeMap<String, String[]> getAllEvents()
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT * FROM event";
            queryResult = statement.executeQuery(sqlSelect);

            //Declare treemap to hold results of query
            TreeMap<String, String[]> eventMap = new TreeMap<String, String[]>();

            //Iterate through results of query
            while(queryResult.next())
            {
                String[] infoArray = {
                                        queryResult.getString("Date") ,
                                        queryResult.getString("Duration") ,
                                        queryResult.getString("Name") ,
                                        queryResult.getString("End") ,
                                        queryResult.getString("OwnerID")
                                    };
                eventMap.put(queryResult.getString("ID"), infoArray);
            }

            return eventMap;
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to get roster of a particular event
    public static ArrayList<String[]> getEventRoster(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            //String sqlSelect = "SELECT * FROM event";
            String sqlSelect = "SELECT  * " +
                                "FROM attends " +
                                "WHERE EventID = '" + targetEventID + "' ";
            queryResult = statement.executeQuery(sqlSelect);


            //Store results of query into IDArray
            ArrayList<String> IDArray = new ArrayList<>();
            while(queryResult.next())
            {
                IDArray.add(queryResult.getString("AttID"));
            }

            //Iterate through IDArray to find names
            ArrayList<String[]> nameArray = new ArrayList<>();
            for (String ID : IDArray)
            {
                nameArray.add(findAttendeeECHO(ID));
            }

            return nameArray;

        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to find duration of an event
    public static String findDuration(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            //String sqlSelect = "SELECT * FROM event";
            String sqlSelect = "SELECT  * " +
                    "FROM event " +
                    "WHERE ID = '" + targetEventID + "' ";
            queryResult = statement.executeQuery(sqlSelect);


            //Store results of query into IDArray
            String foundDuration = null;
            while(queryResult.next())
            {
                foundDuration = queryResult.getString("Duration");
            }

            return foundDuration;

        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to find start of an event
    public static String findStart(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            //String sqlSelect = "SELECT * FROM event";
            String sqlSelect = "SELECT  * " +
                    "FROM event " +
                    "WHERE ID = '" + targetEventID + "' ";
            queryResult = statement.executeQuery(sqlSelect);


            //Store results of query
            String foundStart = null;
            while(queryResult.next())
            {
                foundStart = queryResult.getString("Date");
            }

            return foundStart;

        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to find end of an event
    public static String findEnd(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            //String sqlSelect = "SELECT * FROM event";
            String sqlSelect = "SELECT  * " +
                    "FROM event " +
                    "WHERE ID = '" + targetEventID + "' ";
            queryResult = statement.executeQuery(sqlSelect);


            //Store results of query
            String foundEnd = null;
            while(queryResult.next())
            {
                foundEnd = queryResult.getString("End");
            }

            return foundEnd;

        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }


    //Method to create an attendee, requires event ID
    public void createAttendee(String first, String last, String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Try to perform insert until ID is unique
            int generatedID = 1;
            while (true)
            {
                try
                {
                    Statement statement = conHolder.createStatement();
                    String sql = "INSERT INTO attendees (ID, Last, First)\n" +
                                "VALUES ('" + generatedID + "', '" + last + "', '"  + first + "');";
                    statement.executeUpdate(sql);

                    sql = "INSERT INTO attends (AttID, EventID, FirstCheck, LastCheck, HasAttended, SignMethod, MAC)\n" +
                            "VALUES ('" +
                            generatedID + "', '" +
                            targetEventID +
                            "', null, null, 0, null, null);";
                    statement.executeUpdate(sql);
                    break;
                }
                catch(SQLException error)
                {
                    error.printStackTrace();
                    generatedID++;
                    continue;
                }
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to create an attendee, does NOT require event ID
    public void createAttendee(String first, String last)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Try to perform insert until ID is unique
            int generatedID = 1;
            while (true)
            {
                try
                {
                    Statement statement = conHolder.createStatement();
                    String sql = "INSERT INTO attendees (ID, Last, First)\n" +
                            "VALUES ('" + generatedID + "', '" + last + "', '"  + first + "');";
                    statement.executeUpdate(sql);
                    break;
                }
                catch(SQLException error)
                {
                    error.printStackTrace();
                    generatedID++;
                    continue;
                }
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }


    //Method to create an event
    public void createEvent(String date, String duration, String name, String end, String ownerID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Try to perform insert until ID is unique
            int generatedNum = 1;
            String generatedID = "E" + generatedNum;
            while (true)
            {
                try
                {
                    Statement statement = conHolder.createStatement();
                    String sql = "INSERT INTO event (ID, Date, Duration, Name, End, OwnerID)\n" +
                            "VALUES ('" + generatedID + "', '" +
                            date + "', '"  +
                            duration + "', '"  +
                            name + "', '"  +
                            end + "', '"  +
                            ownerID + "');";
                    statement.executeUpdate(sql);

                    break;
                }
                catch(SQLException error)
                {
                    error.printStackTrace();
                    generatedNum++;
                    generatedID = "E" + generatedNum;
                    continue;
                }
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to create an event owner
    public void createEventOwner(String first, String last, String password)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Try to perform insert until ID is unique
            int generatedID = 1;
            while (true)
            {
                try
                {
                    Statement statement = conHolder.createStatement();
                    String sql = "INSERT INTO eventowner (ID, First, Last, Password)\n" +
                            "VALUES ('" + generatedID + "', '" + first + "', '"  + last + "', '" + password + "');";
                    statement.executeUpdate(sql);
                    break;
                }
                catch(SQLException error)
                {
                    error.printStackTrace();
                    generatedID++;
                    continue;
                }
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to update an attendee's information
    public void updateAttendeeInfo(String targetAttendeeID, String newFirst, String newLast)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            try
            {
                //Delete old information
                Statement statement = conHolder.createStatement();
                String sql = "DELETE FROM attendees WHERE ID='" + targetAttendeeID + "';";
                statement.executeUpdate(sql);

                //Insert new information
                sql = "INSERT INTO attendees (ID, Last, First)\n" +
                        "VALUES ('" + targetAttendeeID + "', '" + newLast + "', '"  + newFirst + "');";
                statement.executeUpdate(sql);

            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to update an owner's information
    public void updateEventOwnerInfo(String targetEventOwnerID, String newFirst, String newLast, String newPassword)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            try
            {
                //Delete old information
                Statement statement = conHolder.createStatement();
                String sql = "DELETE FROM eventowner WHERE ID='" + targetEventOwnerID + "';";
                statement.executeUpdate(sql);

                //Insert new information
                sql = "INSERT INTO eventowner (ID, First, Last, Password)\n" +
                        "VALUES ('" + targetEventOwnerID + "', '" +
                        newFirst + "', '"  +
                        newLast + "', '" +
                        newPassword + "');";
                statement.executeUpdate(sql);

            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to update an event's information
    public void updateEventInfo(String targetEventID, String newDate, String newDuration, String newName, String newEnd, String newOwnerID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            try
            {
                //Delete old information
                Statement statement = conHolder.createStatement();
                String sql = "DELETE FROM event WHERE ID='" + targetEventID + "';";
                statement.executeUpdate(sql);

                //Insert new information
                sql = "INSERT INTO event (ID, Date, Duration, Name, End, OwnerID)\n" +
                        "VALUES ('" + targetEventID + "', '" +
                        newDate + "', '"  +
                        newDuration + "', '" +
                        newName + "', '" +
                        newEnd + "', '" +
                        newOwnerID + "');";
                statement.executeUpdate(sql);

            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to delete an attendee
    public void deleteAttendee(String targetAttendeeID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            try
            {
                //Delete from attendees
                Statement statement = conHolder.createStatement();
                String sql = "DELETE FROM attendees WHERE ID='" + targetAttendeeID + "';";
                statement.executeUpdate(sql);
            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to delete an event owner
    public void deleteEventOwner(String targetEventOwnerID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            try
            {
                //Delete from eventowner
                Statement statement = conHolder.createStatement();
                String sql = "DELETE FROM eventowner WHERE ID='" + targetEventOwnerID + "';";
                statement.executeUpdate(sql);
            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to delete an event
    public void deleteEvent(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            try
            {
                //Delete from event
                Statement statement = conHolder.createStatement();
                String sql = "DELETE FROM event WHERE ID='" + targetEventID + "';";
                statement.executeUpdate(sql);
            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to get list of every event currently considered active
    public static TreeMap<String, String[]> findActiveEvents()
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT * FROM event\n" +
                                "WHERE CURDATE() >= Date AND CURDATE() <= End";
            queryResult = statement.executeQuery(sqlSelect);

            //Declare treemap to hold results of query
            TreeMap<String, String[]> eventMap = new TreeMap<String, String[]>();

            //Iterate through results of query
            while(queryResult.next())
            {
                String[] infoArray = {
                        queryResult.getString("Date") ,
                        queryResult.getString("Duration") ,
                        queryResult.getString("Name") ,
                        queryResult.getString("End") ,
                        queryResult.getString("OwnerID")
                };
                eventMap.put(queryResult.getString("ID"), infoArray);
            }

            return eventMap;
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return null;
    }

    //Method to add an attendee to an event, considered NOT checked in
    public void addAttendeeToEvent(String targetAttendeeID, String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Insert record into attends table
            try
            {
                Statement statement = conHolder.createStatement();
                String sql = "INSERT INTO attends (AttID, EventID, FirstCheck, LastCheck, HasAttended, SignMethod, MAC)\n" +
                        "VALUES ('" +
                        targetAttendeeID + "', '" +
                        targetEventID +
                        "', null, null, 0, null, null);";
                statement.executeUpdate(sql);
            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to verify login
    public boolean verifyLogin(String targetOwnerID, String password)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT  *\n" +
                    "FROM eventowner\n" +
                    "WHERE ID = '" + targetOwnerID + "' ";
            queryResult = statement.executeQuery(sqlSelect);

            //Store result of query in String
            String foundPW = null;
            while(queryResult.next())
            {
                foundPW = queryResult.getString("Password");
            }

            //Compare the found password to the given password
            if(password.equals(foundPW))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
        return false;
    }

    //Method to check into an event
    public static void checkIn(String targetAttendeeID, String targetEventID, String signInMethod, String macAddress)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            try
            {
              
                Statement statement = conHolder.createStatement();
                String sql = null;

                //Check if mac address is null
                if(macAddress != null)
                {
                    //Insert new information
                    sql = "CALL checkInMobile('" + targetAttendeeID + "', '" +targetEventID + "', '" + signInMethod + "', '" + macAddress + "');";
                }
                else
                {
                	//String currTime = (java.time.LocalDate.now() +" " + java.time.LocalTime.now());
                	//currTime = currTime.substring(0,currTime.length()-4);
                	
                	
                	
                    //Insert new information
                	sql = "CALL checkInOther('"+ targetAttendeeID + "', '" +targetEventID + "','" +signInMethod + "');";
                }
                statement.executeUpdate(sql);

            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    /*
    //Method to check out of an event
    public static void checkOut(String targetAttendeeID, String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            Statement statement = conHolder.createStatement();
            String sql = null;

            //Check if mac address is null
           
            //Insert new information
            sql = "CALL checkInMobile('" + targetAttendeeID + "', '" +targetEventID + "', '" + signInMethod + "', '" + macAddress + "');";
            

            	
            	
            	
            //Insert new information
        	sql = "CALL checkInOther('"+ targetAttendeeID + "', '" +targetEventID + "','" +signInMethod + "');";
        
            statement.executeUpdate(sql);
            //Store timestamp for future comparison
            Date timestamp = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT * FROM attends\n" +
                                "WHERE AttID='" + targetAttendeeID +
                                "' AND EventID='" + targetEventID +
                                "' AND CURDATE() >= '" + findStart(targetEventID) +
                                "' AND CURDATE() <= '" + findEnd(targetEventID) +
                                "' AND CAST(CURDATE() AS TIME) <= '" + findDuration(targetEventID) + "';";
            queryResult = statement.executeQuery(sqlSelect);
            
            String attendedString = "0";
            //If there were was a result, then attended must be true b/c conditions were met
            while(queryResult.next())
            {
                attendedString = "1";
            }

            try
            {
                //Update information
                statement = conHolder.createStatement();
                String sql = "UPDATE attends\n" +
                            "SET LastCheck='" + timestamp +
                            "', HasAttended='" + attendedString + "'\n" +
                            "WHERE AttID='" + targetAttendeeID + "' AND EventID='" + targetEventID + "';";
                statement.executeUpdate(sql);

            }
            catch (SQLException error)
            {
                error.printStackTrace();
            }
        }
        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }*/

    //Method to check if an attendee has checked in or not
    public boolean isFirstCheckNull(String targetAttendeeID, String targetEventID)
    {
        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT  *\n" +
                    "FROM attends\n" +
                    "WHERE AttID = '" + targetAttendeeID + "' " +
                    "AND EventID = '" + targetEventID + "';";
            queryResult = statement.executeQuery(sqlSelect);

            //Store result of query in String
            String firstCheck = null;
            while(queryResult.next())
            {
                firstCheck = queryResult.getString("FirstCheck");
            }

            //Check if firstCheck is null
            if(firstCheck == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
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