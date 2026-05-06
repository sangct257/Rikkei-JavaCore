package bai3;

public class Main {
    public static void main(String[] args) {
        Student[] listStudents= {
                new Student(1, "Nguyễn Văn An", 20, 3.5),
                new Student(2, "Trần Thị Bình", 21, 3.8),
                new Student(3, "Lê Hoàng Nam", 19, 2.5)
        };

        System.out.println("=== DANH SÁCH SINH VIÊN ===");
        for (Student stu : listStudents){
            stu.printInfo();
        }

        System.out.println("Tổng số sinh viên đã được tạo: " + Student.getCount());
    }
}
