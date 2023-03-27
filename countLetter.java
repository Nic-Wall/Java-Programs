//Import
import java.util.*;
import java.io.*;

class countLetter
{//and countletterfile.java

    static int numEs(String s)
    {
        int cnt = 0;
        for(int i = 0; i<s.length(); i++)
        {
            char thisletter;
            thisletter = s.charAt(i);
            if(thisletter == 'e' || thisletter == 'E')
            {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String [] args)
    throws IOException
    {
        Scanner cin = new Scanner(System.in);

        /*
        //Reads from input
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter a line of text please: ");
        String line=cin.nextLine();
        System.out.print("There are " + numEs(line) + " e's in your input.");
        */

        //Reads from file
        int count = 0;
        String line;

        System.out.println("Please enter a file name: ");
        String fn = cin.nextLine();
        Scanner infile = new Scanner(new FileReader(fn));
        //infile.hasNext(); returns a boolean value to let you know if there's more to read
            //Throws and IOException if the file isn't there is fixed with line 
        //infile.nextln(); to get the next line in the file
        while(infile.hasNext())
        {
            line = infile.nextLine();
            count = count + numEs(line);
        }
        System.out.print("There are " + count + " e's in your file.");

        cin.close();
        infile.close();
    }
}