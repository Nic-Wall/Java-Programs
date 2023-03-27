//import java.util.*;
import java.io.*;

class writingToFiles
{
    static public void main(String [] args)
    throws IOException
    {
        String fileName = "greeting.txt";
        PrintWriter outfile = new PrintWriter(new FileWriter(fileName));
        outfile.println("hello\n");
        outfile.close();
    }
}