import java.text.NumberFormat;
import java.util.Locale;

public class Tips
{
    private static Tips tips = new Tips();

    private double totalTips;
    private NumberFormat format;

    private Tips() {
        this.totalTips = 0;
        this.format = NumberFormat.getCurrencyInstance(Locale.US);
    }

    public static Tips getInstance()
    {
        return tips;
    }

    public void addTip(double tipAmount)
    {
        totalTips += tipAmount;
        String tip = format.format(tipAmount);
        System.out.println("You tipped " + tip);
    }

    public void getTotalTips()
    {
        String tips = format.format(totalTips);
        System.out.println("Total amount of tip money: " + tips);
    }
}
