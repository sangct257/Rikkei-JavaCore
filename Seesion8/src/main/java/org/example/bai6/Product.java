package org.example.bai6;

import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private double price;

    // Thuộc tính static: Dùng chung cho toàn lớp để tự động tăng ID
    private static int AUTO_ID = 1;

    // Thuộc tính final: Hằng số không đổi cho mỗi đối tượng
    private final String WAREHOUSE_CODE = "KHO-01";

    // 1. Constructor không tham số
    public Product() {
        this.id = AUTO_ID++; // Gán ID hiện tại rồi mới tăng AUTO_ID lên 1
    }

    // 2. Constructor có tham số
    public Product(String name, double price) {
        this(); // Gọi constructor không tham số để xử lý ID tự động
        this.name = name;
        this.price = price;
    }

    // Phương thức nhập thông tin
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        this.name = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        this.price = Double.parseDouble(sc.nextLine());
    }

    // Phương thức in thông tin
    public void print() {
        System.out.printf("ID: %d | Tên: %s | Giá: %.2f | Mã kho: %s\n",
                id, name, price, WAREHOUSE_CODE);
    }

    // Getter cho price để dùng khi tìm kiếm theo khoảng giá
    public double getPrice() {
        return price;
    }

    // Phương thức tĩnh để lấy số lượng sản phẩm đã tạo
    public static int getProductCount() {
        return AUTO_ID - 1;
    }
}