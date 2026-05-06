package org.example.bai6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] listProduct = null;
        int choice;

        do {
            System.out.println("\n===== MENU SẢN PHẨM =====");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. In danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm theo khoảng giá");
            System.out.println("4. Thống kê số sản phẩm đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm muốn thêm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    listProduct = new Product[n];

                    for (int i = 0; i < n; i++) {
                        System.out.println("Sản phẩm thứ " + (i + 1) + ":");
                        listProduct[i] = new Product();
                        listProduct[i].input();
                    }
                    break;

                case 2:
                    if (listProduct == null) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
                        for (Product p : listProduct) {
                            p.print();
                        }
                    }
                    break;

                case 3:
                    if (listProduct == null) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.print("Nhập giá từ: ");
                        double min = Double.parseDouble(sc.nextLine());
                        System.out.print("Đến giá: ");
                        double max = Double.parseDouble(sc.nextLine());

                        System.out.println("Kết quả tìm kiếm:");
                        for (Product p : listProduct) {
                            if (p.getPrice() >= min && p.getPrice() <= max) {
                                p.print();
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Tổng số sản phẩm đã tạo trên hệ thống: "
                            + Product.getProductCount());
                    break;

                case 0:
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}