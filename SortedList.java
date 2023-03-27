interface SortedList extends DataStructure
{
    public void insert(inheritance x);
    public inheritance get(int position);
    public inheritance delete(int position);
    public inheritance lookup(inheritance x);
    
}
/*
 head --> [azalea]] --> [daisy]] --> [orchid]] --> [rose]null]
 compareTo function needs to be useable (which means all the objects must be same)
 insert(Pansy) will go between "Orchid" and "Rose"
 get operation will return the item in the position requested
 delete will remove the item in the position requested
 makeEmpty, size, etc. must also be used
 Operations: size, isEmpty, isFull, makeEmpty, insert, get, delete, lookup(if there's time)
    Insert
        3 Cases:
            Beginning
                Insert "Aster" in front of Azalea. Making head point to Aster and Aster point to Azalea
            Middle
                Inserting "Pansy" in the middle would require us to scan the array and find the place it fits (Orchid and Rose)
            End
                Same as the queue

    Delete
        head --> [buttercup]] --> [daffodil]] --> [lilly]null]
                      0                 1            2
                    before            target
        delete(1):
            before.next = before.next.next;
            count--;
        delete(0):
            head = head.next;
            count--;
*/