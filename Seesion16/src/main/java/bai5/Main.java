package bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo danh sách ít nhất 10 sinh viên thuộc nhiều chuyên ngành
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyễn Văn A", "IT", 8.5));
        students.add(new Student("Trần Thị B", "Marketing", 7.2));
        students.add(new Student("Lê Hoàng C", "IT", 9.0));
        students.add(new Student("Phạm Minh D", "Biz", 6.8));
        students.add(new Student("Vũ Lệ E", "Marketing", 8.0));
        students.add(new Student("Hoàng Quốc F", "IT", 7.5));
        students.add(new Student("Đặng Thu G", "Biz", 8.2));
        students.add(new Student("Bùi Tiến H", "IT", 6.5));
        students.add(new Student("Ngô Mai I", "Marketing", 9.5));
        students.add(new Student("Đỗ Đức K", "Design", 7.8));

        System.out.println("========= THỐNG KÊ SINH VIÊN PRO =========");

        // Thống kê số lượng sinh viên theo chuyên ngành (Gom nhóm và đếm)
        Map<String, Long> statsMap = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));

        // Sắp xếp kết quả theo số lượng sinh viên GIẢM DẦN và In kết quả
        System.out.println("\nKết quả thống kê (Sắp xếp giảm dần theo số lượng):");

        statsMap.entrySet().stream()
                // Sử dụng Map.Entry.comparingByValue() kết hợp .reversed() để đảo ngược thứ tự (giảm dần)
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println("Chuyên ngành: " + entry.getKey() + " - Số lượng: " + entry.getValue()));

        System.out.println("==========================================");
    }
}
