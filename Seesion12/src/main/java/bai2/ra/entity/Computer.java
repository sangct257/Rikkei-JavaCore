package bai2.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Computer extends Asset{
    private String ram;
    private String cpu;

    public Computer() {
    }

    public Computer(String assetCode, String name, double purchasePrice, String ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return this.getPurchasePrice() * 0.8;
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner);
        System.out.print("Nhập dung lượng RAM (Ví dụ: 16GB): ");
        this.ram = scanner.nextLine().trim();
        System.out.print("Nhập thông số CPU (Ví dụ: Core i7): ");
        this.cpu = scanner.nextLine().trim();
    }

    @Override
    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        super.displayData();
        System.out.println("RAM: " + this.ram + ", CPU: " + this.cpu + ", Giá hiện tại (đã khấu hao 20%%): " + nf.format(this.getMarketValue()));
    }
}
