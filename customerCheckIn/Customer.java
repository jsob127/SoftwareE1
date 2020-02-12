public class Customer extends Person {
    private String name;
    private int age;
    private boolean canDrink = false;

    Customer(String name, int age) {
        this.name = name;
        this.age = age;

        canDrink = (age >=21) ? true : false;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean getCanDrink() { return canDrink; }
}