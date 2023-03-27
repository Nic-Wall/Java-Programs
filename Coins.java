public class Coins 
{
    static int [] coins = {1, 5, 10, 11, 25, 50};

    static int M(int n) //Doesn't follow rule 4 of recursion
    {
        //Base case (is n == 0)
        if(n == 0)
            {return 0;}
        //Base case (does n match a coin?)
        for(int i = 0; i < coins.length; i++)
        {
            if(coins[i] == n )
                {return 1;}
        }

        //Recursive case
        int minimum = n;
        for(int i = 0; i < coins.length && coins[i] < n; i++)
        {
            int thisMin;
            thisMin = M(n - coins[i]) + 1;
            if(thisMin < minimum)
                {minimum = thisMin;}
        }
        return minimum;
    }

    static int M2(int n)
    {
        //Base case (is n == 0)
        if(n == 0)
            {return 0;}
        //Base case (does n match a coin?)
        for(int i = 0; i < coins.length; i++)
        {
            if(coins[i] == n )
                {return 1;}
        }

        int [] m = new int [n+1];
        m[0] = 0; m[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            int min = i;
            for(int j = 0; j < coins.length && j <= coins[j]; j++)
            {
                int it = m[i - coins[j]] + 1;
                if(it < min)
                    {min = it;}
            }
            m[i] = min;
        }
        return m[n];
    }


    public static void main(String [] args)
    {
        for(int n = 0; n <= 100; n++)
        {
            System.out.println("M("+n+") = "+M(n));
        }
    }
}
/*
    The Land of Fish Donuts
        Assume there exists the following values of coins...
        1, 5, 10, 11, 25, 50
        What is the minimum number of coins to match n?
        15 = 2 coins (10, 5)
        40 = 3 coins (25, 10, 5)
        33 = 3 coins (11, 11, 11) w/out the 11 coin it would be 5 coins (25, 5, 1, 1, 1)
        
        M(n) = minimum number of coins for n cents
        M(n) = 1 for n = 1, 5, 10, 11, 25, 50   (base case 1)
        M(0) = 0                                (base case 2)
        M(n) = Minimum{           }
               coins c{ M(n-c) + 1}
               c <= n
*/