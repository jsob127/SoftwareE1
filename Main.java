import java.util.*;

public class Main {

    public static void main (String[] args) {

        Customer[] customers = {};
        Scanner reader = new Scanner(System.in);

        customers = checkInCustomer(customers, reader);

        for (int i = 0; i < customers.length; i++) {
            Customer temp = customers[i];

            System.out.println(temp.getName() + ", " + temp.getAge() + " has $" + temp.getMoneyAvailable());
        }

        customers = checkInCustomer(customers, reader);

        for (int i = 0; i < customers.length; i++) {
            Customer temp = customers[i];

            System.out.println(temp.getName() + ", " + temp.getAge() + " has $" + temp.getMoneyAvailable());
        }

        customers = checkInCustomer(customers, reader);

        for (int i = 0; i < customers.length; i++) {
            Customer temp = customers[i];

            System.out.println(temp.getName() + ", " + temp.getAge() + " has $" + temp.getMoneyAvailable());
        }

    }

    static Customer[] checkInCustomer(Customer[] customers, Scanner reader) {
        int length = customers.length;
        Customer[] newCustomers = new Customer[length + 1];

        // get customer info
        System.out.print("Welcome. What is your full name? ");
        String n = reader.nextLine();
        System.out.print("What is your age? ");
        int a = reader.nextInt();
        System.out.print("How much money do you have available? ");
        double m = reader.nextDouble();

        // capture \n
        reader.nextLine();

        Customer c = new Customer(n, a, m);

        // return original list if new customer is underage
        if (!c.getCanDrink()) { return customers; }

        // check if customer is already in system
        for (int i = 0; i < customers.length; i++) {
            Customer temp = customers[i];
            boolean sameName = (temp.getName().equals(c.getName())) ? true : false;
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
}