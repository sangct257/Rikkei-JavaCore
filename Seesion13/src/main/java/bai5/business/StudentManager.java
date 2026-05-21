package bai5.business;

import bai5.entity.Student;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    // Chức năng 1: Thêm sinh viên
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Chức năng 2: Hiển thị danh sách sinh viên
    public void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống.");
            return;
        }
        System.out.println("--- DANH SÁCH SINH VIÊN ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // Chức năng 3: Tìm kiếm sinh viên gần đúng hoặc chính xác theo tên
    public void searchByName(String searchName) {
        boolean found = false;
        System.out.println("Kết quả tìm kiếm cho '" + searchName + "':");
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(searchName.toLowerCase().trim())) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào có tên phù hợp.");
        }
    }

    // Chức năng 4: Lọc và hiển thị danh sách phân loại theo nhóm GPA
    public void classificationReport() {
        if (studentList.isEmpty()) {
            System.out.println("Chưa có dữ liệu sinh viên để phân loại.");
            return;
        }

        System.out.println("\n============ PHÂN LOẠI SINH VIÊN THEO GPA ============");

        System.out.println("\n[ XUẤT SẮC (GPA >= 8.5) ]");
        printByRank("Xuất sắc");

        System.out.println("\n[ GIỎI (7.0 <= GPA < 8.5) ]");
        printByRank("Giỏi");

        System.out.println("\n[ KHÁ (5.5 <= GPA < 7.0) ]");
        printByRank("Khá");

        System.out.println("\n[ TRUNG BÌNH / YẾU (GPA < 5.5) ]");
        printByRank("Trung bình / Yếu");
    }

    // Hàm phụ trợ in ra sinh viên theo nhóm xếp loại nhất định
    private void printByRank(String rank) {
        int count = 0;
        for (Student s : studentList) {
            if (s.getRank().equals(rank)) {
                System.out.println("  -> " + s);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("  (Không có sinh viên nào)");
        }
    }
}
