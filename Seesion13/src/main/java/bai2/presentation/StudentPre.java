package bai2.presentation;

import bai2.business.AttendanceManager;
import bai2.entity.Student;

import java.util.Scanner;

public class StudentPre {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("***************** MENU QUẢN LÝ ĐIỂM DANH *****************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    System.out.println("Nhập id sinh viên :");
                    Integer id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên sinh viên:");
                    String name = scanner.nextLine();

                    manager.add(new Student(id, name));
                    break;

                case 2:
                    manager.display();

                    System.out.println("Nhập id sinh viên cần sửa (Nhập số thứ tự hiển thị ở đầu dòng):");
                    int indexToUpdate = Integer.parseInt(scanner.nextLine());

                    System.out.println("Nhập id sinh viên mới (hoặc giữ nguyên id cũ):");
                    Integer newId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên mới sinh viên:");
                    String newName = scanner.nextLine();

                    Student updatedStudent = new Student(newId, newName);

                    manager.update(indexToUpdate, updatedStudent);

                case 3:
                    manager.display();

                    System.out.println("Nhập id sinh viên cần xóa (Nhập số thứ tự hiển thị ở đầu dòng):");
                    int indexToDelete = Integer.parseInt(scanner.nextLine());

                    manager.delete(indexToDelete);

                case 4:
                    manager.display();
                    break;

                case 5:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại!");
            }
            System.out.println();
        } while (choice != 5);

        scanner.close();
    }
}
