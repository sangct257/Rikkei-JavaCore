package bai3;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Thêm sản phẩm vào đơn hàng
    public void addProductToOrder(Product product) {
        this.products.add(product);
    }

    // Tính tổng tiền đơn hàng
    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayOrderDetails() {
        if (products.isEmpty()) {
            System.out.println("   (Đơn hàng này chưa có sản phẩm nào)");
            return;
        }
        for (Product p : products) {
            System.out.println("   + " + p);
        }
        System.out.println("   => Tổng tiền đơn hàng: " + String.format("%,.0f", calculateTotal()) + "đ");
    }
}
