package org.example.bai5;

import java.util.Scanner;

public class Student {
    // Thuộc tính đối tượng
    private int id;
    private String name;
    private double gpa;

    // Hằng số cho mỗi đối tượng
    private final double SCORE_FACTOR = 0.25;

    // Thuộc tính tĩnh (Static) - dùng chung toàn lớp
    private static int countStudent = 0;

    // Constructor không tham số
    public Student() {
        countStudent++;
    }

    // Constructor 3 tham số - Gọi constructor không tham số bằng this()
    public Student(int id, String name, double gpa) {
        this();
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Phương thức nhập thông tin cho 1 sinh viên
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập GPA: ");
        this.gpa = Double.parseDouble(sc.nextLine());
    }

    // Phương thức in thông tin 1 sinh viên
    public void print() {
        System.out.printf("ID: %d | Tên: %s | GPA: %.2f | Hệ số: %.2f\n",
                id, name, gpa, SCORE_FACTOR);
    }

    // Getter cho GPA
    public double getGpa() {
        return gpa;
    }

    // Phương thức static trả về countStudent
    public static int getTotalStudent() {
        return countStudent;
    }
}