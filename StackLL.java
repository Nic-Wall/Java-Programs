class StackLL implements Stack
{
    //Just allocating memory (two variables)
    private class stacknode
    {
        public Object data;
        public stacknode next;
    }
    stacknode top;
    int count;

    public StackLL()
    {
        top = null;
        count = 0;
    }

    //First time this is called it creates say data = SpB and a next = null
    public void push(Object x)
    {
        stacknode newnode = new stacknode();
        newnode.data = x;
        newnode.next = top;
        top = newnode;
        count++;

    }

    public Object pop()
    {
        if(isEmpty())
            {return null;}
        else
        {
            Object saved = top.data;
            top = top.next;
            count--;
            return saved;
        }

    }
    
    public Object getTop()
    {
        if(isEmpty())
            {return null;}
        else
            {return top.data;}
    }

    public void makeEmpty()
    {
        top = null;
        count = 0;
    }
    
    public boolean isEmpty()
        {return top == null;}
    
    public boolean isFull()
        {return false;}
    
    public int size()
        {return count;}


    
}
