package bai3;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private double gpa;

    private static int count = 0;

    private final double MIN_GPA = 0.0;
    private final double MAX_GPA = 4.0;

    public Student(int id, String fullName, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gpa = gpa;
        if (gpa >= MIN_GPA && gpa <= MAX_GPA){
            this.gpa = gpa;
        }else {
            this.gpa = 0.0;
        }
        count++;
    }

    public void printInfo(){
        System.out.println("ID: " + id);
        System.out.println("Họ tên: " + fullName);
        System.out.println("Tuổi: " + age);
        System.out.println("GPA: " + gpa);
        System.out.println("-----------------------");
    }

    public static int getCount(){
        return count;
    }
}
