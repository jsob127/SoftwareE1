package project.customer;

import project.drinks.*;

public class DrinkTracker
{
    public Customer customer;
    public int max_drinks;

    public DrinkTracker(Customer customer, int max_drinks)
    {
        this.customer = customer;
        this.max_drinks = max_drinks;
    }

    public void addDrink()
    {
        if (customer.getCanDrink())
        {
            customer.addDrinkBought();
        }
        else
        {
            System.out.println("Sorry you have already reached. No more drinks for you!");
        }
    }

    public boolean checkCustomerCanDrink()
    {
        if(customer.getCanDrink() && customer.getNumDrinksBought() >= max_drinks) {
            customer.setCanDrink(false);
        }

        return customer.getCanDrink();
    }
}