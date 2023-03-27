import java.io.*;
import java.util.*;

public class LinkedListMain
{
    public static void main(String [] args)
    throws IOException
    {
        Scanner fishfile = new Scanner(new FileReader(".\\Class Notes\\fishfile.txt"));
        int n = fishfile.nextInt();

        Stack S = new StackLL();

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
    Linked Lists = Array Alternative
        [B, E, E, T, L, E]
         ^  ^  ^  ^  ^  ^
         0  1  2  3  4  5
    Head pointer references node...
        [B]] -> [E]] -> [E]] -> [T]] -> [L]] -> [E]null]
         ^
        Head
            Each of the above are called nodes, with the pointers. The last node ends with a "null" pointer.
    
    Linked Lists vs Arrays
        Pros:
            - Less Space
            - Insert in the middle
        Cons:
            - Harder to code
            - Doesn't support direct access
                + Ex. You can't get to the T straight away (array[3]), you must step your way down starting from the head
    Ex.
        | Sqw | 3      so, top = 3
        | Sad | 2
        | Pat | 1
        | SpB | 0
        +-----+

        top = 3
            |
            V
        [Sqw]2]
            |
            V
        [Sad]1]
            |
            V
        [Pat]0]
            |
            V
        [SpB]null]

        Parts of a Node
            [data]next] -->
            Object's sit in the data part

        Suppose you wish to push Plankton (Pla)
            1. Create a node    (Create a new node)
            2. Fill it with Plankton, "Pla"  (Fill it with data)
            2. [Pla]3]  (Set next equal to top)
            4. top = 4  (Set top = new node)
            5. Count++
        Suppose you wish to pop Squidward (Sqw)
            1. Save the top item Squidward (Sqw)
            2. Set top equal to 2 (Sad) (top = top.next)
            3. Count--
            4. Return Squidward (Sqw) 
     
*/