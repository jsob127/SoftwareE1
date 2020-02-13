import java.text.NumberFormat;
import java.util.Locale;

public class Tips
{
    private int totalTips;
    private NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

    public void addTip(int tipAmount)
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
