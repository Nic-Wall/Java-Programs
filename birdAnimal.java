public class birdAnimal extends dinoAnimal 
{
    String songQuality;

    public birdAnimal(String n, String s, String c, String q)
    {
        super(n,s,c,0); //horns=0 for all birds
        songQuality = q;
    }

    //Hide the horns variable (doesn't work the way the professor intended)
    //private int getHorns(){return 0;}

    public String getSongquality(){ return songQuality;}

    public String toString()
    {
        return "Bird: "+name+" | Species: "+species+" | Color: "+color+" | Song Quality: "+songQuality;
    }
}
