//import java.util.*; //Need to reactivate to run the commented out portions
//import java.math.*;

class PrimeNumberTesterWithFunction
{
    static boolean isPrime(int n)
    {
        if(n<2) return false;
        //for(int d = 0; d < n; d++)
        for(int d=2; d<=Math.sqrt(n); d++)  //Using square root
        {
            if(n % d == 0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args)
    {
        /*
        int UENumber;
        Scanner cin = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        UENumber = cin.nextInt();
        
        if(isPrime(UENumber) && UENumber>1)
        {
            System.out.println("$UENumber is a prime number!");
        }
        else
        {
            System.out.println("$UENumber is not a prime number!");
        }
        */
        for(int d=1; d<1000000; d++)
        {
            if(isPrime(d)) System.out.println(d);
        }

    }
}