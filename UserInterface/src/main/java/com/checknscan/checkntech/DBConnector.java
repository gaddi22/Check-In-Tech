package com.checknscan.checkntech;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class DBConnector
{
    //Method to get list of every single attendee
    public static TreeMap<String, String[]> getAllAttendees()
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static TreeMap<String, String[]> getAllEventOwners()
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static TreeMap<String, String[]> getAllEvents()
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
            ArrayList<String[]> IDArray = new ArrayList<>();
            while(queryResult.next())
            {
                IDArray.add(new String[] {queryResult.getString("AttID"),queryResult.getString("HasAttended")});
            }

            //Iterate through IDArray to find names
            ArrayList<String[]> nameArray = new ArrayList<>();
            for (String[] ID : IDArray)
            {
                String[] temp = Arrays.copyOf(findAttendeeECHO(ID[0]),findAttendeeECHO(ID[0]).length+1);
                temp[temp.length-1] = ID[1];
                nameArray.add(temp);
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
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public String findStart(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public String findEnd(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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

    //Method to find end of an event
    public static String findTimeAttended(String targetAttendeeID, String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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

            String sqlSelect = "SELECT  FirstCheck, LastCheck, " +
                    "TIMESTAMPDIFF(YEAR, LastCheck, FirstCheck) AS yearDiff, " +
                    "TIMESTAMPDIFF(MONTH, LastCheck, FirstCheck) AS monthDiff, " +
                    "TIMESTAMPDIFF(DAY, LastCheck, FirstCheck) AS dayDiff, " +
                    "TIMESTAMPDIFF(HOUR, LastCheck, FirstCheck) AS hourDiff, " +
                    "TIMESTAMPDIFF(MINUTE, LastCheck, FirstCheck) AS minDiff, " +
                    "TIMESTAMPDIFF(SECOND, LastCheck, FirstCheck) AS secDiff" +
                    "\nFROM attends" +
                    "\nWHERE AttID='" + targetAttendeeID + "'" +
                    "\nAND EventID='" + targetEventID + "';";
            queryResult = statement.executeQuery(sqlSelect);


            //Store results of query
            String yearDiff = null;
            String monthDiff = null;
            String dayDiff = null;
            String hourDiff = null;
            String minDiff = null;
            String secDiff = null;

            while(queryResult.next())
            {
                yearDiff = queryResult.getString("yearDiff");
                monthDiff = queryResult.getString("monthDiff");
                dayDiff = queryResult.getString("dayDiff");
                hourDiff = queryResult.getString("hourDiff");
                minDiff = queryResult.getString("minDiff");
                secDiff = queryResult.getString("secDiff");
            }

            //Make sure to take absolute value
            yearDiff = yearDiff.replace("-", "");
            monthDiff = monthDiff.replace("-", "");
            dayDiff = dayDiff.replace("-", "");
            hourDiff = hourDiff.replace("-", "");
            minDiff = minDiff.replace("-", "");
            secDiff = secDiff.replace("-", "");


            //Format foundTimeDifference string
            String foundTimeDifference = yearDiff + "-" + monthDiff + "-" + dayDiff + " "  + hourDiff + ":" + minDiff + ":" + secDiff;

            return foundTimeDifference;

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
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static void createAttendee(String first, String last)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static void createEvent(String date, String duration, String name, String end, String ownerID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static void createEventOwner(String first, String last, String password)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static void updateAttendeeInfo(String targetAttendeeID, String newFirst, String newLast)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");


            Statement statement = conHolder.createStatement();
            String sql = "UPDATE attendees\n" +
                    "SET Last='" + newLast + "', First='" + newFirst + "'\n" +
                    "WHERE ID='" + targetAttendeeID + "';";
            statement.executeUpdate(sql);

        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to update an owner's information
    public static void updateEventOwnerInfo(String targetEventOwnerID, String newFirst, String newLast, String newPassword)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Update eventowner record
            Statement statement = conHolder.createStatement();
            String sql = "UPDATE eventowner\n" +
                    "SET First='" + newFirst + "', Last='" + newLast + "', Password='" + newPassword + "'\n" +
                    "WHERE ID='" + targetEventOwnerID + "';";
            statement.executeUpdate(sql);
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to update an event's information
    public static void updateEventInfo(String targetEventID, String newDate, String newDuration, String newName, String newEnd, String newOwnerID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Update event record
            Statement statement = conHolder.createStatement();
            String sql = "UPDATE event\n" +
                    "SET Date='" + newDate +
                    "', Duration='" + newDuration +
                    "', Name='" + newName +
                    "', End='" + newEnd +
                    "', OwnerID='" + newOwnerID +
                    "'\n" +
                    "WHERE ID='" + targetEventID + "';";
            statement.executeUpdate(sql);
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to delete an attendee
    public static void deleteAttendee(String targetAttendeeID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static void deleteEventOwner(String targetEventOwnerID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
    public static void deleteEvent(String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
                    "WHERE CURRENT_TIMESTAMP() >= Date AND  CURRENT_TIMESTAMP() <= End";
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
    public static void addAttendeeToEvent(String targetAttendeeID, String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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

    //Method to remove an attendee from an event
    public static void removeAttendeeFromEvent(String targetAttendeeID, String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            //Delete record from attends
            Statement statement = conHolder.createStatement();
            String sql = "DELETE FROM attends WHERE AttID='" + targetAttendeeID + "' AND EventID='" + targetEventID + "';";
            statement.executeUpdate(sql);

        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to verify login
    public static boolean verifyLogin(String targetOwnerID, String password)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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

    //Method to check out of an event
    public static void checkOut(String targetAttendeeID, String targetEventID)
    {

        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

        try
        {
            //Register driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Attempt to log in
            conHolder = DriverManager.getConnection(conUrl, "Manager", "password");

            Statement statement = conHolder.createStatement();
            String sql="";

            //See if FirstCheck is NOT null, then perform check out
            if(!isFirstCheckNull(targetAttendeeID, targetEventID))
            {
                //Sets LastCheck to current_timestamp
                sql = "UPDATE attends" +
                        "\nSET LastCheck=current_timestamp(), HasAttended=null" +
                        "\nWHERE AttID='" + targetAttendeeID + "'" +
                        "\nAND EventID='" + targetEventID + "';";
                statement.executeUpdate(sql);

                //Find difference in time between LastCheck and First Check in seconds
                String timeAttendedSeconds = findTimeAttended(targetAttendeeID, targetEventID);
                timeAttendedSeconds = timeAttendedSeconds.substring(timeAttendedSeconds.lastIndexOf(":") + 1);
                int timeAttendedSecondsInt = Integer.parseInt(timeAttendedSeconds);

                //Grab duration of the event, split by colon
                String[] eventDurationParts = findDuration(targetEventID).split(":");

                //Grab each part of the duration time
                String eventDurationHourString = eventDurationParts[0];
                String eventDurationMinuteString = eventDurationParts[1];
                String eventDurationSecondString = eventDurationParts[2];

                //Create integer for calculations, convert to seconds
                int eventDurationHourInt = Integer.parseInt(eventDurationHourString);
                eventDurationHourInt *= 3600;
                int eventDurationMinuteInt = Integer.parseInt(eventDurationMinuteString);
                eventDurationMinuteInt *= 60;
                int eventDurationSecondInt = Integer.parseInt(eventDurationSecondString);

                //Add all seconds together
                int eventDurationInSeconds = eventDurationHourInt + eventDurationMinuteInt + eventDurationSecondInt;

                //User attended at least event duration
                if(timeAttendedSecondsInt >= eventDurationInSeconds)
                {
                    sql = "UPDATE attends" +
                            "\nSET HasAttended=1" +
                            "\nWHERE AttID='" + targetAttendeeID + "'" +
                            "\nAND EventID='" + targetEventID + "';";
                }
                //User did NOT attend event long enough
                else
                {
                    sql = "UPDATE attends" +
                            "\nSET HasAttended=0" +
                            "\nWHERE AttID='" + targetAttendeeID + "'" +
                            "\nAND EventID='" + targetEventID + "';";
                }

                statement.executeUpdate(sql);
            }
        }

        catch (SQLException error)
        {
            error.printStackTrace();
        }
    }

    //Method to check if an attendee has checked in or not
    public static boolean isFirstCheckNull(String targetAttendeeID, String targetEventID)
    {
        //Establish connection to database
        Connection conHolder = null;
        String conUrl = "jdbc:mysql://localhost:3306/checkintech?useSSL=false&allowPublicKeyRetrieval=true";

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

}