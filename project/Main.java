package project;

import java.util.*;
import project.customer.*;

public class Main {

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

    static void orderDrink(Scanner r, Customer c) {
        // order drink code

        // tip

        tip(r, c);
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
