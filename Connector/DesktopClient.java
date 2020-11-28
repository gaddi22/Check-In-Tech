import java.util.Arrays;
import java.util.Map;

public class DesktopClient
{
     public static void main(String[] args)
     {
         //Create Connector object
         Connector SQLGrabber = new Connector();

         //Test getAllAttendees method
         System.out.println("Printing all attendees...");
         for (Map.Entry row : SQLGrabber.getAllAttendees().entrySet())
         {
             String ID = (String)row.getKey();
             String[] nameArray = (String[])row.getValue();

             System.out.println(ID + " : " + Arrays.toString(nameArray));
         }

         //Test findAttendee method
         System.out.println("\nFinding attendee with ID of 12333...");
         String[] foundNameArray = SQLGrabber.findAttendee("12333");
         System.out.println(Arrays.toString(foundNameArray));

         //Test getAllEventOwners method
         System.out.println("\nPrinting all event owners...");
         for (Map.Entry row : SQLGrabber.getAllEventOwners().entrySet())
         {
             String ID = (String)row.getKey();
             String[] nameArray = (String[])row.getValue();

             System.out.println(ID + " : " + Arrays.toString(nameArray));
         }

         //Test getAllEvents method
         System.out.println("\nPrinting all events...");
         for (Map.Entry row : SQLGrabber.getAllEvents().entrySet())
         {
             String ID = (String)row.getKey();
             String[] infoArray = (String[])row.getValue();

             System.out.println(ID + " : " + Arrays.toString(infoArray));
         }

         //Test getEventRoster method using ID 2468
         System.out.println("\nPrinting roster with event ID 2468...");
         for (String[] fullName : SQLGrabber.getEventRoster("2468"))
         {
             System.out.println(Arrays.toString(fullName));
         }

         //Test createAttendee method
         System.out.println("\nCreating attendee 'First Name, Last Name' with associated event 2468...");
         SQLGrabber.createAttendee("First Name", "Last Name", "2468");

         //Test createEvent method
         System.out.println("\nCreating event...");
         SQLGrabber.createEvent("2021-12-25 00:00:00", "01:00:00", "Dynamic Event", "2021-12-26 00:00:00", "55555");

         //Test verify login
         System.out.println("\nVerifying 55555 with password 'pw'...");
         System.out.println("w/ correct: " + SQLGrabber.verifyLogin("55555", "pw"));
         System.out.println("w/ wrong: " + SQLGrabber.verifyLogin("55555", "wrongpassword"));

     }
}
