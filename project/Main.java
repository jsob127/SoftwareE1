package project;

import java.sql.SQLOutput;
import java.util.*;
import project.customer.*;

public class Main {

    static Ingredient vodka = new Ingredient("vodka", "alcohol", 25);
    static Ingredient whiskey = new Ingredient("whiskey", "alcohol", 25);
    static Ingredient tequila = new Ingredient("tequila", "alcohol", 25);
    static Ingredient midori = new Ingredient("midori", "alcohol", 25);
    static Ingredient rum = new Ingredient("rum", "alcohol", 25);

    static Ingredient sprite = new Ingredient("sprite", "sodaMixer", 150);
    static Ingredient coke = new Ingredient("coke", "sodaMixer", 150);

    static Ingredient sweetNSour = new Ingredient("sweetNSour","mixer", 100);
    static Ingredient squirt = new Ingredient("squirt", "mixer", 100);
    static Ingredient tajin = new Ingredient("tajin", "mixer", 100);

    static project.customer.Cocktail midoriSour = new project.customer.Cocktail("Midori Sour", "Vodka", 2, "Midori", 2, "Sweet & Sour", 4, "Sprite", 4, "The Midori Sour is good");

    static project.customer.Cocktail whiskeySour = new project.customer.Cocktail("Whiskey Sour", "Whiskey", 2, "Sweet & Sour Mix", 4, "Sprite", 6, "No third mixer", 0, "The Whiskey sour is the perfect amount of whiskey and sourness");

    static project.customer.Cocktail whiskeyCoke = new project.customer.Cocktail("Whiskey Coke", "Whiskey", 2, "Coke", 10, "No second Mixer", 0, "No third Mixer", 0, "A simple cocktail for those that want to play it safe");

    static project.customer.Cocktail rumCoke = new project.customer.Cocktail("Rum & Coke", "Rum", 2, "Coke", 10, "No second Mixer", 0, "No third Mixer", 0, "A simple cocktail for those that want to play it safe" );

    static project.customer.Cocktail paloma = new project.customer.Cocktail("Paloma", "Tequila", 2, "Squirt", 10, "Tajin", 0.25, "No third Mixer", 0, "A Mexican project.customer.Cocktail that tast spicy and sweet almost like lucas candy");


    public static void main (String[] args) {

        Customer[] customers = {};
        Scanner reader = new Scanner(System.in);

        customers = checkInCustomer(customers, reader);

        for (int i = 0; i < customers.length; i++) {
            Customer temp = customers[i];

            System.out.println(temp.getName() + ", " + temp.getAge() + " has $" + temp.getMoneyAvailable());
        }

        // customers = checkInCustomer(customers, r);

        // for (int i = 0; i < customers.length; i++) {
        //     Customer temp = customers[i];

        //     System.out.println(temp.getName() + ", " + temp.getAge() + " has $" + temp.getMoneyAvailable());
        // }

        // customers = checkInCustomer(customers, r);

        // for (int i = 0; i < customers.length; i++) {
        //     Customer temp = customers[i];

        //     System.out.println(temp.getName() + ", " + temp.getAge() + " has $" + temp.getMoneyAvailable());
        // }

        orderDrink(reader, customers[0]);

    }

    static Customer[] checkInCustomer(Customer[] customers, Scanner r) {
        int length = customers.length;
        Customer[] newCustomers = new Customer[length + 1];

        // get customer info
        System.out.print("Welcome. What is your full name? ");
        String n = r.nextLine();
        System.out.print("What is your age? ");
        int a = r.nextInt();
        System.out.print("How much money do you have available? ");
        double m = r.nextDouble();

        // capture \n
        r.nextLine();

        Customer c = new Customer(n, a, m);

        // return original list if new customer is underage
        if (!c.getCanDrink()) { return customers; }

        // check if customer is already in system
        for (int i = 0; i < customers.length; i++) {
            Customer temp = customers[i];
            boolean sameName = (temp.getName().equalsIgnoreCase(c.getName())) ? true : false;
            boolean sameAge = (temp.getAge() == c.getAge()) ? true : false;
            boolean sameMoney = (temp.getMoneyAvailable() == c.getMoneyAvailable()) ? true : false;

            if (sameName && sameAge && sameMoney) {
                // customer already exists, return original list
                return customers;
            } else {
                newCustomers[i] = temp;
            }
        }

        // add new customer to list
        newCustomers[length] = c;

        return newCustomers;
    }

