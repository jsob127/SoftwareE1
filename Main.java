import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static boolean n = true;
    public static void main(String[] args)
    {
        Tips tips = new Tips();
        while(n)
        {
            System.out.println("Would you like to leave a tip? Y or N?");
            String tipDecision = scanner.nextLine();
            if((tipDecision.equals("y")) || (tipDecision.equals("Y")))
            {
                System.out.println("How much would you like to tip?");
                tips.addTip(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Thank you.");
                n = false;
            }
            else if ((tipDecision.equals("n")) || (tipDecision.equals("N")))
            {
                System.out.println("Thank you.");
                n = false;
            }
            else
            {
                System.out.println("Invalid entry.");
                n = true;
            }
        }
        scanner.close();
        // For bartender use
        //tips.getTotalTips();
    }

}
