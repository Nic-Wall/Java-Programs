//import java.io.*;

public class animalMain
{
    static void printAnimal(animal x)
    {
        System.out.println("Printing inside function!");
        System.out.println(x);
    }

    public static void main(String [] args)
    {
        animal a = new animal("Animal","drummer","red");
        System.out.println(a);

        fishAnimal f = new fishAnimal("BG","bluegill","burnt sienna",6);
        System.out.println(f);

        dinoAnimal d = new dinoAnimal("Ike","brontosaurus","forest green",0);
        System.out.println(d);

        dinoAnimal d2 = new dinoAnimal("Cera","triceratops","leopard print",3);
        System.out.println(d2);

        birdAnimal b = new birdAnimal("Mother Goose","goose","white","scary");
        System.out.println(b);

        //This is legal. animal w = new fishAnimal(..);
        //This is called "virtual binding"
        printAnimal(f);

    }
    
}
