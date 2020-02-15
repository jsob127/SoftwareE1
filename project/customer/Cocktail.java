package project.customer;

public class Cocktail
{
    String name;
    String alcoholType;
    double oz;
    String mixers;
    double mixersOz;
    String mixerTwo;
    double mixerTwoOz;
    String mixerThree;
    double mixerThreeOz;
    String description;

    public Cocktail(String name, String alcoholType, double oz, String mixers, double mixersOz, String mixerTwo, double mixerTwoOz, String mixerThree, double mixerThreeOz, String description)
    {
        this.name = name;
        this.alcoholType = alcoholType;
        this.oz = oz;
        this.mixers = mixers;
        this.mixersOz = mixersOz;
        this.mixerTwo = mixerTwo;
        this.mixerTwoOz = mixerTwoOz;
        this.mixerThree = mixerThree;
        this.mixerThreeOz = mixerThreeOz;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getAlcoholType()
    {
        return alcoholType;
    }

    public double getOz ()
    {
        return oz;
    }

    public String getMixers()
    {
        return mixers;
    }

    public double getMixersOz()
    {
        return mixersOz;
    }

    public String getMixerTwo()
    {
        return mixerTwo;
    }

    public double getMixerTwoOz()
    {
        return mixerTwoOz;
    }

    public String getMixerThree()
    {
        return mixerThree;
    }

    public double getMixerThreeOz()
    {
        return mixerThreeOz;
    }

    public String getDescription()
    {
        return description;
    }

    public String toString()
    {
        return(this.getName() + "\nThis cocktail contains: \n"  + this.getOz() + "oz "+ this.getAlcoholType() + "\n" + this.getMixersOz() + "oz " + this.getMixers() + "\n" +  this.getMixerTwoOz() + "oz " + this.getMixerTwo() + "\n" + this.getMixerThreeOz() + "oz " + this.getMixerThree() + "\n" + this.getDescription() + "\n");
    }

//    public static void main(String[] args)
//    {
//        project.customer.Cocktail MidoriSour = new project.customer.Cocktail("Midori Sour", "Vodka", 2, "Midori", 2, "Sweet & Sour", 4, "Sprite", 4, "The Midori Sour is good");
//
//        project.customer.Cocktail WhiskeySour = new project.customer.Cocktail("Whiskey Sour", "Whiskey", 2, "Sweet & Sour Mix", 4, "Sprite", 6, "No third mixer", 0, "The Whiskey sour is the perfect amount of whiskey and sourness");
//
//        project.customer.Cocktail WhiskeyCoke = new project.customer.Cocktail("Whiskey Coke", "Whiskey", 2, "Coke", 10, "No second Mixer", 0, "No third Mixer", 0, "A simple cocktail for those that want to play it safe");
//
//        project.customer.Cocktail RumCoke = new project.customer.Cocktail("Rum & Coke", "Rum", 2, "Coke", 10, "No second Mixer", 0, "No third Mixer", 0, "A simple cocktail for those that want to play it safe" );
//
//        project.customer.Cocktail Paloma = new project.customer.Cocktail("Paloma", "Tequila", 2, "Squirt", 10, "Tajin", 0.25, "No third Mixer", 0, "A Mexican project.customer.Cocktail that tast spicy and sweet almost like lucas candy");

//        System.out.println(MidoriSour.toString());
//        System.out.println(WhiskeySour.toString());
//        System.out.println(WhiskeyCoke.toString());
//        System.out.println(RumCoke.toString());
//        System.out.println(Paloma.toString());
//    }

}
