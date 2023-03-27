import java.util.*;
import java.io.*;
public class QueueMain
{
    public static void main(String [] args)
    throws IOException
    {
        Scanner fishfile = new Scanner(new FileReader(".\\Class Notes\\fishfile.txt"));
        int n = fishfile.nextInt();

        //Queue Q = new QueueArray(100);    //Donut version
        Queue Q = new QueueLL();        //Linked List version

        for(int i=0; i<n; i++)
        {
            Q.enqueue(new fish(fishfile));
        }
        System.out.println("Size of queue: " + Q.size());
        System.out.println("Top of queue: " + Q.getFront());
        System.out.println("Queue is empty: " + Q.isEmpty());
        System.out.println("Queue is full: " + Q.isFull());

        while(!Q.isEmpty())
        {
            System.out.println("Dequeue: " + Q.dequeue());
        }
    }
}
/*
    Queue = line
    A queue is like a stack with no bottom
    | 3 |   <- last in, first out            | 3 |   <- last in, last out
    | 2 |   <- second in, second out         | 2 |   <- second in, second out
    | 1 |   <- first in, last out            | 1 |   <- first in, first out
    +---+
    Stack                                    Queue
    LIFO (Last In, First Out)                FIFO (First In, First Out)

    Methods
        - enqueue = insert
        - dequeue = remove
        - getFront = get a copy of the first item
        - makeEmpty
        - isFull
        - isEmpty
        - size
    Ex.
        [A, B, C, D, , , , , , ]
         ^        ^
        Front    Back
        add some items...
        [A, B, C, D, E, F, G, , , ]
         ^                 ^
        Front             Back
        remove some items...
        [, , , D, E, F, G, , , ]
               ^        ^
              Front    Back
        If you imagine a donut shape seperated into each part of the array you can make a perpetually circular queue
*/