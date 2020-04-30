package customer;

public class NullCustomer extends Customer
{

    public NullCustomer(String name, int age, double moneyAvailable) {
        super(name, age, moneyAvailable);
    }

    public NullCustomer() {
        super();
    }

    @Override
    public String getName()
    {
        System.out.println("No customer data found");
        return null;
    }
}