package bai5.ra.business;

import bai5.ra.entity.Employee;

import java.util.Scanner;

public class EmployeeBusiness {
    private static Employee[] employees = new Employee[99];

    private static int currentIndex = 0;

    public static Employee[] getEmployees() {
        return employees;
    }

    public static void setEmployees(Employee[] employees) {
        EmployeeBusiness.employees = employees;
    }

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void setCurrentIndex(int currentIndex) {
        EmployeeBusiness.currentIndex = currentIndex;
    }

    public static void addEmployees(Scanner scanner) {
        if (currentIndex >= employees.length) {
            System.out.println("Bộ nhớ danh sách nhân viên đã đầy (Tối đa 99 người)!");
            return;
        }
        Employee newEmployee = new Employee();
        newEmployee.inputData(scanner, employees, currentIndex);
        employees[currentIndex++] = newEmployee;
        System.out.println("Thêm nhân viên thành công!");
    }

    public static void displayEmployees() {
        if (currentIndex == 0) {
            System.out.println("Không có nhân viên nào trong danh sách!");
        } else {
            System.out.println("================= DANH SÁCH NHÂN VIÊN =================");
            for (int i = 0; i < currentIndex; i++) {
                Employee showEmployee = employees[i];
                showEmployee.displayData();
            }
            System.out.println("=======================================================");
        }
    }

    public static void updateEmployee(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không thể cập nhật!");
            return;
        }

        System.out.print("Nhập mã nhân viên cần cập nhật (Ví dụ: E0001): ");
        String searchEmployeeId = scanner.nextLine().trim();

        // Tìm vị trí (chỉ số i) của nhân viên có ID trùng khớp
        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(searchEmployeeId)) {
                foundIndex = i; // Lưu lại vị trí tìm thấy
                break;          // Tìm thấy rồi thì dừng vòng lặp luôn
            }
        }

        // Kiểm tra kết quả tìm kiếm và xử lý
        if (foundIndex != -1) {
            System.out.println("--- Cập nhật thông tin cho nhân viên " + searchEmployeeId + " ---");

            // Chỉ gọi duy nhất phần tử tại vị trí tìm thấy để cập nhật
            employees[foundIndex].inputUpdateData(scanner);

            System.out.println("Cập nhật thông tin nhân viên thành công!");
        } else {
            System.out.println("Mã nhân viên không tồn tại trong hệ thống!");
        }
    }

    public static void deleteEmployee(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không có nhân viên để xóa!");
            return;
        }
        System.out.println("Nhập mã nhân viên cần xoá: ");
        String deleteId = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(deleteId)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            // Thực hiện dịch chuyển các phần tử phía sau sang trái 1 ô để đè lên phần tử xóa
            for (int i = foundIndex; i < currentIndex - 1; i++) {
                employees[i] = employees[i + 1];
            }

            // Giải phóng ô nhớ cuối cùng và giảm biến đếm
            employees[currentIndex - 1] = null;
            currentIndex--;
            System.out.println("Xóa nhân viên thành công!");
        } else {
            System.out.println("Không tìm thấy mã nhân viên [" + deleteId + "] trong hệ thống!");
        }
    }

    public static void searchEmployeeByName(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không thể tìm kiếm!");
            return;
        }

        System.out.print("Nhập tên nhân viên muốn tìm: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        boolean hasResult = false;
        System.out.println("================= KẾT QUẢ TÌM KIẾM =================");
        for (int i = 0; i < currentIndex; i++) {
            // Kiểm tra xem tên nhân viên có chứa chuỗi tìm kiếm không
            if (employees[i].getEmployeeName().toLowerCase().contains(searchName)) {
                employees[i].displayData();
                hasResult = true;
            }
        }
        System.out.println("=====================================================");

        if (!hasResult) {
            System.out.println("Không tìm thấy nhân viên nào có tên chứa: " + searchName);
        }
    }

    public static void sortEmployeeBySalaryDesc() {
        if (currentIndex <= 1) {
            System.out.println("📋 Danh sách có ít hơn 2 nhân viên, không cần sắp xếp!");
            return;
        }

        // Áp dụng Bubble Sort chỉ chạy đến biên currentIndex để tránh lỗi NullPointerException
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = 0; j < currentIndex - i - 1; j++) {
                if (employees[j].getSalary() < employees[j + 1].getSalary()) {
                    // Tráo đổi vị trí 2 đối tượng
                    Employee temp = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = temp;
                }
            }
        }
        System.out.println("⭐ Đã sắp xếp danh sách nhân viên theo lương giảm dần!");
        // Gọi luôn hàm hiển thị ra để người dùng nhìn thấy kết quả lập tức thay vì phải bấm Menu 2
        displayEmployees();
    }
}
