package bai3.entity;

public class Invoice {
    private String id;
    private double totalAmount;

    public Invoice() {
    }

    public Invoice(String id, double totalAmount) {
        this.id = id;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
