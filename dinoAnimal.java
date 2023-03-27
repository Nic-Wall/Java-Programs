public class dinoAnimal extends animal
{
    int horns;

    public dinoAnimal(String n, String s, String c, int h)
    {
        super(n,s,c);   //calls the animal constructor (super refers to the parent class)
        horns=h;
    }

    public int getHorns() {return horns;}

    public String toString() 
    {
        String answer = super.toString();   //Makes a string from the Animal parts of the dinoAnimal
        return "Dino: "+ answer +" | Horns: " +horns;
    }

    
}
