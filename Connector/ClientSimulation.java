import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class ClientSimulation
{
    public static void main(String[] args)
    {
        Scanner inputReader = new Scanner(System.in);
        DBConnector connector = new DBConnector();
        String buffer;

        while (true)
        {
            System.out.println("\nPlease enter an option:\n" +
                    "1) See all events\n" +
                    "2) See all attendees\n" +
                    "3) See all event owners\n" +
                    "\n4) Check roster of an event\n" +
                    "5) Find active events\n" +
                    "6) Log in\n" +
                    "\n7) Create an event\n" +
                    "8) Create an attendees\n" +
                    "9) Create an event owner\n" +
                    "\n10) Update an event's information\n" +
                    "11) Update an attendee's information\n" +
                    "12) Update an event owner's information\n" +
                    "\n13) Delete an event\n" +
                    "14) Delete an attendee\n" +
                    "15) Delete an event owner\n" +
                    "\n16) Check into an event\n" +
                    "17) Check out of an event\n" +
                    "18) Check if an attendee has checked into an event\n" +
                    "\n19) Add an attendee to an event\n" +
                    "20) Remove an attendee from an event\n" +
                    "\nx) Exit program");

            System.out.print("\noption >> ");

            switch(inputReader.nextLine())
            {
                //See all events
                case "1":
                    System.out.println("\nPrinting all events...");
                    for (Map.Entry row : connector.getAllEvents().entrySet())
                    {
                        String ID = (String)row.getKey();
                        String[] infoArray = (String[])row.getValue();

                        System.out.println(ID + " : " + Arrays.toString(infoArray));
                    }

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //See all attendees
                case "2":
                    System.out.println("\nPrinting all attendees...");
                    for (Map.Entry row : connector.getAllAttendees().entrySet())
                    {
                        String ID = (String)row.getKey();
                        String[] nameArray = (String[])row.getValue();

                        System.out.println(ID + " : " + Arrays.toString(nameArray));
                    }

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //See all event owners
                case "3":
                    System.out.println("\nPrinting all event owners...");
                    for (Map.Entry row : connector.getAllEventOwners().entrySet())
                    {
                        String ID = (String)row.getKey();
                        String[] nameArray = (String[])row.getValue();

                        System.out.println(ID + " : " + Arrays.toString(nameArray));
                    }

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Check roster of an event
                case "4":
                    System.out.println("\nEvent ID:");
                    String userInput = inputReader.nextLine();
                    System.out.println("\nPrinting roster with event ID of " + userInput + " ...");
                    for (String[] fullName : connector.getEventRoster(userInput))
                    {
                        System.out.println(Arrays.toString(fullName));
                    }

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Find active events
                case "5":
                    System.out.println("\nFinding active events...");
                    for (Map.Entry row : connector.findActiveEvents().entrySet())
                    {
                        String ID = (String)row.getKey();
                        String[] infoArray = (String[])row.getValue();

                        System.out.println(ID + " : " + Arrays.toString(infoArray));
                    }

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Log in
                case "6":
                    System.out.println("\nUser ID:");
                    String userID = inputReader.nextLine();
                    System.out.println("Password:");
                    String userPW = inputReader.nextLine();

                    System.out.println("\nVerifying " + userID + " with password '" + userPW  + "'...");
                    System.out.println(connector.verifyLogin(userID, userPW));

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Create an event
                case "7":
                    System.out.println("\nStarting date of event:");
                    String userDate = inputReader.nextLine();
                    System.out.println("Time an attendee must meet to be considered checked in:");
                    String userDuration = inputReader.nextLine();
                    System.out.println("Name of event:");
                    String userEventName = inputReader.nextLine();
                    System.out.println("Ending date of event:");
                    String userEnd = inputReader.nextLine();
                    System.out.println("ID of owner:");
                    String userOwnerID = inputReader.nextLine();

                    System.out.println("\nCreating event " + userEventName + "...");
                    connector.createEvent(userDate, userDuration, userEventName, userEnd, userOwnerID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Create an attendee
                case "8":
                    System.out.println("\nFirst name:");
                    String userFirst = inputReader.nextLine();
                    System.out.println("Last name:");
                    String userLast = inputReader.nextLine();

                    System.out.println("Creating " + userFirst + " " + userLast + "...");
                    connector.createAttendee(userFirst, userLast);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Create an event owner
                case "9":
                    System.out.println("\nFirst name:");
                    userFirst = inputReader.nextLine();
                    System.out.println("Last name:");
                    userLast = inputReader.nextLine();
                    System.out.println("Password:");
                    userPW = inputReader.nextLine();

                    System.out.println("\nCreating " + userFirst + " " + userLast + "...");
                    connector.createEventOwner(userFirst, userLast, userPW);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Update an event's information
                case "10":
                    System.out.println("\nID of event:");
                    String userTargetEventID = inputReader.nextLine();
                    System.out.println("Starting date of event:");
                    userDate = inputReader.nextLine();
                    System.out.println("Time an attendee must meet to be considered checked in:");
                    userDuration = inputReader.nextLine();
                    System.out.println("Name of event:");
                    userEventName = inputReader.nextLine();
                    System.out.println("Ending date of event:");
                    userEnd = inputReader.nextLine();
                    System.out.println("ID of owner:");
                    userOwnerID = inputReader.nextLine();

                    System.out.println("\nUpdating event " + userEventName + "...");
                    connector.updateEventInfo(userTargetEventID, userDate, userDuration, userEventName, userEnd, userOwnerID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Update an attendee's information
                case "11":
                    System.out.println("\nID of attendee:");
                    String userTargetAttendeeID = inputReader.nextLine();
                    System.out.println("First name:");
                    userFirst = inputReader.nextLine();
                    System.out.println("Last name:");
                    userLast = inputReader.nextLine();

                    System.out.println("\nCreating " + userFirst + " " + userLast + "...");
                    connector.updateAttendeeInfo(userTargetAttendeeID, userFirst, userLast);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Update an event owner's information
                case "12":
                    System.out.println("\nID of event owner:");
                    String userTargetEventOwnerID = inputReader.nextLine();
                    System.out.println("First name:");
                    userFirst = inputReader.nextLine();
                    System.out.println("Last name:");
                    userLast = inputReader.nextLine();
                    System.out.println("Password:");
                    userPW = inputReader.nextLine();

                    System.out.println("\nUpdating " + userFirst + " " + userLast + "...");
                    connector.updateEventOwnerInfo(userTargetEventOwnerID, userFirst, userLast, userPW);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Delete an event
                case "13":
                    System.out.println("\nID of event:");
                    userTargetEventID = inputReader.nextLine();

                    System.out.println("\nDeleting event " + userTargetEventID + "...");
                    connector.deleteEvent(userTargetEventID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Delete an attendee
                case "14":
                    System.out.println("\nID of attendee:");
                    userTargetAttendeeID = inputReader.nextLine();

                    System.out.println("\nDeleting attendee " + userTargetAttendeeID + "...");
                    connector.deleteAttendee(userTargetAttendeeID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Delete an event owner
                case "15":
                    System.out.println("\nID of event owner:");
                    userTargetEventOwnerID = inputReader.nextLine();

                    System.out.println("\nDeleting event owner " + userTargetEventOwnerID + "...");
                    connector.deleteEventOwner(userTargetEventOwnerID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Check into an event
                case "16":

                    System.out.println("\nID of attendee:");
                    userTargetAttendeeID = inputReader.nextLine();
                    System.out.println("ID of event:");
                    userTargetEventID = inputReader.nextLine();
                    System.out.println("Method of sign in:");
                    String userSIM = inputReader.nextLine();
                    System.out.println("MAC address (enter null if not mobile):");
                    String userMAC = inputReader.nextLine();

                    //If user typed "null", set userMAC to null
                    if(userMAC.equals("null"))
                    {
                        userMAC = null;
                    }

                    System.out.println("Checking in attendee " + userTargetAttendeeID + " into event " + userTargetEventID + "...");
                    connector.checkIn(userTargetAttendeeID, userTargetEventID, userSIM, userMAC);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Check out of an event
                case "17":
                    System.out.println("\nID of attendee:");
                    userTargetAttendeeID = inputReader.nextLine();
                    System.out.println("ID of event:");
                    userTargetEventID = inputReader.nextLine();

                    System.out.println("Checking out attendee " + userTargetAttendeeID + " out of event " + userTargetEventID + "...");
                    connector.checkOut(userTargetAttendeeID, userTargetEventID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //See if attendee has checked into an event
                case "18":
                    System.out.println("\nID of attendee:");
                    userTargetAttendeeID = inputReader.nextLine();
                    System.out.println("ID of event:");
                    userTargetEventID = inputReader.nextLine();

                    System.out.println("Checking if attendee " + userTargetAttendeeID + " is checked into event " + userTargetEventID + "...");
                    System.out.println(!connector.isFirstCheckNull(userTargetAttendeeID, userTargetEventID));

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Add an attendee to an event
                case "19":
                    System.out.println("\nID of attendee:");
                    userTargetAttendeeID = inputReader.nextLine();
                    System.out.println("ID of event:");
                    userTargetEventID = inputReader.nextLine();

                    System.out.println("Adding attendee " + userTargetAttendeeID + " to event " + userTargetEventID + "...");
                    connector.addAttendeeToEvent(userTargetAttendeeID, userTargetEventID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;

                //Remove an attendee from an event
                case "20":
                    System.out.println("\nID of attendee:");
                    userTargetAttendeeID = inputReader.nextLine();
                    System.out.println("ID of event:");
                    userTargetEventID = inputReader.nextLine();

                    System.out.println("Removing attendee " + userTargetAttendeeID + " to event " + userTargetEventID + "...");
                    connector.removeAttendeeFromEvent(userTargetAttendeeID, userTargetEventID);

                    System.out.println("\nEnter anything to continue...");
                    buffer = inputReader.nextLine();
                    break;
                //Exit program
                case "x":
                    System.exit(0);
                default:
                    System.out.println("\nInvalid input.");
            }
        }

    }
}
