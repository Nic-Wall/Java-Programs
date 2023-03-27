class RefenceTypes
{
    public static void main(String [] args)
    {
        /*
            Basic (Simple) Types: int, double, char, boolean, and the rest (pass-by-value)
            Reference Types: Reference variables indicate where the object is: (pass-by-reference)
                Scanner, Arrays, Strings, Objects in general
                2 Steps:
                    1. Create the variable  (Scanner cin;)
                    2. Call new to built it out and get the address (cin = new Scanner(..);)
            In Java, all functions use pass-by-value. But, sending a reference variable using pass-by-value gives the effect of pass-by-reference
        */
        //Arrays
        int[] A;
        A = new int[5]; //creates an array of 0-4 indexes
        //Can do it in one line with: int[] A = new int[5]
        A[3] = 12;
        //Array length
        if(A.length == 5){};



    }
}