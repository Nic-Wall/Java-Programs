public class QueueLL implements Queue
{
    private class qnode
    {
        public Object data;
        public qnode next;
    }

    qnode front, back;
    int count;
    
    public QueueLL()
    {
        front = back = null;
        count = 0;
    }

    public void enqueue(Object x)
        {
            qnode newnode = new qnode();
            newnode.data = x;
            newnode.next = null;
            if(isEmpty())
                {front = newnode;}
            else
                {back.next = newnode;}
            back = newnode;
            count++;
        }

    public Object dequeue()
        {
            if(isEmpty())
                {return null;}
            else
                {
                    Object saved = front.data;
                    front = front.next;
                    count--;
                    if(front == null)
                        {back = null;}
                    return saved;
                }
        }

    public Object getFront()
        {
            if(isEmpty())
                {return null;}
            else
                {return front.data;}
        }

    public void makeEmpty()
        {
            front = back = null;
            count = 0;
        }

    public boolean isEmpty()
        {return count <= 0;}

    public boolean isFull()
        {return false;}

    public int size()
        {return count;}
}
/*
    Which direction?
                front             back      (this way is better)
        head --> []] --> []] --> []null]
        or      back              front     (no good, needs a loop)
    Enqueue
                    back
        --> []] --> []null]
        1. Create a new node ([]])
        2. Fill it with data ([data]null])
        3. Attach it, by changing the current back null to the pointer of the (currently) last node
            - Ex. back.next() = newnode;
        4. Move back to point to the new last node
            - Ex. back = newnode; count++;
        to make...
                                back
        --> []] --> []] --> [data]null]
        This is assuming you already have node with data before creating a new one. If this isn't true you'll receive an error
        so...
            1. Create the node
            2. Fill it
            3. Attach
                - front = newnode; count = newnode; count++;

    Dequeue
        front(1)
        [x]] --> []] --> ...
                front(2)
        need to move front ahead one, but we also need to save the data in the fron item (x)
        1. Save the front item
        2. Move front forward
            - front = front.next;
        3. count--;
        4. return saved item
        But we must also account for the chance of there only being one item in our queue
*/