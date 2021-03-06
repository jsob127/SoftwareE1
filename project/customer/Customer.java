package customer;

import drinks.*;

public class Customer extends Person {
    private String name;
    private int age;
    private boolean canDrink = false;
    private int numDrinksBought = 0;
    private double moneyAvailable;

    public Customer(String name, int age, double moneyAvailable) {
        this.name = name;
        this.age = age;
        this.moneyAvailable = moneyAvailable;

        super.name = name;
        super.age = age;

        canDrink = (age >=21) ? true : false;
    }

    public Customer() {

    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean getCanDrink() { return canDrink; }
    public int getNumDrinksBought() { return numDrinksBought; }
    public double getMoneyAvailable() { return moneyAvailable; }
    
    public void addDrinkBought()
    {
        numDrinksBought++;
    }
    public void setCanDrink(boolean state)
    {
        canDrink = state;
    }

    public void subtractMoneyAvailable(double cost)
    {
        if((moneyAvailable - cost) >= 0)
        {
            moneyAvailable -= cost;
        }
        else
        {
            System.out.println("Not enough funds available");
        }
    }

}