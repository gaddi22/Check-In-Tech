import java.sql.*;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;

public class Connector
{
    /*public static void main(String[] args) throws SQLException
    {
        Connection con = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false";

        try
        {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(conUrl, "Manager", "password");
            System.out.println("Connected to " + con.getCatalog() + " successfully.");

            ResultSet testResult = null;

            Statement statement = con.createStatement();
            String sqlSelect = "SELECT * FROM blank";
            testResult = statement.executeQuery(sqlSelect);

            while(testResult.next())
            {
                System.out.println(testResult.getString(1));
            }

            System.out.println();

            //System.out.println("List of student IDs:\n" + );
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }*/

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
    public String[] findAttendeeECHO(String targetAttendeeID)
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
    public ArrayList<String[]> getEventRoster(String targetEventID)
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
    public String findDuration(String targetEventID)
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

    //Method to create an attendee
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
    public TreeMap<String, String[]> findActiveEvents()
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
    public void checkIn(String targetAttendeeID, String targetEventID, String signInMethod, String macAddress)
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
                String sql = "DELETE FROM attends WHERE AttID='" + targetAttendeeID + "' AND EventID='" + targetEventID + "';";
                statement.executeUpdate(sql);

                //Check if mac address is null
                if(macAddress != null)
                {
                    //Insert new information
                    sql = "INSERT INTO attends (AttID, EventID, FirstCheck, LastCheck, HasAttended, SignMethod, MAC)\n" +
                            "VALUES ('" + targetAttendeeID + "', '" +
                            targetEventID + "', '"  +
                            new java.sql.Date(Calendar.getInstance().getTimeInMillis()) + "', null, 0, '" +
                            signInMethod + "', '" +
                            macAddress + "');";
                }
                else
                {
                    //Insert new information
                    sql = "INSERT INTO attends (AttID, EventID, FirstCheck, LastCheck, HasAttended, SignMethod, MAC)\n" +
                            "VALUES ('" + targetAttendeeID + "', '" +
                            targetEventID + "', '"  +
                            new java.sql.Date(Calendar.getInstance().getTimeInMillis()) + "', null, 0, '" +
                            signInMethod + "', null);";
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

    //Method to check out of an event
    public void checkOut(String targetAttendeeID, String targetEventID)
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

            //Store timestamp for future comparison
            Date timestamp = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

            //Declare ResultSet
            ResultSet queryResult;

            //Perform SQL query
            Statement statement = conHolder.createStatement();
            String sqlSelect = "SELECT * FROM attends\n" +
                                "WHERE AttID='" + targetAttendeeID +
                                "' AND EventID='" + targetEventID +
                                "' AND CAST (CURRDATE() AS TIME) <= '" + findDuration(targetEventID) + "';";
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
    }

}