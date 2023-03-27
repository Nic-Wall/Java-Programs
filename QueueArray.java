class QueueArray implements Queue
{
    int front, back;
    int count;
    Object [] donut;

    public QueueArray(int maxsize)
    {
        donut = new Object[maxsize];
        count = 0;
        front = 0;
        back = donut.length-1;
    }

    public void enqueue (Object x)
    {
        if(isFull())
            {return;}
        back++;
        if(back >= donut.length)
            {back = 0;}
        donut[back] = x;
        count++;
    }

    public Object dequeue()
    {
        if(isEmpty())
            {return null;}
        else
        {
            Object itemToReturn = donut[front];
            front++;
            if(front>=donut.length)
                {front = 0;}
            count--;
            return itemToReturn;
        }
    }

    public Object getFront ()
        {return isEmpty()?null:donut[front];}

    public void makeEmpty()
    {
        count = 0;
        front = 0;
        back = donut.length-1;
    }

    public boolean isEmpty()
        {return(count <=0);}

    public boolean isFull()
        {return(count >= donut.length);}

    public int size()
        {return count;}
}