import java.util.*;
class PrimeNumberTester
{
    public static void main(String [] args)
    {
        int UENumber;
        Scanner cin = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        UENumber = cin.nextInt();
        boolean isPrime = true;
        for(int d = 0; d < UENumber; d++)
        {
            if(UENumber % d == 0)
            {
                isPrime = false;
            }
        }
        if(isPrime && UENumber>1)
        {
            System.out.print("$UENumber is a prime number!");
        }
        else
        {
            System.out.print("$UENumber is not a prime number!");
        }
        cin.close();

    }
}