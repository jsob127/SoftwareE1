package drinks;

import customer.*;

public class Ingredient
{
    String name;
    String type;
    double oz;

    public Ingredient(String name, String type, double oz)
    {
        this.name = name;
        this.type = type;
        this.oz = oz;

    }

    public double getOz()
    {
        return oz;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public boolean subtractOz(double ozUsed, String type)
    {
        if(oz == 0)
        {
            return false;
        }
        oz = oz - ozUsed;
        if(type == "alcohol")
        {
            if(oz < 5)
            {
                System.out.println("WARNING: Running low on " + name);
            }
        }
        if(type != "alcohol")
        {
            if(oz < 20)
            {
                System.out.println("WARNING: Running low on " + name);
            }
        }
        return true;
    }

    /*public static void main(String[] args)
    {
        Ingredient Vodka = new Ingredient("vodka", "alcohol", 25);
        Ingredient Whiskey = new Ingredient("whiskey", "alcohol", 25);
        Ingredient Tequila = new Ingredient("tequila", "alcohol", 25);
        Ingredient Midori = new Ingredient("midori", "alcohol", 25);
        Ingredient Rum = new Ingredient("rum", "alcohol", 25);

        Ingredient Sprite = new Ingredient("sprite", "sodaMixer", 150);
        Ingredient Coke = new Ingredient("coke", "sodaMixer", 150);

        Ingredient SweetNSour = new Ingredient("sweetNSour","mixer", 100);
        Ingredient Squirt = new Ingredient("squirt", "mixer", 100);
        Ingredient Tajin = new Ingredient("tajin", "mixer", 100);

    }*/
}