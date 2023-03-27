public class StackArray implements Stack
{// Pairs with Stack, DataStructure, and StackMain
    int top;
    Object [] items; //stack contents

    public StackArray(int maxSize)
    {
        items = new Object[maxSize];
        top = -1;
    }
    public void push(Object x)
    {
        if(!isFull()){items[++top] = x;}   //Increments top by 1 before the initialization
    }
    public Object pop()
    {
        if(!isEmpty()){return null;}
        else{return items[top--];}
    }
    public Object getTop()
    {
        if(isEmpty()) {return null;}
        else{return items[top];}
        //return isEmpty()?null:items[top]; //One line
    }

    public void makeEmpty() {top = -1;}
    public boolean isEmpty() {return (size()<=0);}
    public boolean isFull() {return (top+1 >= items.length);}
    public int size() {return top+1;}
}
/*
    Data Structures
        - Collection of data
        - Operations that act on the data
        - ex. stack, queue, tree, priority queue, hash table, etc.
        Stack
            - Primary Operations
                + Push: Add to the top
                + Pop: Remove from the top
                + GetTop: Gives access to the top item
            | 3 |   <-- added last, removed first
            | 2 |   <-- added second last, removed second last
            | 1 |   <-- add first, removed last
            +---+
            - (more) Methods
                + makeEmpty
                + size
                + isEmpty
                + isFull
*/
