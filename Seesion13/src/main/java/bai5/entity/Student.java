package bai5.entity;

public class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id; // Gán id hiện tại rồi tự động tăng lên 1 cho sinh viên kế tiếp
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Hàm phân loại sinh viên dựa trên điểm GPA
    public String getRank() {
        if (gpa >= 8.5) {
            return "Xuất sắc";
        } else if (gpa >= 7.0) {
            return "Giỏi";
        } else if (gpa >= 5.5) {
            return "Khá";
        } else {
            return "Trung bình / Yếu";
        }
    }

    @Override
    public String toString() {
        return "Mã SV: " + id + " | Họ tên: " + name + " | GPA: " + gpa + " | Xếp loại: " + getRank();
    }
}
