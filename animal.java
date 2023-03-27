public class animal 
{
    protected String name;
    protected String species;
    protected String color;
    //Protected means it's accesible in all derived classes (dino, bird, fish) but not in main

    //Constructor
    public animal(String n, String s, String c)
    {
        name = n; species =s; color = c;
    }

    //Accessors
    public String getName() {return name;}
    public String getSpecies() {return species;}
    public String getColor() {return color;}

    public String toString()
    {
        return "Animal: "+name+" | Species: "+species+" | Color: "+color;
    }
    
}
