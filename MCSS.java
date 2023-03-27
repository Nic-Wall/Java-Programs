//Imports
//import java.util.*;

class MCSS
{
    //Algorithm 1 - Brute Force
    static int alg1(int [] list)
    {
        int best = 0;
        for(int start = 0; start < list.length; start++)
        {
            for (int stop = start; stop < list.length; stop++)
            {
                int sum = 0;
                for(int i = start; i <= stop; i++)
                    {sum += list[i];}
                if(sum > best){best = sum;}
            }
        }
        return best;
    }

    //Algorithm 2 - A Bit Better
    static int alg2(int [] list)
    {
        int best = 0;
        for(int start = 0; start < list.length; start++)
        {
            int sum = 0;
            for (int stop = start; stop < list.length; stop++)
            {
                sum += list[stop];
                if(sum > best){best = sum;}
            }
        }
        return best;
    }

    //Algorithm 3 - Using Prefix Sum (Check the website for the sheet on how this works)
    static int alg3(int [] list)
    {
        //Compute the prefix sum (red numbers)
        int [] red = new int[list.length];
        red[0]=list[0];
        for(int i=1; i<list.length; i++)
        {
            red[i] = red[i-1] + list[i];
        }
        //If you print red under the original list it'll help you understand
        
        //Compute the minimum red number to the left (green numbers)
        int [] green = new int[list.length];
        int min=0;
        for(int i=0; i<list.length; i++)
        {
            if(red[i] < min){min = red[i];}
            green[i] = min;
        }
        //Print green under red (which is under the original list)

        //Finding the best 
        int best = 0;
        for(int i=0; i<list.length; i++)
        {
            int here=red[i] - green[i];
            if(here>best) {best = here;}
        }
        return best;
    }

    //Make a list (return a list of size n in range (-range to +range (ex. -100 to 100)))
    static int[] makeList(int size, int range)
    {
        int [] list;
        list = new int[size];
        for(int i = 0; i < size; i++)
        {
            list[i] = (int) ((2*range+1)*Math.random())-range;
        }
        return list;
    }

    //Main
    public static void main(String [] args)
    {
        //int [] list = {2,-1,-3,4,2,-3,10};  //New allocation implied here
        int n = 100;
        //System.out.print("How big is the input: ");
        //Scanner cin = new Scanner(System.in);
        //n = cin.nextInt();
        //cin.close();

        int [] list = makeList(n,20);
        /*
        for(int i = 0; i < list.length; i++)
        {
            System.out.print(list[i] + " ");
        }
        */
        System.out.println("Algorithm 1: "+ alg1(list));   //O(n^(3))
        System.out.println("Algorithm 2: "+ alg2(list));   //O(n^(2))
        System.out.println("Algorithm 3: "+ alg3(list));   //O(n)
    }
}


/*
When doing the analysis...
    n = list.length
Go through the code and count the number of instructions...
Algorithm 1
    1 + 1
    n [2 + 1
      [n [2
      [  [1 + 1
      [  [n [2
      [  [  [1
      [  [2         (If statement)
    1

    3 3  6  3       (accessed by columns, each has an n too for formatting purposes they were excluded on this line)
Gets us...
    ((3 * n + 6) * n + 3)n + 3      (analyzed inside out)
Simplified is...
    3*n^(3)+6*n^(2)+3n+3
Ignore constants and lower order terms
    Ignore lower order terms...
        3*n^(3)+6*n^(2)+3n
    Ignore constants
        Big O(n^(3))

Algorithm 2
    1 + 1
    n [2 + 1 + 1
      [n [2
      [  [1
      [  [2
    1
    3  4  3
Gets us...
    3 + n(4+n(5))       (analyzed outside in)
    = 5n^(2) + 4n + 3
    = O(n^(2))

Algorithm 3
    1
    1 + 1
    n [2
      [1
    _____ red part^
    1
    1 + 1
    n [2
      [2
      [1
    _____ green part ^
    1 + 1
    n [2
      [1
      [2
    1

    Gets us...
        13n + 9
        = 13n (dropped lower order term(s))
        = n (dropped constant(s))
        = O(n)
    */