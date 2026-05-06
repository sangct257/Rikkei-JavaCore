package bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chiều rộng hình chữ nhật : ");
        double w = sc.nextDouble();
        System.out.print("Nhập chiều cao hình chữ nhật : ");
        double h = sc.nextDouble();

        Rectangle rectangle = new Rectangle(w,h);

        double area = rectangle.getArea();
        double perimeter = rectangle.getPerimeter();

        System.out.println("\nKết quả tính toán riêng lẻ:");
        System.out.println("Diện tích là: " + area);
        System.out.println("Chu vi là: " + perimeter);

        // Bước 5: Gọi phương thức in thông tin tổng hợp
        System.out.println("\nKết quả gọi từ printInfo():");
        rectangle.printInfo();

    }
}
