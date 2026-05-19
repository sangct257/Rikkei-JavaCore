package bai1.ra.entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public abstract class Staff implements ICapability {
    private String id;
    private String name;
    private double baseSalary;

    public Staff() {}
    public Staff(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    // Phương thức trừu tượng tính lương bắt buộc lớp con phải tự viết công thức
    public abstract double calculateTotalSalary();

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã ID: ");
        this.id = scanner.nextLine().trim();

        System.out.print("Nhập họ và tên: ");
        this.name = scanner.nextLine().trim();

        while (true) {
            try {
                System.out.print("Nhập lương cơ bản: ");
                this.baseSalary = Double.parseDouble(scanner.nextLine());
                if (this.baseSalary > 0) break;
                System.out.println("Lương cơ bản phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lương phải là một số!");
            }
        }
    }

    public void displayData() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));
        System.out.println("ID: "+this.id+", Tên: "+this.name+", Lương CB: "+ nf.format(this.baseSalary));
    }
}
