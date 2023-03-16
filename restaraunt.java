import java.io.*;
import java.util.*;

public class restaraunt
{//Pairs with waitList.java, patrons.java, and patrons.txt
    static public void main(String [] args)
    throws IOException
    {
        String data;    //Creating a variable to hold file name and the lines of said file
        System.out.println("*** Welcome to La Food Restaraunt Simulator ***\n");

        //Receiving the input for the file used in the simulation
        Scanner cin = new Scanner(System.in);
        System.out.print("Please enter the file you wish to simulate: ");
        data = cin.next();
        cin.close();
        cin = new Scanner(new File(".\\JavaStuff\\" + data));
        //cin = new Scanner(new File(".\\JavaStuff\\patrons.txt"));

        //Necessary declarations before the loop
        patrons party;      //Creating the patrons object
        waitList waiting = new waitList();  //Creating the linked list used to hold all the patrons
        int time;   //Keeps track of the individual times for the tables
        float totalTime = 0;  //Keeps track fo the total time (to measure the average time) spent waiting
        float seated = 0;

        //Outputs from the user input file
        while(cin.hasNext())
        {
            data = cin.next();  //Takes in the "command" A(dd patron), T(able), Q(uit the simulation)
            if(data.equals("A"))    //Adding a patron takes in...
            {
                party = new patrons(cin.nextInt(), cin.nextInt(), cin.nextLine());  //The time arrived, the number of people, and the name of the party
                waiting.addTo(party);   //Adding the party to the waitlist
                System.out.println("Please wait at the bar, \n  party" + party.Name() + " of " + party.People() + " people. (time = " + party.Time() + ")");
            }
            else if(data.equals("T"))
            {
                time = cin.nextInt(); //taking the time the table opened
                party = waiting.remove();   //Removing the party from the waitlist who arrived first
                System.out.println("Table for" + party.Name() + "! (time = " + time + ")");
                totalTime += (party.People()) * (time - party.Time()); //Figuring the average wait time
                seated += party.People();
            }
            else if(data.equals("Q"))
                {break;}    //Breaking out of the loop (this will happen if a "Q" is input or not)
        }

        //Closing
        cin.close();    //Closing the scanner holding the file
        System.out.println("** Simulation Terminated **");  //Notifying the user
        System.out.println("\nThe average waiting time was: " + String.format("%.2f",(totalTime/seated)));  //Printing the average time waited in a two decimal format
        System.out.println("The following parties were never seated:");
        while(!waiting.isEmpty())   //Looping through the rest of the waitlist...
        {
            party = waiting.remove();   //Removing each party in the order they were added
            System.out.println("  party" + party.Name() + " of " + party.People() + " people"); //Printing their information
        }
        System.out.println("\nHave a nice meal!");  //Notifying the user the script has ended
    }
    
}
/*
    A(dd a party) t(ime arrive) n(umber of people) name(of the party)
    T(able is ready) t(ime table became available)
    Q(uit)

    Please wait at the bar,
        party (name) of (people) people. (time = <time>)
    Table for (name)! (time = <time>)
    ** Simulation Terminated **
    
    The average waiting time was: 
    The following parties were never seated:
        party (name) of (people) people

    Have a nice meal!
*/