import java.util.Scanner;

public class Main {

    static private final String ALCOHOL = "alcohol";
    static private final String SODA = "sodaMixer";
    static private final String MIXER = "mixer";

    static Ingredient vodka = new Ingredient("vodka", ALCOHOL, 25);
    static Ingredient whiskey = new Ingredient("whiskey", ALCOHOL, 25);
    static Ingredient tequila = new Ingredient("tequila", ALCOHOL, 25);
    static Ingredient midori = new Ingredient("midori", ALCOHOL, 25);
    static Ingredient rum = new Ingredient("rum", ALCOHOL, 25);

    static Ingredient sprite = new Ingredient("sprite", SODA, 150);
    static Ingredient coke = new Ingredient("coke", SODA, 150);

    static Ingredient sweetNSour = new Ingredient("sweetNSour", MIXER, 100);
    static Ingredient squirt = new Ingredient("squirt", MIXER, 100);
    static Ingredient tajin = new Ingredient("tajin", MIXER, 100);

    static Cocktail midoriSour = new Cocktail("Midori Sour", "Vodka", 2, "Midori", 2, "Sweet & Sour", 4, "Sprite", 4, "The Midori Sour is a sweet and easy drink.");

    static Cocktail whiskeySour = new Cocktail("Whiskey Sour", "Whiskey", 2, "Sweet & Sour Mix", 4, "Sprite", 6, "No third mixer", 0, "The Whiskey sour is the perfect amount of whiskey and sourness");

    static Cocktail whiskeyCoke = new Cocktail("Whiskey Coke", "Whiskey", 2, "Coke", 10, "No second Mixer", 0, "No third Mixer", 0, "A simple cocktail for those that want to play it safe");

    static Cocktail rumCoke = new Cocktail("Rum & Coke", "Rum", 2, "Coke", 10, "No second Mixer", 0, "No third Mixer", 0, "A simple cocktail for those that want to play it safe" );

