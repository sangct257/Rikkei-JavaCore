package bai5.presentation;

import bai5.business.StudentManager;
import bai5.entity.Student;

import java.util.Scanner;

public class StudentPre {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        int choice;

        do {
            System.out.println("==================== MENU ====================");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại sinh viên theo GPA");
            System.out.println("0. Thoát chương trình");
            System.out.println("==============================================");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1; // Gán lựa chọn sai để kích hoạt thông báo nhập lại
            }

            switch (choice) {
                case 1:
                    int quantity = inputPositiveInteger("Nhập số lượng sinh viên muốn thêm: ");
                    for (int i = 0; i < quantity; i++) {
                        System.out.println("\n--- Nhập thông tin cho sinh viên thứ " + (i + 1) + " ---");

                        System.out.println("Nhập id sinh viên: ");
                        Integer id = Integer.parseInt(inputNonEmptyString());
                        System.out.print("Nhập họ và tên sinh viên: ");
                        String name = inputNonEmptyString();

                        double gpa = inputValidGpa();

                        manager.addStudent(new Student(id,name, gpa));
                    }
                    System.out.println("\nThêm danh sách sinh viên thành công!");
                    break;

                case 2:
                    manager.displayAll();
                    break;

                case 3:
                    if (manager.getStudentList().isEmpty()) {
                        System.out.println("Danh sách trống, không thể tìm kiếm.");
                    } else {
                        System.out.print("Nhập tên sinh viên cần tìm: ");
                        String searchName = inputNonEmptyString();
                        manager.searchByName(searchName);
                    }
                    break;

                case 4:
                    manager.classificationReport();
                    break;

                case 0:
                    System.out.println("Đang thoát chương trình... Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 0 đến 4.");
            }
            System.out.println(); // Ngắt dòng thẩm mỹ
        } while (choice != 0);
    }

    // Ép buộc người dùng nhập chuỗi không trống
    private static String inputNonEmptyString() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.print("Dữ liệu không được để trống! Mời nhập lại: ");
        }
    }

    // Đảm bảo số lượng sinh viên nhập vào là số nguyên dương > 0
    private static int inputPositiveInteger(String label) {
        while (true) {
            try {
                System.out.print(label);
                int val = Integer.parseInt(scanner.nextLine());
                if (val > 0) {
                    return val;
                }
                System.out.println("Số lượng phải lớn hơn 0!");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }

    // Đảm bảo điểm số GPA hợp lệ nằm trong đoạn từ 0.0 đến 10.0
    private static double inputValidGpa() {
        while (true) {
            try {
                System.out.print("Nhập điểm trung bình (GPA): ");
                double gpa = Double.parseDouble(scanner.nextLine());
                if (gpa >= 0.0 && gpa <= 10.0) {
                    return gpa;
                }
                System.out.println("Điểm GPA phải nằm trong khoảng từ 0.0 đến 10.0!");
            } catch (NumberFormatException e) {
                System.out.println("Định dạng điểm không hợp lệ! Vui lòng nhập số thực (Ví dụ: 7.5).");
            }
        }
    }
}
