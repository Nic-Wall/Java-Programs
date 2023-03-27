import java.io.*;
//import java.util.*;

public class SortsMain
{
    public static Integer [] randomlist(int n)
    {
        Integer [] numList = new Integer [n];
        for(int i = 0; i < numList.length; i++)
            {numList[i] = ((int) (n * Math.random()));}
        return numList;
    }

    public static void main(String [] args)
    throws IOException
    {
        Integer [] numList; //Integer is a built in class in java that holds ints as an object rather than a simple data type
        numList = randomlist(100);

        for(int i = 0; i < numList.length; i++)
            {System.out.print(numList[i] + " ");}
        System.out.println("\n");

        Sorting.quick(numList);

        for(int i = 0; i < numList.length; i++)
            {System.out.print(numList[i] + " ");}
        System.out.println("");

        //Reading in fish file
        /*
        Scanner fishfile=new Scanner(new FileReader(".\\Class Notes\\fishfile.txt"));
        int n=fishfile.nextInt();
        fish [] school=new fish[n];
        for(int i=0; i<school.length; i++)
            {school[i]=new fish(fishfile);}
        
        //Sorting the fish list
        Sorting.shell(school);
        
        //Printing sorted list
        System.out.println("School roster:");
        for(int i=0; i<school.length; i++)
            {System.out.println(school[i]);}
        fishfile.close();
        */
    }
}
/*
    nlogn lower bound for comparison based sorts (i.e. it's the best you can do) because...
        + It does a comparison < or > and then, based on that answer, it does it again with another option
            point
          < /   \ >
         point        <-- decision tree
       < /   \ >
          etc.
        until it reaches the bottom or all n! permutations or log(base 2)n! comparisons
    What is log(base 2)n! ?
        n! <= n**n
        which tells us log(base 2)n! <= log(base 2) n**n == nlog(base 2)n
        n! >= (n/2)**(n/2)
        log(base 2)n! >= log(base 2)((n/2)**(n/2)) == (n/2)log(base 2)(n/2)
        log(n!) == O(nlogn)
    This shows that merge sort is as optimal as (the running time of) sorts can be...
        but that doesn't necessarily mean it'll always be the fastest or use the least amount of memory
*/