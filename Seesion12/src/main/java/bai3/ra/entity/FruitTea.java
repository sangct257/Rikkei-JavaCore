package bai3.ra.entity;

public class FruitTea extends Drink{
    public FruitTea() {
    }

    public FruitTea(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.print("Lắc đều với đá và trái cây tươi");
    }

    @Override
    public void displayData() {
        super.displayData();
        this.prepare();
        System.out.println();
    }
}
