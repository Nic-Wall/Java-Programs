import java.util.*;

class fish implements inheritance
{ //Pairs with ObjectAndClasses.java
    //^ Creating a fish Class

    //Creating a fish's objects
    String name;
    String color;
    String species;
    int fins;

    public static int count = 0;

    //Constructing a fishes objects
    public fish(String n, String c, String s, int f)
    {
        name = n;
        color = c;
        species = s;
        fins = f;    
        count++;    
    }

    public fish(Scanner f)
    {
        name = f.next();
        color = f.next();
        species = f.next();
        fins=f.nextInt();
    }

    //Functions that converts the fish to a string
    public String toString()
    {
        return "Fish: "+name+" color="+color+" species="+species+" number of fins="+fins;
    }

    //Accessor Function (also called "getters")
    public String getName()
        {return name;}
    public String getColor()
        {return color;}
    public String getSpecies()
        {return species;}
    public int getFins()
        {return fins;}

    public int compareTo(Object y)
    {
        if(y instanceof fish)
        {
            fish f=(fish)y; //Convert y to a fish
            return name.compareTo(f.getName());
            //f.getName() is getting the name of (newly converted) fish y and comparing it to
        }
        else{return 0;} //y isn't a fish
    }

    //Transformer Functions (also called "setters")
    public void sharkAttack()
    {
        fins--;
        if(fins<0) {fins=0;}
    }

    //Fish eats radioactive seaweed
    public void seaweed()
    {
        fins++;
        color = "glowing" + color;
    }
}