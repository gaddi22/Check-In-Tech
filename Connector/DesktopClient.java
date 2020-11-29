import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DesktopClient
{
     public static void main(String[] args)
     {
         //Create Connector object
         Connector SQLGrabber = new Connector();

         //Test getAllEventOwners method
         /*
         System.out.println("\nPrinting all event owners...");
         for (Map.Entry row : SQLGrabber.getAllEventOwners().entrySet())
         {
             String ID = (String)row.getKey();
             String[] nameArray = (String[])row.getValue();

             System.out.println(ID + " : " + Arrays.toString(nameArray));
         }*/

         //Test verify login
         /*
         System.out.println("\nVerifying 54321 with password 'pw'...");
         System.out.println("w/ correct: " + SQLGrabber.verifyLogin("54321", "pw"));
         System.out.println("w/ wrong: " + SQLGrabber.verifyLogin("54321", "wrongpassword"));
         */

         //Test createEvent method
         /*
         System.out.println("\nCreating event...");
         SQLGrabber.createEvent("2021-12-25 05:00:00", "01:00:00", "Dynamic Event", "2021-12-26 08:00:00", "54321");
         */

         //Test getAllEvents method
         /*
         System.out.println("\nPrinting all events...");
         for (Map.Entry row : SQLGrabber.getAllEvents().entrySet())
         {
             String ID = (String)row.getKey();
             String[] infoArray = (String[])row.getValue();

             System.out.println(ID + " : " + Arrays.toString(infoArray));
         }
         */

         //Test createAttendee method
         /*
         System.out.println("\nCreating attendee 'First Name, Last Name' with associated event E1...");
         SQLGrabber.createAttendee("First Name", "Last Name", "E1");
         */

         //Test getEventRoster method using ID E1
         /*
         System.out.println("\nPrinting roster with event ID E1...");
         for (String[] fullName : SQLGrabber.getEventRoster("E1"))
         {
             System.out.println(Arrays.toString(fullName));
         }
         */

         //Test getAllAttendees method
         /*
         System.out.println("Printing all attendees...");
         for (Map.Entry row : SQLGrabber.getAllAttendees().entrySet())
         {
             String ID = (String)row.getKey();
             String[] nameArray = (String[])row.getValue();

             System.out.println(ID + " : " + Arrays.toString(nameArray));
         }
         */

         //Test findAttendee method
         /*
         System.out.println("\nFinding attendee with ID of 1...");
         String[] foundNameArray = SQLGrabber.findAttendee("1");
         System.out.println(Arrays.toString(foundNameArray));
         */

         //Test createEventOwner method
         /*
         System.out.println("\nCreating owner 'Bob, Test' with password 'goodpassword'...");
         SQLGrabber.createEventOwner("Bob", "Test", "goodpassword");
         */

         //Test updateAttendeeInfo
         /*
         System.out.println("\nUpdating attendee ID 1...");
         SQLGrabber.updateAttendeeInfo("1", "New First", "New Last");
         */

         //Test updateEventOwnerInfo
         /*
         System.out.println("\nUpdating owner ID 1...");
         SQLGrabber.updateEventOwnerInfo("1", "New First", "New Last", "new password yo");
         */

         //Test updateEventInfo
         /*
         System.out.println("\nUpdating event ID E1...");
         SQLGrabber.updateEventInfo("E1",
                 "2020-12-25 05:00:00",
                 "01:00:00",
                 "Christmas",
                 "2020-12-26 08:00:00",
                 "1");
         */

         //Test addAttendeeToEvent
         /*
         System.out.println("\nAdding attendee 2 to event E1...");
         SQLGrabber.addAttendeeToEvent("2", "E1");
         */

         //Test deleteAttendee
         /*
         System.out.println("\nDeleting attendee 2");
         SQLGrabber.deleteAttendee("2");
         */

         //Test deleteEventOwner
         /*
         System.out.println("\nDeleting event owner 2");
         SQLGrabber.deleteEventOwner("2");
         */

         //Test deleteEvent
         /*
         System.out.println("\nDeleting event E2");
         SQLGrabber.deleteEvent("E2");
         */

         //Test findActiveEvents method
         /*System.out.println("\nFinding active events...");
         for (Map.Entry row : SQLGrabber.findActiveEvents().entrySet())
         {
             String ID = (String)row.getKey();
             String[] infoArray = (String[])row.getValue();

             System.out.println(ID + " : " + Arrays.toString(infoArray));
         }
          */

         //Test checkIn method
         /*

         System.out.println("Checking in attendee 1 into event E1 with a mobile device of MAC 'testmac_1234'...");
         SQLGrabber.checkIn("1", "E1", "mobile", "testmac_1234");

         System.out.println("Checking in attendee 2 into event E1 with a card...");
         SQLGrabber.checkIn("2", "E1", "card", null);
          */

         //Test checkOut method
         /*
         System.out.println("Checking out attendee 1 out of event E2");
         SQLGrabber.checkOut("1", "E2");
          */

         //Test isFirstCheckNull
         /*
         System.out.println("Checking if attendee 2 checked into event E1");
         System.out.println(SQLGrabber.isFirstCheckNull("2", "E1"));

         System.out.println("Checking if attendee 1 checked into event E1");
         System.out.println(SQLGrabber.isFirstCheckNull("1", "E1"));
          */

     }
}
