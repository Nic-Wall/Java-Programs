public class patrons
{//pairs with waitList.java, restaraunt.java, and patrons.txt
    int people;
    int time;
    String name;

    public patrons(int t, int p, String n)  //Creates the object outright
    {
        time = t;
        people = p;
        name = n;
    }

    //Allows for the adding of the variables if the insertion format changes
    public String Name()
        {return name;}
    public int People()
        {return people;}
    public int Time()
        {return time;}

    //Allows for the changing of variables after the object has been created
    public void changeName(String x)
        {name = x;}
    public void changePeople(int x)
        {people = x;}
    public void changeTime(int x)
        {time = x;}
    
}
