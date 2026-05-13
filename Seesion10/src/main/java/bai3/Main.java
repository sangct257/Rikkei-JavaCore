package bai3;

import bai3.model.Computer;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        double base = 1000.0;
        double tax = 100.0;
        double discount = 50.0;

        // Gọi phiên bản 1
        double price1 = computer.calculatePrice(base);
        System.out.println("Final Price = " + price1);
        System.out.println();

        // Gọi phiên bản 2
        double price2 = computer.calculatePrice(base, tax);
        System.out.println("Final Price = " + price2);
        System.out.println();

        // Gọi phiên bản 3
        double price3 = computer.calculatePrice(base, tax, discount);
        System.out.println("Final Price = " + price3);
    }
}
