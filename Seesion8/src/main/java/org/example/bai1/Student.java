package org.example.bai1;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: <" + id +
                ">, Name: <" + name +
                ">, Age: <" + age + ">";
    }

    public static void main(String[] args) {
        Student student = new Student(1,"Nguyễn Văn A",18);
        System.out.println(student);
    }
}
