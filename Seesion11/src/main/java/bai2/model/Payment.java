package bai2.model;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void pay();

    public void printAmount(){
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));

        System.out.println("Số tiên giao dịch: "+nf.format(amount));
    }
}
