public class SortedListLL implements SortedList
{
    private class node
    {
        public inheritance data;
        public node next;
    }
    node head;
    int count;

    public SortedListLL()
    {
        head = null;
        count = 0;
    }

    public void insert(inheritance x)
    {
        node before, after;
        node newnode = new node();
        newnode.data = x;

        before = null;
        after = head;
        while(after != null && after.data.compareTo(x) < 0)
        {
            before = after;
            after = after.next;
        }
        newnode.next = after;
        if(before == null)  //Insertion in the beginning
            {head = newnode;}
        else    //Insertion in middle/ end
            {before.next = newnode;}
        count++;
    }

    public inheritance get(int position)
    {
        if(position < 0 || position >= count)
            {return null;}
        node pointer;
        pointer = head;
        for(int i = 0; i < position; i++)
            {pointer = pointer.next;}
        return pointer.data;
    }

    public inheritance delete(int position)
    {
        if(position < 0 || position >= count)
            {return null;}
        node before = head;
        for(int i = 1; i < position; i++)
            {before = before.next;}
        
        inheritance saved;
        if(position == 0)
        {
            saved = head.data;
            head = head.next;
        }
        else
        {
            saved = before.next.data;
            before.next = before.next.next;
        }
        count--;
        return saved;
    }

    public inheritance lookup(inheritance x)
    {return null;}

    public void makeEmpty()
    {
        head = null;
        count = 0;
    }

    public boolean isEmpty()
        {return count <= 0;}

    public boolean isFull()
        {return false;}
    
    public int size()
        {return count;}
    
}
