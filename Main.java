public class Main {
    public static void main (String[] args) {
        Customer c1 = new Customer("cust1", 20);
        Customer c2 = new Customer("cust2", 21);
        Customer c3 = new Customer("cust3", 50);

        System.out.println(c1.getName() + " can drink? " + c1.getCanDrink());
        System.out.println(c2.getName() + " can drink? " + c2.getCanDrink());
        System.out.println(c3.getName() + " can drink? " + c3.getCanDrink());
    }
}