//This program will say if you're old or not
//import java.io.*; //In and out library
import java.util.*;
class UserInputAndIfElse
{
    public static void main(String [] args)
    {
        //This two step process builds the scanner and connects it to the keyboard
        Scanner cin;
        cin = new Scanner(System.in);
        //Could also do "Scanner cin = new Scanner(System.in);""

        System.out.println("How old are you?");
        int years; //all the variables from C++ are also present here

        years = cin.nextInt(); //Receives a user's response

        if(years<59)
        {
            System.out.println("You are young!");
        }
        else
        {
            System.out.println("You are old!");
        }
        cin.close();
    }
}