    static void orderDrink(Scanner r, Customer c){
//        // order drink code

        int loopcheck = 1;
        while(loopcheck == 1)
        {
            System.out.println("Enter 0 to view a drink list.");
            System.out.println("What would you like to drink? Enter a number.");

            int drinkDecision = r.nextInt();
            r.nextLine();
            if (drinkDecision == 0) {
                System.out.println("1. " + midoriSour.toString());
                System.out.println("2. " + whiskeySour.toString());
                System.out.println("3. " + whiskeyCoke.toString());
                System.out.println("4. " + rumCoke.toString());
                System.out.println("5. " + paloma.toString());
                System.out.println("What would you like to drink? Enter a number.");
                drinkDecision = r.nextInt();
                r.nextLine();
            }
            if (drinkDecision == 1) {
                System.out.println("You have chosen a " + midoriSour.getName());
                vodka.subtractOz(midoriSour.getOz(), "alcohol");
                midori.subtractOz(midoriSour.getMixersOz(), "mixer");
                sweetNSour.subtractOz(midoriSour.getMixerTwoOz(), "mixer");
                sprite.subtractOz(midoriSour.getMixerThreeOz(), "mixer");
                c.subtractMoneyAvailable(8);
            }
            if (drinkDecision == 2) {
                System.out.println("You have chosen a " + whiskeySour.getName());
                whiskey.subtractOz(whiskeySour.getOz(), "alcohol");
                sweetNSour.subtractOz(whiskeySour.getMixersOz(), "mixer");
                sprite.subtractOz(whiskeySour.getMixerTwoOz(), "mixer");
                c.subtractMoneyAvailable(6);
            }
            if (drinkDecision == 3) {
                System.out.println("You have chosen a " + whiskeyCoke.getName());
                whiskey.subtractOz(whiskeyCoke.getOz(), "alcohol");
                coke.subtractOz(whiskeyCoke.getMixersOz(), "mixer");
                c.subtractMoneyAvailable(5);
            }
            if (drinkDecision == 4) {
                System.out.println("You have chosen a " + rumCoke.getName());
                rum.subtractOz(rumCoke.getOz(), "alcohol");
                coke.subtractOz(rumCoke.getMixersOz(), "mixer");
                c.subtractMoneyAvailable(6);
            }
            if (drinkDecision == 5) {
                System.out.println("You have chosen a " + paloma.getName());
                tequila.subtractOz(paloma.getOz(), "alcohol");
                squirt.subtractOz(paloma.getMixersOz(), "mixer");
                tajin.subtractOz(paloma.getMixerTwoOz(), "mixer");
                c.subtractMoneyAvailable(8);
            }

            // tip

            tip(r, c);

            System.out.println("\nPlease enter 1 for another drink, or 0 to close out your tab.");
            System.out.println("You now have $" + c.getMoneyAvailable() + " left.\n");
            loopcheck = r.nextInt();
            r.nextLine();
        }
    }

    static void tip(Scanner r, Customer c) {
        Tips tip = new Tips();
        while (true) {
            System.out.print("Would you like to leave a tip? y/n ");
            String choice = r.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                System.out.print("How much would you like to tip? ");
                double amt = r.nextDouble();
                tip.addTip(amt);
                c.subtractMoneyAvailable(amt);

                System.out.println("You now have $" + c.getMoneyAvailable() + " left.");

                r.nextLine();
                System.out.println("Thank you.");
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Thank you.");
                break;
            } else {
                System.out.println("Invalid entry. Try again...");
            }
        }
    }
}