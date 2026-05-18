package bai2;

import bai2.model.*;

public class Main {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new CashPayment(5000000);
        payments[1] = new CreditCardPayment(10000000);
        payments[2] = new EWalletPayment(20000000);

        for (Payment p : payments){
            p.printAmount();
            p.pay();

            if (p instanceof Refundable){
                ((Refundable) p).refund();
            }

            System.out.println("---------------------------");
        }
    }
}
