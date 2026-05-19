package bai3.ra.entity;

public class Coffee extends Drink{

    public Coffee() {
    }

    public Coffee(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.print("Pha bằng máy chuyên dụng");
    }

    @Override
    public void displayData() {
        super.displayData();
        this.prepare();
        System.out.println();
    }
}
