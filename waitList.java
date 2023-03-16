public class waitList
{//Pairs with patrons.txt, patrons.java, and restaraunt.java
    private class node //Creates the node shapped like [data]next]
    {
        public patrons data; //Both       empty       filled
        public node next;   //     start       until         below
    }

    node front, back;   //Creates empty nodes for the front and the back which (at creation) will be referencing nothing
    int count;  //Variable that keeps track of the nodes in the que

    //Creating the queLinkedList with a front node, back node, and empty count
    public waitList()
    {
        front = back = null;
        count = 0;
    }

    //Adds Object x to the que (in the data part of a new node, referncing the node after it, which (if the que is empty) is null)
    public void addTo(patrons x)
    {
        node newNode = new node();
        newNode.data = x;
        newNode.next = null;
        if(isEmpty())
            {front = newNode;}
        else
            {back.next = newNode;}
        back = newNode;
        count++;
    }

    public patrons remove()  //Remove the object that was added to the que longest ago
    {
        if(isEmpty())
            {return null;}
        else
        {
            patrons saved = front.data;
            front = front.next;
            count--;
            if(front == null)
                {back = null;}
            return saved;
        }
    }

    public void makeEmpty() //Remove all object from the que
    {
        front = back = null;
        count = 0;
    }

    public boolean isEmpty()    //Don't need isFull because it's a linkedList, the main advantage of it over an array is it won't be full
        {return count <= 0;}

    public int size()   //Return the size of the que
        {return count;}

    public patrons getFront()    //Find the earliest arrival of the que
    {
        if(isEmpty())
            {return null;}
        else
            {return front.data;}
    }
}
/*


*/