package bai1.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class AdminStaff extends Staff {
    private double bonus;

    public AdminStaff() {}
    public AdminStaff(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return this.getBaseSalary() + this.bonus;
    }

    @Override
    public void checkPerformance() {
        if (this.bonus > 2000000) {
            System.out.print("Đánh giá: Hoàn thành Xuất sắc");
        } else {
            System.out.print("Đánh giá: Hoàn thành nhiệm vụ");
        }
    }

    @Override
    public void inputData(Scanner scanner) {
        super.inputData(scanner); // Nhập ID, Tên, Lương cơ bản từ lớp cha
        while (true) {
            try {
                System.out.print("Nhập tiền thưởng (bonus): ");
                this.bonus = Double.parseDouble(scanner.nextLine());
                if (this.bonus >= 0){
                    break;
                } else {
                    System.out.println("Tiền thưởng không được âm!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Tiền thưởng phải là số!");
            }
        }
    }

    @Override
    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        super.displayData();
        System.out.printf("Thưởng: "+nf.format(this.bonus)+", Tổng nhận: "+ nf.format(this.calculateTotalSalary())+", ");
        this.checkPerformance();
        System.out.println();
    }
}
