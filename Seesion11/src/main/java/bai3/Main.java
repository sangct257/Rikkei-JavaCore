package bai3;

import bai3.model.BonusEligible;
import bai3.model.Employee;
import bai3.model.FullTimeEmployee;
import bai3.model.PartTimeEmployee;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee(1,"Nguyen Van A",6300000);
        employees[1] = new PartTimeEmployee(2,"Nguyen Van B",25000,6.5);

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("vi","VN"));

        for (Employee employee : employees) {
            employee.showInfo();

            // PartTime không có lương cơ bản
            if (!(employee instanceof PartTimeEmployee)) {
                System.out.println("Lương cơ bản: " + nf.format(employee.calculateSalary()));
            } else {
                // Xử lý riêng cho PartTime như bạn đã làm
                PartTimeEmployee pt = (PartTimeEmployee) employee;
                System.out.println("Lương theo giờ: " + nf.format(pt.getHourlyRate()));
                System.out.println("Giờ làm: " + pt.getWorkingHour() + " giờ");
                System.out.println("TỔNG NHẬN: Lương theo giờ * Giờ làm việc = " + nf.format(pt.calculateSalary()));
            }

            // Sau đó mới xét đến thưởng
            if (employee instanceof BonusEligible be) {
                System.out.println("Thưởng thêm (10%): " + nf.format(be.calculateBonus()));
                System.out.println("TỔNG NHẬN: Lương cơ bản + Thường = " + nf.format(employee.calculateSalary() + be.calculateBonus()));
            } else {
                System.out.println("Nhân viên này không có thưởng");
            }
            System.out.println("----------------------------------------------");
        }
    }
}
