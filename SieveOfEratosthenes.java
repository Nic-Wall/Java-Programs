//Sieve of Eratosthenes (algorithm for listing primes): If a number is prime its multiples are not
import java.util.*;

class SieveOfEratosthenes
{
    public static void main(String [] args)
    {
        Scanner cin = new Scanner(System.in);
        int n;
        System.out.print("Enter your prime limit: ");
        n = cin.nextInt();
        cin.close();

        //Set up array of booleans
        boolean [] x;
        x = new boolean[n+1];
        for(int i=2; i<x.length; i++)
            {x[i] =true;}
        x[0] = x[1] = false; //Java's assignment is right associative meaning it'll assign false to x[1] first then x[0]
        
        //Cross off multiples
        for(int p=2; p<Math.sqrt(n); p++)
        {
            if(x[p]) //Don't cross off multiples of non-primes
            {
                //Multiples of p
                for(int q=2*p; q<=n; q=q+p)
                    {x[q] = false;}
            }
        }
        
        for(int i=0; i<x.length; i++)
        {
            if(x[i])
                {System.out.print(i + " ");}
        }
        System.out.println("");

    }
}