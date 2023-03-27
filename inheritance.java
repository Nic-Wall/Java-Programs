public interface inheritance
{//Also known as Comparable.java
    public int compareTo(Object y);
    /*
        returns:
            -1 if x<y
            0 if x==y
            1 if x>y
        where we called x.compareTo(y)
    */
    
    
    /*Notes
        2 Types
            1. Extends: Make a class from an existing class speciying only differences
            2. Implements: For an interface
                - Interface: Specifies (part of, not all) the behavior of an object
                    + A list of one or more function prototypes
                    + A class can implement multiple interfaces
        Comparable Interface
            - x.compareTo(y) will return -1(if x<y),0(if x==y),1(if x>y)
        Class heirarchy: Object (built-in)
            E.x.          |
                        Animal  (inheritence sub-folder)
                        /   \
                    Fish    Dinosaur
                                |
                              Birds
    */
}