    static Cocktail paloma = new Cocktail("Paloma", "Tequila", 2, "Squirt", 10, "Tajin", 0.25, "No third Mixer", 0, "A Mexican Cocktail that tast spicy and sweet almost like lucas candy");

    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);

        Customer[] customers = {};

        boolean isOpen = true;

        while (isOpen) {
            System.out.println("Hello, what would you like to do?");

            System.out.println("\n1. Check in a new customer\n2. Order a drink\n3. Check balance available\n4. Close your tab\n5. Close bar");

            System.out.print("Enter the appropriate number: ");
            int choice = reader.nextInt();
            switch (choice) {
                case 1: // check in customer
                    customers = checkInCustomer(customers, reader);
                    continue;
                case 2: // order a drink
                    // find customer
                    int customerIndex = findCustomer(reader, customers);
                    if (customerIndex < 0) {
                        System.out.println("Customer not found. Please check in first.\n");
                        continue;
                    }

                    // view menu
                    System.out.println("\n");
                    displayMenu();

                    // order drink
                    orderDrink(reader, customers[customerIndex]);
                    continue;
                case 3: // check balance
                    // find customer
                    customerIndex = findCustomer(reader, customers);
                    if (customerIndex < 0) {
                        System.out.println("Customer not found. Please check in first.\n");
                        continue;
                    }
                    System.out.println("You, " + customers[customerIndex].getName() + ", have $" + customers[customerIndex].getMoneyAvailable() + " left.");
                    continue;
                case 4: // close tab
                    checkoutCustomer(reader, customers);
                    continue;
                case 5: // end program
                    System.out.println("Goodbye...");
                    isOpen = false;
                    break;
                default:
                    System.out.println("I'm sorry, that choice is invalid. Please try again...\n");
                    continue;
            }

        }

    }

    static Customer[] checkInCustomer(Customer[] customers, Scanner r) {
        int length = customers.length;
        Customer[] newCustomers = new Customer[length + 1];

        // get customer info
        System.out.print("Welcome. What is your full name? ");
        String n = r.nextLine();
        r.nextLine();
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
            // boolean sameMoney = (temp.getMoneyAvailable() == c.getMoneyAvailable()) ? true : false;

            if (sameName && sameAge) {
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

    static int findCustomer(Scanner r, Customer[] c) {
        int retVal = -1;

        System.out.print("Please enter your full name: ");
        String name = r.nextLine();
        r.nextLine();

        System.out.print("Please enter your age: ");
        int age = r.nextInt();
        r.nextLine();

        for (int i = 0; i < c.length; i++) {
            String tName = c[i].getName();
            int tAge = c[i].getAge();

            if (tName.equalsIgnoreCase(name) && tAge == age) {
                retVal = i;
                break;
            }
        }

        return retVal;
    }

    static Customer[] checkoutCustomer(Scanner r, Customer[] c) {
        int customerIndex = findCustomer(r, c);
        if (customerIndex < 0) {
            System.out.println("Customer not found.\n");
            return c;
        }

        Customer[] newC = new Customer[c.length-1];

        for (int i = 0; i < c.length; i++) {
            if (i < customerIndex) {
                newC[i] = c[i];
            } else if (i > customerIndex) {
                newC[i-1] = c[i];
            }
        }

        System.out.println("Goodbye " + c[customerIndex].getName() + ". Your closing balance left is $" + c[customerIndex].getMoneyAvailable());

        return newC;
    }

    static void orderDrink(Scanner r, Customer c) {
        // order drink code
        DrinkTracker dt = new DrinkTracker(c, 3);

        boolean loopcheck = true;

        while(loopcheck) {
            if (dt.checkCustomerCanDrink()) {
                boolean valid = true;
                System.out.print("To view the menu again, press 0. Otherwise, enter the number for the drink you would like to order. ");

                int drinkDecision = r.nextInt();
                r.nextLine();
                switch(drinkDecision) {
                    case 0:
                        displayMenu();
                        System.out.print("Enter the number for the drink you would like to order. ");
                        drinkDecision = r.nextInt();
                        r.nextLine();
                        break;
                    case 1:
                        System.out.println("You have chosen a " + midoriSour.getName());
                        vodka.subtractOz(midoriSour.getOz(), "alcohol");
                        midori.subtractOz(midoriSour.getMixersOz(), "mixer");
                        sweetNSour.subtractOz(midoriSour.getMixerTwoOz(), "mixer");
                        sprite.subtractOz(midoriSour.getMixerThreeOz(), "mixer");
                        c.subtractMoneyAvailable(8); // CHANGE PRICES
                        dt.addDrink();
                        break;
                    case 2:
                        System.out.println("You have chosen a " + whiskeySour.getName());
                        whiskey.subtractOz(whiskeySour.getOz(), "alcohol");
                        sweetNSour.subtractOz(whiskeySour.getMixersOz(), "mixer");
                        sprite.subtractOz(whiskeySour.getMixerTwoOz(), "mixer");
                        c.subtractMoneyAvailable(6);
                        dt.addDrink();
                        break;
                    case 3:
                        System.out.println("You have chosen a " + whiskeyCoke.getName());
                        whiskey.subtractOz(whiskeyCoke.getOz(), "alcohol");
                        coke.subtractOz(whiskeyCoke.getMixersOz(), "mixer");
                        c.subtractMoneyAvailable(5);
                        dt.addDrink();
                        break;
                    case 4:
                        System.out.println("You have chosen a " + rumCoke.getName());
                        rum.subtractOz(rumCoke.getOz(), "alcohol");
                        coke.subtractOz(rumCoke.getMixersOz(), "mixer");
                        c.subtractMoneyAvailable(6);
                        dt.addDrink();
                        break;
                    case 5:
                        System.out.println("You have chosen a " + paloma.getName());
                        tequila.subtractOz(paloma.getOz(), "alcohol");
                        squirt.subtractOz(paloma.getMixersOz(), "mixer");
                        tajin.subtractOz(paloma.getMixerTwoOz(), "mixer");
                        c.subtractMoneyAvailable(8);
                        dt.addDrink();
                        break;
                    default:
                        System.out.println("I'm sorry, but your drink selection is invalid. Please try again...");
                        valid = false;
                        break;
                }

                if (!valid) { continue; }

                tip(r, c);

                System.out.print("\nWould you like to order another drink? y/n ");
                if (r.nextLine().equalsIgnoreCase("y")) {
                    // order another drink
                    continue;
                } else {
                    // exit
                    loopcheck = false;
                    break;
                }
            } else {
                System.out.println("Sorry, you have reached the drink limit.");
                loopcheck = false;
                break;
            }
        }
    }

    static void displayMenu() {
        System.out.println("1. " + midoriSour.toString());
        System.out.println("2. " + whiskeySour.toString());
        System.out.println("3. " + whiskeyCoke.toString());
        System.out.println("4. " + rumCoke.toString());
        System.out.println("5. " + paloma.toString());
    }

    static void tip(Scanner r, Customer c)
    {
        // Singleton design pattern has been implemented therefore the old instantiation below will no longer work
        //Tips tip = new Tips();
        // Singleton design pattern will prevent instantiation
        // This design pattern is meant solely to get its static instance to the main method to ensure that only a single object is created
        Tips tip = Tips.getInstance();
        while (true)
        {
            System.out.print("Would you like to leave a tip? y/n ");
            String choice = r.nextLine();
            if (choice.equalsIgnoreCase("y"))
            {
                System.out.print("How much would you like to tip? ");
                double amt = r.nextDouble();
                tip.addTip(amt);
                c.subtractMoneyAvailable(amt);

                System.out.println("You now have $" + c.getMoneyAvailable() + " left.");

                r.nextLine();
                System.out.println("Thank you.");
                break;
            }
            else if (choice.equalsIgnoreCase("n"))
            {
                System.out.println("Thank you.");
                break;
            }
            else
            {
                System.out.println("Invalid entry. Try again...");
            }
        }
    }
}
