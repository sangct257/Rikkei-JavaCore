package bai5.ra.entity;

import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private Role role;
    private double salary;

    public Employee() {
    }

    public Employee(double salary, Role role, String employeeName, String employeeId) {
        this.salary = salary;
        this.role = role;
        this.employeeName = employeeName;
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public void inputData(Scanner scanner, Employee[] arrEmp, int index) {

        getEmployeeId(scanner, arrEmp, index);

        getEmployName(scanner);

        getEmployeeRole(scanner);

        getEmployeeSalary(scanner);
    }

    public void inputUpdateData(Scanner scanner) {

        getEmployName(scanner);

        getEmployeeRole(scanner);

        getEmployeeSalary(scanner);
    }

    private void getEmployeeSalary(Scanner scanner) {
        do {
            try {
                System.out.print("Mời nhập vào lương nhân viên (lương > 0):");
                this.salary = Double.parseDouble(scanner.nextLine().trim());
                if (this.salary > 0) {
                    break;
                } else {
                    System.out.println("Lương phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi hệ thống: Định dạng tiền lương phải là chữ số thực (Ví dụ: 1200 hoặc 1500.5)!");
            }
        } while (true);
    }

    private void getEmployeeRole(Scanner scanner) {
        // try-catch chống lỗi khi nhập chữ
        do {
            try {
                System.out.print("Vui lòng chọn vai trò (1. DEV, 2. TESTER, 3. PM, 4. BA): ");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                // Role.values().length tương đương với số lượng phần tử của Enum (bằng 4)
                if (choice >= 1 && choice <= Role.values().length) {
                    this.role = Role.values()[choice - 1];// Lấy phần tử theo chỉ số mảng enum (0 đến 3)
                    break;
                } else {
                    System.out.println("Vui lòng chỉ chọn số thứ tự trong danh mục từ 1 đến 4!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi hệ thống: Nhập sai kiểu! Bạn phải nhập vào chữ số nguyên.");
            }
        } while (true);
    }

    private void getEmployName(Scanner scanner) {
        do {
            System.out.print("Mời nhập tên nhân viên (6–30 ký tự): ");
            this.employeeName = scanner.nextLine().trim();
            if (this.employeeName.length() >= 6 && this.employeeName.length() <= 30) {
                break;
            } else {
                System.out.println("Vui lòng nhập đủ độ dài tên nhân viên (6–30 ký tự)!");
            }
        } while (true);
    }

    private void getEmployeeId(Scanner scanner, Employee[] arrEmp, int index) {
        do {
            System.out.print("Mời nhập vào mã nhân viên (E0001): ");
            this.employeeId = scanner.nextLine().trim();
            if (this.employeeId.matches("^E\\d{4}$")) {
                if (checkIdEmployeeExist(this.employeeId, arrEmp, index)) {
                    System.out.println("Mã nhân viên đã tồn tại!");
                } else {
                    break;
                }
            } else if (this.employeeId.isEmpty()) {
                System.out.println("Mã nhân viên không được để trống!");
            } else {
                System.out.println("Vui lòng nhập đúng định dạng bắt đầu bằng chữ P và + 4 ký tự!");
            }
        } while (true);
    }

    public boolean checkIdEmployeeExist(String id, Employee[] employees, int index) {
        for (int i = 0; i < index; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void displayData() {
        System.out.println("Mã nhân viên: " + this.employeeId + ", Tên nhân viên: " + this.employeeName + ", Vai trò: " + this.role + ", Lương: " + this.salary);
    }
}
