package org.example.bai5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] listStudent = null; // Khởi tạo mảng chưa có kích thước
        int choice;

        do {
            System.out.println("\n====== MENU QUẢN LÝ SINH VIÊN =======");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm sinh viên GPA cao nhất");
            System.out.println("4. In tổng số sinh viên đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên muốn thêm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    listStudent = new Student[n]; // Khởi tạo mảng n phần tử

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập sinh viên thứ " + (i + 1) + ":");
                        listStudent[i] = new Student(); // Gọi Constructor tăng countStudent
                        listStudent[i].input();
                    }
                    break;

                case 2:
                    if (listStudent == null) {
                        System.out.println("Danh sách trống! Vui lòng chọn 1 để nhập.");
                    } else {
                        System.out.println("\n------- DANH SÁCH SINH VIÊN -------");
                        for (Student s : listStudent) {
                            s.print(); // Mỗi đối tượng tự in chính mình
                        }
                    }
                    break;

                case 3:
                    if (listStudent == null) {
                        System.out.println("Danh sách trống!");
                    } else {
                        Student maxGpa = listStudent[0];
                        for (int i = 1; i < listStudent.length; i++) {
                            if (listStudent[i].getGpa() > maxGpa.getGpa()) {
                                maxGpa = listStudent[i];
                            }
                        }
                        System.out.println("Sinh viên có GPA cao nhất:");
                        maxGpa.print();
                    }
                    break;

                case 4:
                    // Gọi thông qua tên lớp vì đây là phương thức static
                    System.out.println("Tổng số sinh viên đã tạo (countStudent): "
                            + Student.getTotalStudent());
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }
}