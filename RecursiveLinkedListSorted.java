public class RecursiveLinkedListSorted implements SortedList
{
    private class node
  {
    public inheritance data;
    public node next;
  }
  node head;
  int count;

  public RecursiveLinkedListSorted()
  {
    head=null; count=0;
  }

  public void insert(inheritance x)
  {
    head = inserthelp(head, x);
  }

  private node inserthelp(node h, inheritance x)
  {
    //base case - h == null or the list is empty, OR
    // we insert at the front - h.data is larger than x
    if(h == null || h.data.compareTo(x) > 0)
    {
        node newnode = new node();
        newnode.data = x;
        newnode.next = h;
        count++;
        return newnode;
    }
    else //recursive case
    {
        h.next = inserthelp(h.next,x);
        return h;
    }
  }

/*
  public void insert(inheritance x)
  {
    node before, after;
    node newnode=new node();
    newnode.data=x;

    // place before and after
    before=null;
    after=head;
    while(after!=null && after.data.compareTo(x)<0)
    {
      before=after; // catch up
      after=after.next;
    }
    // put in the node
    newnode.next=after;
    if(before==null) // insertion at the beginning
      { head=newnode; }
    else // insertion in the middle or on the end
      { before.next=newnode; }
    count++;
  }
*/

  private inheritance gethelp(node h, int pos)
  {
    if(pos==0) { return h.data; }
    else { return gethelp(h.next,pos-1); }
  }

  public inheritance get(int position) 
  {
    if(position<0 || position>=count) { return null; }
    return gethelp(head,position); // call a recursive helper function
/*
    node pointer;
    pointer=head;
    for(int i=0; i<position; i++)
      { pointer=pointer.next; }
    return pointer.data;
*/
  }

  public inheritance delete(int position)
  {
    if(position<0 || position>=count) { return null; }
    node before=head;
    for(int i=1; i<position; i++) { before=before.next; }
    inheritance saved;
    if(position==0) 
    {
      saved=head.data; 
      head=head.next;
    }
    else 
    { 
      saved=before.next.data; 
      before.next=before.next.next;
    }
    count--;
    return saved;
  }
  public inheritance lookup(inheritance x) { return null; }

  public void makeEmpty()
  {
    head=null; count=0;
  }
  public boolean isEmpty() { return count<=0; }
  public boolean isFull() { return false; }
  public int size() { return count; }

}
/*
    head --> [Brownies]] --> [Fish Donuts]] --> [Ice Cream]null]
                  0                 1                2
    base case: pos == 0
        return head.data
    recusive case: pos > 0
        recusive on
        head.next for head
        pos - 1 for pos
    Suppos one wishes to insert Cookies...
    head --> [Brownies]] --> [Cookies]] --> [Fish Donuts]] --> [Ice Cream]null]
        Brownies head needs to point to Cookies and Cookies head needs to point to Fish Donuts
        

    Sorting
        Given an array of comparable objects, re-arrange them into non-decreasing order
    Sorts we'll learn:
        + Selection Sort: minimizes data moves
        + Insertion Sort: fast on almost-sorted data
            - Shell Sort
        + Bubble Sort: has poor performance and any other alternetives are better (it's used because it's easy and quick to write)
        + Quick Sort: } recursive     fast
        + Merge Sort: }           and
*/