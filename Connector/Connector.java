import java.sql.*;
import java.util.ArrayList;
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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
                            "VALUES (" +
                            generatedID + ", " +
                            targetEventID +
                            ", null, null, 0, null, null);";
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

    //Method to create an attendee
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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
            //System.out.println("Connected to " + conHolder.getCatalog() + " successfully.");

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
}