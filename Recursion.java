public class Recursion
{
    static int factorial(int n)
    {
        if(n == 0)
            {return 1;}
        else
            {return n * factorial(n-1);}
    }

    static double power(double x, int n) //Computes x^n
    {
        if(n == 0)
            {return 1;}
        else if(n > 0)
            {return x*power(x, n-1);}
        else //n < 0
            {return 1 / power(x, -n);}
    }

    static double powerButBetter(double x, int n)
    {
        if(n == 0)
            {return 1;}
        else if(n > 0)
            {
                if(n % 2 == 0)
                {
                    double y = powerButBetter(x, n/2);
                    return y * y;
                }
                else
                {
                    double y = powerButBetter(x, (n-1)/2);
                    return x * y * y;
                }
            }
        else //n < 0
            {return 1 / powerButBetter(x, -n);}
        /*
            n even: x^n = (x^(n/2))^2
            n odd: x^n = x * (n^(n-1/2))^2
        */
    }

    static void backwards(int n)
    {
        if(n < 10)
            {System.out.print(n);}
        else
        {
            int lsd = n % 10;
            int rest = n / 10;
            System.out.print(lsd);
            backwards(rest);
        }
    }

    static long fibonaccia(int n)
    {
        if(n <= 1)
            {return n;}
        else
            {return fibonaccia(n-1) + fibonaccia(n-2);}
    }

    static long fibBetter(int n)
    {
        if(n <= 1)
            {return n;}
        long [] f = new long[n+1];
        f[0] = 0; f[1] = 1;
        for(int i = 2; i <= n; i++)
            {f[i] = f[i - 1] + f[i - 2];}
        return f[n];
    }

    public static void main(String [] args)
    {
        /*
        System.out.println(factorial(4));
        System.out.println(power(2,4));
        backwards(8675309);
        System.out.println(fibonaccia(16));
        */
        System.out.println(fibBetter(100));
    }
}
/*
    Recursion: A function that calls itself
    Ex. Factorials
        4! = 4 * 3 * 2 * 1 = 4 * 3!
            0! = 1 (base case: does not use recursion)
            n! = n * (n -1)! (Recursive case)
        If you put a negative number as "n" you'll reach a stack overflow error because it won't reach 0.

    Ex. Computing Powers
        x^n = x * x * x *... n times
         = x * x^(n-1)
         x^0 = 1 when x != 0
         we'll use 0^0 = 1
    
    Ex. Printing a Number Backwards
        8675309 --> 9035768
        n % 10 = 9
        + Extract the least significant digit
        + Print it
        + Print the rest backwards using recursion

    Ex. Fibonacci Numbers
        0 + 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21...
        F0 = 0, F1 = 1, Fn = F(n-1) + F(n-2)

    Rules
        1. Always have a base case (if n == 0)
        2. Converge to the base case (if n > or n < 0)
        3. If you have base case and a convergence from the base case, have faith that recursive calls work (the design rule)
        4. Avoid repeated work

    Big Oh Notation of Factorial
        T(0) = 2
        T(n) = 2 + T(n - 1)
            T(0) = 2
            T(1) = 2 + T(0) = 2 + 2 = 4
            T(2) = 2 + T(1) = 2 + 4 = 6
            T(n) = 2 * (n + 1) = O(n)
    powerButBetter
        T(0) = 2
        T(n) = 5 + T(n/2)        if n is even  Only solving this one*
        T(n) = 5 + T((n-1)/2)    if n is odd

        *
        T(0) = 2
        T(n) = 5 + T(n/2)
        T(1) = 7 (solved with the odd one)
        T(2) = 5 + T(1) = 5 + 7 = 12
        T(2^2) = 5 + T(2) = 17
        T(2^3) = 5 + T(4) = 22
        T(2^k) = 5 + T(2^(k-1))
               = 5 * k + T(1) = 5k 7
               = O(k)
        T(2^k) = O(k)
        if n = 2^k and k = log(2) n then...
        T(n) = O(log n)

    Fibonacci
        counting reursive calls
                fibonacci(n) - 1
                /           \
            (n - 1)       (n - 2)
            /     \        /    \
        (n - 2) (n - 3) (n - 3) (n - 4)
        /   \     / \      / \    /  \

        is read as...
        n     = 1
        n - 1 = 1
        n - 2 = 2
        n - 3 = 3
        n - 4 = 5
        n - 5 = 8
        n - 6 = 13
        ...
        0 = (fibonacci(n))
        There's a formula...
        fibonacci(n) = (1.6^(n)) / sqrt(5)

        Dynamic Programming: Using arrays to store function values to avoid repeated work
        Imagine an array...
        [0, 1, 1, 2, 3, 5, 8, ...]

*/
