package project;

import java.text.*;
import java.util.*;

public class Tips
{
    private double totalTips;
    private NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

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
