package bai1.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Lecturer extends Staff {
    private int teachingHours;

    public Lecturer() {}
    public Lecturer(String id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return this.getBaseSalary() + (this.teachingHours * 200000);
    }

    @Override
    public void checkPerformance() {
        if (this.teachingHours >= 60) {
            System.out.print("Đánh giá: Hoàn thành Xuất sắc");
        } else{
            System.out.print("Đánh giá: Cần tăng giờ dạy");
        }
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner); // Nhập ID, Tên, Lương cơ bản từ lớp cha
        while (true) {
            try {
                System.out.print("Nhập số giờ dạy: ");
                this.teachingHours = Integer.parseInt(scanner.nextLine());
                if (this.teachingHours >= 0){
                    break;
                } else {
                    System.out.println("Số giờ dạy không được âm!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Số giờ dạy phải là số nguyên!");
            }
        }
    }

    @Override
    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        super.displayData();
        System.out.println("Giờ dạy: "+this.teachingHours+", Tổng nhận: "+ nf.format(this.calculateTotalSalary())+", ");
        this.checkPerformance();
        System.out.println();
    }
}
