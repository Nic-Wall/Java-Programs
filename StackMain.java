import java.util.*;
import java.io.*;
class StackMain 
{
    public static void main(String [] args)
    throws IOException
    {
        Scanner fishfile = new Scanner(new FileReader(".\\Class Notes\\fishfile.txt"));
        int n = fishfile.nextInt();

        Stack S = new StackArray(100);

        for(int i=0; i<n; i++)
        {
            S.push(new fish(fishfile));
        }
        System.out.println("Size of stack: " + S.size());
        System.out.println("Top of stack: " + S.getTop());
        System.out.println("Stack is empty: " + S.isEmpty());
        System.out.println("Stack is full: " + S.isFull());

        while(!S.isEmpty())
        {
            System.out.println("Popping: " + S.pop());
        }
    }
}
/*
Stack applications:
    - Runtime Stack
        Ex. Main:
                f()
            
            the the activation record shows...
            |   println   |
            |      f      |
            |    main     | <-- Activation record (the one on the top of the stack is most recently ran/running)
            +-------------+
    - Post fix expression evaluation
        + Infix: (1 + 2) * 3 = 9
                    ^    ^
                  Written between the numbers
        + Postfix: 1 2 + 3 *
                       ^   ^
                    Written after the numbers
            - Algorithm: Scan left to right. If it's a number you push it and if it's an operator you (pop -> a), (pop -> b),
                            and (push <- b op a)
            Ex.
                |   |
                | 2 |   <- push 
                | 1 |   <- push
                +---+
                then the operator is found...
                pop 2 into a (a = 2) and 1 into b (b = 1)
                then push (b op a) which is equal to (2 + 1), so the new stack looks like...
                |   |
                |   |
                | 3 |   <- pushed (b op a)
                +---+
            Ex.2. Evaluate...
                2 3 4 5 + * 7 - +
                [2,3,4,5] op!
                so a = 5 and b = 4 and op = +
                a + b = 9
                [2,3,9] op!
                so a = 9 and b = 3 and op = *
                a * b = 27
                [2,27,7] op!
                so a = 7 and b = 27 and op = -
                b - a = 20
                [2,20] op!
                so a = 20 and b = 2 and op = +
                a + b = 22
                Answer: 22
                (2+((3*(4+5)))-7) = 22

*/