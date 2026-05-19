package bai3.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public abstract class Drink implements IPromotion{
    private String id;
    private String name;
    private double price;

    public Drink() {
    }

    public Drink(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void prepare();

    @Override
    public void applyDiscount(double percentage) {
        this.price = this.price * (1 - (percentage / 100));
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã đồ uống: ");
        this.id = scanner.nextLine().trim();

        System.out.print("Nhập tên đồ uống: ");
        this.name = scanner.nextLine().trim();

        while (true) {
            try {
                System.out.print("Nhập giá bán: ");
                this.price = Double.parseDouble(scanner.nextLine());
                if (this.price > 0) break;
                System.out.println("Giá bán đồ uống phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Giá bán phải là một số thực hợp lệ!");
            }
        }
    }

    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        System.out.println("Mã: "+this.id+", Tên món: "+this.name+", Giá: "+nf.format(this.price)+", Chế biến: ");
    }
}
