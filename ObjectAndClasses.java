import java.util.*;
import java.io.*;

class ObjectAndClasses
{//Also known as fishmain
    //We wrote the inheritance interface in the inheritance.java file
    static void printMax(inheritance [] list)
    {
        inheritance max=list[0];
        for(int i=1; i<list.length; i++)
        {
            if(list[i].compareTo(max)>0)    //if (max>list[i])
            {
                max=list[i];
            }
        }
        System.out.println("The max is " +max);
    }

    static void frenzy(fish [] school)
    {
        int target = (int) (school.length*Math.random());
        school[target].sharkAttack();
    }

    public static void main(String [] args)
    throws IOException
    {
        //Creating a fish
        fish f,f2;
        f = new fish("Polly","ranbow","parrotfish",6);
        f2 = new fish("Sephanie","grean","stegasaurus",10);
        System.out.println(f);
        System.out.println(f2);

        //Accessor
        System.out.println(f.getName()+" is the color "+f.getColor()+".");

        //Transformer
        f.sharkAttack();
        System.out.println("Shark attack"+f);

        //Reading it into a file
        Scanner fishfile = new Scanner(new FileReader("fishfile.txt"));
        int n=fishfile.nextInt();

        fish[] school = new fish[n];
        for(int i=0; i<school.length; i++)
        {
            school[i] = new fish(fishfile);
            System.out.println(school[i]);
        }

        //Shark frenzy
        final int frenzySize = 5; //A constant
        for(int i = 0; i < frenzySize; i++)
        {
            frenzy(school);
        }

        System.out.println("There are " + fish.count + " total fish.");
        //f, f2, and fish .count are the same thing

        printMax(school);
    }

    /*
    private static void notes(String [] args)
    {
    /*
        Pairs with fish.java
    Class = Programmer defined data type
            Object = Variable of a class type (reference variable = build a pointer to it and then call new (eg. string))
            An object contains...
                - Variables, or data members
                - Functions, or methods
                    + Functions/ method types fall into four categories
                        1. Constructor (initializes the object)
                        2. Accessor/ Observer (doesn't change the state but can view it)
                        3. Mutators/ Transformers (changes the state of the object)
                        4. Iterator (used if the object is a collection of something, the iterator is used to step through each part of the collection)
    If a variable or function is static, it is shared among all objects in the class (meaning, if name is static, all the fish will have the same name)
        So, it exists even if there are no objects. Meaning main must be static because it has to exist before anything else can be created
        We can use the class name instead of a variable to access static members (variables or functions)
    Access Control
        Public: Accessible from anywhere (scope)
        Private: Accessible only from within the class
    No parenthesis on the end of count because that tells the program it's a function, when it's not
    }
    */
}