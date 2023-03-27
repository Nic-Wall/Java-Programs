public class fishAnimal extends animal
{
    int fins;

    public fishAnimal(String n, String s, String c, int f)
    {
        super(n,s,c);   //calls the animal constructor (super refers to the parent class)
        fins=f;
    }

    public int getFins() {return fins;}

    public String toString() 
    {
        String answer = super.toString();   //Makes a string from the Animal parts of the fishAnimal
        return "Fish: "+ answer +" | Fins: " +fins;
    }
    
}
