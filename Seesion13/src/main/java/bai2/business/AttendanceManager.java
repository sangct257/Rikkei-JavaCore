package bai2.business;

import bai2.entity.Manage;
import bai2.entity.Student;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student>{
    private ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }



    @Override
    public void add(Student item) {
        studentList.add(item);
        System.out.println("Sinh viên đã được thêm thành công.");
    }

    @Override
    public void update(int index, Student item) {
        int actualIndex = index - 1;

        if (actualIndex >= 0 && actualIndex < studentList.size()) {
            studentList.set(actualIndex, item);
            System.out.println("Sinh viên đã được sửa thành công.");
        } else {
            System.out.println("Vị trí (Index) không hợp lệ.");
        }
    }

    @Override
    public void delete(int index) {
        int actualIndex = index - 1;

        if (actualIndex >= 0 && actualIndex < studentList.size()) {
            studentList.remove(actualIndex);
            System.out.println("Đã xóa thành công sinh viên !");
        } else {
            System.out.println("Vị trí (Index) không hợp lệ.");
        }
    }

    @Override
    public void display() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống.");
            return;
        }
        int displayIndex = 1;
        for (Student s : studentList) {
            System.out.println(displayIndex + ". " + s);
            displayIndex++;
        }
    }
}
